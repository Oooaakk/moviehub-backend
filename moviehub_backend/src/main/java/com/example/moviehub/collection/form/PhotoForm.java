package com.example.moviehub.collection.form;

import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PhotoForm {

    private MultipartFile photo;

    public PhotoForm(MultipartFile photo) {
        this.photo = photo;
    }
}
