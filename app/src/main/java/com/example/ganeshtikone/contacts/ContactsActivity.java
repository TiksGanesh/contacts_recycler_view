package com.example.ganeshtikone.contacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity
  implements MyContactAdapter.OnContactClickListener{

    private List<MyContacts> myContactsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createDummyData();
        initRecyclerView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * initialise recyclerview and adapter
     */
    private void initRecyclerView() {

        RecyclerView recyclerViewContacts = findViewById(R.id.recyclerViewContacts);
        recyclerViewContacts.setHasFixedSize(true);
        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this));

        MyContactAdapter contactAdapter = new MyContactAdapter(
                myContactsList,
                this
        );
        contactAdapter.setListener(this);

        recyclerViewContacts.setAdapter(contactAdapter);

    }

    /**
     * Create MyContacts object and Add it to list
     */
    private void createDummyData() {


        myContactsList = new ArrayList<>();

        MyContacts amitabh = new MyContacts("Mr. Amitabh Bachhan",
                "982201020304");

        MyContacts amir = new MyContacts("Mr. Amir Khan",
                "98220100908");

        MyContacts salman = new MyContacts("Mr. Salman Khan",
                "900201020304");

        MyContacts ranbir = new MyContacts("Mr. Ranbir Kapoor",
                "0123456789");

        MyContacts ranvir = new MyContacts("Mr. Ranvir Singh",
                "54634278212");

        MyContacts priyanka = new MyContacts("Ms. Priyanka Chopra",
                "2345678901");

        MyContacts madhuri = new MyContacts("Mrs. Madhuri Nene",
                "9865432198");

        myContactsList.add(madhuri);
        myContactsList.add(priyanka);
        myContactsList.add(amitabh);
        myContactsList.add(amir);
        myContactsList.add(salman);
        myContactsList.add(ranbir);
        myContactsList.add(ranvir);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onContactClick(int position) {

        String name = myContactsList.get(position).getContactName();

            Toast.makeText(this,
                    "Tapped on :"+name,
                    Toast.LENGTH_SHORT).show();

    }
}
