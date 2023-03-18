package com.example.banque.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.banqueRepository.findAll());
    }
    
    @PostMapping("edit" )
    public void createNewBanque() {
    	Banque banque = new Banque(toBigDecimal(1234.56), toBigDecimal(1234.56), toBigDecimal(1234.56), toBigDecimal(654.2));
    	banqueRepository.save(banque);
    }
    
    @GetMapping("edit/{id}" )
    public Banque getBanquebyId(@PathVariable int id) {
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
