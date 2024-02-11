package org.centrale.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.centrale.api.entity.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameServiceTests {

    @Autowired
    GameService gameService;
    @Autowired
    PlayerDBService dataService;

    @Test
    public void testGameService(){
        PlayerEntity p1 = dataService.getPlayerEntity(1L);
        PlayerEntity p2 = dataService.getPlayerEntity(2L);

        gameService.addPlayer(p1.getName());
        gameService.addPlayer(p2.getName());

        gameService.play("paper", "rock");
        assertEquals(1, this.gameService.getScore(1));
    }

}
