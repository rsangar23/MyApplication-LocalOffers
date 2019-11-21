package com.example.myapplication.API;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeadingBanner {

    @SerializedName("imgs")
    @Expose
    private String imgs;

    /**
     * No args constructor for use in serialization
     *
     */
    public HeadingBanner() {
    }

    /**
     *
     * @param imgs
     */
    public HeadingBanner(String imgs) {
        super();
        this.imgs = imgs;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

}