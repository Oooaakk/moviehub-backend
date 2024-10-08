package com.example.moviehub.repository;

import com.example.moviehub.collection.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findByUserId(String userId);

    List<Post> findByMovieName(String movieName);

    List<Post> findByMovieId(String movieId);
}