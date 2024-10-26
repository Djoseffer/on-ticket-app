package com.djoseffer.onticket.adapters.in.api;

import com.djoseffer.onticket.adapters.in.api.dto.UserRegisterDto;
import com.djoseffer.onticket.adapters.in.api.dto.UserResponseDto;
import com.djoseffer.onticket.application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid final UserRegisterDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }
}
