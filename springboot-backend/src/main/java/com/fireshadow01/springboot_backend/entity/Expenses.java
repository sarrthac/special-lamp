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
public class Expenses {

    @Id
    private String expenseId;

    private String category;

    private float amount;

    private LocalDateTime timestamp;
}
