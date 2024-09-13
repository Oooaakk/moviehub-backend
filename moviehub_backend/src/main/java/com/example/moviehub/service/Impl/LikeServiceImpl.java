package com.example.moviehub.service.Impl;

import com.example.moviehub.collection.Like;
import com.example.moviehub.collection.likeId;
import com.example.moviehub.repository.LikeRepository;
import com.example.moviehub.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    public Like.Status lookup(String postId, String email){
        likeId likeId = new likeId(postId, email);
        Like like = likeRepository.findById(likeId);
        if (like != null){
            return like.getStatus();
        }else {
            return Like.Status.UNKNOWN;
        }
    }

    @Override
    public Boolean like(String postId, String email) {
        try {
            System.out.println(email);
            likeId likeId = new likeId(postId, email);
            Like like =  likeRepository.findById(likeId);
            if (like != null && like.getStatus().equals(Like.Status.LIKE)){
                likeRepository.delete(like);
            }else {
                likeRepository.save(new Like(likeId, postId, Like.Status.LIKE));
            }

            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }


    @Override
    public Boolean dislike(String postId, String email) {
        try {
            likeId likeId = new likeId(postId, email);
            likeRepository.save(new Like(likeId, postId, Like.Status.DISLIKE));
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean cancel(String postId, String email) {
        try {
            likeId likeId = new likeId(postId, email);
            return likeRepository.deleteById(likeId);
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Long countLikeDislike(String postId, Like.Status status) {
        return likeRepository.countAllByPostIdAndStatus(postId, status);
    }
}
