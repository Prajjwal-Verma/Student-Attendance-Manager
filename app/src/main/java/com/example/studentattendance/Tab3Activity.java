package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Tab3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);
        RecyclerView programminglist3 = (RecyclerView) findViewById(R.id.programminglist3);
        programminglist3.setLayoutManager(new LinearLayoutManager(this));
        String[] language = {"Student Info. 1" , "Student Info. 2" , "Student Info. 3" , "Student Info. 4" , "Student Info. 5" ,
                "Student Info. 6" , "Student Info. 7" , "Student Info. 8" , "Student Info. 9" , "Student Info. 10" ,
                "Student Info. 11" , "Student Info. 12" , "Student Info. 13" , "Student Info. 14" , "Student Info. 15" , "Student Info. 16"};
        programminglist3.setAdapter(new ProgrammingAdapter3(language));
    }
}
