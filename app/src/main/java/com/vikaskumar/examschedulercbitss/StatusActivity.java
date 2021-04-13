package com.vikaskumar.examschedulercbitss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StatusActivity extends AppCompatActivity {
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        imageView = findViewById(R.id.back);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StatusActivity.this, MainActivity.class));
            }
        });

<<<<<<< HEAD
=======
<<<<<<< HEAD


=======
>>>>>>> 745906c0773128f130f1372a4c270b4f0ad5a0c5
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
    }
}