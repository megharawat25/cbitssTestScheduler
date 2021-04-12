package com.vikaskumar.examschedulercbitss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vikaskumar.examschedulercbitss.Adapters.CourseAdapter;
import com.vikaskumar.examschedulercbitss.Utility.NeTWorkChange;

public class CourseActivity extends AppCompatActivity{
    private GridView gridView;
    NeTWorkChange neTWorkChange = new NeTWorkChange();
    private EditText fullName, courseID;
    private TextView  tvDate,trainerName, status;
    private Spinner courseName, courseTime;
    private ImageView datePick;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        gridView = findViewById(R.id.course_rcv);
        CourseAdapter adapter1 = new CourseAdapter(1);
        gridView.setAdapter(adapter1);

//       courseName = findViewById(R.id.sp_course_name);
//        courseTime = findViewById(R.id.sp_time);
//        datePick  =findViewById(R.id.date_pick);
//        button = findViewById(R.id.submit);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_item, android.R.layout.simple_list_item_1);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        courseName.setAdapter(adapter);

    }

    private void xmlBinding() {
//        fullName = findViewById(R.id.et_name);
//        courseID = findViewById(R.id.et_course_id);
//        tvDate  = findViewById(R.id.tv_date);
//        trainerName = findViewById(R.id.et_trainer_name);
//        status = findViewById(R.id.et_status);

    }
}