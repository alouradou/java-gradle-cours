package org.centrale.domain.rockpaperscissors;

public class HandFactory {

    public static Hand createHandFromFrench(String hand){
        return switch (hand) {
            case "Pierre" -> new Pierre();
            case "Feuille" -> new Feuille();
            default -> new Ciseaux();
        };
    }

    public static Hand createHandFromEnglish(String hand){
        return switch (hand) {
            case "rock" -> new Pierre();
            case "paper" -> new Feuille();
            default -> new Ciseaux();
        };
    }

}
