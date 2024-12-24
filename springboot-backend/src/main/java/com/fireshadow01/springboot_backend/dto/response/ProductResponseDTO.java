package com.fireshadow01.springboot_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// ProductResponseDTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String photoUrl;
    private String status;
    private Boolean favourite;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
