/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public Club employeur;
    public List<Embauche> lesEmbauches = new LinkedList<Embauche>();
    
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Optional<Club> optional = Optional.empty();
        if(lesEmbauches.size()== 0){
        }else{
            optional = Optional.of(lesEmbauches.get(lesEmbauches.size()-1).getEmployeur());
        }
        return optional;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche embauche = new Embauche(debutNouvelle, this, employeur);
        lesEmbauches.add(embauche);
    }
    
    public void terminerEmbauche(LocalDate fin){
        Embauche embauche = lesEmbauches.get(lesEmbauches.size()-1);
        embauche.terminer(fin);
    }

    public List<Embauche> emplois() {
        return lesEmbauches;
    }

}
