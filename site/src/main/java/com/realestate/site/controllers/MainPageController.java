package com.realestate.site.controllers;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.*;
import com.realestate.site.services.post.interfaces.PostService;
import com.realestate.site.services.search.interfaces.SearchService;
import com.realestate.site.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private PostService postService;
    @Autowired
    SearchService searchService;

    @GetMapping({"/","/main"})
    public String main(@RequestParam(defaultValue = "0") int page,Model model){
        Post post  = new Post();
        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        Pager pager = new Pager(posts);
        model.addAttribute("pager" , pager );

//        post.setDealType(DealType.RENT);
//        post.setCommercial(Commercial.OFFICE);
//        post.setLiving(null);
//        post.setNumberOfRooms(null);
//        post.setAccountType(AccountType.OWNER);
//        List<Post> posts1 = searchService.findAllByQuery(post.getDealType(),post.getCommercial(),post.getLiving(),post.getNumberOfRooms(),post.getAccountType());
//        for (Post post1: posts1) {
//            System.out.println(post1);
//        }
                model.addAttribute("post",post);

        return "main";
    }

}
