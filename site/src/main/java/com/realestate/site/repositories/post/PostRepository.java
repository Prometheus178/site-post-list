package com.realestate.site.repositories.post;


import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByDealType(DealType dealType);

}
