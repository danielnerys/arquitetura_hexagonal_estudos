package com.dnery.hexagonal.application.core.domain;

public class Customer {

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(Boolean isValidCpf, String cpf, Address address, String name, String id) {
        this.isValidCpf = isValidCpf;
        this.cpf = cpf;
        this.address = address;
        this.name = name;
        this.id = id;
    }

    private String id;
    private String name;

    private Address address;

    private String cpf;

    private Boolean                                                                                                                 isValidCpf;

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }


    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

