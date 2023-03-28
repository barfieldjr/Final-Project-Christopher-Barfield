package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class GameController {
    @Autowired
    GameRepository repo;


    // Create a new Game information
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGameInformation (@RequestBody Game game){
        return repo.save(game);
    }

    // Find a  Game  by id
    @GetMapping("/games/{id}")
    public Game findGameInfoById(@PathVariable int id){

        //Checking with optional if there is actually a game with that id
        Optional<Game> gameFromRepo = repo.findById(id);
        if (gameFromRepo.isPresent()){
            //If we find a  game with the given id
            //then return it
            return gameFromRepo.get();

        } else {
            //If we don't find any game  with that id
            //then return nothing
            return null;
        }
    }

    //Update  Game
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGameInfo(@RequestBody Game game){
        //When  updating, the user must provide the json body of the  game including its id
        // send to this path in order for JPA to update  and not add a new game info
        repo.save(game);
    }


    //Delete  Game
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameInfo(@PathVariable int  id){
        repo.deleteById(id);
    }

    //Read all Game info's
    @GetMapping("/allgameinfo")
    public List<Game> findAllGames(){
        return repo.findAll();
    }




    // Search game  by Studio
    @GetMapping("/games/Studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Game> GetGameByStudio(@PathVariable String studio){
        Set<Game> gameList = new HashSet<>();
        for (Game  g:repo.findAll()){
            if (g.getStudio() == studio){
                gameList.add(g);
            }
        }
        return gameList;
    }

    // Search game ESRB
    @GetMapping("/games/ESRB/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Game> GetGameByESRB(@PathVariable String esrb){
        Set<Game> gameList = new HashSet<>();
        for (Game  g:repo.findAll()){
            if (g.getEsrb_rating() == esrb){
                gameList.add(g);
            }
        }
        return gameList;
    }

    // Search game Title
    @GetMapping("/games/Title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Game> GetGameByTitle(@PathVariable String title){
        Set<Game> gameList = new HashSet<>();
        for (Game  g:repo.findAll()){
            if (g.getTitle() == title){
                gameList.add(g);
            }
        }
        return gameList;
    }



}
