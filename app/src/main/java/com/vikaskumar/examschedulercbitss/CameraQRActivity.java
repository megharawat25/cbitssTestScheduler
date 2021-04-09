package com.vikaskumar.examschedulercbitss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class CameraQRActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    TextView textBarCodeValue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    TextView btnAction;
    String intentData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_qractivity);


        surfaceView = findViewById(R.id.surfaceView);
        textBarCodeValue = findViewById(R.id.textBarCodeValue);
        btnAction = findViewById(R.id.btnAction);
        getSupportActionBar().hide();

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intentData.length()>0)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(intentData)));
                }
            }
        });

    }

    private void initialIsDirectorAndSource()
    {
        Toast.makeText(this, "Scanning Start ", Toast.LENGTH_SHORT).show();

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector).
                setRequestedPreviewSize(1000,1200)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {

                try {
                    if (ActivityCompat.checkSelfPermission(CameraQRActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
                    {
                        cameraSource.start(surfaceView.getHolder());
                    }else {
                        ActivityCompat.requestPermissions(CameraQRActivity.this, new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                cameraSource.stop();

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                Toast.makeText(CameraQRActivity.this, "Bar Code has been stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(@NonNull Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodeSparseArray = detections.getDetectedItems();
                if (barcodeSparseArray.size() != 0)
                {
                    textBarCodeValue.post(new Runnable() {
                        @Override
                        public void run() {
                            textBarCodeValue.setVisibility(View.INVISIBLE);
                            btnAction.setText("GOOOOOOOOOOO");
                            intentData = barcodeSparseArray.valueAt(0).displayValue;
                            textBarCodeValue.setText(intentData);
                        }
                    });

                }else {
                    Toast.makeText(CameraQRActivity.this, "Empty Size", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.release();
    }

    @Override
    protected void onResume() {
        super.onResume();

        initialIsDirectorAndSource();
    }
}