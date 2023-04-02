package com.company.gamestore.controller;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.service.ServiceLayer;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
// Test post and put request with this Json body
//        {
//            "name": "Customer 1",
//                "street": "100 Main Street",
//                "city": "Clovis",
//                "state": "CA",
//                "zipcode": "93612",
//                "itemType": "Game",
//                "itemId": 269,
//                "quantity": 12
//        }



    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel invoice)  {
        return  serviceLayer.saveInvoice(invoice);
    }

    private double calculateTax(String state, double subtotal) {
        double rate = 0;
        switch (state) {
            case "AL":
                rate = 0.05;
                break;
            case "AK":
                rate = 0.06;
                break;
            case "AZ":
                rate = 0.04;
                break;
            case "AR":
                rate = 0.06;
                break;
            case "CA":
                rate = 0.06;
                break;
            case "CO":
                rate = 0.04;
                break;
            case "CT":
                rate = 0.03;
                break;
            case "DE":
                rate = 0.05;
                break;
            case "FL":
                rate = 0.06;
                break;
            case "GA":
                rate = 0.07;
                break;
            case "HI":
                rate = 0.05;
                break;
            case "ID":
                rate = 0.03;
                break;
            case "IL":
                rate = 0.05;
                break;
            case "IN":
                rate = 0.05;
                break;
            case "IA":
                rate = 0.04;
                break;
            case "KS":
                rate = 0.06;
                break;
            case "KY":
                rate = 0.04;
                break;
            case "LA":
                rate = 0.05;
                break;
            case "ME":
                rate = 0.03;
                break;
            case "MD":
                rate = 0.07;
            case "MA":
                rate = 0.05;
                break;
            case "MI":
                rate = 0.06;
                break;
            case "MN":
                rate = 0.06;
                break;
            case "MS":
                rate = 0.05;
                break;
            case "MO":
                rate = 0.05;
                break;
            case "MT":
                rate = 0.03;
                break;
            case "NE":
                rate = 0.04;
                break;
            case "NV":
                rate = 0.04;
                break;
            case "NH":
                rate = 0.06;
                break;
            case "NJ":
                rate = 0.05;
                break;
            case "NM":
                rate = 0.05;
                break;
            case "NY":
                rate = 0.06;
                break;
            case "NC":
                rate = 0.05;
                break;
            case "ND":
                rate = 0.05;
                break;
            case "OH":
                rate = 0.04;
                break;
            case "OK":
                rate = 0.04;
                break;
            case "OR":
                rate = 0.07;
                break;
            case "PA":
                rate = 0.06;
                break;
            case "RI":
                rate = 0.06;
                break;
            case "SC":
                rate = 0.06;
                break;
            case "SD":
                rate = 0.06;
                break;
            case "TN":
                rate = 0.05;
                break;
            case "TX":
                rate = 0.03;
                break;
            case "UT":
                rate = 0.04;
                break;
            case "VT":
                rate = 0.07;
                break;
            case "VA":
                rate = 0.06;
                break;
            case "WA":
                rate = 0.05;
                break;
            case "WV":
                rate = 0.05;
                break;
            case "WI":
                rate = 0.03;
                break;
            case "WY":
                rate = 0.04;
                break;
            default:
                throw new IllegalArgumentException("Invalid state code: " + state);
        }
        return subtotal * rate;
    }

    private double calculateProcessingFee(int quantity) {
        return 0.0;
    }

    @GetMapping("invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id)  {
        return serviceLayer.findInvoice(id);
    }

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices()  {
        return serviceLayer.getAllInvoices();
    }

    @GetMapping("invoices/customer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoiceByCustomerName(@PathVariable String name)  {
        return serviceLayer.getAllInvoicesByCustomerName(name);
    }



}