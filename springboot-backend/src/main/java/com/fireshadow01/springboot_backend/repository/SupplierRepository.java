package com.fireshadow01.springboot_backend.repository;

import com.fireshadow01.springboot_backend.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
