package com.example.myapplication.API;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinalResult {

    @SerializedName("catId")
    @Expose
    private Integer catId;
    @SerializedName("c_name")
    @Expose
    private String cName;
    @SerializedName("catImg")
    @Expose
    private String catImg;
    @SerializedName("lst")
    @Expose
    private ArrayList<Lst> lst = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public FinalResult() {
    }

    /**
     *
     * @param catImg
     * @param cName
     * @param catId
     * @param lst
     */
    public FinalResult(Integer catId, String cName, String catImg, ArrayList<Lst> lst) {
        super();
        this.catId = catId;
        this.cName = cName;
        this.catImg = catImg;
        this.lst = lst;
    }

    public Integer getCatId() {
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

    public ArrayList<Lst> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Lst> lst) {
        this.lst = lst;
    }

}