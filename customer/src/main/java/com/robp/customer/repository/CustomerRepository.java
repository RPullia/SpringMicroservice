package com.robp.customer.repository;

import com.robp.customer.domain.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    Iterable<CustomerEntity> findByFirstName(String firstName);

    Iterable<CustomerEntity> findByLastName(String lastName);

    Iterable<CustomerEntity> findByEmail(String email);

}
