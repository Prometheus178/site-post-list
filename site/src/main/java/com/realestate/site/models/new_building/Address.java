package com.realestate.site.models.new_building;


import lombok.*;

import javax.persistence.*;


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

    public Address(String address, byte[] image) {
        this.address = address;
        this.image = image;
    }
    public Address(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
