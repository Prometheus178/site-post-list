package com.realestate.site.users.entities;

import com.realestate.site.parent.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
public class Role extends BaseEntity {

    private String role;
    private Set<User> users;

}
