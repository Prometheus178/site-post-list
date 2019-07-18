package com.realestate.site.users.entities;

import com.realestate.site.parent.Person;
import lombok.Data;

import javax.persistence.Column;

@Data
public class User extends Person {

//    @Column(name = "password")
    private String password;

}
