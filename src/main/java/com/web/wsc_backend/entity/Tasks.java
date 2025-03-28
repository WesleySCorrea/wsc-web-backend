package com.web.wsc_backend.entity;

import com.web.wsc_backend.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "finish_date", nullable = false)
    private LocalDate finishDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEnum status;
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprises enterprise;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;
}
