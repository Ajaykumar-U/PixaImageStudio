package com.android.pixaimage.search;

import java.util.List;

public interface SearchContractor {
    interface Presenter{
        void setView(SearchContractor.View view);
        void getSearchData(String searchData);
    }

    interface View{
        void getImageData(List<String> imageList);
    }
}
