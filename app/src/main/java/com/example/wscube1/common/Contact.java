package com.example.wscube1.common;

import java.util.Map;
import java.util.Objects;

public class Contact {
    int _id;
    String _name;
    String _phoneNumber;

    public Contact(){};

    public Contact(int id, String name, String phoneNumber){
        this._id = id;
        this._name = name;
        this._phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber){
        this._name = name;
        this._phoneNumber = phoneNumber;
    }
    public Contact(Map<String,String> json) {
        this._id = Integer.parseInt(Objects.requireNonNull(json.get("id")));
        this._name = json.get("img");
        this._phoneNumber = json.get("number");
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getPhoneNumber(){
        return this._phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this._phoneNumber = phoneNumber;
    }

}
