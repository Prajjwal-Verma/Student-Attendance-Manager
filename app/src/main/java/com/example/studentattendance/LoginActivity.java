package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;
    TextView tx1;
    int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        tx1 = (TextView) findViewById(R.id.TextView3);
        tx1.setVisibility(View.GONE);

        final DatabaseHelper db = new DatabaseHelper(this, getFilesDir().getAbsolutePath());
        try {
            db.prepareDatabase();
        }catch (IOException e){
            Log.e("Registeation",e.getMessage());
        }
        /*DatabaseHelper db = new DatabaseHelper(this);
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT USERNAME, PASSWORD FROM STUDENT_TABLE",new  String[]{});
        if(cursor != null){
            cursor.moveToNext();
        }
        final StringBuilder builder1 = new StringBuilder();
        final StringBuilder builder2 = new StringBuilder();
            do{
                String username = cursor.getString(3);
                String password = cursor.getString(4);
                builder1.append(username);
                builder2.append(password);

            }while (cursor.moveToNext());*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg= db.checklogin("register",ed1.getText().toString(),ed2.getText().toString());
                if (msg.equals("success"))
                {
                    Intent intents = new Intent(LoginActivity.this, MainScreen.class);
                    startActivity(intents);
                }

                if (ed1.getText().toString().isEmpty()) {
                    ed1.setError("Username not entered");
                    ed1.requestFocus();
                }
                if (ed2.getText().toString().isEmpty()) {
                    ed2.setError("Password not entered");
                    ed2.requestFocus();
                }
                if (ed1.getText().toString().equals("User") && ed2.getText().toString().equals("Password")) {

                    Toast.makeText(getApplicationContext(),"go",Toast.LENGTH_LONG).show();
                } else {

                    tx1.setVisibility(View.VISIBLE);
                    // tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                        StyleableToast.makeText(getApplicationContext(), "Wrong Candidate", Toast.LENGTH_SHORT, R.style.mytoast).show();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Registration.class);
                startActivity(i);
            }
        });
    }
}
