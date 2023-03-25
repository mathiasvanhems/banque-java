package com.example.banque.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @GetMapping("get/{annee}" )
    public List<Historique> getAllMontantFromYear(@PathVariable String annee) throws ParseException {
        Date debut=new SimpleDateFormat("yyyy-MM-dd").parse(annee.concat("-01-01"));
        Date fin=new SimpleDateFormat("yyyy-MM-dd").parse(annee.concat("-12-31"));
        return historiqueRepository.findByAnnee(debut,fin);
    }
    
    @DeleteMapping("delete/{id}" )
    public void deleteHistorique(@PathVariable int id) {
    	historiqueRepository.deleteById(id);
    }
    
    public BigDecimal toBigDecimal(double val) {
    	return BigDecimal.valueOf(val);
    }
}
