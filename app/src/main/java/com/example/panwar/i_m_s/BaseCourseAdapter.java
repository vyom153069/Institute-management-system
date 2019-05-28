package com.example.panwar.i_m_s;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Panwar on 08-11-2016.
 */

public class BaseCourseAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<COURSEVIEW> data;
    BaseCourseAdapter(Context context){
        CourseList list=new CourseList();
        data=list.getCourseList();
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.size()+11;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=inflater.inflate(R.layout.course_list_tems,parent,false);
        }
        COURSEVIEW courseview= data.get(position);
        TextView textView= (TextView) convertView.findViewById(R.id.adapter_course_tv_corseID);
        textView.setText("CourseID : "+courseview.getCourseID());
        textView= (TextView) convertView.findViewById(R.id.adapter_course_tv_courseNmae);
        textView.setText("CourseName : "+courseview.getCourseName());
        textView= (TextView) convertView.findViewById(R.id.adapter_course_tv_courseDuration);
        textView.setText("Duration: "+courseview.getCourseDuration());
        textView= (TextView) convertView.findViewById(R.id.adapter_course_tv_courseFee);
        textView.setText("Fee : "+courseview.getCourseFee());
        return convertView;
    }
}
