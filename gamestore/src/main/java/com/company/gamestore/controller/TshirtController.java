package com.company.gamestore.controller;

import com.company.gamestore.model.Tshirt;
import com.company.gamestore.repository.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class TshirtController {

    @Autowired
    TshirtRepository repo;

    // Create a Tshirt
    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt createNewTshirt(@RequestBody Tshirt tshirt){
        return repo.save(tshirt);
    }

    // Get a Tshirt by ID
    @GetMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int id){
        Optional<Tshirt> value = repo.findById(id);
        if(value.isPresent()){
            return value.get();
        } else{
            return null;
        }
    }

    // Get all Tshirts
    @GetMapping("/tshirts")
    public List<Tshirt> getAllTshirts() {
        return repo.findAll();
    }


    // Update a Tshirt
    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingTshirt(@RequestBody Tshirt tshirt) {
        repo.save(tshirt);
    }

    // Delete a Tshirt
    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Search for Tshirts by color
    @GetMapping("/tshirts/{color}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Tshirt > GetTshirtsByColor(@PathVariable String color){
        Set<Tshirt> tshirtList= new HashSet<>();
        for (Tshirt t: repo.findAll()) {
            if (t.getColor() == color) {
                tshirtList.add(t);
            }
        }
        return tshirtList;
    }

    // Search for Tshirts by size
    @GetMapping("/tshirts/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Tshirt > GetTshirtsBySize(@PathVariable String size){
        Set<Tshirt> tshirtList= new HashSet<>();
        for (Tshirt t: repo.findAll()) {
            if (t.getSize() == size) {
                tshirtList.add(t);
            }
        }
        return tshirtList;
    }
}
