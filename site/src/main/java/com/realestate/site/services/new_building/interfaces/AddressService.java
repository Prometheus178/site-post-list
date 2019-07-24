package com.realestate.site.services.new_building.interfaces;


import com.realestate.site.models.new_building.Address;

import java.util.List;

public interface AddressService {


    List<Address> findAllAddress();

    Address findAddressById(Long id);

    Address saveAddress(Address address);

    void deleteAddressById(Long id);

}
