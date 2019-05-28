package com.example.panwar.i_m_s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panwar on 08-11-2016.
 */

public class StudentDB extends SQLiteOpenHelper {

    private static final String TAG = "DBAdapter";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "stdentdbsystem";
    //Stduent Registration
    private static final String TABLE_STUDENT_REG = "StudentReg";
    // Column Name
    private static final String STUDENT_REG_ID="RollNO";
    private static final String STUDENT_NAME="Name";
    private static final String STUDENT_FATHER_NAME="Fathername";
    private static final String STUDENT_ADDRESS="address";
    private static final String STUDENT_PHONE="phone";
    private static final String STUDENT_COURSE="COURSENAME";
    private static final String CREATE_TABLE_STUDENTREG = "CREATE TABLE "
            + TABLE_STUDENT_REG + "(" + STUDENT_REG_ID + " integer primary key autoincrement ,"
            + STUDENT_NAME + " text ," + STUDENT_FATHER_NAME + " text ," + STUDENT_ADDRESS
            + " text ," +STUDENT_PHONE  + " integer ," +STUDENT_COURSE + " text" + ")";



    public StudentDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTREG);
        //db.execSQL(CREATE_TABLE_COURSE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void insertStudent(String name, String fatherName, String address, String phone, String course) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(STUDENT_NAME, name);
        values.put(STUDENT_FATHER_NAME, fatherName);
        values.put(STUDENT_ADDRESS, address);
        values.put(STUDENT_PHONE, phone);
        values.put(STUDENT_COURSE, course);
        long v= db.insert(TABLE_STUDENT_REG, null, values);
        System.out.println(v);
        db.close();
    }

    public void editStudent(String regNo,String name, String fatherName, String address, String phone, String course) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(STUDENT_NAME, name);
        values.put(STUDENT_FATHER_NAME, fatherName);
        values.put(STUDENT_ADDRESS, address);
        values.put(STUDENT_PHONE, phone);
        values.put(STUDENT_COURSE, course);
        int update = db.update(TABLE_STUDENT_REG, values, STUDENT_REG_ID + " = ?", new String[]{regNo});
        System.out.println(update);
        db.close();
    }

    public void deleteStudent(String regNo) {
        SQLiteDatabase db=getReadableDatabase();
        int delete = db.delete(TABLE_STUDENT_REG, STUDENT_REG_ID + " = ?", new String[]{regNo});
        System.out.print("I HAVE DELETED");
        System.out.println(delete);
        db.close();
    }

    public List<StudentView> getAllStudent()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<StudentView> student=new ArrayList<StudentView>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_REG;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst())
        {
            do {
                StudentView stud = new StudentView();
                stud.setStudent_REGISTRATION((c.getInt(c.getColumnIndex(STUDENT_REG_ID))));
                stud.setStudent_name((c.getString(c.getColumnIndex(STUDENT_NAME))));
                stud.setStudent_FATHER_NAME((c.getString(c.getColumnIndex(STUDENT_FATHER_NAME))));
                stud.setStudent_Address((c.getString(c.getColumnIndex(STUDENT_ADDRESS))));
                stud.setStudent_Course((c.getString(c.getColumnIndex(STUDENT_COURSE))));
                stud.setStudent_Phone((c.getString(c.getColumnIndex(STUDENT_PHONE))));
                student.add(stud);
            } while (c.moveToNext());
        }
        c.close();
        return  student;
    }

    public StudentView getStudentREGBY(String regNo)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        StudentView stud = new StudentView();
        //List<StudentView> student=new ArrayList<StudentView>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_REG+" where "+STUDENT_REG_ID;
        Cursor c = db.query(TABLE_STUDENT_REG, new String[]{STUDENT_REG_ID, STUDENT_NAME, STUDENT_FATHER_NAME, STUDENT_ADDRESS, STUDENT_PHONE, STUDENT_COURSE}, STUDENT_REG_ID + " = ?",
                new String[]{regNo}, null, null, null);

        if (c.moveToFirst())
        {
            // do {

            stud.setStudent_REGISTRATION((c.getInt(c.getColumnIndex(STUDENT_REG_ID))));
            stud.setStudent_name((c.getString(c.getColumnIndex(STUDENT_NAME))));
            stud.setStudent_FATHER_NAME((c.getString(c.getColumnIndex(STUDENT_FATHER_NAME))));
            stud.setStudent_Address((c.getString(c.getColumnIndex(STUDENT_ADDRESS))));
            stud.setStudent_Course((c.getString(c.getColumnIndex(STUDENT_COURSE))));
            stud.setStudent_Phone((c.getString(c.getColumnIndex(STUDENT_PHONE))));
            // student.add(stud);
            // } while (c.moveToNext());
        }else{
            stud.setStudent_REGISTRATION(-1);

        }
        c.close();
        return  stud;
    }

    public List<StudentView> getStudentNameBY(String sname)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<StudentView> student=new ArrayList<StudentView>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_REG+" where "+STUDENT_NAME;
        Cursor c = db.query(TABLE_STUDENT_REG,new String[]{STUDENT_REG_ID,STUDENT_NAME,STUDENT_FATHER_NAME,STUDENT_ADDRESS,STUDENT_PHONE,STUDENT_COURSE},STUDENT_NAME+" = ?",
                new String[]{sname },null,null,null );

        if (c.moveToFirst())
        {
            do {
                StudentView stud = new StudentView();
                stud.setStudent_REGISTRATION((c.getInt(c.getColumnIndex(STUDENT_REG_ID))));
                stud.setStudent_name((c.getString(c.getColumnIndex(STUDENT_NAME))));
                stud.setStudent_FATHER_NAME((c.getString(c.getColumnIndex(STUDENT_FATHER_NAME))));
                stud.setStudent_Address((c.getString(c.getColumnIndex(STUDENT_ADDRESS))));
                stud.setStudent_Course((c.getString(c.getColumnIndex(STUDENT_COURSE))));
                stud.setStudent_Phone((c.getString(c.getColumnIndex(STUDENT_PHONE))));
                student.add(stud);
            } while (c.moveToNext());
        }
        c.close();
        return  student;
    }
}