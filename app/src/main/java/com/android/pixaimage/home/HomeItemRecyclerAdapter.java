package com.android.pixaimage.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pixaimage.R;
import com.squareup.picasso.Callback;
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
        holder1.progressBarLayoutItem.setVisibility(View.VISIBLE);
        Picasso.get().load(imageUrl).into(holder1.imageViewItem, new Callback() {
            @Override
            public void onSuccess() {
                holder1.progressBarLayoutItem.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewItem;
        ProgressBar progressBarLayoutItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewItem = itemView.findViewById(R.id.iv_layout_item);
            progressBarLayoutItem = itemView.findViewById(R.id.progressBarLayoutItem);
        }
    }
}
