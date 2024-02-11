package org.centrale.api.controller;

import org.centrale.api.service.GameService;
import org.centrale.api.service.PlayerDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    GameService gameService;
    final PlayerDBService playerDBService;

    public GameController(GameService gameService, PlayerDBService playerDBService){
        this.gameService = gameService;
        this.playerDBService = playerDBService;
    }

    @GetMapping("/")
    public String gameHome(){
        return "Bienvenue dans le game !";
    }


    @PostMapping("/player-play")
    public String gameNewPlayer(@RequestParam String name){
        this.gameService.addPlayer(name);
        playerDBService.addNewPlayer(name);
        return "Nouveau joueur " + name + " créé !\n" +
                "La liste des joueurs est : " + this.gameService.getPlayers();
    }

    // POST /play?player1Id=ID1&player2Id=ID2&handPlayer1=HAND1&handPlayer2=HAND2 (le résultat devra etre persisté)
    @PostMapping("/play")
    public String gameTurn(@RequestParam Long player1Id, @RequestParam Long player2Id, @RequestParam String handPlayer1, @RequestParam String handPlayer2){
        this.gameService.addPlayer(playerDBService.getPlayerEntity(player1Id).getName());
        this.gameService.addPlayer(playerDBService.getPlayerEntity(player2Id).getName());
        this.gameService.play(player1Id, player2Id, handPlayer1, handPlayer2);
        return "Le score est : " + this.gameService.getScore(1) + " - " + this.gameService.getScore(2);
    }


}
