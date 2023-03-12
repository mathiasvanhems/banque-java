package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
}
