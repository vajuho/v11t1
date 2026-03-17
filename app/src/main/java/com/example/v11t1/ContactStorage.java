package com.example.v11t1;

import java.util.ArrayList;

public class ContactStorage {
    private static ContactStorage instance;
    private ArrayList<Contact> contacts = new ArrayList<>();

    private ContactStorage() {
    }
    public static ContactStorage getInstance() {
        if (instance == null) {
            instance = new ContactStorage();
        }
        return instance;
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void removeContact(int num) {
        contacts.remove(num);
    }
}
