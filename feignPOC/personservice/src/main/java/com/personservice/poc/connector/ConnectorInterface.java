package com.personservice.poc.connector;

import com.personservice.poc.model.model.AddressModel;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface ConnectorInterface {

    @RequestLine("GET /")
    List<AddressModel> findAllAddress();

    @RequestLine("GET /{addressId}")
    AddressModel findAddressById(@Param("addressId") int addressId);

}
