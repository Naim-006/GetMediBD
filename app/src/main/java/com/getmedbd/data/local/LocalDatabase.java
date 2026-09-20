package com.getmedbd.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Local database helper
 */
public class LocalDatabase extends SQLiteOpenHelper {
    
    private static final String DATABASE_NAME = "getmedbd.db";
    private static final int DATABASE_VERSION = 1;
    
    public LocalDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade database
    }
}
