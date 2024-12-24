package com.fireshadow01.springboot_backend.service;

import com.fireshadow01.springboot_backend.dto.request.ProductRequestDTO;
import com.fireshadow01.springboot_backend.dto.response.ProductResponseDTO;
import com.fireshadow01.springboot_backend.entity.Product;
import com.fireshadow01.springboot_backend.exceptions.ProductAlreadyExistsException;
import com.fireshadow01.springboot_backend.exceptions.ResourceNotFoundException;
import com.fireshadow01.springboot_backend.repository.ProductRepository;
import com.fireshadow01.springboot_backend.repository.searchCriteria.ProductSpecification;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {

        Optional<Product> existingProduct = productRepository.findByName(requestDTO.getName());
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExistsException("Product with the same name already exists.");
        }

        Product product = new Product();
        BeanUtils.copyProperties(requestDTO, product);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return mapToResponseDTO(savedProduct);
    }

    public Page<ProductResponseDTO> getAllProducts(String status, String category, Boolean favourite, Pageable pageable) {
        Specification<Product> spec = Specification.where(ProductSpecification.hasStatus(status))
                .and(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.isFavourite(favourite));

        Page<Product> products = productRepository.findAll(spec,pageable);
        return products.map(this::mapToResponseDTO);
    }


    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return mapToResponseDTO(product);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {
        // Fetch the product to be updated
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Check for duplicates with the same name
        Optional<Product> duplicateProduct = productRepository.findByName(requestDTO.getName());
        if (duplicateProduct.isPresent() && !duplicateProduct.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException("Another product with the same name already exists.");
        }

        // Update the product details
        BeanUtils.copyProperties(requestDTO, product, "id", "createdAt");
        product.setUpdatedAt(LocalDateTime.now());
        Product updatedProduct = productRepository.save(product);

        return mapToResponseDTO(updatedProduct);
    }


    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setStatus("Inactive");
        product.setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    public ProductResponseDTO toggleFavourite(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setFavourite(!product.getFavourite());
        product.setUpdatedAt(LocalDateTime.now());
        Product updatedProduct = productRepository.save(product);
        return mapToResponseDTO(updatedProduct);
    }

    private ProductResponseDTO mapToResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        BeanUtils.copyProperties(product, responseDTO);
        return responseDTO;
    }
}

