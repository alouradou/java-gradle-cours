package org.centrale.domain.rockpaperscissors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPierreFeuilleCiseaux {

    @Test 
    public void jeuEgalite(){
        Hand p = new Pierre();
        Hand f = new Feuille();
        Hand c = new Ciseaux();
        Assertions.assertEquals(p.playWith(new Pierre()), 0);
        Assertions.assertEquals(f.playWith(new Feuille()), 0);
        Assertions.assertEquals(c.playWith(new Ciseaux()), 0);
    }

    @Test
    public void gameImplementation(){
        RockPaperScissors game = new RockPaperScissors();
        Assertions.assertEquals(game.playTurn("rock", "rock"), 0);
        Assertions.assertEquals(game.playTurn("rock", "paper"), -1);
        Assertions.assertEquals(game.playTurn("rock", "scissors"), 1);
        Assertions.assertEquals(game.playTurn("paper", "rock"), 1);
        Assertions.assertEquals(game.playTurn("paper", "paper"), 0);
        Assertions.assertEquals(game.playTurn("paper", "scissors"), -1);
        Assertions.assertEquals(game.playTurn("scissors", "rock"), -1);
        Assertions.assertEquals(game.playTurn("scissors", "paper"), 1);
        Assertions.assertEquals(game.playTurn("scissors", "scissors"), 0);
    }

    @Test
    public void gameTimeline(){
        Game game = new Game();
        game.playNextRound("rock", "rock");
        Assertions.assertEquals(game.getScore(1), 0);
    }

}
