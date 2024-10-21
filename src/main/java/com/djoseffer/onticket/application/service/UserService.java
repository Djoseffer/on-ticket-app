package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.application.serviceImpl.UserServiceImpl;
import com.djoseffer.onticket.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImpl {
    @Override
    public void registerUser(User user) {

    }

    @Override
    public void loginUser(String email, String password) {

    }

    @Override
    public void buyTicket(Long userId, Long eventId, Long ticketId) {

    }
}
