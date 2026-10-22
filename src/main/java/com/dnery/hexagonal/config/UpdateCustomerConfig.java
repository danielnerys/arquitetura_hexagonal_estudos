package com.dnery.hexagonal.config;

import com.dnery.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.dnery.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.dnery.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.dnery.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.dnery.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
