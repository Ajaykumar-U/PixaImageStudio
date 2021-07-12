package com.android.pixaimage.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pixaimage.R;
import com.android.pixaimage.more.MoreActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements HomeContractor.View {

    RecyclerView recyclerViewBirds, recyclerViewAnimals,
            recyclerViewFish, recyclerViewTrees, recyclerViewSnakes;

    Button btnAnimals, btnSnakes, btnFish, btnBirds, btnTrees;

    HomeContractor.Presenter presenter = (HomeContractor.Presenter) new HomePresenter();
    ArrayList<String> birdsList, animalsList, fishList, treesList, snakesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter.attachView(this);
        presenter.getAnimalsDetails("animals");
        presenter.getBirdsDetails("birds");
        presenter.getFishDetails("fish");
        presenter.getSnakesDetails("snakes");
        presenter.getTreesDetails("trees");

        btnAnimals = findViewById(R.id.btnAnimalHome);
        btnSnakes = findViewById(R.id.btnSnakesHome);
        btnBirds = findViewById(R.id.btnBirdHome);
        btnFish = findViewById(R.id.btnFishHome);
        btnTrees = findViewById(R.id.btnTreeHome);

        btnTrees.setOnClickListener((v) -> {
            Intent intent = new Intent(HomeActivity.this, MoreActivity.class);
            intent.putStringArrayListExtra("imageList", treesList);
            intent.putExtra("AppBarName", "Trees");
            startActivity(intent);
        });
        btnFish.setOnClickListener((v) -> {
            Intent intent = new Intent(HomeActivity.this, MoreActivity.class);
            intent.putStringArrayListExtra("imageList", fishList);
            intent.putExtra("AppBarName", "Fish");
            startActivity(intent);
        });
        btnBirds.setOnClickListener((v) -> {
            Intent intent = new Intent(HomeActivity.this, MoreActivity.class);
            intent.putStringArrayListExtra("imageList", birdsList);
            intent.putExtra("AppBarName", "Birds");
            startActivity(intent);
        });
        btnAnimals.setOnClickListener((v) -> {
            Intent intent = new Intent(HomeActivity.this, MoreActivity.class);
            intent.putStringArrayListExtra("imageList", animalsList);
            intent.putExtra("AppBarName", "Animals");
            startActivity(intent);
        });
        btnSnakes.setOnClickListener((v) -> {
            Intent intent = new Intent(HomeActivity.this, MoreActivity.class);
            intent.putStringArrayListExtra("imageList", snakesList);
            intent.putExtra("AppBarName", "Snakes");
            startActivity(intent);
        });

        recyclerViewAnimals = findViewById(R.id.recyclerViewHomeAnimal);
        recyclerViewAnimals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewBirds = findViewById(R.id.recyclerViewHomeBird);
        recyclerViewBirds.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewFish = findViewById(R.id.recyclerViewHomeFish);
        recyclerViewFish.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewTrees = findViewById(R.id.recyclerViewHomeTree);
        recyclerViewTrees.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewSnakes = findViewById(R.id.recyclerViewHomeSnakes);
        recyclerViewSnakes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void getBirdsImages(ArrayList<String> imageArrayList) {
        this.birdsList = imageArrayList;
        recyclerViewBirds.setAdapter(new HomeItemRecyclerAdapter(imageArrayList));
    }

    @Override
    public void getAnimalsImages(ArrayList<String> imageArrayList) {
        this.animalsList = imageArrayList;
        recyclerViewAnimals.setAdapter(new HomeItemRecyclerAdapter(imageArrayList));
    }

    @Override
    public void getFishImages(ArrayList<String> imageArrayList) {
        this.fishList = imageArrayList;
        recyclerViewFish.setAdapter(new HomeItemRecyclerAdapter(imageArrayList));
    }

    @Override
    public void getTreesImages(ArrayList<String> imageArrayList) {
        this.treesList = imageArrayList;
        recyclerViewTrees.setAdapter(new HomeItemRecyclerAdapter(imageArrayList));
    }

    @Override
    public void getSnakesImages(ArrayList<String> imageArrayList) {
        this.snakesList = imageArrayList;
        recyclerViewSnakes.setAdapter(new HomeItemRecyclerAdapter(imageArrayList));
    }
}