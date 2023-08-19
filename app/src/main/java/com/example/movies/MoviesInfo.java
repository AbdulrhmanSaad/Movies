package com.example.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MoviesInfo {


    ArrayList<Movie>results;
    @SerializedName("total_pages")
    String totalPages;
    @SerializedName("total_results")
    int  resultsNumber;
    public ArrayList<Movie> getMovies() {
        return results;
    }


    public ArrayList<Movie> getResults() {
        return results;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public int getResultsNumber() {
        return resultsNumber;
    }
}