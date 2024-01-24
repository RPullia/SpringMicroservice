package com.robp.customer;

import com.robp.customer.domain.entity.CustomerEntity;

public final class CustomerTestDataUtil {
    private CustomerTestDataUtil(){

    }

    public static CustomerEntity createTestCustomerA(){
        return new CustomerEntity("TestNameA", "TestSurnameA", "testA@email.com");
    }

    public static CustomerEntity createTestCustomerB(){
        return new CustomerEntity("TestNameB", "TestSurnameB", "testB@email.com");
    }

    public static CustomerEntity createTestCustomerC(){
        return new CustomerEntity("TestNameC", "TestSurnameC", "testC@email.com");
    }

}
