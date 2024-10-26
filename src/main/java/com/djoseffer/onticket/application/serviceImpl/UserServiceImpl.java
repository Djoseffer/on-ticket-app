package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.adapters.in.api.dto.UserRegisterDto;

public interface UserServiceImpl {

    void registerUser(UserRegisterDto userDto);

    void buyTicket(String userId, String eventId, String ticketId);
}
