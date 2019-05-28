package com.example.panwar.i_m_s;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Panwar on 08-11-2016.
 */

public class BaseStudentAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<StudentView> data;
    public BaseStudentAdapter(Context context){
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        StudentDB db=new StudentDB(context);
        data=db.getAllStudent();
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
            convertView=inflater.inflate(R.layout.allstudent_listitems,parent,false);
        }
        StudentView view=data.get(position);
        TextView textView= (TextView) convertView.findViewById(R.id.adapter_all_student_tv_registrationNO);
        textView.setText("Registration ID : "+view.getStudent_REGISTRATION());
        textView= (TextView) convertView.findViewById(R.id.adapter_all_student_tv_name);
        textView.setText("Name : "+view.getStudent_name());
        textView= (TextView) convertView.findViewById(R.id.adapter_all_student_tv_fathername);
        textView.setText("Father : "+view.getStudent_FATHER_NAME());
        textView= (TextView) convertView.findViewById(R.id.adapter_all_student_tv_course);
        textView.setText("Course : "+view.getStudent_Course());
        textView= (TextView) convertView.findViewById(R.id.adapter_all_student_tv_mobile);
        textView.setText("Mobile : "+view.getStudent_Phone());
        textView= (TextView) convertView.findViewById(R.id.adapter_all_student_tv_address);
        textView.setText("Address : "+view.getStudent_Address());
        return convertView;
    }
}