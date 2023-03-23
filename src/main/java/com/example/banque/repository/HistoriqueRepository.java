package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Historique;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Integer> {



}
