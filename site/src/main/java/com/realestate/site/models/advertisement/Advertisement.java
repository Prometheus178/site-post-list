package com.realestate.site.models.advertisement;





import com.realestate.site.models.advertisement.enums.*;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "advertisements")
public class Advertisement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private Long id;
    //todo 1 add String washer
    //todo 2 correct design add advertisement
    @Column(name = "title")
    private String title;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "account_type")
    private AccountType accountType;
    @Column(name = "deal_type")
    private DealType dealType;
    @Column(name = "rent_type")
    private RentType rentType;
    @Column(name = "real_estate_type")
    private RealEstateType realEstateType;
    @Column(name = "living")
    private Living living;
    @Column(name = "commercial")

    private Commercial commercial;
    @Column(name = "district")

    private District district;
    @Column(name = "address")

    private String address;

    @Column(name = "building_type")
    private BuildingType buildingType;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "price")
    private int price;

    @Column(name = "communal_payments")
    private boolean communalPayments;

    @Column(name = "number_of_rooms")
    private NumberOfRooms numberOfRooms;

    @Column(name = "repairs")
    private Repairs repairs;

    @Column(name = "floor")
    private int floor;

    @Column(name = "square")
    private double square;

    @Column(name = "deposit")
    private int deposit;

    @Column(name = "name_of_complex")
    private String nameOfComplex;

    @Column(name = "year_of_construction")
    private int yearOfConstruction;
    @Column(name = "squareOfLiving")

    private double squareOfLiving;

    @Column(name = "square_of_kitchen")
    private double squareOfKitchen;

    @Column(name = "animal")
    private boolean animal;

    @Column(name = "furniture")
    private boolean furniture;

    @Column(name = "window_inside")
    private boolean windowInside;

    @Column(name = "window_outside")
    private boolean windowOutside;

    @Column(name = "balcony")
    private boolean balcony;

    @Column(name = "loggia")
    private boolean loggia;

    @Column(name = "tv")
    private boolean tv;

    @Column(name = "phone")
    private boolean phone;
    @Column(name = "bath")

    private boolean bath;

    @Column(name = "shower")
    private boolean shower;

    @Column(name = "conditioner")
    private boolean conditioner;

    @Column(name = "internet")
    private boolean internet;
    @Column(name = "separate_bathroom")
    private boolean separateBathroom;

    @Column(name = "combined_bathroom")
    private boolean combinedBathroom;

    @Column(name = "lift")
    private boolean lift;
    @Column(name = "ramp")
    private boolean ramp;


}
