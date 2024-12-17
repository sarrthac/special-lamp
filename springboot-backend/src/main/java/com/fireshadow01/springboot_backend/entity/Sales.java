package com.fireshadow01.springboot_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Sales {

    @Id
    private String saleId;

    private String productId;

    private LocalDateTime timestamp;

    private Integer  quantity;

    private float unitPrice;

    private float totalAmount;

    @ManyToOne
    private Products products;
}
