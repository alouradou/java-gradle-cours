package org.centrale.domain.rockpaperscissors;

import lombok.NoArgsConstructor;

@NoArgsConstructor // cf https://projectlombok.org
public class Feuille implements Hand{

    @Override // cf https://projectlombok.org
    public int playWith(Hand h) {
        return -h.playWithFeuille(this);
    }

    @Override
    public int playWithPierre(Pierre p) {
        return 1;
    }

    @Override
    public int playWithCiseaux(Ciseaux c) {
        return -1;
    }

    @Override
    public int playWithFeuille(Feuille f) {
        return 0;
    }
}
