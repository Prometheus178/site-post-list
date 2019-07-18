package com.realestate.site.new_buildings.entities;


import com.realestate.site.parent.BaseEntity;
import lombok.Data;

import javax.persistence.Column;

@Data
public class Apartment extends BaseEntity {
    @Column(name = "address")
    private Address address;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "floor")
    private int floor;
    @Column(name = "numberOfApartment")
    private int numberOfApartment;
    @Column(name = "number_of_rooms")
    private int numberOfRooms;
    @Column(name = "square")
    private double square;
    @Column(name = "price_per_square")
    private int pricePerSquare;
    @Column(name = "full_price")
    private int fullPrice;
    @Column(name = "status")
    private Status status;


}
