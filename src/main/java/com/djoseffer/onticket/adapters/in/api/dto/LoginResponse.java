package com.djoseffer.onticket.adapters.in.api.dto;

public record LoginResponse(String accessToken, Long expiresIn, String email) {
}
