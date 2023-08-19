package com.example.movies.Retrofit;

import com.example.movies.MoviesInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    @GET("top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af")
    Call<MoviesInfo>getMovies();

}
