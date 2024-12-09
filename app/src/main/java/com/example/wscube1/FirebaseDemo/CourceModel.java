package com.example.wscube1.FirebaseDemo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CourceModel implements Parcelable {
    private String CourceName;
    private String CourcePrice;
    private String CourceSutedFor;
    private String CourceImgLink;
    private String CourceLink;
    private String CourceDescri;
    private String CourceID;

    public CourceModel(){

    }

    public CourceModel(String courceName, String courcePrice, String courceSutedFor, String courceImgLink, String courceLink, String courceDescri, String courceID) {
        this.CourceName = courceName;
        this.CourcePrice = courcePrice;
        this.CourceSutedFor = courceSutedFor;
        this.CourceImgLink = courceImgLink;
        this.CourceLink = courceLink;
        this.CourceDescri = courceDescri;
        this.CourceID = courceID;
    }

    protected CourceModel(Parcel in) {
        CourceName = in.readString();
        CourcePrice = in.readString();
        CourceSutedFor = in.readString();
        CourceImgLink = in.readString();
        CourceLink = in.readString();
        CourceDescri = in.readString();
        CourceID = in.readString();
    }

    public static final Creator<CourceModel> CREATOR = new Creator<CourceModel>() {
        @Override
        public CourceModel createFromParcel(Parcel in) {
            return new CourceModel(in);
        }

        @Override
        public CourceModel[] newArray(int size) {
            return new CourceModel[size];
        }
    };

    public String getCourceName() {
        return CourceName;
    }

    public void setCourceName(String courceName) {
        CourceName = courceName;
    }

    public String getCourcePrice() {
        return CourcePrice;
    }

    public void setCourcePrice(String courcePrice) {
        CourcePrice = courcePrice;
    }

    public String getCourceSutedFor() {
        return CourceSutedFor;
    }

    public void setCourceSutedFor(String courceSutedFor) {
        CourceSutedFor = courceSutedFor;
    }

    public String getCourceImgLink() {
        return CourceImgLink;
    }

    public void setCourceImgLink(String courceImgLink) {
        CourceImgLink = courceImgLink;
    }

    public String getCourceLink() {
        return CourceLink;
    }

    public void setCourceLink(String courceLink) {
        CourceLink = courceLink;
    }

    public String getCourceDescri() {
        return CourceDescri;
    }

    public void setCourceDescri(String courceDescri) {
        CourceDescri = courceDescri;
    }

    public String getCourceID() {
        return CourceID;
    }

    public void setCourceID(String courceID) {
        CourceID = courceID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(CourceName);
        parcel.writeString(CourcePrice);
        parcel.writeString(CourceSutedFor);
        parcel.writeString(CourceImgLink);
        parcel.writeString(CourceLink);
        parcel.writeString(CourceDescri);
        parcel.writeString(CourceID);
    }
}
