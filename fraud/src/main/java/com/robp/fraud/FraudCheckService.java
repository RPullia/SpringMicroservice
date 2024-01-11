package com.robp.fraud;

import java.time.LocalDateTime;

public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService (FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }



    public boolean isFraudulentCustomer(Integer customerId){
        boolean isFraudulent = false;
        FraudCheckHistory fraudCheckHistory;

        //todo: implement some sort of check to decide if it is fraudulent

        fraudCheckHistoryRepository.save(
              fraudCheckHistory  = new FraudCheckHistory(customerId, isFraudulent, LocalDateTime.now())
        );
        return false;
    }
}
