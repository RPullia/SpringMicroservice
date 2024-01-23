package com.robp.customer.repository;

import com.robp.customer.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Iterable<CustomerEntity> findByFirstName(String firstName);

    Iterable<CustomerEntity> findByLastName(String lastName);

    Iterable<CustomerEntity> findByEmail(String email);

}
