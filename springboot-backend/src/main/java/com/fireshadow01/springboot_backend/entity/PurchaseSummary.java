package com.fireshadow01.springboot_backend.entity;


import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PurchaseSummary {

    @Id
    private String purchaseSummaryId;

    private float totalPurchased;

    private Float changePercentage;

    private LocalDateTime date;
}
