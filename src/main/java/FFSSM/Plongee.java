/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public LocalDate date;

    public int profondeur;

    public int duree;

    public Set<Plongeur> lesPlongeurs = new HashSet<Plongeur>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    

    public LocalDate getDate() {
        return date;
    }

    public Moniteur getChefDePalanquee() {
        return chefDePalanquee;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public int getDuree() {
        return duree;
    }

    public Site getLieu() {
        return lieu;
    }
    
    public void ajouteParticipant(Plongeur participant) {
        lesPlongeurs.add(participant);
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        
        for (Plongeur participant : lesPlongeurs) {
            if (participant.getLicence().estValide(date)) {
                return true;
            }
        }
        return false;
    }

}
