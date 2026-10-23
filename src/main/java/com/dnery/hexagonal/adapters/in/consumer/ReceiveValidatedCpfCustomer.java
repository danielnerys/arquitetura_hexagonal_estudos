package com.dnery.hexagonal.adapters.in.consumer;

import com.dnery.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.dnery.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.dnery.hexagonal.application.core.domain.Customer;
import com.dnery.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.dnery.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import com.dnery.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfCustomer{

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "dnery")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());

    }


}
