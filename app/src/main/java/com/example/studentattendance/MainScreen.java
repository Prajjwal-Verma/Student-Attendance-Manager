package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainScreen extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);


        TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        TabSpec tab3 = tabHost.newTabSpec("Third tab");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected

        tab1.setIndicator("Class");
        //tab1.setIndicator("",getResources().getDrawable(R.drawable.ic_launcher));
        tab1.setContent(new Intent(this,Tab1Activity.class));

        tab2.setIndicator("Student");
        //tab2.setIndicator("",getResources().getDrawable(R.drawable.target));
        tab2.setContent(new Intent(this,Tab2Activity.class));

        tab3.setIndicator("Info.");
        //tab3.setIndicator("",getResources().getDrawable(R.drawable.teamwork));
        tab3.setContent(new Intent(this,Tab3Activity.class));

        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
}
