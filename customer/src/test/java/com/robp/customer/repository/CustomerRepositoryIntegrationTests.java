package com.robp.customer.repository;

import com.robp.customer.CustomerTestDataUtil;
import com.robp.customer.domain.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

// note: EurekaServerApplication not needed to run this test suite, but if stopped will produce INFO messages in console.

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerRepositoryIntegrationTests {

    private CustomerRepository underTest;

    @Autowired
    public CustomerRepositoryIntegrationTests(CustomerRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatCustomerCanBeCreated(){
        CustomerEntity customerEntity = CustomerTestDataUtil.createTestCustomerC();
        underTest.save(customerEntity);

        Optional<CustomerEntity> result = underTest.findById(customerEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(customerEntity);
    }

    @Test
    public void testThatMultipleCustomersCanBeCreated(){
        CustomerEntity customerEntityA = CustomerTestDataUtil.createTestCustomerA();
        underTest.save(customerEntityA);

        CustomerEntity customerEntityB = CustomerTestDataUtil.createTestCustomerB();
        underTest.save(customerEntityB);

        List<CustomerEntity> result = underTest.findAll();
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(customerEntityA, customerEntityB);
    }

    @Test
    public void testThatCustomerCanBeDeleted(){
        CustomerEntity customerEntityA = CustomerTestDataUtil.createTestCustomerA();
        underTest.save(customerEntityA);
        underTest.delete(customerEntityA);
        Optional<CustomerEntity> result = underTest.findById(customerEntityA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testGetCustomerWithFirstNameEqualsTo(){
        CustomerEntity customerEntityA = CustomerTestDataUtil.createTestCustomerA();
        underTest.save(customerEntityA);

        CustomerEntity customerEntityB = CustomerTestDataUtil.createTestCustomerB();
        underTest.save(customerEntityB);

        Iterable <CustomerEntity> result = underTest.findByFirstName("TestNameA");
        assertThat(result).containsExactly(customerEntityA);
    }

    @Test
    public void testGetCustomerWithLastNameEqualsTo(){
        CustomerEntity customerEntityA = CustomerTestDataUtil.createTestCustomerA();
        underTest.save(customerEntityA);

        CustomerEntity customerEntityB = CustomerTestDataUtil.createTestCustomerB();
        underTest.save(customerEntityB);

        Iterable <CustomerEntity> result = underTest.findByLastName("TestSurnameB");
        assertThat(result).containsExactly(customerEntityB);
    }

    @Test
    public void testGetCustomerWithEmailEqualsTo(){
        CustomerEntity customerEntityA = CustomerTestDataUtil.createTestCustomerA();
        underTest.save(customerEntityA);

        CustomerEntity customerEntityB = CustomerTestDataUtil.createTestCustomerB();
        underTest.save(customerEntityB);

        Iterable <CustomerEntity> result = underTest.findByEmail("testB@email.com");
        assertThat(result).containsExactly(customerEntityB);
    }
}
