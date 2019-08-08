package com.realestate.site.services.search.impl;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.*;
import com.realestate.site.repositories.post.PostRepository;
import com.realestate.site.services.search.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllByQuery(DealType dealType, Commercial commercial, Living living, NumberOfRooms numberOfRooms, AccountType accountType) {
        return postRepository.findByDealTypeAndCommercialAndLivingAndNumberOfRoomsAndAccountType(dealType,commercial,living,numberOfRooms,accountType);

    }
}
