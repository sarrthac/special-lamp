package com.fireshadow01.springboot_backend.repository;
import com.fireshadow01.springboot_backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

    }

