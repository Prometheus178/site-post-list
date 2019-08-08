package com.realestate.site.controllers;

import com.realestate.site.models.post.Post;
import com.realestate.site.models.post.enums.Commercial;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.models.post.enums.Living;
import com.realestate.site.models.post.enums.NumberOfRooms;
import com.realestate.site.services.search.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("/search")
    public String searchForm(Model model, @ModelAttribute("post") Post post) {

        List<Post> posts = searchService.findAllByQuery(post.getDealType(),post.getCommercial(),post.getLiving(),post.getNumberOfRooms(),post.getAccountType());
        model.addAttribute("postsSearchedByQuery", posts);

        return "search-result";
    }

}
