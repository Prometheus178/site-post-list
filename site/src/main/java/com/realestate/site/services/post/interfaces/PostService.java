package com.realestate.site.services.post.interfaces;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.models.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    Post findById(Long id);
    List<Post> findAllByUser(User user);
    void deletePost(Post post);
    Post save(Post post);

    Page<Post> findAllOrderedByDatePageable(int page);
    Page<Post> findAllByDealType(int page, DealType dealType);


}
