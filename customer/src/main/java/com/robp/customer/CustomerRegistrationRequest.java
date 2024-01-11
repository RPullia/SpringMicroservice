package com.robp.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {


}
