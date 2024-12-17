package com.fireshadow01.springboot_backend.repository;

import com.fireshadow01.springboot_backend.entity.ExpenseSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseSummaryRepository extends JpaRepository<ExpenseSummary, String> {
    // You can define custom queries here, if needed
}