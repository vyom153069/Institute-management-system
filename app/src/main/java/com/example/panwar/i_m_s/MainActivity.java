package com.example.panwar.i_m_s;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button BtnCourse,BtnQuery;
    Button BtnStudent,BtnExit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.titlebar_color));
        }
        BtnCourse=(Button)findViewById(R.id.button2);
        BtnExit=(Button)findViewById(R.id.button4);
        BtnQuery=(Button)findViewById(R.id.button3);
        BtnStudent=(Button)findViewById(R.id.button);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ac938a"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        BtnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,CourseActivity.class);
                startActivity(intent);

            }
        });

        BtnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,RegisterStudentActivity.class);
                startActivity(intent);

            }
        });

        BtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        BtnExit.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                CustomDialog cd=new CustomDialog(MainActivity.this);
                cd.show();

            }
        });
    }

    @Override
    public void onBackPressed() {

        super.finish();
    }
}
