package com.realestate.site.controllers.post;


import com.realestate.site.models.post.Post;
//import com.realestate.site.advertisements.services.PostService;
import com.realestate.site.models.user.User;
import com.realestate.site.services.post.interfaces.PostService;
import com.realestate.site.services.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;


@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/add-post")
    public String addPostPage(Principal principal, Model model) {
        User user =  userService.findUserByEmail(principal.getName());

        if (user != null){
            Post post = new Post();
            post.setUser(user);
            model.addAttribute("postAttribute", post);
            return "add_post";
        } else {
            return "redirect:/access-denied";
        }



    }

    @PostMapping(value = "/save-post")
    public String saveOrUpdatePost(@ModelAttribute("postAttribute") Post post,
                                   BindingResult bindingResult,
                                   @RequestParam("photo") CommonsMultipartFile[] file) {
        for (CommonsMultipartFile multipartFile : file) {
            post.setPhoto(multipartFile.getBytes());
        }

        post.setDateTime(LocalDateTime.now().toString());
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String postPage(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post";
    }


    @GetMapping("/post/{id}/post-image")
    public void showImageFromDB(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        Post post = postService.findById(id);
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            response.setContentType("image/jpeg");
            byte[] image = post.getPhoto();
            outputStream.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }


    }

    @PostMapping("/post-delete/{id}")
    public String postDelete(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
        postService.deletePost(post);
        return "redirect:/user/profile";
    }





}
