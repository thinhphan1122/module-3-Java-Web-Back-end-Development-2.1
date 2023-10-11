package com.example.project_winzhomes.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private String nationalId;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
//    private int roleId;
    public User(int id, String username, String password, String fullName, String dateOfBirth, String nationalId, boolean gender, String address, String phoneNumber, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.nationalId = nationalId;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

//    public User(int id, String username, String password, String fullName, String dateOfBirth, String nationalId, boolean gender, String address, String phoneNumber, String email, int roleId) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.fullName = fullName;
//        this.dateOfBirth = dateOfBirth;
//        this.nationalId = nationalId;
//        this.gender = gender;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.roleId = roleId;
//    }

    public User(String username, String password, String fullName, String dateOfBirth, String nationalId, boolean gender, String address, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.nationalId = nationalId;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
