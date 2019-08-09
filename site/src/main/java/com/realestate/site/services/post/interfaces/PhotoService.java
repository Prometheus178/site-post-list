package com.realestate.site.services.post.interfaces;

import com.realestate.site.models.post.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    Photo storePhoto(Photo photo);
    Photo getPhotoByPostId(Long id);
    List<Photo> getPhotos(Long id);

}
