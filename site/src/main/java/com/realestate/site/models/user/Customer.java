package com.realestate.site.models.user;


import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.utils.FormatDateTime;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "date_time")
    private String dateTime;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "comment")
    private String comment;

    @Column(name = "mortgage")
    private boolean mortgage;

    @Column(name = "agree_to_data_processing")
    private boolean agreeToDataProcessing;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public String getDateTime() {
        return FormatDateTime.getInstance().formattedDateTime(dateTime);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                ", mortgage=" + mortgage +
                ", agreeToDataProcessing=" + agreeToDataProcessing +
                ", apartment=" + apartment.getAddress() +
                '}';
    }
}
