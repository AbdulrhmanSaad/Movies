package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    TextView title,rate,releaseDate,overview;
    ImageView image;
    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detailse);

        Intent intent=getIntent();
        int pos=intent.getIntExtra("item",-1);
        overview=findViewById(R.id.overview);
        title=findViewById(R.id.title);
        rate=findViewById(R.id.rate);
        releaseDate=findViewById(R.id.releaseDate);
        image=findViewById(R.id.img);

        title.setText(MainActivity.movies.get(pos).getTitle());
        releaseDate.setText(MainActivity.movies.get(pos).getRelease_date());
        rate.setText(String.valueOf(MainActivity.movies.get(pos).getVote_average()));
        overview.setText(MainActivity.movies.get(pos).getOverview());
        Picasso.with(getApplicationContext()).load(IMAGE_BASE_URL +MainActivity.movies.get(pos).getPoster_path()).into(image);
    }
}