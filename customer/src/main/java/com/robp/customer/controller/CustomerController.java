package com.robp.customer.controller;


import com.robp.customer.domain.dto.CustomerDto;
import com.robp.customer.domain.entity.CustomerEntity;
import com.robp.customer.mapper.Mapper;
import com.robp.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1")
public class  CustomerController {

    private final CustomerService customerService;
    private Mapper<CustomerEntity, CustomerDto> customerMapper;

    public CustomerController(CustomerService customerService, Mapper<CustomerEntity, CustomerDto> customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(path = "/customers")
    public ResponseEntity<CustomerDto> registrateCustomer(@RequestBody CustomerDto customerDto){
        CustomerEntity customerEntity = customerMapper.mapFrom(customerDto);
        CustomerEntity savedCustomerEntity = customerService.createCustomer(customerEntity);
        return new ResponseEntity<>(customerMapper.mapTo(savedCustomerEntity), HttpStatus.CREATED);
    }
}
