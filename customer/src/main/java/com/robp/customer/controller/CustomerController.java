package com.robp.customer.controller;


import com.robp.customer.domain.dto.CustomerDto;
import com.robp.customer.domain.entity.CustomerEntity;
import com.robp.customer.mapper.Mapper;
import com.robp.customer.service.CustomerRegistrationRequest;
import com.robp.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/customers")
public class  CustomerController {

    private final CustomerService customerService;
    private Mapper<CustomerEntity, CustomerDto> customerMapper;

    public CustomerController(CustomerService customerService, Mapper<CustomerEntity, CustomerDto> customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public void registrateCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
