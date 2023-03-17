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

import com.example.banque.model.Historique;
import com.example.banque.repository.HistoriqueRepository;



@RestController
@RequestMapping("/historique")
public class HistoriqueController {

    private final HistoriqueRepository historiqueRepository;

    public HistoriqueController(HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }
    
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.historiqueRepository.findAll());
    }
    
    @PostMapping("edit" )
    public void createNewHistorique() {
    	Historique historique = new Historique(toBigDecimal(1234.56),new Date());
    	historiqueRepository.save(historique);
    }
    
    @GetMapping("edit/{id}" )
    public Historique getHistoriquebyId(@PathVariable int id) {
    	return historiqueRepository.findById(id).orElseThrow();
    }
    
    @DeleteMapping("delete/{id}" )
    public void deleteHistorique(@PathVariable int id) {
    	historiqueRepository.deleteById(id);
    }
    
    public BigDecimal toBigDecimal(double val) {
    	return BigDecimal.valueOf(val);
    }
}
