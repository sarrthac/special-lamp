package com.fireshadow01.springboot_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariantRequestDTO {
    private Long productId;
    private Integer measurementValue;
    private String measurementUnit;
    private BigDecimal price;
    private String status;
}
