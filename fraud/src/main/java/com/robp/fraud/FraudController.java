package com.robp.fraud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
   private final FraudCheckService fraudCheckService;

   private static final Logger logger = LoggerFactory.getLogger(FraudController.class);

   public FraudController(FraudCheckService fraudCheckService){
       this.fraudCheckService = fraudCheckService;
   }
    @GetMapping(path ="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
       boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
       logger.info("Fraud check request for customer: ", customerId);
       return new FraudCheckResponse(isFraudulentCustomer);
    }

}
