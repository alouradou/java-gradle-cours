package org.centrale.domain.rockpaperscissors;

public interface Hand {

    int playWith(Hand h);

    int playWithPierre(Pierre p);

    int playWithCiseaux(Ciseaux c);

    int playWithFeuille(Feuille f);

}
