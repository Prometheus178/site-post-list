package com.realestate.site.models.user;


import com.realestate.site.parent.Person;
import lombok.*;


@Data
public class Admin extends Person {
//    @Column(name = "password")
    private String password;

}
