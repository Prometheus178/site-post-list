package com.realestate.site.controllers.post;


import com.realestate.site.models.post.Post;
//import com.realestate.site.advertisements.services.AdvertisementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


@Controller
public class PostController {


//    private AdvertisementService advertisementService;

//    public AdvertisementController(AdvertisementServiceTEST advertisementService) {
//        this.advertisementService = advertisementService;
//    }

    @GetMapping("/add-post")
    public String addPostPage(Model model) {
        Post post = new Post();
        model.addAttribute("postAttribute", post);
        return "add_post";
    }

    @PostMapping(value = "/save-post")
    public String saveOrUpdatePost(@ModelAttribute("postAttribute") Post post,
                                   @RequestParam("image") CommonsMultipartFile[] image, BindingResult bindingResult) {
        for (CommonsMultipartFile multipartFile : image) {
            post.setPhoto(multipartFile.getBytes());
        }
        post.setDateTime(LocalDateTime.now());
//        advertisementService.save(post);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String postPage(@PathVariable("id") Long id, Model model) {
//        Post advertisement = advertisementService.findById(id);
//        model.addAttribute("advertisement", advertisement);
        return "post";
    }


    @GetMapping("/post/{id}/post-image")
    public void showImageFromDB(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
//        Post advertisement = advertisementService.findById(id);
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            response.setContentType("image/jpeg");
//            byte[] image = advertisement.getPhoto();
//            outputStream.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }


    }


}
