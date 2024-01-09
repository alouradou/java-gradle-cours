package org.centrale.domain.tourniquet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestTourniquet {

    @Test
    public void testObjectTourniquet() {
        TourniquetMetro tourniquet = new TourniquetMetro();
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
        tourniquet.setEtat(new EtatDebloque(tourniquet));
        Assertions.assertInstanceOf(EtatDebloque.class, tourniquet.getEtat());
    }

    @Test
    public void testActions() {
        TourniquetMetro tourniquet = new TourniquetMetro();

        tourniquet.setEtat(new EtatBloque(tourniquet));
        // On est en état bloqué
        tourniquet.tourner();
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
        tourniquet.insererTicketNonValide();
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
        // On passe en etat débloqué
        tourniquet.insererTicketValide();
        Assertions.assertInstanceOf(EtatDebloque.class, tourniquet.getEtat());

        tourniquet.setEtat(new EtatDebloque(tourniquet));
        // On est en état débloqué
        tourniquet.insererTicketValide();
        Assertions.assertInstanceOf(EtatDebloque.class, tourniquet.getEtat());
        tourniquet.insererTicketNonValide();
        Assertions.assertInstanceOf(EtatDebloque.class, tourniquet.getEtat());
        // On passe en etat bloqué
        tourniquet.tourner();
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());

    }

}
