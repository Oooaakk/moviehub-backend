package com.example.moviehub.collection;

import java.io.Serializable;

public class likeId implements Serializable {
    private String postId;
    private String email;

    public likeId() {
    }

    public likeId(String postId, String email) {
        this.postId = postId;
        this.email = email;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "likeId{" +
                "postId='" + postId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
