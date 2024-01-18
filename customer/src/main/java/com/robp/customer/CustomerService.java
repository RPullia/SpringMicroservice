package com.robp.customer;

import com.robp.fraud.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    //Fraud service names that will be used for service discovery from Eureka
    private final String FRAUD_SERVICE_NAME = "FRAUD";

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer(request.getFirstName(), request.getLastName(), request.getEmail());


        //todo: check if email is valid
        //todo: check if email not taken
        customerRepository.saveAndFlush(customer);

        //communicate with fraud microservice and check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://"+FRAUD_SERVICE_NAME+"/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster!");
        }
        //todo: send notification
    }
}
