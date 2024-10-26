package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.adapters.in.api.dto.LoginRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.LoginResponse;
import com.djoseffer.onticket.adapters.out.persistence.MongoUserRepository;
import com.djoseffer.onticket.application.serviceImpl.AuthServiceImpl;
import com.djoseffer.onticket.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService implements AuthServiceImpl {

    private final JwtEncoder jwtEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MongoUserRepository mongoUserRepository;
    private final JwtDecoder jwtDecoder;

    public AuthService(JwtEncoder jwtEncoder, BCryptPasswordEncoder bCryptPasswordEncoder, MongoUserRepository mongoUserRepository, @Qualifier("jwtDecoder") JwtDecoder jwtDecoder) {
        this.jwtEncoder = jwtEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mongoUserRepository = mongoUserRepository;
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public LoginResponse aunthenticateUser(LoginRequestDto loginRequestDto) {
        var user = mongoUserRepository.findByEmail(loginRequestDto.email());
        if (user.isEmpty() || !isLoginCorrect(user.get(), loginRequestDto)) {
            throw new BadCredentialsException("Invalid email or password");
        }

        var now = Instant.now();
        var expiresIn = 500L;
        var scopes = user.get()
                .getEmail();

        var claims = JwtClaimsSet.builder()
                .issuer("back-end")
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn, user.get().getEmail());
    }

    private boolean isLoginCorrect(User user, LoginRequestDto loginRequestDto) {
        return bCryptPasswordEncoder.matches(loginRequestDto.password(), user.getPassword());
    }

    public String extractUserIdFromToken(String token) {
        Jwt decodeJwt = jwtDecoder.decode(token.replace("Bearer ", ""));
        return decodeJwt.getSubject();
    }

}
