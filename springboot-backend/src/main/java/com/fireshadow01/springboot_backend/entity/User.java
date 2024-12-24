package com.fireshadow01.springboot_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'Standard'")
    private String role;

    private String photoUrl;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'Active'")
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

