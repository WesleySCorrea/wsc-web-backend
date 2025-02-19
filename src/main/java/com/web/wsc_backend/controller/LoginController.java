package com.web.wsc_backend.controller;

import com.web.wsc_backend.DTO.login.request.LoginRequestDTO;
import com.web.wsc_backend.DTO.login.request.RefreshRequestDTO;
import com.web.wsc_backend.DTO.login.response.LoginResponse;
import com.web.wsc_backend.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {

        LoginResponse loginResponse = this.loginService.login(loginRequestDTO);

        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshRequestDTO refreshToken) {

        LoginResponse loginResponse = this.loginService.loginWithRefresh(refreshToken);

        return ResponseEntity.ok().body(loginResponse);
    }
}
