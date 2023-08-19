package com.example.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Movie {

        private String id;
        private String title;
        private String release_date;
        private String poster_path;
        private String backdrop_path;
        private String overview;
        private float vote_average;



        public String getRelease_date() {
                return release_date;
        }

        public void setRelease_date(String release_date) {
                this.release_date = release_date;
        }

        public float getVote_average() {
                return vote_average;
        }

        public void setVote_average(float vote_average) {
                this.vote_average = vote_average;
        }



        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getBackdrop_path() {
                return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
                this.backdrop_path = backdrop_path;
        }

        public String getPoster_path() {
                return poster_path;
        }

        public void setPoster_path(String poster_path) {
                this.poster_path = poster_path;
        }

        public String getOverview() {
                return overview;
        }

        public void setOverview(String overview) {
                this.overview = overview;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getPosterUrl() {
                return poster_path;
        }

        public void setPosterUrl(String posterUrl) {
                this.poster_path = posterUrl;
        }

        public Movie(String title, String release_date) {
                this.title = title;
                this.release_date = release_date;
        }
}
