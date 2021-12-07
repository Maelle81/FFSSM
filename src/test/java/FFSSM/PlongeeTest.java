/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import FFSSM.*;
/**
 *
 * @author Maell
 */
public class PlongeeTest {
    
    Club CPC;
    Moniteur Pierrette;
    Plongeur Paulette, Jacqueline;
    Site site1;
    LocalDate dateNaiss = new LocalDate.of(1985,5,26);
    LocalDate datePlongee = new LocalDate.of(2021,12,7);
    Plongee p1;
      
       
    @BeforeEach
    public void setUp() {
        
        CPC = new Club(Pierrette, "Club de Plongée de Castres","102 boulevard des peupliers" , "0563247896");
        site1 = new Site("site1", "épave de bateau");
        Pierrette = new Moniteur("4023", "Dupont", "Pierrette", "15 avenue des lys", "0758693214", dateNaiss, 5, 1056);
        Paulette = new Plongeur("4012", "Dupuy", "Paulette", "48 rue des lilas", "0625547895", dateNaiss, 3);
        Jacqueline = new Plongeur("4058", "Dupré", "Jacqueline", "82 impasse des tulipes", "0627895463", dateNaiss, 2);
        p1 = new Plongee(site1, Pierrette,datePlongee , 20, 2);
                
    }   
    
    
    /**
     * Test of getDate method, of class Plongee.
     */
    @Test
    public void testGetDate() {
        assertEquals(p1.getDate(), datePlongee, "La date est fausse");
    }

    /**
     * Test of getChefDePalanquee method, of class Plongee.
     */
    @Test
    public void testGetChefDePalanquee() {
        assertEquals(p1.getChefDePalanquee(), Pierrette, "Le chef n'est pas le bon");
    }

    /**
     * Test of getProfondeur method, of class Plongee.
     */
    @Test
    public void testGetProfondeur() {
        assertEquals(p1.getProfondeur(), 20, "La profondeur est fausse");
    }

    /**
     * Test of getDuree method, of class Plongee.
     */
    @Test
    public void testGetDuree() {
        assertEquals(p1.getDuree(), 2, "La duree est fausse");
    }

    /**
     * Test of getLieu method, of class Plongee.
     */
    @Test
    public void testGetLieu() {
        assertEquals(p1.getLieu(), site1, "Le lieu est faux");
    }

    /**
     * Test of ajouteParticipant method, of class Plongee.
     */
    @Test
    public void testAjouteParticipant() {
        p1.ajouteParticipant(Paulette);
        assertTrue(p1.lesPlongeurs.contains(Paulette), "Il n'y a pas les bons partcipants");
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme() {
        Paulette.ajouteLicence("7058",LocalDate.of(2021, 3, 30), CPC);
        p1.ajouteParticipant(Paulette);
        assertTrue(p1.estConforme(), "La plongee est conforme");
    }
    
    @Test
    public void testEstNonConforme() {
        Paulette.ajouteLicence("7058", LocalDate.of(2021, 3, 30), CPC);
        Jacqueline.ajouteLicence("7089",LocalDate.of(2001, 3, 30), CPC);
        p1.ajouteParticipant(Paulette);
        p1.ajouteParticipant(Jacqueline);
        assertFalse(p1.estConforme(), "La plongee est non conforme");
    }
    
}
