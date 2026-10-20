package com.dnery.hexagonal.adapters.out.client;

import com.dnery.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${nery.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    AddressResponse findAddressByZipCode(String zipCode);


    @GetMapping("/{zipCode}")
    AddressResponse findAddressByZipCode2(@PathVariable("zipCode") String zipCode);
}
