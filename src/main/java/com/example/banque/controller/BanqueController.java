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

import com.example.banque.model.Banque;
import com.example.banque.repository.BanqueRepository;

@RestController
@RequestMapping("/banque")
public class BanqueController {

    private final BanqueRepository banqueRepository;

    public BanqueController(BanqueRepository banqueRepository) {
        this.banqueRepository = banqueRepository;
    }
    
    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(this.banqueRepository.findAll());
    }
    
    @PostMapping("edit" )
    public void createNewBanque() {
    	Banque banque = new Banque(toBigDecimal(1234.56), toBigDecimal(1234.56), toBigDecimal(1234.56), toBigDecimal(654.2));
    	banqueRepository.save(banque);
    }
    
    @GetMapping("edit/{id}" )
    public Banque getBanquebyId(@PathVariable int id) {
    	banqueRepository.findById(id);
    	return banqueRepository.findById(id).orElseThrow();
    }
    
    @DeleteMapping("delete/{id}" )
    public void deleteBanque(@PathVariable int id) {
    	banqueRepository.deleteById(id);
    }
    
    public BigDecimal toBigDecimal(double val) {
    	return BigDecimal.valueOf(val);
    }
}
