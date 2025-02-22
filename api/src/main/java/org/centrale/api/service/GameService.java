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
        this.game = new Game();
    }

    public Game game;

    private String player1 = "";
    private String player2 = "";

    public void addPlayer(String name){
        if(player1.isEmpty()){
            player1 = name;
        } else if(player2.isEmpty()){
            player2 = name;
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il y a déjà deux joueurs dans cette partie !");
        }
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

    public Integer getWinner(){
        GameEntity gameEntity = new GameEntity();
        gameEntity.setNamePlayer1(player1);
        gameEntity.setNamePlayer2(player2);
        gameEntity.setScorePlayer1(game.getScore(1));
        gameEntity.setScorePlayer2(game.getScore(2));
        gameRepository.save(gameEntity);
        if (game.getScore(1) > game.getScore(2)){
            return 1;
        }
        else if (game.getScore(1) < game.getScore(2)){
            return 2;
        }
        else {
            return 0;
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
        // Check if there are two players
        if (!player1.isEmpty() && !player2.isEmpty()) {
            game.playNextRound(hand1, hand2);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Il n'y a pas deux joueurs !");
        }
    }

    public void play(String handPlayer1, String handPlayer2){
        this.playTurn(handPlayer1, handPlayer2);
    }


}
