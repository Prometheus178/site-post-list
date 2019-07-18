package com.realestate.site;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SiteApplication {


    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }

}
