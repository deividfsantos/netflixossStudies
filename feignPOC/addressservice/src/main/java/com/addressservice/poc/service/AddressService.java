package com.addressservice.poc.service;

import com.addressservice.poc.dao.AddressDAO;
import com.addressservice.poc.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressDAO addressDAO;

    public List<AddressModel> getAllAddress() {
        return addressDAO.getAddressModels();
    }

    public AddressModel getAddressById(int addressId) {

        return addressDAO.getAddressById(addressId);

    }
}
