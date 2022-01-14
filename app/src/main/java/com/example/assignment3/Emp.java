package com.example.assignment3;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class Emp extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;
    public Emp( Context context) {
        super(context, "employee.db", null, 1);
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table person (Name text,Phone text,Password text, Location text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    public void savedb(String names, String mobs, String ps, String ls) {

        ContentValues cv = new ContentValues();
        cv.put("Name",names);
        cv.put("Phone",mobs);
        cv.put("Password",ps);
        cv.put("Location",ls);

        sqLiteDatabase.insert("person",null,cv);
        //return "hello";
    }

    public ArrayList<String> retrvloc(String sna2) {
        ArrayList<String> s = new ArrayList<String>();
        Cursor c;
        c= sqLiteDatabase.query("person",null,"Phone=?",new String[]{sna2},
                null,null,null);

        c.moveToFirst();

        if(c.getCount()<1){
            s.add("user does not exist");
            return  s;
        }

        //String v1= c.getString(c.getColumnIndex("Password"));
        s.add(c.getString(c.getColumnIndex("Password")));
        s.add(c.getString(c.getColumnIndex("Name")));
        s.add(c.getString(c.getColumnIndex("Location")));

        //String v2 =c.getString(c.getColumnIndex("Location"));
        //String v3 = c.getString(c.getColumnIndex("Phone"));

        return s;
    }
}
