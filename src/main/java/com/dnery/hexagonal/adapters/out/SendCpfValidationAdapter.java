package com.dnery.hexagonal.adapters.out;

import com.dnery.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {

        kafkaTemplate.send("tp-cpf-validation", cpf);

    }
}
