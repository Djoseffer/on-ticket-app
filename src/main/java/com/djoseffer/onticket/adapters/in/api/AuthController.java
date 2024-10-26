package com.djoseffer.onticket.adapters.in.api;

import com.djoseffer.onticket.adapters.in.api.dto.LoginRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.LoginResponse;
import com.djoseffer.onticket.application.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequestDto loginDto) {
        return ResponseEntity.ok(authService.aunthenticateUser(loginDto));
    }


}
