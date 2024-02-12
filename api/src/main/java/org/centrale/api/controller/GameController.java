package org.centrale.api.controller;

import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.repository.GameRepository;
import org.centrale.api.service.GameDBService;
import org.centrale.api.service.GameService;
import org.centrale.api.service.PlayerDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class GameController {

    final PlayerDBService playerDBService;
    final GameDBService gameDBService;
    final DataSource dataSource;
    final GameRepository gameRepository;
    GameService gameService;

    public GameController(GameService gameService, PlayerDBService playerDBService, GameDBService gameDBService, DataSource dataSource, GameRepository gameRepository){
        this.gameService = gameService;
        this.playerDBService = playerDBService;
        this.gameDBService = gameDBService;
        this.dataSource = dataSource;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/")
    public String gameHome(){
        return "Bienvenue dans le game !";
    }

    // POST /play?player1Id=ID1&player2Id=ID2&handPlayer1=HAND1&handPlayer2=HAND2 (le résultat devra etre persisté)
    @PostMapping("/play")
    public String gameTurn(@RequestParam Long player1Id, @RequestParam Long player2Id, @RequestParam String handPlayer1, @RequestParam String handPlayer2){
        PlayerEntity p1 = playerDBService.getPlayerEntity(player1Id);
        PlayerEntity p2 = playerDBService.getPlayerEntity(player2Id);

        GameService gameService = new GameService(dataSource, gameRepository);

        gameService.addPlayer(p1.getName());
        gameService.addPlayer(p2.getName());

        gameService.play(handPlayer1, handPlayer2);

        Integer winner = gameService.getWinner();

        System.out.println(gameDBService.getGamesList());

        if (winner == 1){
            return "Le joueur " + p1.getName() + " a gagné !";
        }
        else if (winner == 2){
            return "Le joueur " + p2.getName() + " a gagné !";
        }
        else {
            return "Match nul !";
        }
    }

    // get games
    @GetMapping("/games")
    public String getGames(){
        return gameDBService.getGamesList();
    }

    // GET /game-stats?playerId1=ID1 (donne les statistiques de jeu (parties gagnées, perdues, pire player ennemi))
    @GetMapping("/game-stats")
    public String gameStats(@RequestParam Long playerId1) {
        String message = gameDBService.getGameStats(playerId1);
        return message;
    }


}
