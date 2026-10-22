package com.dnery.hexagonal.application.core.usecase;

import com.dnery.hexagonal.application.core.domain.Customer;
import com.dnery.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.dnery.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.dnery.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;





    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer custumer, String zipCode) {

        var address = findAddressByZipCodeOutputPort.findAddressByZipCode(zipCode);

        custumer.setAddress(address);

        insertCustomerOutputPort.insert(custumer);


    }
}
