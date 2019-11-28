package com.example.vanshika.innovaccer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME2 = "Host.db";
    public static final String TABLE_NAME2 = "host_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PHONE";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME2 +" (NAME TEXT,EMAIL TEXT,PHONE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }


    public boolean insert2(String name, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,phone);
        long result = db.insert(TABLE_NAME2,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }

    public List<String> getHost() {
        List<String> hList = new ArrayList<String>();
        Cursor cursor = null;
        String name = "";
        String em = "";
        String phone = "";
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME2 + " ORDER BY RANDOM() LIMIT 1",null);
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                name= cursor.getString(cursor.getColumnIndex(COL_1));
                em= cursor.getString(cursor.getColumnIndex(COL_2));
                phone= cursor.getString(cursor.getColumnIndex(COL_3));
                hList.add(name);
                hList.add(em);
                hList.add(phone);
            }
            return hList;
        }finally {
            cursor.close();
        }
    }

   /* public List<String> getAllQuestions() {
        List<String> quesList = new ArrayList<String>();
        String name = "";
        String em = "";
        String phone = "";
        String selectQuery = "SELECT * FROM " + TABLE_NAME2 + " ORDER BY RANDOM() LIMIT 1";
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                name= cursor.getString(cursor.getColumnIndex(COL_1));
                em= cursor.getString(cursor.getColumnIndex(COL_2));
                phone= cursor.getString(cursor.getColumnIndex(COL_3));
                quesList.add(name);
                quesList.add(em);
                quesList.add(phone);
            } while (cursor.moveToNext());
        }
        return quesList;
    }*/

    public boolean updateData2(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        db.update(TABLE_NAME2, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData2 (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2, "ID = ?",new String[] {id});
    }
}