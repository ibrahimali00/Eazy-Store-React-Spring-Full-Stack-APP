package com.eazybytes.eazybytes.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;


@Setter
@Getter
public class ContactDto {


    @NotBlank(message = "Name can not be empty")
    @Size(min = 5 , max = 30 , message = "Name must be between 5 and 30 characters")
    private String name;

    @NotBlank(message = "Email can not be empty")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Mobile Number can not be empty")
    @Pattern(regexp = "^\\d{10}$" , message = "mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Message can not be empty")
    @Size(min = 5 , max = 500 , message = "message must be between 5 and 500 characters")
    private String message;

}
