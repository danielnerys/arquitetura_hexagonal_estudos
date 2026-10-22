package com.dnery.hexagonal.application.ports.in;

import com.dnery.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
