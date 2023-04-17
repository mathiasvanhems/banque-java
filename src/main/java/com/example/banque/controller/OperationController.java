package com.example.banque.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banque.model.Operation;
import com.example.banque.model.TypeOperation;
import com.example.banque.repository.OperationRepository;
import com.example.banque.repository.TypeOperationRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        return ResponseEntity.ok(this.operationRepository.findAllWithType());
    }
    
    @PostMapping(value="save", consumes = "application/json", produces = "application/json")
    public void updateOperation(@RequestBody Operation operation, HttpServletResponse response) {

    	//TypeOperation type = safeCast(typeOperationRepository.findById((int)3).orElseThrow(),TypeOperation.class).orElseGet(TypeOperation::new);
    	
    	//Operation operation = new Operation(toBigDecimal(1234.56),"test",new Date(),type);
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/edit/" + operation.getId()).toUriString());
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
