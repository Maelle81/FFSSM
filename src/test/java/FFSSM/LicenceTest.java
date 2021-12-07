/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
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
public class LicenceTest {

    Club CPC;
    Moniteur Pierrette;
    LocalDate date1 = LocalDate.of(2021, 11, 20);
    LocalDate date2 = LocalDate.of(2022, 9, 7);
    LocalDate date3 = LocalDate.of(2023, 1, 15);
    LocalDate dateNaiss = LocalDate.of(2000, 10, 2);
    Licence licence1;

    @BeforeEach
    public void setUp() {
        CPC = new Club(Pierrette, "Club de Plongée de Castres", "102 boulevard des peupliers", "0563247896");
        Pierrette = new Moniteur("4023", "Dupont", "Pierrette", "15 avenue des lys", "0758693214", dateNaiss, 5, 1056);
        licence1 = new Licence(Pierrette, "7045", date1, CPC);
    }

    @Test
    public void testGetPossesseur() {
        assertEquals(licence1.getPossesseur(), Pierrette, "Le possesseur doit-etre pierrette.");
    }

    @Test
    public void testGetNumero() {
        assertEquals(licence1.getNumero(), "7045", "La licence n'est pas correcte.");
    }

    @Test
    public void testGetDelivrance() {
        assertEquals(licence1.getDelivrance(), date1, "Cette licence n'a pas été delivree à cette date.");
    }

    @Test
    public void testGetClub() {
        assertEquals(licence1.getClub(), CPC, "Cette licence n'est pas delivrée par ce club");
    }

    @Test
    public void testEstValide() {
        assertFalse(licence1.estValide(date3), "La licence doit etre non valide");
        assertTrue(licence1.estValide(date1), "La licenec doit etre valide");
    }

}
