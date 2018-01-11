package com.addressservice.poc;

import com.addressservice.poc.dao.AddressDAO;
import com.addressservice.poc.model.AddressModel;
import com.addressservice.poc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("address/v1")
public class Endpoint {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AddressModel> getAllAddressModels() throws IOException {
        return addressService.getAllAddress();
    }

    @RequestMapping(value = "/{addressId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressModel getAddressById(@PathVariable(value = "addressId") int addressId) throws IOException {
        return addressService.getAddressById(addressId);
    }

}
