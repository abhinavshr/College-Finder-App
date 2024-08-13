package com.example.collegefinder.Model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user")
public class RequestLogin {

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    public RequestLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
}