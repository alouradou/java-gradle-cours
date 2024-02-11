package org.centrale.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.centrale.api.entity.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerDBServiceTest {

    @Autowired
    PlayerDBService dataService;

    @Test
    public void getPlayer1Entity(){
        PlayerEntity p = dataService.getPlayerEntity(1L);
        assertEquals(1, p.getId());
        assertEquals("Player1", p.getName());
    }
}
