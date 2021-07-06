package com.android.pixaimage.more;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pixaimage.R;

import java.util.ArrayList;

public class MoreActivity extends AppCompatActivity {

    ArrayList<String> imagesList;
    RecyclerView recyclerView;
    TextView tvActionBarMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        recyclerView = findViewById(R.id.recyclerViewMore);
        tvActionBarMore = findViewById(R.id.tv_action_bar_more);
        tvActionBarMore.setText("PixaImage: " + getIntent().getStringExtra("AppBarName"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imagesList = getIntent().getStringArrayListExtra("imageList");

        recyclerView.setAdapter(new MoreRecyclerAdapter(imagesList));
    }
}