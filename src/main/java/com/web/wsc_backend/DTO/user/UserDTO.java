package com.web.wsc_backend.DTO.user;

import com.web.wsc_backend.entity.Users;
import com.web.wsc_backend.enums.RoleEnum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String username;
    private String password;
    private Boolean active;
    private RoleEnum role;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public UserDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surName = user.getSurName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.getActive();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
