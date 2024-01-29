package com.example.studentattendance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class Registration extends AppCompatActivity {
    Button btnReg,btnView;
    EditText edtFirst,edtLast, edtUser, edtPass, edtConfPass, edtEmail,edtmobile;
    DatabaseHelper mydb;
   // private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +"(?=.*[0-9])" + "(?=.*[a-z])" +"(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=.\\S+$)" +".{6,})" + "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /*mydb = new DatabaseHelper(this, getFilesDir().getAbsolutePath());

		try {
        mydb.prepareDatabase();
		} catch (IOException e) {
			Log.e("Registration", e.getMessage());
		}*/


        edtFirst=(EditText)findViewById(R.id.edtfirstname);
        edtLast=(EditText)findViewById(R.id.edtlastname);
        edtUser=(EditText)findViewById(R.id.edtUsername);
        edtPass=(EditText)findViewById(R.id.edtPass);
        edtConfPass=(EditText)findViewById(R.id.edtConfirmPass);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtmobile=(EditText)findViewById(R.id.edtMob);
        //Initialization of Register Button
        btnReg=(Button)findViewById(R.id.button1);
        btnView=(Button)findViewById(R.id.button2);
        mydb = new DatabaseHelper(this, getFilesDir().getAbsolutePath());
        //Registration button functionality
        btnReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String emailInput = edtEmail.getEditableText().toString().trim();
                if(edtFirst.getText().toString().length()==0){
                    edtFirst.setError("First name not entered");
                    edtFirst.requestFocus();
                }
                if(edtLast.getText().toString().length()==0){
                    edtLast.setError("Last name not entered");
                    edtLast.requestFocus();
                }

                if(edtUser.getText().toString().length()==0){
                    edtUser.setError("Username is Required");
                    edtUser.requestFocus();
                }
                if(edtPass.getText().toString().length()==0){
                    edtPass.setError("Password not entered");
                    edtPass.requestFocus();
                }
                if(edtConfPass.getText().toString().length()==0){
                    edtConfPass.setError("Please confirm password");
                    edtLast.requestFocus();
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
                    edtEmail.setError("Please enter a valid email address");
                    edtEmail.requestFocus();
                }
                if(!edtPass.getText().toString().equals(edtConfPass.getText().toString())){
                    edtConfPass.setError("Password Not matched");
                    edtConfPass.requestFocus();
                }
                if(edtPass.getText().toString().length()<6 ){
                    edtPass.setError("Password should be atleast of 8 charactors");
                    edtPass.requestFocus();
                }
                if(edtmobile.getText().toString().length()<8 ){
                    edtmobile.setError("Password should be atleast of 8 charactors");
                    edtmobile.requestFocus();
                }

                else {

                    insertdata();

                }

            }
        }); viewData();
    }
    public void insertdata(){
        btnReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertdata(edtFirst.getText().toString() , edtLast.getText().toString() , edtUser.getText().toString() , edtPass.getText().toString() ,  edtEmail.getText().toString() , edtmobile.getText().toString() );

                        if(isInserted == true)
                            StyleableToast.makeText(getApplicationContext(), "Data Inserted !!!", Toast.LENGTH_SHORT,R.style.mytoast3).show();
                        else
                            Toast.makeText(getApplicationContext(),"Database Error",Toast.LENGTH_LONG).show();
                    }
                } );
    }

    public void viewData() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Cursor res = mydb.insertdata();
                if(res.getCount()==0){
                    //Show Message
                    showMessages("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("First Name :- "+res.getString(0)+"\n");
                    buffer.append("Last Name :- "+res.getString(1)+"\n");
                    buffer.append("Username :- "+res.getString(2)+"\n");
                    buffer.append("Password :- "+res.getString(3)+"\n");
                    buffer.append("Email :- "+res.getString(4)+"\n");
                    buffer.append("Mobile No. :- "+res.getString(5)+"\n\n");
                }
                //Show All Data
                showMessages("Data",buffer.toString());
                StyleableToast.makeText(getApplicationContext(), "Data Showing", Toast.LENGTH_SHORT,R.style.mytoast2).show();
            }
        });
    }

    public void showMessages(String title,String Message)
    {
        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
