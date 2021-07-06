package com.android.pixaimage.more;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pixaimage.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoreRecyclerAdapter extends RecyclerView.Adapter {

    ArrayList<String> imagesList;

    public MoreRecyclerAdapter(ArrayList<String> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        String imageUrl = imagesList.get(position);
        Picasso.get().load(imageUrl).resize(420, 360).into(holder1.imageViewItem);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewItem = itemView.findViewById(R.id.iv_layout_more);
        }
    }
}
