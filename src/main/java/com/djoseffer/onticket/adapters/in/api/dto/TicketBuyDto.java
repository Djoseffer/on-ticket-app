package com.djoseffer.onticket.adapters.in.api.dto;

import java.math.BigDecimal;

public record TicketBuyDto(
        String email,
        String eventName,
        Long ticketQuantity
) {
}
