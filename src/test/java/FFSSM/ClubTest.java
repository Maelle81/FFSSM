/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import FFSSM.*;

/**
 *
 * @author Maell
 */
public class ClubTest {
    
    Club CPC, CPT;
    Moniteur Pierrette, Pierre;
    Plongeur Paulette, Jacqueline, Paul;
    Plongee plg1, plg2;
    Site site1;
    LocalDate date1 = LocalDate.of(2021,2,11);
    LocalDate date2 = LocalDate.of(2021,12,27);
    LocalDate dateNaiss = LocalDate.of(2001,01,01);
    Set<Plongee> palanquee = new HashSet<Plongee>();
    Embauche embauche1;
      
       
    @BeforeEach
    public void setUp() {
        CPC = new Club(Pierrette, "Club de Plongée de Castres","102 boulevard des peupliers" , "0563247896");
        plg1 = new Plongee(site1, Pierrette, date1, 10, 2);
        Set<Plongee> palanquee = new HashSet<Plongee>();
        site1 = new Site("site1", "épave de bateau");
        Pierrette = new Moniteur("4023", "Dupont", "Pierrette", "15 avenue des lys", "0758693214", dateNaiss, 5, 1056);
        Paulette = new Plongeur("4012", "Dupuy", "Paulette", "48 rue des lilas", "0625547895", dateNaiss, 3);
        Jacqueline = new Plongeur("4058", "Dupré", "Jacqueline", "82 impasse des tulipes", "0627895463", dateNaiss, 2);
        embauche1 = new Embauche(date1, Pierrette, CPC);
        Plongee p1 = new Plongee(site1, Pierrette, date1, 10, 2);
        Plongee p2 = new Plongee(site1, Pierrette, date2, 20, 3);
        Licence l1 = new Licence(Pierrette, "8047", date1, CPC);
        Licence l2 = new Licence(Paulette, "8123", date1, CPC);
    }
    
    
    /**
     * Test of plongeesNonConformes method, of class Club.
     */
    
    @Test
    public void testPlongeesNonConformes() {
        Set<Plongee> palanquee = new HashSet<Plongee>();
        plg1.plongeesNonConformes();
    }

    /**
     * Test of organisePlongee method, of class Club.
     */
    
    @Test
    public void testOrganisePlongee() {
        organisePlongee(plg1);
        assertTrue(palanquee.contains(plg1), "La plongee n'est pas organisee");
    }

    /**
     * Test of getPresident method, of class Club.
     */
    @Test
    public void testGetPresident() {
        assertEquals(CPC.getPresident(), Pierrette, "Ce n'est pas le bon president");
    }

    /**
     * Test of setPresident method, of class Club.
     */
    @Test
    public void testSetPresident() {
        CPC.setPresident(Pierre);
        assertEquals(CPC.getPresident(), Pierre, "Pierre est president");
    }

    /**
     * Test of getNom method, of class Club.
     */
    @Test
    public void testGetNom() {
        assertEquals(CPC.getNom(), "Club de Plongée de Castres", "Ce n'est pas le bon nom");
    }

    /**
     * Test of setNom method, of class Club.
     */
    @Test
    public void testSetNom() {
        CPC.setNom("CPT");
        assertEquals(CPC.getNom(), "CPT", "Le nom du club doit etre CPT");
    }

    /**
     * Test of getAdresse method, of class Club.
     */
    @Test
    public void testGetAdresse() {
        assertEquals(CPC.getAdresse(), "102 boulevard des peupliers", "Ce n'est pas la bonne adresse");
    }

    /**
     * Test of setAdresse method, of class Club.
     */
    @Test
    public void testSetAdresse() {
        CPC.setAdresse("120 rue des sapins");
        assertEquals(CPC.getAdresse(), "120 rue des sapins", "L'adresse doit etre : 120 rue des sapins");
    }

    /**
     * Test of getTelephone method, of class Club.
     */
    @Test
    public void testGetTelephone() {
        assertEquals(CPC.getTelephone(), "0563247896", "Ce n'est pas le bon numero" );
    }

    /**
     * Test of setTelephone method, of class Club.
     */
    @Test
    public void testSetTelephone() {
        CPC.setTelephone("0563247800");
        assertEquals(CPC.getTelephone(), "0563247800", "Le numéro doit etre : 0563247800");
    }

    
    
}
