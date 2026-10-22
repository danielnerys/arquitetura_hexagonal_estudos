package com.dnery.hexagonal.adapters.out;

import com.dnery.hexagonal.adapters.out.repository.CustumerRespository;
import com.dnery.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {
    @Autowired
    private CustumerRespository custumerRespository;

    @Override
    public void delete(String id) {
        custumerRespository.deleteById(id);


    }
}
