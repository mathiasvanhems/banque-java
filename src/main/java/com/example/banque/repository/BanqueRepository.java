package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Banque;

@Repository
public interface BanqueRepository extends JpaRepository<Banque, Integer> {
}
