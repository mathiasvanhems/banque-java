package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
