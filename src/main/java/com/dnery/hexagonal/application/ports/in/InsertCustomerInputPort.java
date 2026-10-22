package com.dnery.hexagonal.application.ports.in;

import com.dnery.hexagonal.application.core.domain.Customer;


public interface InsertCustomerInputPort {

    void insert(Customer custumer, String zipCode);
}
