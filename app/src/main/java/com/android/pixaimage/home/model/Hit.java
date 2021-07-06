package com.android.pixaimage.home.model;

public class Hit {
    public int id;
    public String previewURL;
    public String largeImageURL;

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public int getId() {
        return id;
    }

    public String getPreviewURL() {
        return previewURL;
    }
}
