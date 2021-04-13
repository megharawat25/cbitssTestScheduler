package com.vikaskumar.examschedulercbitss;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
=======
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
<<<<<<< HEAD

import com.vikaskumar.examschedulercbitss.Utility.NeTWorkChange;

import java.util.Calendar;

public class CourseActivity extends AppCompatActivity {
=======
import android.widget.Toast;

import com.vikaskumar.examschedulercbitss.Adapters.CourseAdapter;
import com.vikaskumar.examschedulercbitss.Utility.NeTWorkChange;

public class CourseActivity extends AppCompatActivity{
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
    private GridView gridView;
    NeTWorkChange neTWorkChange = new NeTWorkChange();
    private EditText fullName, courseID;
    private TextView  tvDate,trainerName, status;
    private Spinner courseName, courseTime;
    private ImageView datePick;
    private Button button;

<<<<<<< HEAD
  String[] cName={"SELECT COURSE", "BCA","BCom","BBA","BTech","BA","DIPLOMA","OTHER"};

  String[] cTime={"SELECT TIME", "9AM :10 AM","9AM :10 AM","9AM :10 AM","9AM :10 AM","9AM :10 AM","9AM :10 AM","9AM :10 AM"};
=======
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

<<<<<<< HEAD
        xmlBinding();

        ArrayAdapter<String> ug=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cName);
        courseName.setAdapter(ug);

        ArrayAdapter<String> time=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cTime);
        courseTime.setAdapter(time);
    }

    private void xmlBinding() {
        fullName = findViewById(R.id.et_name);
        courseID = findViewById(R.id.et_course_id);
        tvDate  = findViewById(R.id.tv_date);
        trainerName = findViewById(R.id.et_trainer_name);
        status = findViewById(R.id.et_status);
        courseName = findViewById(R.id.sp_course_name);
        courseTime = findViewById(R.id.sp_time);
        datePick  =findViewById(R.id.date_pick);
        button = findViewById(R.id.submit);

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar= Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(CourseActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date=dayOfMonth+"/"+(month+1)+"/"+year;
                        tvDate.setText(date);

                    }
                },year,month,day);
                dialog.show();
            }
        });
    }

=======
        gridView = findViewById(R.id.course_rcv);
        CourseAdapter adapter1 = new CourseAdapter(1);
        gridView.setAdapter(adapter1);

//       courseName = findViewById(R.id.sp_course_name);
//        courseTime = findViewById(R.id.sp_time);
//        datePick  =findViewById(R.id.date_pick);
//        button = findViewById(R.id.submit);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CourseActivity.this, ScheduleActivity.class));
//                finish();
//            }
//        });
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
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
}