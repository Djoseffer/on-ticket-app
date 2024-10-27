package com.djoseffer.onticket.adapters.in.api.dto;

import java.math.BigDecimal;

public record TicketsPurchasedDto(
        String eventName,
        Long ticketQuantity,
        BigDecimal totalValue,
        String message
) {
}
