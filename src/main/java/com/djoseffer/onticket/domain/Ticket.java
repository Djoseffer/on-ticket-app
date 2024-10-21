package com.djoseffer.onticket.domain;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class Ticket implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal price;
    private Event event;
    private User buyer;
}
