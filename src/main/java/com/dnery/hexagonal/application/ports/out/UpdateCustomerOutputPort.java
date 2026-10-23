package com.dnery.hexagonal.application.ports.out;

import com.dnery.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer, String zipCode);
}
