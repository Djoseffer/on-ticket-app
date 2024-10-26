package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.adapters.in.api.dto.LoginRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.LoginResponse;

public interface AuthServiceImpl {
    LoginResponse aunthenticateUser(LoginRequestDto loginRequestDto);
}
