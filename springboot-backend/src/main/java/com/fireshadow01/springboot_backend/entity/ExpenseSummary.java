package com.fireshadow01.springboot_backend.entity;



import jakarta.persistence.OneToMany;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExpenseSummary {

    @Id
    private String expenseSummaryId;

    private float totalExpenses;

    private LocalDateTime date;

    @OneToMany(mappedBy = "expenseSummary")
    private List<ExpenseByCategory> expenseByCategory;
}
