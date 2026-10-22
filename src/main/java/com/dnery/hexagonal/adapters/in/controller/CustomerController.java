package com.dnery.hexagonal.adapters.in.controller;

import com.dnery.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.dnery.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.dnery.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.dnery.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.dnery.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.dnery.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.dnery.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var custumer = customerMapper.toCustumer(customerRequest);
        insertCustomerInputPort.insert(custumer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var custumer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok(customerMapper.toCustomerResponse(custumer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var custumer = findCustomerByIdInputPort.find(id);
        custumer.setId(id);
        updateCustomerInputPort.update(custumer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.noContent().build();

    }
}
