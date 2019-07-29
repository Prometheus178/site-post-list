package com.realestate.site.services.post.impl;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.models.user.User;
import com.realestate.site.repositories.post.PostRepository;
import com.realestate.site.services.post.interfaces.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
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

    @Override
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return postRepository.findAll(new PageRequest(subtractPageByOne(page), 12));
    }

    @Override
    public Page<Post> findAllByDealType(int page, DealType dealType) {
        return postRepository.findAllByDealType(new PageRequest(subtractPageByOne(page), 12),dealType);
    }

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }


}
