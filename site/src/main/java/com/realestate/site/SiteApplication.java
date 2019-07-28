package com.realestate.site;

import com.realestate.site.models.post.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;


@EntityScan
@EnableJpaRepositories
@SpringBootApplication

public class SiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);


    }

}
