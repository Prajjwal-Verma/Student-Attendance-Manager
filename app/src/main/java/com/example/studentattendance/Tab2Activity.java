package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Tab2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);
        RecyclerView programminglist2 = (RecyclerView) findViewById(R.id.programminglist2);
        programminglist2.setLayoutManager(new LinearLayoutManager(this));
        String[] language = {"Student Name 1" , "Student Name 2" , "Student Name 3" , "Student Name 4" , "Student Name 5" ,
                "Student Name 6" , "Student Name 7" , "Student Name 8" , "Student Name 9" , "Student Name 10" ,
                "Student Name 11" , "Student Name 12" , "Student Name 13" , "Student Name 14" , "Student Name 15" , "Student Name 16"};
        programminglist2.setAdapter(new ProgrammingAdapter2(language));
    }
}
