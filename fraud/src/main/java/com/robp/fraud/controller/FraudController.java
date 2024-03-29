package com.robp.fraud.controller;

import com.robp.clients.fraud.FraudCheckResponse;
import com.robp.fraud.service.impl.FraudCheckServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
   private final FraudCheckServiceImpl fraudCheckService;

   public FraudController(FraudCheckServiceImpl fraudCheckService){
       this.fraudCheckService = fraudCheckService;
   }
    @GetMapping(path ="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
       boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        // todo : add logging
       return new FraudCheckResponse(isFraudulentCustomer);
    }

}
