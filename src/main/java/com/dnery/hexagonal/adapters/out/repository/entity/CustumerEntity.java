package com.dnery.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "custumers")
public class CustumerEntity {

    @Id
    private String id;
    
    private String name;
    private AddressEntity addressEntity;
    private String cpf;
    private boolean isValidCpf;
}
