package com.example.movies;

import static com.example.movies.R.drawable.ic_launcher_background;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    ArrayList<Movie>movies;
    OnClick onClick;
    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";

    public MoviesAdapter(OnClick onClick,ArrayList<Movie> movies) {
        this.movies = movies;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos=position;
        holder.title.setText( movies.get(position).getTitle());
        holder.date.setText( movies.get(position).getRelease_date());
        Picasso.with(holder.image.getContext()).load(IMAGE_BASE_URL + movies.get(position).getPoster_path()).into(holder.image);
        //Log.d("+++",IMAGE_BASE_URL+movies.get(position).getPoster_path());
        holder.itemView.setOnClickListener(view -> onClick.setClick(pos));
    }

    @Override
    public int getItemCount() {
        return movies==null? 0: movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,date;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.pic);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.RelaseDate);
        }
    }
    public void setData(ArrayList<Movie> data) {
        if (movies != null) {
            movies.clear();
            movies.addAll(data);
            notifyDataSetChanged();
        }
    }
}
