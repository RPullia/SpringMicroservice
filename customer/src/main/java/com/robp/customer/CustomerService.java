package com.robp.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer(request.getFirstName(), request.getLastName(), request.getEmail());


        //todo: check if email is valid
        //todo: check if email not taken

        customerRepository.save(customer);
    }
}
