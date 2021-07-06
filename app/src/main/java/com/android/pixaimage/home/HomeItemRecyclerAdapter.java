package com.android.pixaimage.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pixaimage.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeItemRecyclerAdapter extends RecyclerView.Adapter {

    ArrayList<String> imageArrayList;

    public HomeItemRecyclerAdapter(ArrayList<String> imageArrayList) {
        this.imageArrayList = imageArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        String imageUrl = imageArrayList.get(position);
        Picasso.get().load(imageUrl).into(holder1.imageViewItem);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewItem = itemView.findViewById(R.id.iv_layout_item);
        }
    }
}
