package com.example.wscube1.common;

import java.util.Map;

public class ContactModel {
    private final String name;
    private final String img;
    private final String number;

    public ContactModel(String name, String img, String number) {
        this.name = name;
        this.img = img;
        this.number = number;
    }


    public ContactModel(Map<String,String> json) {
        this.name = json.get("name");
        this.img = json.get("img");
        this.number = json.get("number");
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getNumber() {
        return number;
    }

    public Map<String,String> toJson() {
        return  Map.of("name",name,"img",img,"number",number);
    }
}


