package com.fireshadow01.springboot_backend.repository;

import com.fireshadow01.springboot_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
