package com.eazybytes.eazybytes.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;


@Setter
@Getter
public class ProductDto {


    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int popularity;
    private String imageUrl;
    private Instant createdAt;
}
