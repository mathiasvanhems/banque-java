package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.banque.model.TypeOperation;


import java.util.List;

@Repository
public interface TypeOperationRepository extends JpaRepository<TypeOperation, Integer> {

    @Query(value="SELECT t FROM TypeOperation t order by t.sortie asc, t.recurrence asc, t.libelle asc")
    List<TypeOperation> findAllOrder();
}
