package com.android.pixaimage.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.pixaimage.R;
import com.android.pixaimage.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchContractor.View {

    ImageView ivBack;
    SearchView searchView;
    String searchText;
    RecyclerView recyclerViewSearch;
    SearchContractor.Presenter presenter = (SearchContractor.Presenter) new SearchPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        presenter.setView(this);
        recyclerViewSearch = findViewById(R.id.recyclerViewSearch);
        recyclerViewSearch.setLayoutManager(new LinearLayoutManager(this));
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            private Handler svHandler = new Handler();
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.getSearchData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchText = newText;
                svHandler.removeCallbacks(svRunnable);
                svHandler.postDelayed(svRunnable,1000);
                return false;
            }
        });
    }
    Runnable svRunnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(getApplicationContext(),searchText,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void getImageData(List<String> imageList) {
        recyclerViewSearch.setAdapter(new SearchRecyclerAdapter((ArrayList<String>) imageList));
    }
}