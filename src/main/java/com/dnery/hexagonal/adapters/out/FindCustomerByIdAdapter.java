package com.dnery.hexagonal.adapters.out;

import com.dnery.hexagonal.adapters.out.repository.CustumerRespository;
import com.dnery.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.dnery.hexagonal.application.core.domain.Customer;
import com.dnery.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPutPort {

    @Autowired
    private CustumerRespository custumerRespository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = custumerRespository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
