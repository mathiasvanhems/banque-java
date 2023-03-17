package com.example.banque.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.model.Operation;
import com.example.banque.model.TypeOperation;
import com.example.banque.repository.OperationRepository;
import com.example.banque.repository.TypeOperationRepository;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private final OperationRepository operationRepository;
    private final TypeOperationRepository typeOperationRepository;

    public OperationController(OperationRepository operationRepository,TypeOperationRepository typeOperationRepository) {
        this.operationRepository = operationRepository;
        this.typeOperationRepository = typeOperationRepository;
    }
    
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.operationRepository.findAll());
    }
    
    @PostMapping("edit" )
    public void createNewOperation() {

    	TypeOperation type = safeCast(typeOperationRepository.findById((int)3).orElseThrow(),TypeOperation.class).orElseGet(TypeOperation::new);
    	
    	Operation operation = new Operation(toBigDecimal(1234.56),"test",new Date(),type);
    	operationRepository.save(operation);
    }

    @GetMapping("edit/{id}" )
    public Operation getOperationbyId(@PathVariable int id) {
    	return operationRepository.findById(id).orElseThrow();
    }
    
    @DeleteMapping("delete/{id}" )
    public void deleteOperation(@PathVariable int id) {
    	operationRepository.deleteById(id);
    }
    
    public BigDecimal toBigDecimal(double val) {
    	return BigDecimal.valueOf(val);
    }
    
    public static <S, T> Optional<T> safeCast(S candidate, Class<T> targetClass) {
 	   return targetClass.isInstance(candidate)
 	       ? Optional.of(targetClass.cast(candidate))
 	       : Optional.empty();
 	}
}
