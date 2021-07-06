package com.android.pixaimage.home;

import android.util.Log;

import com.android.pixaimage.home.model.Model;
import com.android.pixaimage.home.model.Root;
import com.android.pixaimage.service.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContractor.Presenter {

    HomeContractor.View view;
    Model model = new Model();

    @Override
    public void attachView(HomeContractor.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getBirdsDetails(String info) {
        Call<Root> detailsItem = RetrofitBuilder.getApiService().getBirdsList();
        detailsItem.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    view.getBirdsImages(model.setImageList(response.body().getHits()));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAnimalsDetails(String info) {
        Call<Root> detailsItem = RetrofitBuilder.getApiService().getAnimalsList();
        detailsItem.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    view.getAnimalsImages(model.setImageList(response.body().getHits()));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }

    @Override
    public void getFishDetails(String info) {
        Call<Root> detailsItem = RetrofitBuilder.getApiService().getFishList();
        detailsItem.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    view.getFishImages(model.setImageList(response.body().getHits()));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }

    @Override
    public void getTreesDetails(String info) {
        Call<Root> detailsItem = RetrofitBuilder.getApiService().getTreesList();
        detailsItem.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    view.getTreesImages(model.setImageList(response.body().getHits()));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }

    @Override
    public void getSnakesDetails(String info) {
        Call<Root> detailsItem = RetrofitBuilder.getApiService().getSnakesList();
        Log.d("Tag", info);
        detailsItem.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    view.getSnakesImages(model.setImageList(response.body().getHits()));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }

}
