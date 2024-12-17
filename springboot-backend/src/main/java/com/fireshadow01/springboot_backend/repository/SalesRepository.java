package com.fireshadow01.springboot_backend.repository;

import com.fireshadow01.springboot_backend.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {
    // You can define custom queries here, if needed
}