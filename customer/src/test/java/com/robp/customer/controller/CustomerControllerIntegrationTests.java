package com.robp.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robp.customer.domain.entity.CustomerEntity;
import com.robp.customer.CustomerTestDataUtil;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public CustomerControllerIntegrationTests(MockMvc mockMvc ){
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }


    @Test
    public void testThatRegistrateCustomerSuccesfullyReturn201Created() throws Exception{
        CustomerEntity testCustomerA = CustomerTestDataUtil.createTestCustomerA();
        testCustomerA.setId(null);
        String customerJson = objectMapper.writeValueAsString(testCustomerA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatRegistrateCustomerSuccesfulltReturnSavedCustomer() throws Exception{
        CustomerEntity testCustomerB = CustomerTestDataUtil.createTestCustomerB();
        testCustomerB.setId(null);
        String customerJson = objectMapper.writeValueAsString(testCustomerB);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.firstName").value("TestNameB")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.lastName").value("TestSurnameB")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.email").value("testB@email.com")
        );
    }
}
