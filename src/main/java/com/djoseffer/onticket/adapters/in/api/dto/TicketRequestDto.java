package com.djoseffer.onticket.adapters.in.api.dto;

import java.math.BigDecimal;

public record TicketRequestDto(
        BigDecimal price,
        String description,
        String local
) {
}
