/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import FFSSM.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Maell
 */
public class MoniteurTest {
    
    Club cpc;
    Moniteur pierrette, paul;
    Plongee plg1;
    Site site1;
    LocalDate dateNaiss1, dateNaiss2;
        
    @BeforeEach
    public void setUp() {
        
        dateNaiss1 = LocalDate.of(1985, 3, 10);
        dateNaiss2 = LocalDate.of(1970, 6, 15);
        pierrette = new Moniteur("4023", "Dupont", "Pierrette", "15 avenue des lys", "0758693214", dateNaiss2, 5, 1056);
        cpc= new Club(pierrette, "Club de Plongée de Castres","102 boulevard des peupliers" , "0563247896");
        paul = new Moniteur("4701", "Dujardin", "Paul", "5 rue des roses", "0236789145", dateNaiss1, 5, 1085);
        

    }
    
    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    
    @Test
    public void testEmployeurActuel() {
        assertEquals(paul.employeurActuel(), Optional.empty(), "Le moniteur ne doit pas avoir un employeur");
        paul.nouvelleEmbauche(cpc, LocalDate.of(2020,8,24));
        assertEquals(paul.employeurActuel(),Optional.ofNullable(cpc), "Le moniteur est embauché au CPC");
        
    }

    /**
     * Test of nouvelleEmbauche method, of class Moniteur.
     */
    @Test
    public void testNouvelleEmbauche() {
        paul.nouvelleEmbauche(cpc, LocalDate.of(2020, 8, 24));
        assertEquals(LocalDate.of(2020, 8, 24), paul.lesEmbauches.get(paul.lesEmbauches.size()-1).getDebut(), "Le moniteur a été embauché à cette date");
        assertEquals(paul,paul.lesEmbauches.get(paul.lesEmbauches.size()-1).getEmploye(), "Le moniteur a été embauché");
        assertEquals(cpc, paul.lesEmbauches.get(paul.lesEmbauches.size()-1).getEmployeur(), "Le moniteur est embauché dans le bon club");
    }

    /**
     * Test of emplois method, of class Moniteur.
     */
    
    @Test
    public void testTerminerEmbauche() {
        pierrette.nouvelleEmbauche(cpc, LocalDate.of(2020, 9, 20));
        pierrette.terminerEmbauche(LocalDate.of(2021, 5, 6));
        assertEquals(LocalDate.of(2021,5, 6), pierrette.lesEmbauches.get(pierrette.lesEmbauches.size()-1).getFin(),"Le moniteur a fini son contrat à cette date");
    }
    
    @Test
    public void TestEmplois(){
        List<Embauche> lesEmbauches = new LinkedList<>();
        Embauche e = new Embauche(LocalDate.of(2020,9,20), paul, cpc);
        lesEmbauches.add(e);
        paul.nouvelleEmbauche(cpc, LocalDate.of(2020, 9, 20));
        assertEquals(paul.lesEmbauches, paul.emplois(), "Ajout de l'emploi");
       
    }
    
}
