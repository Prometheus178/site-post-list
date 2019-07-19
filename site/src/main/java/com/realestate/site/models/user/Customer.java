package com.realestate.site.models.user;


import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.parent.Person;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Customer extends Person {
//    @Column(name = "date_time")
    private LocalDateTime dateTime;

//    @Column(name = "phone_number")
    private String phoneNumber;

//    @Column(name = "email")
    private String email;

//    @Column(name = "comment")
    private String comment;

//    @Column(name = "mortgage")
    private boolean mortgage;

//    @Column(name = "agree_to_data_processing")
    private boolean agreeToDataProcessing;

//    @Column(name = "apartment")
    private Apartment apartment;

}
