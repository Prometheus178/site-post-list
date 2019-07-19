package com.realestate.site.models.user;

import com.realestate.site.parent.Person;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Entity
public class User extends Person {

    private String email;
    //    @Column(name = "password")
    private String password;
    private int active;
    private Set<Role> roles;

}
