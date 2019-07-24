package com.realestate.site.services.post.interfaces;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.models.user.User;

import java.util.List;

public interface PostService {

    Post findById(Long id);
    List<Post> findAllByUser(User user);
    void deletePost(Post post);
    Post save(Post post);
    List<Post> findAllPost();
    List<Post> findAllPostByDealType(DealType dealType);

}
