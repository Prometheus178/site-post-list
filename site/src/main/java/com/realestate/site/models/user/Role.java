package com.realestate.site.models.user;

import com.realestate.site.parent.BaseEntity;
import lombok.Data;

import java.util.Set;

@Data
public class Role extends BaseEntity {

    private String role;
    private Set<User> users;

}
