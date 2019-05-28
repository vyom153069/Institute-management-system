package com.example.panwar.i_m_s;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

public class SearchAllStudent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all_student);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.titlebar_color));
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ac938a"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        BaseStudentAdapter adapter=new BaseStudentAdapter(this);
        ListView listView=(ListView)findViewById(R.id.act_all_student_lv_listview);
        listView.setAdapter(adapter);
    }
}
