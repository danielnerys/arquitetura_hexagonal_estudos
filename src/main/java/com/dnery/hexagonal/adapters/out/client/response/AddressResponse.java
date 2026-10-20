package com.dnery.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {
    String street;
    String city;
    String state;

    public AddressResponse(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }
}
