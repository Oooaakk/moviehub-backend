package com.example.moviehub.collection;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "post")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

public class Post {

    @Id
    private String id;
    private String userId;
    private String movieId;
    private String movieName;
    private String content;
    private double rating;

    private String poster;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    public Post(String id, String userId, String movieId, String movieName, String content, double rating, String poster, Date createdDate, Date lastModifiedDate) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.content = content;
        this.rating = rating;
        this.poster = poster;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Post() {
    }

    public Post(String userId, String movieId,String content, double rating) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.content = content;
    }

    public Post(String userId, String movieId, String movieName, String content, double rating, String poster) {
        this.userId = userId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.content = content;
        this.rating = rating;
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
