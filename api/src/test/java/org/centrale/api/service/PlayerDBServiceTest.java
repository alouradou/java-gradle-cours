package org.centrale.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.centrale.api.entity.PlayerEntity;
import org.centrale.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerDBServiceTest {

    @Autowired
    PlayerDBService dataService;

    @Test
    public void getPlayer1(){
        Player p = dataService.getPlayerById(1L);
        assertEquals(1, p.getId());
        assertEquals("Player1", p.getName());
    }

    @Test
    public void getPlayer1Entity(){
        PlayerEntity p = dataService.getPlayerEntity(1);
        assertEquals(1, p.getId());
        assertEquals("Player1", p.getName());
    }
}
