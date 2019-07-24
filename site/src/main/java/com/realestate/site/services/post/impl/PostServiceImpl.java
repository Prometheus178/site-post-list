package com.realestate.site.services.post.impl;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.models.user.User;
import com.realestate.site.repositories.post.PostRepository;
import com.realestate.site.services.post.interfaces.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public List<Post> findAllPost(){
        return postRepository.findAll();
    }
    @Override
    public List<Post> findAllPostByDealType(DealType dealType){
        return postRepository.findAllByDealType(dealType);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public List<Post> findAllByUser(User user) {
        return postRepository.findAllByUser(user);
    }

    @Override
    public void deletePost(Post post){
        postRepository.delete(post);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }



}
