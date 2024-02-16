package com.rh.controller;


import com.rh.entities.Employee;
import com.rh.entities.Stagiaire;
import com.rh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getPersonnes() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getPersonne(@PathVariable int id) {
        return employeeRepository.findById(id);
    }

    @PostMapping("/employee")
    public Employee SaveContact(@RequestBody Employee c) {
        c.setDateDeb(LocalDateTime.now());
        return employeeRepository.save(c);
    }

    @DeleteMapping("/employee/{id}")
    public boolean Supprimer(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @PutMapping("/employee/{id}")
    public Employee modifier(@PathVariable("id") int id, @RequestBody Employee c) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        employee.setService(c.getService());
        return employeeRepository.save(employee);
    }
}
