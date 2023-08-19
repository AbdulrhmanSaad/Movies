package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.movies.Retrofit.ApiCall;
import com.example.movies.Retrofit.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private MoviesAdapter adapter;
    private RecyclerView moviesList;
    private OnClick onClick;
    public static ArrayList<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesList = findViewById(R.id.moviesList);

         movies = new ArrayList<>();
       Call<MoviesInfo>moviesInfoCall= RetrofitClient.getInstance().getMovies();
        moviesInfoCall.enqueue(new Callback<MoviesInfo>() {
            @Override
            public void onResponse(Call<MoviesInfo> call, Response<MoviesInfo> response) {
                if (response.isSuccessful()) {
                    MoviesInfo movies=response.body();
                    updateData(movies.getMovies());
                }
            }

            @Override
            public void onFailure(Call<MoviesInfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        onClick=new OnClick() {
            @Override
            public void setClick(int pos) {
                Intent intent=new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("item",pos);
                startActivity(intent);
            }
        };
        adapter = new MoviesAdapter(onClick,movies);
        moviesList.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        moviesList.setAdapter(adapter);

        }
        public void updateData(ArrayList<Movie> models) {
        adapter.setData(models);

        }



}