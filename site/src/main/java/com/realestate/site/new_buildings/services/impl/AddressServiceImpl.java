package com.realestate.site.new_buildings.services.impl;


import com.realestate.site.new_buildings.dao.interfaces.AddressDAO;
import com.realestate.site.new_buildings.entities.Address;
import com.realestate.site.new_buildings.services.interfaces.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDAO addressDAO;


    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;

    }

//    @Transactional
//    public AddressCommand findCommandById(Long id) {
//        Address detachedAddress = addressDAO.findCommandById(id);
//        return addressToAddressCommand.convert(detachedAddress);
//    }
//
//    @Override
//    public AddressCommand saveAddressCommand(AddressCommand object) {
//        Address detachedAddress = addressCommandToAddress.convert(object);
//        Address savedAddress = addressDAO.saveAddressCommand(detachedAddress);
//        return addressToAddressCommand.convert(savedAddress);
//    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = addressDAO.findAll();
        return addresses;
    }

    public Address findById(Long aLong) {
        Address address = addressDAO.findById(aLong);
        return address;
    }

    @Override
    public Address save(Address object) {
        return addressDAO.save(object);
    }

    @Override
    public void delete(Address object) {

    }

}
