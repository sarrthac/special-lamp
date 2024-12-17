package com.fireshadow01.springboot_backend.entity;


import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExpenseByCategory {

    @Id
    private String expenseByCategoryId;

    private String expenseSummaryId;

    private String category;

    private Long amount;

    private LocalDateTime date;

    @ManyToOne
    private ExpenseSummary expenseSummary;
}
