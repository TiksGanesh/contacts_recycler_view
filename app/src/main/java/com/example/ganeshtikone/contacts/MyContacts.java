package com.example.ganeshtikone.contacts;

/**
 * Created by ganeshtikone on 31/01/18.
 */

public class MyContacts {

    private String contactName;
    private String contactNumber;

    public MyContacts() {
    }

    public MyContacts(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
