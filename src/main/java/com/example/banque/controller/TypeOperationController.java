package com.example.banque.controller;

import java.math.BigDecimal;
import java.util.Optional;

import com.example.banque.model.Banque;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banque.model.TypeOperation;
import com.example.banque.repository.TypeOperationRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/type")
public class TypeOperationController {

    private final TypeOperationRepository typeOperationRepository;

    public TypeOperationController(TypeOperationRepository typeOperationRepository) {
        this.typeOperationRepository = typeOperationRepository;
    }
    
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.typeOperationRepository.findAllOrder());
    }
    
    @PostMapping(value="save", consumes = "application/json", produces = "application/json")
    public void updateTypeOperation(@RequestBody TypeOperation type, HttpServletResponse response) {
    	//TypeOperation type = new TypeOperation("test","NA",true);
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/edit/" + type.getId()).toUriString());
    	typeOperationRepository.save(type);
    }

    @GetMapping("edit/{id}" )
    public TypeOperation getTypeOperationById(@PathVariable int id) {
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
