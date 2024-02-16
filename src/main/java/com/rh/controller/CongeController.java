package com.rh.controller;


import com.rh.entities.Conge;
import com.rh.entities.Employee;
import com.rh.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/con")

public class CongeController {

    @Autowired
    private CongeRepository congeRepository;

    @GetMapping("/conges")
    public List<Conge> getPersonnes() {
        return congeRepository.findAll();
    }
    @GetMapping("/conge/{id}")
    public Optional<Conge> getPersonne(@PathVariable int id) {
        return congeRepository.findById(id);
    }

    @PostMapping("/conge")
    public Conge SaveContact(@RequestBody Conge c) {
        c.setDateDebut(LocalDateTime.now());
        return congeRepository.save(c);
    }

    @DeleteMapping("/conge/{id}")
    public boolean Supprimer(@PathVariable int id) {
        congeRepository.deleteById(id);
        return true;
    }
    @RequestMapping(value = "/conge/{id}", method = RequestMethod.PUT)
    public Conge modifier(@PathVariable("id") int id, @RequestBody Conge c) {
    Conge conge = congeRepository.findById(id).orElse(null);
    conge.setStatus(c.getStatus());
        return congeRepository.save(conge);
    }
}
