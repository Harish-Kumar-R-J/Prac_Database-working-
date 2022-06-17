package com.example.database_conn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHelper extends SQLiteOpenHelper {
    static String DB_NAME="Login.db";
    public DbHelper(Context context) {
        super(context,DB_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(username TEXT ,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table  if exists login");
    }

    public Boolean insertData(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long res=db.insert("login",null,contentValues);
        return res != -1;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from login where username= ?",new String[]{username});
        return cursor.getCount() > 0;
    }

    public Boolean checkCred(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from login where username= ? and password= ?",new String[]{username,password});
        return cursor.getCount()>0;
    }
}
