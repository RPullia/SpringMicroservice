package com.robp.customer.controller;


import com.robp.fraud.FraudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(FraudController.class);

    public CustomerController(CustomerService customerService, Mapper<CustomerEntity, CustomerDto> customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(path = "/customers")
    public ResponseEntity<CustomerDto> registrateCustomer(@RequestBody CustomerDto customerDto){
        CustomerEntity customerEntity = customerMapper.mapFrom(customerDto);
        CustomerEntity savedCustomerEntity = customerService.createCustomer(customerEntity);
        logger.info("Creation request for customer: ", customerDto.toString());
        return new ResponseEntity<>(customerMapper.mapTo(savedCustomerEntity), HttpStatus.CREATED);
    }
}
