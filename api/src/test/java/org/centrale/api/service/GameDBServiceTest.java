package org.centrale.api.service;

import org.centrale.api.entity.GameEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameDBServiceTest {

    @Autowired
    GameDBService dataService;

    @Test
    public void getGame1Entity(){
        GameEntity g = new GameEntity();
        g.setNamePlayer1("Joueur 1");
        g.setNamePlayer2("Joueur 2");

        g.setScorePlayer1(0);
        g.setScorePlayer2(1);

        dataService.saveGameEntity(g);

        assertEquals("Joueur 1", dataService.getGameEntity(1).getNamePlayer1());
        assertEquals("Joueur 2", dataService.getGameEntity(1).getNamePlayer2());
        assertEquals(0, dataService.getGameEntity(1).getScorePlayer1());
        assertEquals(1, dataService.getGameEntity(1).getScorePlayer2());
    }
}
