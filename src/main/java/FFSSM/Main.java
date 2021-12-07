/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author Maell
 */
public class Main {
    
    public static void main(String[] args){
        
        LocalDate date1 = LocalDate.of(2021,10,5);
        LocalDate date2 = LocalDate.of(2021,12,25);
        
        LocalDate dateNaiss1 = LocalDate.of(2001, 2, 23);
        LocalDate dateNaiss2 = LocalDate.of(1999, 8, 7);
        
        Site site1 = new Site("site1", "épave de bateau");
        
        Moniteur Pierrette = new Moniteur("4023", "Dupont", "Pierrette", "15 avenue des lys", "0758693214", dateNaiss1, 5, 1056);
        
        Plongeur Paulette = new Plongeur("4012", "Dupuy", "Paulette", "48 rue des lilas", "0625547895", dateNaiss2, 3);
        Plongeur Jacqueline = new Plongeur("4058", "Dupré", "Jacqueline", "82 impasse des tulipes", "0627895463", dateNaiss1, 2);
        
        Club CPC = new Club(Pierrette, "Club de Plongée de Castres","102 boulevard des peupliers" , "0563247896");
        
        Embauche embauche1 = new Embauche(date1, Pierrette, CPC);
        
        Plongee p1 = new Plongee(site1, Pierrette, date1, 10, 2);
        Plongee p2 = new Plongee(site1, Pierrette, date2, 20, 3);
        
        Licence l1 = new Licence(Pierrette, "8047", date1, CPC);
        Licence l2 = new Licence(Paulette, "8123", date1, CPC);
        
        l1.estValide(date2);
        l2.estValide(date2);
        
        embauche1.estTerminee();
        embauche1.terminer(date2);
        embauche1.estTerminee();
        
        Pierrette.nouvelleEmbauche(CPC, date1);
        Pierrette.employeurActuel();
        Pierrette.nouvelleEmbauche(CPC, date2);
        Pierrette.emplois();
        
        Paulette.ajouteLicence("7203", date1, CPC);
        Paulette.ajouteLicence("7128", date2, CPC);
        Paulette.derniereLicence();
        
        p1.ajouteParticipant(Paulette);
        p1.estConforme();
        p1.ajouteParticipant(Jacqueline);
        p1.estConforme();
        
        CPC.plongeesNonConformes();
        CPC.organisePlongee(p2);

    }
    
}
