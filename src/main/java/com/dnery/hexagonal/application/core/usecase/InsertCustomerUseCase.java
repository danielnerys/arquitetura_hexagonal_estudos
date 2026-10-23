package com.dnery.hexagonal.application.core.usecase;

import com.dnery.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.dnery.hexagonal.application.core.domain.Customer;
import com.dnery.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.dnery.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.dnery.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.dnery.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfValidationOutputPort;





    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort,  SendCpfForValidationOutputPort sendCpfValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;

    }

    @Override
    public void insert(Customer custumer, String zipCode) {

        var address = findAddressByZipCodeOutputPort.findAddressByZipCode(zipCode);

        custumer.setAddress(address);

        insertCustomerOutputPort.insert(custumer);

        sendCpfValidationOutputPort.send(custumer.getCpf());



    }
}
