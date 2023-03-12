package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.TypeOperation;

@Repository
public interface TypeOperationRepository extends JpaRepository<TypeOperation, Integer> {
}
