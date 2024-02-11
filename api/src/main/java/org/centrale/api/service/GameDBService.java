package org.centrale.api.service;

import org.centrale.api.entity.GameEntity;
import org.centrale.api.repository.GameRepository;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class GameDBService {
    final DataSource dataSource;
    final GameRepository gameRepository;

    public GameDBService(DataSource dataSource, GameRepository gameRepository) {
        this.dataSource = dataSource;
        this.gameRepository = gameRepository;
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
            result.append("id : ").append(game.getId()).append(", Joueur 1 : ").append(game.getNamePlayer1()).append(", Joueur 2 : ").append(game.getNamePlayer2()).append("\n");
        }
        return result.toString();
    }


}
