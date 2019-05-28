package com.example.panwar.i_m_s;

import java.util.ArrayList;

/**
 * Created by Panwar on 08-11-2016.
 */

public class CourseList {


    public ArrayList<COURSEVIEW> getCourseList(){
        ArrayList<COURSEVIEW> coList=new ArrayList<COURSEVIEW>();
        COURSEVIEW view=new COURSEVIEW("C001","Java","3 Months",5000);
        coList.add(view);
        view=new COURSEVIEW("C001","Java","3 Months",5000);
        coList.add(view);
        view=new COURSEVIEW("C002","Android","3 Months",8000);
        coList.add(view);
        view=new COURSEVIEW("C003","CCNA","2 Months",6000);
        coList.add(view);
        view=new COURSEVIEW("C004",".NET","3 Months",6000);
        coList.add(view);
        view=new COURSEVIEW("C005","C++","2 Months",4000);
        coList.add(view);
        view=new COURSEVIEW("C006","DBMS","2 Months",8000);
        coList.add(view);
        view=new COURSEVIEW("C007","Networking","2 Months",5000);
        coList.add(view);
        view=new COURSEVIEW("C008","C","1 Months",4000);
        coList.add(view);
        view=new COURSEVIEW("C009","PHP","4 Months",16000);
        coList.add(view);
        view=new COURSEVIEW("C010","LINUX","2 Months",7000);
        coList.add(view);
        view=new COURSEVIEW("C011","JUMLA","3 Months",9000);
        coList.add(view);
        view=new COURSEVIEW("C012","SEO","6 Months",15000);
        coList.add(view);
        return  coList;
    }

}
