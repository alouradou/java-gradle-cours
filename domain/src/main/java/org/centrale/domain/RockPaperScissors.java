package org.centrale.domain;

import java.util.Scanner;

public class RockPaperScissors {
    public void playGame(int handPlayer1) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Saisissez le choix du joueur 1 (1 - Pierre, 2 - Feuille, 3 - Ciseau): ");

        System.out.println("Vous avez choisi " + this.convertIntToEnglish(handPlayer1) + "\n");

        int handPlayer2 = (int)(Math.random() * 3) + 1;
        System.out.println("L'adversaire a choisi " + this.convertIntToEnglish(handPlayer2) + "\n");

        System.out.println(this.playTurn(handPlayer1, handPlayer2));
    }



    public String convertIntToEnglish(int intPlayer) {
        if (intPlayer == 1) {
            return "rock";
        } else if (intPlayer == 2) {
            return "paper";
        } else if (intPlayer == 3) {
            return "scissors";
        }
        return "Invalid input";
    }

    public int playTurn(String handPlayer1, String handPlayer2) {

        Hand hand1 = HandFactory.createHandFromEnglish(handPlayer1);
        Hand hand2 = HandFactory.createHandFromEnglish(handPlayer2);

        return hand1.playWith(hand2);
    }

    public int playTurn(int handPlayer1, int handPlayer2) {
        String player1 = this.convertIntToEnglish(handPlayer1);
        String player2 = this.convertIntToEnglish(handPlayer2);

        Hand hand1 = HandFactory.createHandFromEnglish(player1);
        Hand hand2 = HandFactory.createHandFromEnglish(player2);

        return hand1.playWith(hand2);
    }
}

