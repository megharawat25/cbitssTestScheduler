package com.vikaskumar.examschedulercbitss.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import com.vikaskumar.examschedulercbitss.R;

public class CourseAdapter extends BaseAdapter {

    private int noOfCourse;

    public CourseAdapter(int noOfCourse) {
        this.noOfCourse = noOfCourse;
    }

    @Override
    public int getCount() {
        return noOfCourse;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Spinner courseName, courseTime;

        View view ;
        if (convertView == null)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cource_item, parent, false);
        }
        else {
            view = convertView;
        }
        return view;
    }

}
