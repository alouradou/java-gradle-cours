package org.centrale.api.controller;

import org.centrale.api.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String gameHome(){
        return "Bienvenue dans le game !";
    }

    @GetMapping("/player")
    public String gameUsage(){
        return "Usage : POST /game/player?name=<name> ou /game/player/remove?id=<id>";
    }

    @GetMapping("/player/list")
    public String gameList(){
        return "La liste des joueurs est : " + this.gameService.getPlayers();
    }

    @PostMapping("/player")
    public String gameNewPlayer(@RequestParam String name){
        this.gameService.addPlayer(name);
        return "Nouveau joueur " + name + " créé !\n" +
                "La liste des joueurs est : " + this.gameService.getPlayers();
    }

    @PostMapping("/player/remove")
    public String gameRemovePlayer(@RequestParam String name) {
        if(name.equals("1") || name.equals("2")){
            this.gameService.removePlayer(Integer.parseInt(name));
        }
        else {
            this.gameService.removePlayer(name);
        }
        return "Joueur supprimé !";
    }

    @PostMapping("/play")
    public String gameTurn(@RequestParam String hand1, @RequestParam String hand2){
        this.gameService.playTurn(hand1, hand2);
        System.out.println(this.gameService.getScore(1));
        return "Le score est : " + this.gameService.getScore(1) + " - " + this.gameService.getScore(2);
    }

}
