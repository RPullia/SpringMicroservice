package com.robp.customer.service.impl;

import com.robp.customer.domain.entity.CustomerEntity;
import com.robp.customer.repository.CustomerRepository;
import com.robp.customer.service.CustomerService;
import com.robp.fraud.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    //Fraud service names that will be used for service discovery from Eureka
    private final String FRAUD_SERVICE_NAME = "FRAUD";

    public CustomerServiceImpl(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity){

        //todo: check if email is valid
        //todo: check if email not taken

        //communicate with fraud microservice and check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://"+FRAUD_SERVICE_NAME+"/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customerEntity.getId()
        );

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster!");
        }

        return customerRepository.save(customerEntity);

        //todo: send notification
    }
}
