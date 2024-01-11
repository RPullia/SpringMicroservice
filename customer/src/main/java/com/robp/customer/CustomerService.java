package com.robp.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer(request.firstName(), request.lastName(), request.email());


        //todo: check if email is valid
        //todo: check if email not taken

        customerRepository.save(customer);
    }
}
