package com.example.moviehub.service.Impl;

import com.example.moviehub.collection.User;
import com.example.moviehub.collection.form.PostForm;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostServiceImplTest {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    private final String movieId = "tt000000";
    private final String userId = "635384dd3b797226ddfb4212";

    private final String email = "test@test.com";

    @Test
    void publishPost() {
        PostForm postForm = new PostForm(movieId, "testReview", 10.0);
        User user = userService.getUserByEmail(email);
        postService.publishPost(postForm, user);
    }

    @Test
    void getPostByUserId() {
        postService.getPostByUserId(userId);
    }

    @Test
    void getPostByMovieId() {
        postService.getPostByMovieId(movieId);
    }

}