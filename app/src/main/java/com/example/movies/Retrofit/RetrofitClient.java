package com.example.movies.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String url="http://api.themoviedb.org/3/movie/";
    private static ApiCall instance;
    public static ApiCall getInstance() {
        if(instance==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance= retrofit.create(ApiCall.class);
        }
        return instance;
    }
}
