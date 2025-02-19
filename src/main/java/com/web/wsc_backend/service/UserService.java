package com.web.wsc_backend.service;

import com.web.wsc_backend.DTO.user.UserDTO;

public interface UserService {
    UserDTO findByUsername(String username);
}
