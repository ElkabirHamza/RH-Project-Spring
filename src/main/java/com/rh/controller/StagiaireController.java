package com.rh.controller;


import com.rh.entities.Stagiaire;
import com.rh.repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stg")

public class StagiaireController {
    @Autowired
    private StagiaireRepository stagiaireRespository;

    @GetMapping("/stagiaires")
    public List<Stagiaire> getPersonnes() {
        return stagiaireRespository.findAll();
    }
    @GetMapping("/stagiaire/{id}")
    public Optional<Stagiaire> getPersonne(@PathVariable int id) {
        return stagiaireRespository.findById(id);
    }
    @PostMapping("/stagiaire")
    public Stagiaire SaveContact(@RequestBody Stagiaire c) {
        return stagiaireRespository.save(c);
    }
    @DeleteMapping("/stagiaire/{id}")
    public boolean Supprimer(@PathVariable int id) {
        stagiaireRespository.deleteById(id);
        return true;
    }
    @RequestMapping(value = "/stagiaire/{id}", method = RequestMethod.PUT)
    public Stagiaire modifier(@PathVariable("id") int id,@RequestBody Stagiaire c) {
        Stagiaire stagiaire = stagiaireRespository.findById(id).orElse(null);
        stagiaire.setDepartement(c.getDepartement());
        return stagiaireRespository.save(stagiaire);
    }
}
