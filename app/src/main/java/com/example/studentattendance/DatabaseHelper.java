package com.example.studentattendance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final static String TAG = "DatabaseHelper";
    private final Context myContext;
    private static final String DATABASE_NAME ="art.db";
    private static final int DATABASE_VERSION = 1;
    private String pathToSaveDBFile,s;

    private static final String TABLE_CONTACTS = "data";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CODE = "image";
    private static final String KEY_UNAME = "uname";
    private static final String KEY_PASS = "pass";
    private static final String KEY_MOBILE = "mobile";

    public DatabaseHelper(Context context, String filePath) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.myContext = context;
        pathToSaveDBFile = new StringBuffer(filePath).append("/").append(DATABASE_NAME).toString();
    }



    public void prepareDatabase() throws IOException {
        boolean dbExist = checkDataBase();

        if(dbExist) {
            Log.d(TAG, "Database exists.");
            int currentDBVersion = getVersionId();

            if (DATABASE_VERSION > currentDBVersion) {
                Log.d(TAG, "Database version is higher than old.");
                deleteDb();
                try {
                    copyDataBase();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        } else {
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }
    private boolean checkDataBase() {
        boolean checkDB = false;
        try {
            File file = new File(pathToSaveDBFile);
            checkDB = file.exists();
        } catch(SQLiteException e) {
            Log.d(TAG, e.getMessage());
        }
        return checkDB;
    }
    private void copyDataBase() throws IOException {
        OutputStream os = new FileOutputStream(pathToSaveDBFile);
        InputStream is = myContext.getAssets().open("sqlite/"+DATABASE_NAME);


        byte[] buffer = new byte[1024];
        int length;

        while ((length = is.read(buffer)) > 0) {

            os.write(buffer, 0, length);
        }
        is.close();
        os.flush();
        os.close();
    }
    public void deleteDb() {
        File file = new File(pathToSaveDBFile);
        if(file.exists()) {
            file.delete();
            Log.d(TAG, "Database deleted.");
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL("create table "+TABLE_CONTACTS+" (FIRSTNAME TEXT ,LASTNAME TEXT,USERNAME TEXT PRIMARY KEY ,PASSWORD TEXT,EMAIL TEXT,MOBILENUMBER INTEGER) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }



    public boolean insertdata(String fname, String lname, String uname, String email, String pass, String mobile) {

        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null, SQLiteDatabase.OPEN_READWRITE);


        String query = "insert into register(fname,lname,uname,email,pass,mobile) values('"+fname+"','"+lname+"','"+uname+"','"+email+"','"+pass+"','"+mobile+"')";
        db.execSQL(query);


        db.close();

        return false;
    }


    public String checklogin(String t,String uname,String pass) {

        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null, SQLiteDatabase.OPEN_READWRITE);

        Cursor cursor = db.rawQuery("SELECT * FROM "+t+" where uname='"+uname+"' and pass='"+pass+"'", null);
        cursor.moveToFirst();
        if (cursor.moveToFirst()) {
            s="success";
        }
        db.close();
        return s;


    }

    /*public Cursor getFriends()

    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null,
                SQLiteDatabase.OPEN_READWRITE);

        Cursor cursor = db.rawQuery("SELECT * FROM register", null);

        return cursor;

    }*/

    private int getVersionId() {
  		/*SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null, SQLiteDatabase.OPEN_READONLY);
 		String query = "SELECT version_id FROM dbVersion";
  		Cursor cursor = db.rawQuery(query, null);
  		cursor.moveToFirst();
  		int v =  cursor.getInt(0);
  		db.close();
  		return v; */
        return 1;
    }
}