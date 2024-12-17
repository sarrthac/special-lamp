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
public class SalesSummary {

    @Id
    private String salesSummaryId;

    private float totalValue;

    private Float changePercentage;

    private LocalDateTime date;
}
