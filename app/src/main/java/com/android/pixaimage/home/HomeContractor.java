package com.android.pixaimage.home;

import java.util.ArrayList;

public interface HomeContractor {

    interface Presenter {
        void attachView(HomeContractor.View view);

        void detachView();

        void getBirdsDetails(String info);

        void getAnimalsDetails(String info);

        void getFishDetails(String info);

        void getTreesDetails(String info);

        void getSnakesDetails(String info);

    }

    interface View {
        void getBirdsImages(ArrayList<String> imageArrayList);

        void getAnimalsImages(ArrayList<String> imageArrayList);

        void getFishImages(ArrayList<String> imageArrayList);

        void getTreesImages(ArrayList<String> imageArrayList);

        void getSnakesImages(ArrayList<String> imageArrayList);
    }

}
