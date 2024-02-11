package org.centrale.api.service;

import org.centrale.api.entity.GameEntity;
import org.centrale.api.repository.GameRepository;
import org.centrale.domain.rockpaperscissors.Game;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;

@Component
public class GameService {

    DataSource dataSource;
    GameRepository gameRepository;

    public GameService(DataSource dataSource, GameRepository gameRepository){
        this.dataSource = dataSource;
        this.gameRepository = gameRepository;
    }

    public Game game = new Game();

    private String player1 = "";
    private String player2 = "";

    public void addPlayer(String name){
        GameEntity game = new GameEntity();

        if(player1.equals("")){
            player1 = name;
            game.setNamePlayer1(name);
        } else if(player2.equals("")){
            player2 = name;
            game.setNamePlayer2(name);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il y a déjà deux joueurs dans cette partie !");
        }

        this.gameRepository.save(game);
    }

    public String getPlayers() {
        return player1 + ", " + player2;
    }

    public Integer getScore(Integer player) {
        if(player == 1){
            return game.getScore(1);
        }
        else if(player == 2){
            return game.getScore(2);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ce joueur n'existe pas !");
        }
    }

    public void removePlayer(String name){
        if(player1.equals(name)){
            player1 = "";
        } else if(player2.equals(name)){
            player2 = "";
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ce joueur n'existe pas !");
        }
    }

    public void removePlayer(int id){
        if(id == 1){
            player1 = "";
        } else if(id == 2){
            player2 = "";
        }
        else {
            throw new RuntimeException("Ce joueur n'existe pas !");
        }
    }

    public void playTurn(String hand1, String hand2){
        GameEntity gameEntity = new GameEntity();

        // Check if there are two players
        if (!player1.isEmpty() && !player2.isEmpty()) {
            game.playNextRound(hand1, hand2);
            System.out.println(game.getScore(1));
            System.out.println(game.getScore(2));
            gameEntity.setScorePlayer1(game.getScore(1));
            gameEntity.setScorePalyer2(game.getScore(2));
            System.out.println("Le score est : " + game.getScore(1) + " - " + game.getScore(2));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Il n'y a pas deux joueurs !");
        }
        gameRepository.save(gameEntity);
    }

    public void play(Long player1Id, Long player2Id, String handPlayer1, String handPlayer2){
        this.playTurn(handPlayer1, handPlayer2);
    }


}
