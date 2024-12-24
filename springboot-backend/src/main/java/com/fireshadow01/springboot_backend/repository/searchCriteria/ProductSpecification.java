package com.fireshadow01.springboot_backend.repository.searchCriteria;

import com.fireshadow01.springboot_backend.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
                status != null ? criteriaBuilder.equal(root.get("status"), status) : null;
    }

    public static Specification<Product> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                category != null ? criteriaBuilder.equal(root.get("category"), category) : null;
    }

    public static Specification<Product> isFavourite(Boolean favourite) {
        return (root, query, criteriaBuilder) ->
                favourite != null ? criteriaBuilder.equal(root.get("favourite"), favourite) : null;
    }
}
