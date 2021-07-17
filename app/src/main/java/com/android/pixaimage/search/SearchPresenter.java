package com.android.pixaimage.search;

import android.util.Log;
import android.widget.Toast;

import com.android.pixaimage.home.model.Model;
import com.android.pixaimage.home.model.Root;
import com.android.pixaimage.service.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter implements SearchContractor.Presenter{

    SearchContractor.View view;
    Model model = new Model();

    @Override
    public void setView(SearchContractor.View view) {
        this.view = view;
    }

    @Override
    public void getSearchData(String searchData) {
        Call<Root> detailsItem;
        if(searchData.equalsIgnoreCase("elephant")){
            detailsItem = RetrofitBuilder.getApiService().getElephantList();
        }
        else if(searchData.equalsIgnoreCase("lion")){
            detailsItem = RetrofitBuilder.getApiService().getLionList();
        }
        else if(searchData.equalsIgnoreCase("tiger")){
            detailsItem = RetrofitBuilder.getApiService().getTigerList();
        }
        else{
            detailsItem = RetrofitBuilder.getApiService().getNatureList();
        }

        detailsItem.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    view.getImageData(model.setImageList(response.body().getHits()));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });

    }
}
