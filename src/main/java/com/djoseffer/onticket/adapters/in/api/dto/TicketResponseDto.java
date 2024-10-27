package com.djoseffer.onticket.adapters.in.api.dto;

import java.math.BigDecimal;

public record TicketResponseDto(
        BigDecimal price,
        String description,
        String local
) {
}