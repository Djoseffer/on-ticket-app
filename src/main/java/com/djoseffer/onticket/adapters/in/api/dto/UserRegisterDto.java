package com.djoseffer.onticket.adapters.in.api.dto;

public record UserRegisterDto(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
