package com.dnery.hexagonal.application.core.usecase;

import com.dnery.hexagonal.application.core.domain.Custumer;
import com.dnery.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

public class InsertCustumerUserCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    public InsertCustumerUserCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    }

    public void insert(Custumer custumer, String zipCode) {

        var address = findAddressByZipCodeOutputPort.findAddressByZipCode(zipCode);

        custumer.setAddress(address);


    }
}
