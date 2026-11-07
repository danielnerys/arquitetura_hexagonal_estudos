package com.dnery.hexagonal.adapters.out.client.mapper;

import com.dnery.hexagonal.adapters.out.client.response.AddressResponse;
import com.dnery.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
