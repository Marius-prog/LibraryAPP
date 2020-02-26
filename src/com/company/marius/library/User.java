package com.company.marius.library;

public class User extends LibraryItem {

    private int mobileNumber;
    private String name;

    public User(String name, int userId, int mobileNumber) {
        this.name = name;
        super.setId(userId);
        this.mobileNumber = mobileNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + super.getId() +
                ", mobilNumber=" + mobileNumber +
                '}';
    }
}
