package com.company.marius.library;

public class User extends LibraryItem {

    private int mobileNumber;
    private String name;

    public User(String name, int userId, int mobileNumber) {
        this.name = name;
        super.setId(userId);
        this.mobileNumber = mobileNumber;
    }
}
