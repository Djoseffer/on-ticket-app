package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.adapters.in.api.dto.UserRegisterDto;
import com.djoseffer.onticket.adapters.in.api.dto.UserResponseDto;
import com.djoseffer.onticket.adapters.out.persistence.MongoUserRepository;
import com.djoseffer.onticket.application.service.mapper.UserMapper;
import com.djoseffer.onticket.application.serviceImpl.UserServiceImpl;
import com.djoseffer.onticket.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    private final BCryptPasswordEncoder passwordEncoder;

    private final MongoUserRepository mongoUserRepository;

    public UserService(BCryptPasswordEncoder passwordEncoder, MongoUserRepository mongoUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.mongoUserRepository = mongoUserRepository;
    }

    @Override
    public void registerUser(UserRegisterDto userDto) {
        User newUser = UserMapper.INSTANCE.convertUserRegisterDtotoUser(userDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        mongoUserRepository.save(newUser);
    }

    @Override
    public void buyTicket(String userId, String eventId, String ticketId) {

    }

    public List<UserResponseDto> findAllUsers() {
        List<User> users = mongoUserRepository.findAll();
        return users.stream().map(
                UserMapper.INSTANCE::convertUserToUserResponseDto
        ).toList();
    }


}
