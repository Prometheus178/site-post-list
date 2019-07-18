package com.realestate.site.parent;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class Person extends BaseEntity {

    @Column(name = "username")
    private String username;



}
