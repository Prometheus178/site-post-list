package com.realestate.site.controllers.post;


import com.realestate.site.exception.FileStorageException;
import com.realestate.site.models.post.Photo;
import com.realestate.site.models.post.Post;
//import com.realestate.site.advertisements.services.PostService;
import com.realestate.site.models.user.User;
import com.realestate.site.services.post.interfaces.PhotoService;
import com.realestate.site.services.post.interfaces.PostService;
import com.realestate.site.services.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;
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
    public String saveMultipartPost(@ModelAttribute("postAttribute") Post post,
                                    BindingResult bindingResult,
                                    @RequestParam("photo") MultipartFile[] files){
        post.setDateTime(LocalDateTime.now().toString());
        postService.save(post);

        try {
            for (MultipartFile file: files) {
                Photo photo = new Photo();
                photo.setPhoto(file.getBytes());
                photo.setPost(post);
                photoService.storePhoto(photo);
            }
        }catch (IOException e){
            throw new FileStorageException("Could not store file " + files + ". Please try again!", e);
        }

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
        List<Photo> photos = photoService.getPhotos(id);
        if (photos != null){
            ServletOutputStream outputStream = response.getOutputStream();
            try {
                for (Photo photo : photos) {
                    response.setContentType("image/jpeg");
                    byte[] image = photo.getPhoto();
                    outputStream.write(image);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                outputStream.close();
            }
        }
    }

    @PostMapping("/post-delete/{id}")
    public String postDelete(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
        postService.deletePost(post);
        return "redirect:/user/profile";
    }





}
