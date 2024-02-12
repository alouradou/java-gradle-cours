package org.centrale.api.service;

import org.centrale.api.entity.GameEntity;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.repository.GameRepository;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class GameDBService {
    final DataSource dataSource;
    final GameRepository gameRepository;
    final PlayerDBService playerDataSource;

    public GameDBService(DataSource dataSource, GameRepository gameRepository, PlayerDBService playerDataSource) {
        this.dataSource = dataSource;
        this.gameRepository = gameRepository;
        this.playerDataSource = playerDataSource;
    }

    // use of JPA (hibernate)
    public GameEntity getGameEntity(Integer id){
        return gameRepository.findById(id).orElseThrow();
    }

    public void saveGameEntity(GameEntity game){
        gameRepository.save(game);
    }

    public String getGamesList(){
        Iterable<GameEntity> games = gameRepository.findAll();
        StringBuilder result = new StringBuilder();
        for (GameEntity game : games) {
            result.append(game.getNamePlayer1()).append(" vs ").append(game.getNamePlayer2()).append(" : ").append(game.getScorePlayer1()).append(" - ").append(game.getScorePlayer2()).append("\n");
        }
        return result.toString();
    }

    public List<GameEntity> getPlayerGames(String playerName) {
        return gameRepository.findByNamePlayer1OrNamePlayer2(playerName, playerName);
    }

    public String getGameStats(Long playerId){
        PlayerEntity p = playerDataSource.getPlayerEntity(playerId);
        List<GameEntity> playerGames = getPlayerGames(p.getName());

        int gamesWon = 0;
        int gamesLost = 0;

        for (GameEntity game : playerGames) {
            if (game.getNamePlayer1().equals(p.getName())) {
                if (game.getScorePlayer1() > game.getScorePlayer2()) {
                    gamesWon++;
                }
                else {
                    gamesLost++;
                }
            }
            else if (game.getNamePlayer2().equals(p.getName())) {
                if (game.getScorePlayer2() > game.getScorePlayer1()) {
                    gamesWon++;
                }
                else {
                    gamesLost++;
                }
            }
        }
        return "Parties gagnées : " + gamesWon + ", Parties perdues : " + gamesLost;
    }


}
