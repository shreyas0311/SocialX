package com.example.socialx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    ArrayList<ModalClass> modalClassArrayList;

    public MainAdapter(Context context, ArrayList<ModalClass> modalClassArrayList)
    {
        this.context = context;
        this.modalClassArrayList = modalClassArrayList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.time.setText(modalClassArrayList.get(position).getPublishedAt()+" "+modalClassArrayList.get(position).getAuthor());
        holder.heading.setText(modalClassArrayList.get(position).getTitle());
        holder.content.setText(modalClassArrayList.get(position).getDescription());
        Glide.with(context).load(modalClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modalClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainHeading);
            content = itemView.findViewById(R.id.content);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}