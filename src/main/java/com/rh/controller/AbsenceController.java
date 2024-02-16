package com.rh.controller;

import com.rh.entities.Absence;
import com.rh.entities.Employee;
import com.rh.repository.AbsenceRepository;
import com.rh.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/abs")

public class AbsenceController {
   @Autowired
   private AbsenceRepository absenceRepository;
   @Autowired
   private CongeRepository congeRepository;

    @GetMapping("/absences")
    public List<Absence> getPersonnes() {
        return absenceRepository.findAll();
    }

    @GetMapping("/absence/{id}")
    public Optional<Absence> getPersonne(@PathVariable int id) {
        return absenceRepository.findById(id);
    }

    @PostMapping("/absence")
    public Absence SaveContact(@RequestBody Absence c) {
        return absenceRepository.save(c);
    }

    @DeleteMapping("/absence/{id}")
    public boolean Supprimer(@PathVariable int id) {
        absenceRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/absence/{id}", method = RequestMethod.PUT)
    public Absence modifier(@PathVariable int id, @RequestBody Absence c) {

        return absenceRepository.save(c);
    }

}
