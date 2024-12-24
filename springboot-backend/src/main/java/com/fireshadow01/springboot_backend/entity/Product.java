package com.fireshadow01.springboot_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private String category;

    private String photoUrl;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'Active'")
    private String status;

    private Boolean favourite;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
