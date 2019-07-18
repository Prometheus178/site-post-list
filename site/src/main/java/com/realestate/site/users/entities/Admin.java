package com.realestate.site.users.entities;


import com.realestate.site.parent.Person;
import lombok.*;

import javax.persistence.Column;


@Data
public class Admin extends Person {
//    @Column(name = "password")
    private String password;

}
