package com.example.myapplication.API;

import com.example.myapplication.Category;
import com.example.myapplication.Location;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;

public interface APIInterface {

    @GET(WebServer.IMAGE_KEY)
    Call<Image> getFile();

    @GET(WebServer.IMAGE_KEY_3)
    Call<ArrayList<HeadingBanner>> getHeading();

    @GET(WebServer.IMAGE_KEY_1)
    Call<ArrayList<Example>> getExample();

    @GET(WebServer.IMAGE_KEY_1)
    Call<ArrayList<Example>> getOrders();

    @GET(WebServer.IMAGE_KEY_4)
    Call<ArrayList<Category>> getCategories();

    @GET(WebServer.IMAGE_KEY_5)
    Call<ArrayList<Location>> getLoc();

    @GET(WebServer.IMAGE_KEY_6)
    Call<ArrayList<FinalResult>> getList();

    @GET(WebServer.IMAGE_KEY_6)
    Call<FinalResult> getFragment();
}

