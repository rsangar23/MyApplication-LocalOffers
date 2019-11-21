package com.example.myapplication;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {

    @SerializedName("catId")
    @Expose
    private Integer catId;
    @SerializedName("c_name")
    @Expose
    private String cName;
    @SerializedName("catImg")
    @Expose
    private String catImg;

    /**
     * No args constructor for use in serialization
     *
     */
    public Category() {
    }

    /**
     *
     * @param catImg
     * @param cName
     * @param catId
     */
    public Category(Integer catId, String cName, String catImg) {
        super();
        this.catId = catId;
        this.cName = cName;
        this.catImg = catImg;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCatImg() {
        return catImg;
    }

    public void setCatImg(String catImg) {
        this.catImg = catImg;
    }

}