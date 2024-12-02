
package com.example.wscube1.ApiCallDemo;
import java.util.List;

import java.time.OffsetDateTime;

public class UserModel {
    private String dateOfBirth;
    private String mobileNumber;
    private String userName;
    private String email;
    private String userImg;
    private String city;
    private String id;

    public UserModel(String dateOfBirth, String mobileNumber, String userName, String email, String userImg, String city, String id) {
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.email = email;
        this.userImg = userImg;
        this.city = city;
        this.id = id;
    }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String value) { this.dateOfBirth = value; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String value) { this.mobileNumber = value; }

    public String getUserName() { return userName; }
    public void setUserName(String value) { this.userName = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getUserImg() { return userImg; }
    public void setUserImg(String value) { this.userImg = value; }

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public String getid() { return id; }
    public void setid(String value) { this.id = value; }
}
