package com.android.pixaimage.home.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public ArrayList<String> setImageList(List<Hit> imageList) {
        ArrayList<String> imageArrayList = new ArrayList<>();
        for (Hit hit : imageList) {
            imageArrayList.add(hit.getLargeImageURL());
        }
        return imageArrayList;
    }
}
