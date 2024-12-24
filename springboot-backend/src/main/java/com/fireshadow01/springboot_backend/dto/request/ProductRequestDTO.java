package com.fireshadow01.springboot_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private String name;
    private String description;
    private String category;
    private String photoUrl;
    private String status;
    private Boolean favourite;
}