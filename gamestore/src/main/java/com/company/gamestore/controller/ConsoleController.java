package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ConsoleController {

    @Autowired
    ConsoleRepository repo;

    // Create a console
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createNewConsole(@RequestBody Console console){
        return repo.save(console);
    }

    // Get a Console by ID
    @GetMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsole(@PathVariable int id){
        Optional<Console> value = repo.findById(id);
        if(value.isPresent()){
            return value.get();
        } else{
            return null;
        }
    }

    // Get all consoles
    @GetMapping("/consoles")
    public List<Console> getAllConsoles() {
        return repo.findAll();
    }


    // Update a console
    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingConsole(@RequestBody Console console) {
        repo.save(console);
    }

    // Delete a console
    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Get consoles by manufacturer
    @GetMapping("/consoles/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Console> getConsolesId(@PathVariable String manufacturer){
        Set<Console> consolesList= new HashSet<>();
        for (Console c: repo.findAll()) {
            if (c.getManufacturer() == manufacturer) {
                consolesList.add(c);
            }
        }
        return consolesList;
    }





















}
