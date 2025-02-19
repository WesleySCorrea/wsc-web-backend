package com.web.wsc_backend.DTO.login.response;

import com.web.wsc_backend.DTO.user.UserInfoDTO;
import com.web.wsc_backend.enums.RoleEnum;
import lombok.Getter;

import java.util.Date;

@Getter
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String username;
    private RoleEnum role;
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpiresIn;

    public LoginResponse(UserInfoDTO user, String accessToken, String refreshToken, Date expiration, Date expirationRefreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userId = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.accessTokenExpiresIn = expiration.getTime();
        this.refreshTokenExpiresIn = expirationRefreshToken.getTime();
    }
}
