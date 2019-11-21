package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("loc_name")
    @Expose
    private String locName;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param status
     * @param locName
     */
    public Location(String locName, String status) {
        super();
        this.locName = locName;
        this.status = status;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}