package com.example.v11t1;

public class Contact {
    private String firstName;
    private String lastName;
    private String number;
    private String contactGroup;

    public  Contact (String firstName, String surName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = surName;
        this.number = number;
        this.contactGroup = contactGroup;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
