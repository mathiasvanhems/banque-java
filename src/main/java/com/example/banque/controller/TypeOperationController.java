package com.example.banque.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.model.TypeOperation;
import com.example.banque.repository.TypeOperationRepository;

@RestController
@RequestMapping("/type")
public class TypeOperationController {

    private final TypeOperationRepository typeOperationRepository;

    public TypeOperationController(TypeOperationRepository typeOperationRepository) {
        this.typeOperationRepository = typeOperationRepository;
    }
    
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.typeOperationRepository.findAll());
    }
    
    @PostMapping("edit" )
    public void createNewTypeOperation() {
    	TypeOperation type = new TypeOperation("test","NA",true);
    	typeOperationRepository.save(type);
    }
    
    @GetMapping("edit/{id}" )
    public TypeOperation getTypeOperationbyId(@PathVariable int id) {
    	return typeOperationRepository.findById(id).orElseThrow();
    }
    
    @DeleteMapping("delete/{id}" )
    public void deleteTypeOperation(@PathVariable int id) {
    	typeOperationRepository.deleteById(id);
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
