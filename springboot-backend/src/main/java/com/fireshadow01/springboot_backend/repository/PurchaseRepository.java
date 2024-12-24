package com.fireshadow01.springboot_backend.repository;

import com.fireshadow01.springboot_backend.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
