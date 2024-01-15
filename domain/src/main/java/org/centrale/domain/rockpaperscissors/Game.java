package org.centrale.domain.rockpaperscissors;

public class Game {

    private RockPaperScissors game = new RockPaperScissors();
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public void playNextRound(String hand1, String hand2){
        int turnResult = game.playTurn(hand1, hand2);
        if(turnResult == 1){
            this.scorePlayer1++;
        }
        else if(turnResult == -1){
            this.scorePlayer2++;
        }
    }

    public int getScore(int player){
        if(player == 1){
            return this.scorePlayer1;
        }
        else if(player == 2){
            return this.scorePlayer2;
        }
        else {
            throw new RuntimeException("Ce joueur n'existe pas !");
        }
    }
}
