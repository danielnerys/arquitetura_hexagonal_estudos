package com.dnery.hexagonal.adapters.out;

import com.dnery.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.dnery.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.dnery.hexagonal.adapters.out.client.response.AddressResponse;
import com.dnery.hexagonal.application.core.domain.Address;
import com.dnery.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {
    private AddressResponse addressResponse;

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address findAddressByZipCode(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.findAddressByZipCode(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
