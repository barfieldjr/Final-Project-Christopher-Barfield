package com.company.gamestore.service;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.Tshirt;
import com.company.gamestore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;

    private FeeRepository feeRepository;

    private GameRepository gameRepository;

    private InvoiceRepository invoiceRepository;

    private TaxRepository taxRepository;

    private TshirtRepository tShirtRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, FeeRepository feeRepository, GameRepository gameRepository, InvoiceRepository invoiceRepository, TaxRepository taxRepository, TshirtRepository tShirtRepository) {
        this.consoleRepository = consoleRepository;
        this.feeRepository = feeRepository;
        this.gameRepository = gameRepository;
        this.invoiceRepository = invoiceRepository;
        this.taxRepository = taxRepository;
        this.tShirtRepository = tShirtRepository;
    }

    //
    // CONSOLE API
    //

    public Console saveConsole(Console console){

        return consoleRepository.save(console);
    }

    public Console findConsole(int id){
        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? console.get() : null;
    }

    public List<Console> getAllConsoles(){
        return consoleRepository.findAll();
    }

    public void updateConsole(Console console){
        consoleRepository.save(console);
    }

    public void deleteConsole(int id){
        consoleRepository.deleteById(id);
    }

    public List<Console> getAllConsolesByManufacturer(String manufacturer){
        return consoleRepository.findAllByManufacturer(manufacturer);
    }



    //
    // GAME API
    //


    public Game saveGame(Game game){

        return gameRepository.save(game);
    }

    public Game findGame(int id){
        Optional<Game> game = gameRepository.findById(id);

        return game.isPresent() ? game.get() : null;
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public void updateGame(Game game){
        gameRepository.save(game);
    }

    public void deleteGame(int id){
        gameRepository.deleteById(id);
    }

    public List<Game> getAllGamesByStudio(String studio){
        return gameRepository.findAllByStudio(studio);
    }

    public List<Game> getAllGamesByESRB(String esrb){
        return gameRepository.findAllByEsrbRating(esrb);
    }

    public List<Game> getAllGamesByTitle(String title){
        return gameRepository.findAllByTitle(title);
    }


    //
    // INVOICE API
    //



    public Invoice saveInvoice(Invoice invoice){

//        LOGIC EXAMPLE:
//        if (value2 == 0) {
//            throw new IllegalArgumentException("Cannot divide by zero!");
//        }
//
//        return (double)value1 / value2;





        return invoiceRepository.save(invoice);
    }

    public Invoice findInvoice(int id){
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? invoice.get() : null;
    }

    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    public List<Invoice> getAllInvoicesByCustomerName(String name){
        return invoiceRepository.findByName(name);
    }

    //
    // TSHIRT API
    //

    public Tshirt saveTshirt(Tshirt tshirt){

        return tShirtRepository.save(tshirt);
    }

    public Tshirt findTshirt(int id){
        Optional<Tshirt> tshirt = tShirtRepository.findById(id);

        return tshirt.isPresent() ? tshirt.get() : null;
    }

    public List<Tshirt> getAllTshirts(){
        return tShirtRepository.findAll();
    }

    public void updateTshirt(Tshirt tshirt){
        tShirtRepository.save(tshirt);
    }

    public void deleteTshirt(int id){
        tShirtRepository.deleteById(id);
    }

    public List<Tshirt> getAllTshirtsByColor(String color){
        return tShirtRepository.findAllByColor(color);
    }

    public List<Tshirt> getAllTshirtBySize(String size){
        return tShirtRepository.findAllBySize(size);
    }

































}
