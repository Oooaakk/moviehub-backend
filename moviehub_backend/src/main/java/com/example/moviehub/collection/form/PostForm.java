package com.example.moviehub.collection.form;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {

    private String movieId;
    private String review;
    private Double rating;

    private String movieName;

    private String poster;

    public PostForm(){};

    public PostForm(String movieId, String review, Double rating) {
        this.movieId = movieId;
        this.review = review;
        this.rating = rating;
    }

    public PostForm(String movieId, String review, Double rating, String movieName, String poster) {
        this.movieId = movieId;
        this.review = review;
        this.rating = rating;
        this.movieName = movieName;
        this.poster = poster;
    }
}
