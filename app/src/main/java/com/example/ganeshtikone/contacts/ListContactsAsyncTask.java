package com.example.ganeshtikone.contacts;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Created by ganeshtikone on 03/02/18.
 * Class: ListContactsAsyncTask
 * Implementation of Async Task Class
 * to get all contacts from SQLite Database
 */

public class ListContactsAsyncTask extends AsyncTask<Void,Void,List<MyContacts>>{

    private static final String TAG = ListContactsAsyncTask.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG,"in on preexecute method");
    }

    @Override
    protected List<MyContacts> doInBackground(Void... voids) {
        //TODO: SQLITE DATABASE CODE
        Log.e(TAG,"in on doInBackground method");
        return null;
    }


    @Override
    protected void onPostExecute(List<MyContacts> myContacts) {
        super.onPostExecute(myContacts);
        Log.e(TAG,"in on post execute method");
    }
}
