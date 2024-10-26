package com.djoseffer.onticket.adapters.in.api.dto;

import com.djoseffer.onticket.domain.User;

import java.math.BigDecimal;

public record EventResponseDto(
        String eventName,
        String eventDescription,
        User creator,
        Long ticketQuantity,
        BigDecimal ticketPrice
) {
}
