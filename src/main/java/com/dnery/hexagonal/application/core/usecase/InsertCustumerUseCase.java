package com.dnery.hexagonal.application.core.usecase;

import com.dnery.hexagonal.application.core.domain.Custumer;
import com.dnery.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.dnery.hexagonal.application.ports.out.InsertCustumerOutputPort;

public class InsertCustumerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustumerOutputPort insertCustumerOutputPort;



    public InsertCustumerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustumerOutputPort insertCustumerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustumerOutputPort = insertCustumerOutputPort;
    }

    public void insert(Custumer custumer, String zipCode) {

        var address = findAddressByZipCodeOutputPort.findAddressByZipCode(zipCode);

        custumer.setAddress(address);

        insertCustumerOutputPort.insertCustumer(custumer);


    }
}
