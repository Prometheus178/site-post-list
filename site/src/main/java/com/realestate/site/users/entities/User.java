package com.realestate.site.users.entities;

import com.realestate.site.parent.Person;
import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data

public class User extends Person {

    private String email;
    //    @Column(name = "password")
    private String password;
    private int active;
    private Set<Role> roles;

}
