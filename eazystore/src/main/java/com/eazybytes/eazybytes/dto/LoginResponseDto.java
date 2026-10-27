package com.eazybytes.eazybytes.dto;

public record LoginResponseDto(String message , UserDto user , String jwtToken) {
}
