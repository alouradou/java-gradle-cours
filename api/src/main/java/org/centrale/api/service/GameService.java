package org.centrale.api.service;

import org.centrale.domain.rockpaperscissors.Game;
import org.centrale.domain.rockpaperscissors.RockPaperScissors;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.util.NoSuchElementException;

@Component
public class GameService {

    DataSource dataSource;

    public GameService(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Game game = new Game();

    private String player1 = "";
    private String player2 = "";

    public void addPlayer(String name){
        Integer id = 5;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO players values (?,?)", id, name);

        if(player1.equals("")){
            player1 = name;
        } else if(player2.equals("")){
            player2 = name;
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il y a déjà deux joueurs !");
        }
    }

    public String getPlayers() {
        return player1 + ", " + player2;
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
        if (!player1.equals("") && !player2.equals("")) {
            game.playNextRound(hand1, hand2);
            System.out.println("Le score est : " + game.getScore(1) + " - " + game.getScore(2));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Il n'y a pas deux joueurs !");
        }
    }


}
