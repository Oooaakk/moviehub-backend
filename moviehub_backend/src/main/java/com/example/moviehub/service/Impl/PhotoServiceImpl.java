package com.example.moviehub.service.Impl;


import com.example.moviehub.collection.Photo;
import com.example.moviehub.repository.PhotoRepository;
import com.example.moviehub.service.PhotoService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public String addPhoto(String Filename, MultipartFile image, String userId) throws IOException {
        Photo photo
                = new Photo();
        photo.setTitle(Filename);
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY,image.getBytes()));
        photo.setUserId(userId);
        return photoRepository.save(photo).getId();
    }

    public List<Photo> getPhoto(String userId) {
        return photoRepository.findByUserId(userId);
    }

    public void deletePhoto(String userId){
        photoRepository.deleteByUserId(userId);
    }
}

