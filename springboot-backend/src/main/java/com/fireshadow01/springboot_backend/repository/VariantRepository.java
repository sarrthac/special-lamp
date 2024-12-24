package com.fireshadow01.springboot_backend.repository;

import com.fireshadow01.springboot_backend.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, Long> {
}
