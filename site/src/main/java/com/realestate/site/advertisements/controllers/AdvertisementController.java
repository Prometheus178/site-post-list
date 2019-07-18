package com.realestate.site.advertisements.controllers;


import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.advertisements.services.AdvertisementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


@Controller
public class AdvertisementController {


    private AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/add-advertisement")
    public String addAdvertisementPage(Model model) {
        Advertisement advertisement = new Advertisement();
        model.addAttribute("advertisementAttribute",advertisement);
        return "add_advertisement";
    }

    @PostMapping(value = "/save-advertisement")
    public String saveOrUpdateAdvertisement(@ModelAttribute("advertisementAttribute") Advertisement advertisement,
                                            BindingResult bindingResult,
                                            @RequestParam("image") CommonsMultipartFile[] image ){
        for (CommonsMultipartFile multipartFile : image) {
            advertisement.setPhoto(multipartFile.getBytes());
        }
        advertisement.setDateTime(LocalDateTime.now());
        advertisementService.save(advertisement);
        return "redirect:/";
    }

    @GetMapping("/advertisement/{id}")
    public String advertisementPage(@PathVariable("id") Long id, Model model) {
        Advertisement advertisement = advertisementService.findById(id);
        model.addAttribute("advertisement", advertisement);
        return "advertisement";
    }


    @GetMapping("/advertisement/{id}/advertisement-image")
    public void showImageFromDB(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        Advertisement advertisement = advertisementService.findById(id);
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            response.setContentType("image/jpeg");
            byte[] image = advertisement.getPhoto();
            outputStream.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }


    }


}
