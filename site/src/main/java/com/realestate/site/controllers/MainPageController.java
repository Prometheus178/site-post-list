package com.realestate.site.controllers;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.*;
import com.realestate.site.services.post.interfaces.PhotoService;
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


    @GetMapping({"/","/main"})
    public String main(@RequestParam(defaultValue = "0") int page,Model model){
        Post post  = new Post();
        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        Pager pager = new Pager(posts);
        model.addAttribute("pager" , pager );

        return "main";
    }

}
