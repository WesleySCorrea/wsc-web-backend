package com.web.wsc_backend.entity;

import com.web.wsc_backend.enums.ContactTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "cellphone")
    private String cellphone;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ContactTypeEnum type;
    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    private Enterprises enterprise;
}
