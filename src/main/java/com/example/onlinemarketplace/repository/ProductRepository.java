package com.example.onlinemarketplace.repository;

import com.example.onlinemarketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
