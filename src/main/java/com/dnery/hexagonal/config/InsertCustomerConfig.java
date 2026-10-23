package com.dnery.hexagonal.config;

import com.dnery.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.dnery.hexagonal.adapters.out.InsertCustomerAdapter;
import com.dnery.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.dnery.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, InsertCustomerAdapter insertCustomerAdapter, SendCpfValidationAdapter sendCpfValidationAdapter) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
