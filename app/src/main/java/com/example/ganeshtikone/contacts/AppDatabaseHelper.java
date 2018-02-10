package com.example.ganeshtikone.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ganeshtikone on 10/02/18.
 * Class: AppDatabaseHelper
 * Database Helper Class
 * Insert/Update/Delete/Query
 */

public class AppDatabaseHelper extends SQLiteOpenHelper{

    /**
     * Database name
     */
    private static final String DATABASE_NAME = "mycontacts.sqlite";

    /**
     * Database Version
     */
    private static final int DATABASE_VERSION = 1;


    public AppDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String createTableQuery = " CREATE TABLE " + AppDatabaseContract.Contact.TABLE_NAME
                + " ( "
                + AppDatabaseContract.Contact._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + AppDatabaseContract.Contact.COL_NAME + " TEXT NOT NULL , "
                + AppDatabaseContract.Contact.COL_PHONE + " TEXT NOT NULL "
                +" ) ";


        try {
            sqLiteDatabase.execSQL(createTableQuery);
        }catch (SQLException ex){
            Log.e("####",ex.getLocalizedMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // not required
    }


    // 1. Insert into contact table
    // 2. Get All rows from contact table


    /**
     * Insert contact into contact table
     * @param name String
     * @param phone String
     * @return long new row id if success else 0
     */
    public long insertContact(String name, String phone){

        SQLiteDatabase databaseConnection = getWritableDatabase();

        ContentValues newRow = new ContentValues();
        newRow.put(AppDatabaseContract.Contact.COL_NAME,name);
        newRow.put(AppDatabaseContract.Contact.COL_PHONE,phone);


        long id = databaseConnection.insert(
                AppDatabaseContract.Contact.TABLE_NAME,
                null,
                newRow
        );

        databaseConnection.close();
        return id;
    }


    /**
     * Get All rows from contact table
     */
    public List<MyContacts> getAllContacts(){

        List<MyContacts> contacts = new ArrayList<>();

        SQLiteDatabase databaseConnection = getReadableDatabase();

        Cursor result = databaseConnection.query(
                AppDatabaseContract.Contact.TABLE_NAME,
                null, //*
                null, // WHERE
                null, // WHERE CLAUSE ARGUMENTS
                null, // GROUP BY
                null, // Having
                AppDatabaseContract.Contact._ID+ " DESC "
        );



        if (result.moveToFirst()){

            do {

                // Get Value from Result Set
                String name = result.getString(
                        result.getColumnIndex(
                                AppDatabaseContract.Contact.COL_NAME
                        ));

                String phone = result.getString(
                        result.getColumnIndex(
                                AppDatabaseContract.Contact.COL_PHONE
                        ));

                // Add Value to List : MyContact object
                contacts.add(new MyContacts(name,phone));


            }while (result.moveToNext());
        }


        result.close();
        databaseConnection.close();

        return contacts;
    }














}
