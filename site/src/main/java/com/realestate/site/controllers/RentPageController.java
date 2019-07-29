package com.realestate.site.controllers;


import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.services.post.interfaces.PostService;
import com.realestate.site.services.user.interfaces.UserService;
import com.realestate.site.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentPageController {

    @Autowired
    private PostService postService;


    @GetMapping("/main/all-rent")
    public String findAllRent(@RequestParam(defaultValue = "0") int page, Model model) {

        Page<Post> posts = postService.findAllByDealType(page, DealType.RENT);
        Pager pager = new Pager(posts);
        model.addAttribute("pager" , pager );

        return "rents";
    }


   
}
