package com.web.wsc_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "enterprises")
public class Enterprises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;
    @OneToMany(mappedBy = "enterprisesId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contacts> contatos;
    @OneToMany(mappedBy = "enterprisesId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cars> carList;
    @OneToMany(mappedBy = "enterpriseId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tasks> tasks;
}
