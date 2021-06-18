package com.example.vicky.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EntityDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "list_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table "+EntityContract.ListEntry.TABLE_NAME+
            "("+EntityContract.ListEntry.LIST_ID+" number,"+EntityContract.ListEntry.ITEM_NAME+" text,"+
            EntityContract.ListEntry.COST_PER_UNIT+" number,"+EntityContract.ListEntry.QUANTITY+" text);";
    public static final String DROP_TABLE = "drop table if exists "+EntityContract.ListEntry.TABLE_NAME;

    public EntityDbHelper (Context context){

        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database Operations", "Database Created...");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table Created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void addListItem(int id, String item, int cost, String quantity, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(EntityContract.ListEntry.LIST_ID, id);
        contentValues.put(EntityContract.ListEntry.ITEM_NAME, item);
        contentValues.put(EntityContract.ListEntry.COST_PER_UNIT, cost);
        contentValues.put(EntityContract.ListEntry.QUANTITY, quantity);

        db.insert(EntityContract.ListEntry.TABLE_NAME, null,contentValues);
        Log.d("Database Operations", "One Row Inserted...");
    }
}
