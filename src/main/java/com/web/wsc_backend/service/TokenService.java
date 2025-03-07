package com.web.wsc_backend.service;

import com.web.wsc_backend.DTO.login.response.LoginResponse;
import com.web.wsc_backend.DTO.user.UserInfoDTO;

public interface TokenService {
    LoginResponse generateAccessToken(UserInfoDTO user);
    String validateRefreshTokenAndExtractUserName(String token);
}
