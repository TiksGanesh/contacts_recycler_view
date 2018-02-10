package com.example.ganeshtikone.contacts;

import android.provider.BaseColumns;

/**
 * Created by ganeshtikone on 10/02/18.
 *
 * Database table meta-data class
 */

public class AppDatabaseContract {

    public static class Contact implements BaseColumns {

        public static final String TABLE_NAME = "contacts";

        public static final String COL_NAME = "contact_name";
        public static final String COL_PHONE = "contact_phone";
    }

}
