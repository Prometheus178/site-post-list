package com.realestate.site.models.new_building;


import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "addresses")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private byte[] image;

}
