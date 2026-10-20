package com.dnery.hexagonal.application.ports.out;

import com.dnery.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address findAddressByZipCode(String zipCode);
}
