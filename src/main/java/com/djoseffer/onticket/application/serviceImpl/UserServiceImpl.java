package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.domain.User;

public interface UserServiceImpl {

    void registerUser(User user);

    void loginUser(String email, String password);

    void buyTicket(Long userId, Long eventId, Long ticketId);
}
