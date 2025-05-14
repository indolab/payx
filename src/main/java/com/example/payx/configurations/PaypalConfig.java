package com.example.payx.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;

@Configuration
public class PaypalConfig {
    
    private String clientId = "AT108baSDmONnJrBVGpGj_5lygTgoZFu0m7W3mX1yNmZHGkEcR47jhxg-gGJ8Cd5xJHgEf8q7uKbi21x";

    
    private String clientSecret ="EHkYg1b1-iBp_a6kBKdWyTxWyRVYB17-uWK99AanCnway2siBCi312qHNPddIlkPKjjzMIa7IdN6yPrg";

    
    private String mode = "sandbox";

    @Bean
    public APIContext apiContext() {
        return new APIContext(clientId, clientSecret, mode);
    }

}
