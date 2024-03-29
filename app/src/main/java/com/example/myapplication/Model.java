package com.example.myapplication;

public class Model {

    private int image;
    private String title;
    private String info;

    public Model(int image, String title, String info) {
        this.image = image;
        this.title = title;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
