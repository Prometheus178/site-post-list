package com.realestate.site.services.advetisement.impl;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.repositories.post.PostRepository;
import com.realestate.site.services.advetisement.interfaces.AdvertisementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private PostRepository postRepository;

    public AdvertisementServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public List<Post> findAllAdvertisementByDateTime(){
        return postRepository.findAll();
    }
    @Override
    public List<Post> findAllAdvertisementByDealType(DealType dealType){
        return postRepository.findAllByDealType(dealType);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post updateById(Long id) {
        return null;
    }

}
