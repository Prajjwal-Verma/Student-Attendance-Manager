package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.shimmer.ShimmerFrameLayout;

public class MainActivity extends AppCompatActivity {
    protected boolean active = true;
    protected int splashTime = 14500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread splashThread = new Thread()
        {
            public void run()
            {
                try
                {
                    int waited=0;
                    while(active&&(waited<splashTime))
                    {
                        sleep(40);
                        if(active)
                        {
                            waited+=100;
                        }
                    }
                }
                catch(InterruptedException e)
                {
                    //Do Nothing
                }
                finally
                {
                    finish();
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
            }
        };
        ShimmerFrameLayout container =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        container.startShimmer();
        splashThread.start();
    }
}
