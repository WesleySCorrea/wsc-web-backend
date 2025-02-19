package com.web.wsc_backend.DTO.user;

import com.web.wsc_backend.enums.RoleEnum;
import lombok.Getter;

@Getter
public class UserInfoDTO {
    private Long id;
    private String username;
    private String name;
    private String email;
    private RoleEnum role;

    public UserInfoDTO(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.username = userDTO.getUsername();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.role = userDTO.getRole();
    }
}
