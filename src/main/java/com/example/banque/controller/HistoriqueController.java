package com.example.banque.controller;

import java.math.BigDecimal;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banque.model.Historique;
import com.example.banque.repository.HistoriqueRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


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
    
    @PostMapping(value="save", consumes = "application/json", produces = "application/json")
    public void updateHistorique(@RequestBody Historique historique, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/edit/" + historique.getId()).toUriString());
    	historiqueRepository.save(historique);
    }
    
    @GetMapping("edit/{id}" )
    public Historique getHistoriquebyId(@PathVariable int id) {
    	return historiqueRepository.findById(id).orElseThrow();
    }

    @GetMapping("getMontant/{annee}" )
    public Historique getAllMontantFromYear(@PathVariable int annee) {
        return historiqueRepository.findById(annee).orElseThrow();
    }
    
    @DeleteMapping("delete/{id}" )
    public void deleteHistorique(@PathVariable int id) {
    	historiqueRepository.deleteById(id);
    }
    
    public BigDecimal toBigDecimal(double val) {
    	return BigDecimal.valueOf(val);
    }
}
