package com.example.vanshika.innovaccer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Visitor.db";
    public static final String TABLE_NAME1 = "visitor_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PHONE";
    public static final String COL_4 = "CHECKIN";
    public static final String COL_5 = "CHECKOUT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + " (NAME TEXT,EMAIL TEXT,PHONE TEXT,CHECKIN TEXT,CHECKOUT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public boolean insert1(String name, String email, String phone, String checkin, String checkout) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, checkin);
        contentValues.put(COL_5, checkout);
        long result = db.insert(TABLE_NAME1, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME1, null);
        return res;
    }
}