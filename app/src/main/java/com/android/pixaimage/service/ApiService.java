package com.android.pixaimage.service;

import com.android.pixaimage.home.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=wild+animals&image_type=photo&pretty=true")
    Call<Root> getAnimalsList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=birds")
    Call<Root> getBirdsList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=aquarium+fishes&image_type=photo&pretty=true")
    Call<Root> getFishList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=trees&image_type=photo&pretty=true")
    Call<Root> getTreesList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=snakes&image_type=photo&pretty=true")
    Call<Root> getSnakesList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=elephant")
    Call<Root> getElephantList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=lion")
    Call<Root> getLionList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=tiger")
    Call<Root> getTigerList();

    @GET("api/?key=17829037-929c36dafe663df9cfc1d7793&q=nature")
    Call<Root> getNatureList();
}
