package com.web.wsc_backend.service.impl;

import com.web.wsc_backend.DTO.user.UserDTO;
import com.web.wsc_backend.entity.Users;
import com.web.wsc_backend.repository.UserRepository;
import com.web.wsc_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDTO findByUsername(String username) {

        try {
            Users user = userRepository.findByUsername(username);

            return new UserDTO(user);
        } catch (Exception e) {

            return null;
        }
    }
}
