package com.web.wsc_backend.service;

import com.web.wsc_backend.DTO.login.request.LoginRequestDTO;
import com.web.wsc_backend.DTO.login.request.RefreshRequestDTO;
import com.web.wsc_backend.DTO.login.response.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequestDTO loginRequestDTO);
    LoginResponse loginWithRefresh(RefreshRequestDTO refreshToken);
}
