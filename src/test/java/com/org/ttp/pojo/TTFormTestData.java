package com.org.ttp.pojo;

import org.apache.commons.lang3.StringUtils;

public class TTFormTestData {
    private String firstname;

    private String lastName;
    private String email;

    private String gender;
    private String mobileNum;

    private String dob;
    private String[] hobbies;

    private String location;

    private String address;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = StringUtils.split(hobbies,",");;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
