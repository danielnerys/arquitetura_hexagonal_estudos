package com.dnery.hexagonal.config;

import com.dnery.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.dnery.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.dnery.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdOutputPort);
    }
}
