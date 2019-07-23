package com.realestate.site.services.advetisement.interfaces;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;

import java.util.List;

public interface AdvertisementService {

    List<Post> findAllAdvertisementByDateTime();

    List<Post> findAllAdvertisementByDealType(DealType dealType);
    Post findById(Long id);
    void deleteById(Long id);
    Post save(Post post);
    Post updateById(Long id);
}
