package com.company.gamestore.controller;

import com.company.gamestore.model.Fee;
import com.company.gamestore.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeRepository feeRepository;

    @GetMapping("")
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }

    @GetMapping("/{productType}")
    public Fee getFeeByProductType(@PathVariable String productType) {
        return feeRepository.findById(productType).orElse(null);
    }

    @PostMapping("")
    public Fee addFee(@RequestBody Fee fee) {
        return feeRepository.save(fee);
    }

    @PutMapping("/{productType}")
    public Fee updateFee(@PathVariable String productType, @RequestBody Fee fee) {
        if (feeRepository.existsById(productType)) {
            fee.setProductType(productType);
            return feeRepository.save(fee);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{productType}")
    public void deleteFee(@PathVariable String productType) {
        feeRepository.deleteById(productType);
    }

}

