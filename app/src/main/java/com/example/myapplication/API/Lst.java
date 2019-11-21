package com.example.myapplication.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lst {

    @SerializedName("imgs")
    @Expose
    private String imgs;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("vtxt")
    @Expose
    private String vtxt;
    @SerializedName("vamt")
    @Expose
    private String vamt;
    @SerializedName("vtxt1")
    @Expose
    private String vtxt1;
    @SerializedName("vamt1")
    @Expose
    private String vamt1;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("det")
    @Expose
    private String det;
    @SerializedName("vtxt2")
    @Expose
    private String vtxt2;
    @SerializedName("vamt2")
    @Expose
    private String vamt2;
    @SerializedName("vtxt3")
    @Expose
    private String vtxt3;
    @SerializedName("vamt3")
    @Expose
    private String vamt3;
    @SerializedName("map")
    @Expose
    private String map;
    @SerializedName("addr")
    @Expose
    private String addr;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    /**
     * No args constructor for use in serialization
     *
     */
    public Lst() {
    }

    /**
     *
     * @param imgs
     * @param desc
     * @param det
     * @param vamt1
     * @param addr
     * @param info
     * @param vtxt3
     * @param vtxt
     * @param vtxt2
     * @param vamt
     * @param name
     * @param map
     * @param vamt3
     * @param vamt2
     * @param vtxt1
     */
    public Lst(String imgs, String name, String info, String vtxt, String vamt, String vtxt1, String vamt1, String desc, String det, String vtxt2, String vamt2, String vtxt3, String vamt3, String map, String addr, Double lat, Double lng) {
        super();
        this.imgs = imgs;
        this.name = name;
        this.info = info;
        this.vtxt = vtxt;
        this.vamt = vamt;
        this.vtxt1 = vtxt1;
        this.vamt1 = vamt1;
        this.desc = desc;
        this.det = det;
        this.vtxt2 = vtxt2;
        this.vamt2 = vamt2;
        this.vtxt3 = vtxt3;
        this.vamt3 = vamt3;
        this.map = map;
        this.addr = addr;
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVtxt() {
        return vtxt;
    }

    public void setVtxt(String vtxt) {
        this.vtxt = vtxt;
    }

    public String getVamt() {
        return vamt;
    }

    public void setVamt(String vamt) {
        this.vamt = vamt;
    }

    public String getVtxt1() {
        return vtxt1;
    }

    public void setVtxt1(String vtxt1) {
        this.vtxt1 = vtxt1;
    }

    public String getVamt1() {
        return vamt1;
    }

    public void setVamt1(String vamt1) {
        this.vamt1 = vamt1;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public String getVtxt2() {
        return vtxt2;
    }

    public void setVtxt2(String vtxt2) {
        this.vtxt2 = vtxt2;
    }

    public String getVamt2() {
        return vamt2;
    }

    public void setVamt2(String vamt2) {
        this.vamt2 = vamt2;
    }

    public String getVtxt3() {
        return vtxt3;
    }

    public void setVtxt3(String vtxt3) {
        this.vtxt3 = vtxt3;
    }

    public String getVamt3() {
        return vamt3;
    }

    public void setVamt3(String vamt3) {
        this.vamt3 = vamt3;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
