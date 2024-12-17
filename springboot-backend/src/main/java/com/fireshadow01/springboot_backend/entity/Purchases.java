package com.fireshadow01.springboot_backend.entity;


import lombok.*;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Purchases {

    @Id
    private String purchaseId;

    private String productId;

    private LocalDateTime timestamp;

    private Integer  quantity;

    private float unitCost;

    private float totalCost;

    @ManyToOne
    private Products products;
}
