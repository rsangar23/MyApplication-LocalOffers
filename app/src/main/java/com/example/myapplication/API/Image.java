package com.example.myapplication.API;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URI;

public class Image {

    @SerializedName("img")
    private String img;
    @SerializedName("nam")
    private String nam;


    public Image(String img, String nam) {
        this.img = img;
        this.nam = nam;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

}
