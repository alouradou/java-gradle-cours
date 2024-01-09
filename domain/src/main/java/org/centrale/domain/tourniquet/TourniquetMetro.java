package org.centrale.domain.tourniquet;

public class TourniquetMetro {
    // partern State
    private EtatTourniquet etat; // Bloqué, Débloqué

    public TourniquetMetro() {
        this.etat = new EtatBloque(this);
    }

    public void setEtat(EtatTourniquet etat) {
        this.etat = etat;
    }

    public void tourner() {
        this.etat.tourner();
    }

    public void insererTicketValide() {
        this.etat.insererTicketValide();
    }

    public void insererTicketNonValide() {
        this.etat.insererTicketNonValide();
    }

    public EtatTourniquet getEtat() {
        return this.etat;
    }

}
