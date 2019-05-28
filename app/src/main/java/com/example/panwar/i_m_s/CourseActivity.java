package com.example.panwar.i_m_s;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

public class CourseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.titlebar_color));
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ac938a"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        ListView listView= (ListView) findViewById(R.id.courseenquiry_lv_list);
        BaseCourseAdapter adapter=new BaseCourseAdapter(this);
        listView.setAdapter(adapter);

    }


}
