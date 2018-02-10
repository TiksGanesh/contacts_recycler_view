package com.example.ganeshtikone.contacts;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {


    private TextInputLayout textInputLayoutPersonName;
    private TextInputLayout textInputLayoutPhoneNumber;

    private AppCompatEditText editTextPersonName;
    private AppCompatEditText editTextPhoneNumber;
    private AppCompatButton buttonSaveContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();
        addListener();

    }

    /**
     * Add Listener on component
     */
    private void addListener() {
        buttonSaveContact.setOnClickListener(this);
    }

    /**
     * Initialise User Interface
     */
    private void initUI() {

        textInputLayoutPersonName = findViewById(R.id.textInputLayoutPersonName);
        textInputLayoutPhoneNumber = findViewById(R.id.textInputLayoutPhoneNumber);
        editTextPersonName = findViewById(R.id.editTextContactName);
        editTextPhoneNumber = findViewById(R.id.editTextContactNumber);

        buttonSaveContact = findViewById(R.id.buttonSaveContact);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.buttonSaveContact){
            saveContactToDatabase();
        }
    }

    /**
     * Save new contact to database
     */
    private void saveContactToDatabase() {

        String personName = editTextPersonName.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();

        if (!validPersonName(personName)){
            textInputLayoutPersonName.setError("Invalid person name");
            return;
        }else {
            textInputLayoutPersonName.setErrorEnabled(false);
        }

        if (!validPhoneNumber(phoneNumber)){
            textInputLayoutPhoneNumber.setError("Invalid phone number");
            return;
        }else {
            textInputLayoutPhoneNumber.setErrorEnabled(false);
        }

        // Add new contact to database logic

        AppDatabaseHelper helper = new AppDatabaseHelper(this);
        long id = helper.insertContact(personName,phoneNumber);
        if (id > 0){
            showToast("Operation Success");
            editTextPhoneNumber.setText("");
            editTextPersonName.setText("");
        }else {
            showToast("Operation failed");
        }



    }

    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    /**
     * Validate phone number
     * @param phoneNumber String object
     * @return boolean true if valid input else false
     */
    private boolean validPhoneNumber(String phoneNumber) {

        final int MAX_PHONE_LENGTH = 10;
        final int MIN_PHONE_LENGTH = 8;

        int length = phoneNumber.length();

        boolean isContainsOnlyDigit = TextUtils.isDigitsOnly(phoneNumber);

        return isContainsOnlyDigit
                && length >= MIN_PHONE_LENGTH
                && length <= MAX_PHONE_LENGTH;
    }

    /**
     * Validate person name
     * @param personName String object
     * @return boolean true if valid input else false
     */
    private boolean validPersonName(String personName) {

        Pattern namePattern = Pattern.compile("[a-zA-Z]+");
        return namePattern.matcher(personName).matches();
    }
}
