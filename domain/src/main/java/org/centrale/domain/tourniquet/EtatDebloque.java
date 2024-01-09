package org.centrale.domain.tourniquet;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class EtatDebloque implements EtatTourniquet  {
    private TourniquetMetro tourniquet;

    public void tourner() {
        this.tourniquet.setEtat(new EtatBloque(this.tourniquet));
    }

    public void insererTicketValide() {
        this.tourniquet.setEtat(new EtatDebloque(this.tourniquet));
    }

    public void insererTicketNonValide() {
        this.tourniquet.setEtat(new EtatDebloque(this.tourniquet));
    }
}
