package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.BoringLayout;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){
        //наименование и версия бд
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        //запрос на создание таблицы в бд
        sqLiteDatabase.execSQL("create Table UserInfo(name TEXT primary key, " +
                "phone TEXT, date_of_birth TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        //условие на удаление таблицы UserInfo
        sqLiteDatabase.execSQL("drop Table if exists UserInfo");
    }


    public Boolean insert(String name, String phone, String date_of_birth){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("date_of_birth", date_of_birth);
        long result = DB.insert("UserInfo", null, contentValues);
        return result != -1;
    }

    public Boolean select(String name, String phone, String date_of_birth){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("date_of_birth", date_of_birth);
        long result = DB.insert("UserInfo", null, contentValues);
        return result != -1;
    }

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("Select * from UserInfo", null);
    }

    public Boolean Delete(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int a = db.delete("UserInfo",
                "name = " + "'" + name + "'", null
        );
        db.close();
        return a > 0;
    }
}
