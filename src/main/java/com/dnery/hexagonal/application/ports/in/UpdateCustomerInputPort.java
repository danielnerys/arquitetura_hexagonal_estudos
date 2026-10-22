package com.dnery.hexagonal.application.ports.in;

import com.dnery.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
