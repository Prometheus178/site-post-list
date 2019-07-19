package com.realestate.site.models.new_building;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "apartments")
public class Apartment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
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
