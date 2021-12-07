/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public static Site lieu;

    public static Moniteur chefDePalanquee;

    public static LocalDate date;

    public static int profondeur;

    public static int duree;

    private static Set<Plongeur> lesPlongeurs = new HashSet<Plongeur>();

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

    public static Moniteur getChefDePalanquee() {
        return chefDePalanquee;
    }

    public static int getProfondeur() {
        return profondeur;
    }

    public static int getDuree() {
        return duree;
    }

    public static Site getLieu() {
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
    public static boolean estConforme() {
        
        for (Plongeur lesPlongeurs : lesPlongeurs) {
            if (lesPlongeurs.getLicence().estValide(date)) {
                return true;
            }
        }
        return false;
    }

}
