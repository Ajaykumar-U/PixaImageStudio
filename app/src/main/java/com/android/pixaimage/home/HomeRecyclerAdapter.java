package com.android.pixaimage.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pixaimage.R;
import com.squareup.picasso.Picasso;

public class HomeRecyclerAdapter extends RecyclerView.Adapter {
    String[] imageScrollList;

    public HomeRecyclerAdapter(String[] imageScrollList) {
        this.imageScrollList = imageScrollList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_scroll_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        String imageUrl = imageScrollList[position];
        Log.d("Tag", imageScrollList[position]);
        Picasso.get().load(imageUrl).into(holder1.imageViewScrollHome);
    }

    @Override
    public int getItemCount() {
        return imageScrollList.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewScrollHome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewScrollHome = itemView.findViewById(R.id.imageViewScrollHome);
        }
    }
}
