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
    
    Club cpc;
    Moniteur pierrette, pierre, jacques;
    Plongeur jacqueline, paulette ;
    Site site1;
    LocalDate dateNaiss1 ,dateSortie , dateNaiss2;
    Plongee p1;
          
       
    @BeforeEach
    public void setUp() {
        dateNaiss1 = LocalDate.of(1976,01,2);
        dateSortie = LocalDate.of(2021,12,11);
        dateNaiss2 = LocalDate.of(1990,9,22);
        cpc = new Club(pierrette, "Club de Plongée de Castres","102 boulevard des peupliers" , "0563247896");
        p1 = new Plongee(site1, jacques, dateSortie, 15, 2);
        site1 = new Site("site1", "épave de bateau");
        pierrette = new Moniteur("4023", "Dupont", "Pierrette", "15 avenue des lys", "0758693214", dateNaiss1, 5, 1056);
        pierre = new Moniteur("4701", "Dujardin", "Pierre", "5 rue des roses", "0236789145", dateNaiss1, 5, 1085);
        jacques = new Moniteur("4702", "Dupré", "Jacques", "25 rue des lys", "0236578691", dateNaiss1, 5, 1085);
        paulette = new Plongeur("4012", "Dupuy", "Paulette", "48 rue des lilas", "0625547895", dateNaiss2, 3);
        jacqueline = new Plongeur("4058", "Dupré", "Jacqueline", "82 impasse des tulipes", "0627895463", dateNaiss2, 2);
                
    }
    
    
    /**
     * Test of plongeesNonConformes method, of class Club.
     */
    
    @Test
    public void testPlongeesNonConformes() {
        paulette.ajouteLicence("7034", LocalDate.of(2021, 3, 1), cpc);
        p1.ajouteParticipant(paulette);
        jacqueline.ajouteLicence("7031", LocalDate.of(2010, 11, 24), cpc);
        p1.ajouteParticipant(jacqueline);
        assertFalse(p1.estConforme(), "Il y a une plongee non conforme");
        assertEquals(cpc.lesPlongees, cpc.plongeesNonConformes(),"La liste est correcte");
    }

    /**
     * Test of organisePlongee method, of class Club.
     */
    
    @Test
    public void testOrganisePlongee() {
        cpc.organisePlongee(p1);
        assertTrue(cpc.lesPlongees.contains(p1), "La plongee est organisee");
    }

    /**
     * Test of getPresident method, of class Club.
     */
    
    @Test
    public void TestPlongeeConforme(){
        paulette.ajouteLicence("7034", LocalDate.of(2021, 3, 1), cpc);
        p1.ajouteParticipant(paulette);
        assertTrue(p1.estConforme());
        assertEquals(cpc.lesPlongees, cpc.plongeesNonConformes(), "Les plongees sont conformes");
    }

    
    
}
