package com.example.moviehub.service;

import com.example.moviehub.collection.Like;

public interface LikeService {

    public Boolean like(String postId, String email);

    public Boolean cancel(String postId, String email);

    public Boolean dislike(String postId, String email);


    public Long countLikeDislike(String postId, Like.Status status);
}
