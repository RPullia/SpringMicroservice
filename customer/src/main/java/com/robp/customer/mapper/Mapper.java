package com.robp.customer.mapper;

public interface Mapper <A,B>{

    B mapTo(A a);
    A mapFrom(B b);
}
