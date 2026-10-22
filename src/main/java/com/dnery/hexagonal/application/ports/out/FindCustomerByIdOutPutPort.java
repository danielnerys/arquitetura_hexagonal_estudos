package com.dnery.hexagonal.application.ports.out;

import com.dnery.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPutPort {
    Optional<Customer> find(String id);
}
