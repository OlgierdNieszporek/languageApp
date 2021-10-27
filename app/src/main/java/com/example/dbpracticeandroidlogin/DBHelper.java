package com.example.dbpracticeandroidlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(  userId INTEGER primary key AUTOINCREMENT,username TEXT ,password TEXT)");
        MyDB.execSQL("create Table collections(collectionId INTEGER primary key AUTOINCREMENT, collectionName TEXT, userIdInCollection INTEGER REFERENCES userId)");
        MyDB.execSQL("create Table words(wordId INTEGER primary key AUTOINCREMENT, word TEXT, translation, collectionIdInWords INTEGER REFERENCES collectionId)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists collections");
    }

    public Boolean insertUserData(String username, String password){
        SQLiteDatabase MyDB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDB.insert("users", null , contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?",new String[] {username} );
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkUsernamePassword(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username= ? and password = ?",new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }

    }

    public Boolean insertCollectionName(String collectionName){
        SQLiteDatabase MyDB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("collectionName",collectionName);
        long result = MyDB.insert("collections", null , contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }


}
