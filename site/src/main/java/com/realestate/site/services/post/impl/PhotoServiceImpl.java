package com.realestate.site.services.post.impl;

import com.realestate.site.models.post.Photo;
import com.realestate.site.repositories.post.PhotoRepository;
import com.realestate.site.services.post.interfaces.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo storePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo getPhotoByPostId(Long id) {
        return photoRepository.findByPost_Id(id);
    }

    @Override
    public List<Photo> getPhotos(Long id) {
        return photoRepository.findAllByPost_Id(id);
    }
}
