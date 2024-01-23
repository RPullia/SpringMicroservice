package com.robp.fraud.service;

import com.robp.fraud.domain.entity.FraudCheckHistoryEntity;
import com.robp.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService (FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }



    public boolean isFraudulentCustomer(Integer customerId){
        boolean isFraudulent = false;
        FraudCheckHistoryEntity fraudCheckHistoryEntity;

        //todo: implement some sort of check to decide if it is fraudulent

        fraudCheckHistoryRepository.save(
              fraudCheckHistoryEntity = new FraudCheckHistoryEntity(customerId, isFraudulent, LocalDateTime.now())
        );
        return false;
    }
}
