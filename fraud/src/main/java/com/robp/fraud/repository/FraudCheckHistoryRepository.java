package com.robp.fraud.repository;

import com.robp.fraud.domain.entity.FraudCheckHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, Integer> {
    Iterable<FraudCheckHistoryEntity> findByCustomerId(Integer customerId);
}
