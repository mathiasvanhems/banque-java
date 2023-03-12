package com.example.banque.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.repository.TypeOperationRepository;

@RestController
@RequestMapping("/type")
public class TypeOperationController {

    private final TypeOperationRepository typeOperationRepository;

    public TypeOperationController(TypeOperationRepository typeOperationRepository) {
        this.typeOperationRepository = typeOperationRepository;
    }
    
    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(this.typeOperationRepository.findAll());
    }
}
