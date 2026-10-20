package com.dnery.hexagonal.adapters.out.repository;

import com.dnery.hexagonal.adapters.out.repository.entity.CustumerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustumerRespository extends MongoRepository<CustumerEntity, String> {
}
