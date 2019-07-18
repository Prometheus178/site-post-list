package com.realestate.site.new_buildings.entities;


import com.realestate.site.parent.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
//@Table(name = "addresses")
public class Address extends BaseEntity {
//    @Column(name = "address")
    private String address;
//    @Column(name = "image")
    private byte[] image;

}
