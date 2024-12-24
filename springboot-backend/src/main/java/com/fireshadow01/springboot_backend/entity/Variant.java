package com.fireshadow01.springboot_backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "variants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer measurementValue;

    private String measurementUnit;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'Active'")
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
