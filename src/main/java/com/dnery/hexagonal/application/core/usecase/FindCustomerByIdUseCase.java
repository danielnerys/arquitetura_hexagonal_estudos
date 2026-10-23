package com.dnery.hexagonal.application.core.usecase;

import com.dnery.hexagonal.application.core.domain.Customer;
import com.dnery.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.dnery.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutPutPort.find(id).orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found"));
    }
}
