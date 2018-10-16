package com.example.cln62.service2actbylocalbro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataSourceDAO {
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper dataSourceDbHelper;

    public DataSourceDAO(Context context) {
        dataSourceDbHelper = new DbHelper(context);
        sqLiteDatabase = dataSourceDbHelper.getWritableDatabase();
    }

    public void dbInitializer() {
        ContentValues values = new ContentValues();
        values.put("Nothing", "or?");
        values.put("Really", "of course!");
        sqLiteDatabase.insert("MYTABLE", null, values);
    }

    public String getData() {
        Cursor cursor = sqLiteDatabase.query("MYTABLE", null, null, null, null,
                null, null);

        cursor.moveToLast();
        int dataPosition = cursor.getColumnIndexOrThrow("Nothing");
        String data = cursor.getString(dataPosition);
        return data;
    }
}
