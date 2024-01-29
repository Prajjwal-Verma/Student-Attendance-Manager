package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Tab1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);
        RecyclerView programminglist1 = (RecyclerView) findViewById(R.id.programminglist1);
        programminglist1.setLayoutManager(new LinearLayoutManager(this));
        String[] language = {"Branch Name 1" , "Branch Name 2" , "Branch Name 3" , "Branch Name 4" , "Branch Name 5" ,
                "Branch Name 6" , "Branch Name 7" , "Branch Name 8" , "Branch Name 9" , "Branch Name 10" ,
                "Branch Name 11" , "Branch Name 12" , "Branch Name 13" , "Branch Name 14" , "Branch Name 15" , "Branch Name 16"};
        programminglist1.setAdapter(new ProgrammingAdapter1(language));
    }
}
