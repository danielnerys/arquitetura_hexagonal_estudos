package com.dnery.hexagonal.adapters.out;

import com.dnery.hexagonal.adapters.out.repository.CustumerRespository;
import com.dnery.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.dnery.hexagonal.application.core.domain.Customer;
import com.dnery.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    @Autowired
    private CustumerRespository custumerRespository;

    @Autowired
    private CustomerEntityMapper custumerEntityMapper;

    @Override
    public void insert(Customer custumer) {
        
        custumerRespository.save(custumerEntityMapper.toCustomerEntity(custumer));
    }
}
