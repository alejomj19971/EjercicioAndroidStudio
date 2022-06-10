package com.example.entregafinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=3;
    public static final String DATABASE_NAME = "newbikestore";

    public DBHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT  ,"+ "name VARCHAR(60),email VARCHAR(60),"+"identification int,"+ "password VARCHAR(20))");
        db.execSQL("CREATE TABLE products(idpro INTEGER PRIMARY KEY AUTOINCREMENT  ,"+ "productName VARCHAR(60),productReference VARCHAR(60),"+"productId int,"+ " description VARCHAR(60))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS products");
        onCreate(db);
    }
}
