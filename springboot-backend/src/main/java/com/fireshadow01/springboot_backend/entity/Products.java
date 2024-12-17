package com.fireshadow01.springboot_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Products {

    @Id
    private String productId;

    private String name;

    private float price;

    private Float rating;

    private Integer stockQuantity;

    @OneToMany(mappedBy = "products")
    private List<Sales> sales;

    @OneToMany(mappedBy = "products")
    private List<Purchases> purchases;
}
