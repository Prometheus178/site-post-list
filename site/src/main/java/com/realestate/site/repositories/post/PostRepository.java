package com.realestate.site.repositories.post;


import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.models.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);

    Page<Post> findAllByDealType(Pageable pageable, DealType dealType);
}
