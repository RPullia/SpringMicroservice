package com.robp.customer.mapper.impl;

import com.robp.customer.domain.dto.CustomerDto;
import com.robp.customer.domain.entity.CustomerEntity;
import com.robp.customer.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements Mapper<CustomerEntity, CustomerDto> {
    private final ModelMapper modelMapper;

    public CustomerMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto mapTo(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public CustomerEntity mapFrom(CustomerDto customerDto){
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
}
