package com.example.moviehub.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "like")
public class Like {

    public enum Status{
        LIKE, DISLIKE, UNKNOWN;
    }

    @Id
    private likeId id;
    private String postId;
    private Status status;

    public Like(likeId id, String postId, Status status) {
        this.id = id;
        this.postId = postId;
        this.status = status;
    }

    public Like(String postId, Status status) {
        this.id = null;
        this.postId = postId;
        this.status = status;
    }

    public Like() {
    }
}
