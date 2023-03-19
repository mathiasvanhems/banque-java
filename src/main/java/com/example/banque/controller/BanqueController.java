package com.example.banque.controller;

import java.math.BigDecimal;
import java.util.Optional;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banque.model.Banque;
import com.example.banque.repository.BanqueRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    /**
     * Create et Update
     * @param banque
     * @param response
     * @return
     */
    @PostMapping(value="save", consumes = "application/json", produces = "application/json")
    public Banque updateBanque(@RequestBody Banque banque, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/edit/" + banque.getId()).toUriString());
        return banqueRepository.save(banque);
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
