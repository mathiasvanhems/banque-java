package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Historique;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Integer> {

    @Query(value="SELECT h FROM Historique h WHERE h.periode >= ?1 and h.periode <= ?2 ")
    List<Historique> findByAnnee(Date debut, Date fin);

}
