package org.centrale.domain.tourniquet;

public interface EtatTourniquet {
    void tourner();
    void insererTicketNonValide();
    void insererTicketValide();
}
