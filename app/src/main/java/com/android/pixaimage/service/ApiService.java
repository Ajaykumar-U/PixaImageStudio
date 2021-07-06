package com.android.pixaimage.service;

import com.android.pixaimage.home.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("https://pixabay.com/api/?key=17829037-929c36dafe663df9cfc1d7793&q=wild+animals&image_type=photo&pretty=true")
    Call<Root> getAnimalsList();

    @GET("https://pixabay.com/api/?key=17829037-929c36dafe663df9cfc1d7793&q=birds")
    Call<Root> getBirdsList();

    @GET("https://pixabay.com/api/?key=17829037-929c36dafe663df9cfc1d7793&q=aquarium+fishes&image_type=photo&pretty=true")
    Call<Root> getFishList();

    @GET("https://pixabay.com/api/?key=17829037-929c36dafe663df9cfc1d7793&q=trees&image_type=photo&pretty=true")
    Call<Root> getTreesList();

    @GET("https://pixabay.com/api/?key=17829037-929c36dafe663df9cfc1d7793&q=snakes&image_type=photo&pretty=true")
    Call<Root> getSnakesList();
}
