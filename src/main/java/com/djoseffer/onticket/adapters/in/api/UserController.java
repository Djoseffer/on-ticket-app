package com.djoseffer.onticket.adapters.in.api;

import com.djoseffer.onticket.adapters.in.api.dto.LoginDto;
import com.djoseffer.onticket.adapters.in.api.dto.UserRegisterDto;
import com.djoseffer.onticket.application.service.UserService;
import com.djoseffer.onticket.application.serviceImpl.UserServiceImpl;
import com.djoseffer.onticket.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody final UserRegisterDto userDto) {
        final User register = new User();
        BeanUtils.copyProperties(userDto, register);
        userService.registerUser(register);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        //implementar login
        return ResponseEntity.ok("Login successful");
    }
}
