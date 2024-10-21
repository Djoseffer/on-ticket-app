package com.djoseffer.onticket.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Event implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String eventName;
    private String eventDescription;
    private LocalDateTime date;
    private User creator;
    private Long ticketQuantity;
    private BigDecimal ticketPrice;
    private List<Ticket> eventTickets;

    public void addTicket(Ticket ticket) {
    }

    public boolean isSoldOut;
}
