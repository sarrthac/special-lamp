package com.fireshadow01.springboot_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public String healthCheck()
    {
        return "Application is Running : Status OK";
    }
}
