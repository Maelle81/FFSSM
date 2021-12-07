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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Maell
 */
public class MoniteurTest {
    
    Club CPC, CPT;
    Moniteur Pierrette, Pierre;
    Plongeur Paulette, Jacqueline, Paul;
    Plongee plg1, plg2;
    Site site1;
    LocalDate date1 = LocalDate.of(2021,2,11);
    LocalDate date2 = LocalDate.of(2021,12,27);
    LocalDate date3 = LocalDate.of(2000,12,27);
    LocalDate dateNaiss = LocalDate.of(2001,01,01);
    Set<Plongee> palanquee = new HashSet<Plongee>();
    Embauche embauche1;
    List<Embauche> lesEmplois = new ArrayList<Embauche>();
    
    @BeforeEach
    public void setUp() {
        CPC = new Club(Pierrette, "Club de Plongée de Castres","102 boulevard des peupliers" , "0563247896");
        //CPT = new Club(Pierrette, "Club de Plongée de Toulouse", "245 avenue des chenes", "0215796359");
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
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    
    @Test
    public void testEmployeurActuel() {
        Pierrette.nouvelleEmbauche(CPT, date3);
        Pierrette.nouvelleEmbauche(CPC, date1);
        assertEquals(Pierrette.employeurActuel(), CPC, "Le moniteur est deja employé dans un club");
    }

    /**
     * Test of nouvelleEmbauche method, of class Moniteur.
     */
    @Test
    public void testNouvelleEmbauche() {
        lesEmplois.add(embauche1);
        assertTrue(lesEmplois.contains(embauche1), "La liste n'a pas incrementée ");
    }

    /**
     * Test of emplois method, of class Moniteur.
     */
    @Test
    public void testTerminerEmbauche() {
        Pierrette.nouvelleEmbauche(CPC, date3);
        Pierrette.terminerEmbauche(date1);
        assert;
    }
    
}
