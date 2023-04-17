package com.example.banque.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Operation;


import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

    @Query(value="SELECT o FROM Operation o order by o.dateOperation desc, o.type.sortie ASC, o.montant desc ")
    List<Operation> findAllWithType();
}
