package com.realestate.site.repositories.post;

import com.realestate.site.models.post.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findAllByPost_Id(Long id);
    Photo findByPost_Id(Long id);
}
