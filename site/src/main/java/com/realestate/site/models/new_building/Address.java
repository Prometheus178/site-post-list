package com.realestate.site.models.new_building;


import com.realestate.site.parent.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data

@Table(name = "addresses")
public class Address extends BaseEntity {
    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private byte[] image;

}
