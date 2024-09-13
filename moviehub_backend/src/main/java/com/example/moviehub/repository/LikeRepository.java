package com.example.moviehub.repository;

import com.example.moviehub.collection.Like;
import com.example.moviehub.collection.likeId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends MongoRepository<Like, String> {

    List<Like> findAllByPostId(String postId);


    Long countAllByPostIdAndStatus(String postId, Like.Status status);

    Long countAllByIdAndStatus(likeId id, Like.Status status);

    Boolean deleteById(likeId likeId);

    Like findById(likeId likeId);
}
