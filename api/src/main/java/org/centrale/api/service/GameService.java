package org.centrale.api.service;

import lombok.AllArgsConstructor;
import org.centrale.api.entity.GameEntity;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {

    final GameRepository gameRepository;
    final PlayerDBService playerDBService;

    public void play(Long playerId1, Long playerId2) {

        PlayerEntity player1 = playerDBService.getPlayerEntity(playerId1);
        PlayerEntity player2 = playerDBService.getPlayerEntity(playerId2);
        PlayerEntity winner = player2;
        GameEntity game = new GameEntity();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setWinner(winner);

        gameRepository.save(game);


    }

}
