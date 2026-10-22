package com.dnery.hexagonal.adapters.out.repository;

import com.dnery.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustumerRespository extends MongoRepository<CustomerEntity, String> {
}
