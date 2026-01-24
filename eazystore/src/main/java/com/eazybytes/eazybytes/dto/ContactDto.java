package com.eazybytes.eazybytes.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;


@Setter
@Getter
public class ContactDto {



    private String name;
    private String email;
    private String mobileNumber;
    private String message;

}
