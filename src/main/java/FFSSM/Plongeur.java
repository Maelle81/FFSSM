package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongeur extends Personne{
    
    public int niveau;
    
    private List<Licence> licence = new ArrayList<>();
    private Licence l1;    

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public Licence getLicence() {
        return l1;
    }     
    
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
       
    
    public void ajouteLicence( String numero, LocalDate delivrance, Club c ){
        Plongeur plongeur = this;
        licence.add(new Licence(plongeur, numero, delivrance, c));
    }
    
    public Licence derniereLicence(){
        Licence l = licence.get(licence.size()-1);
        return l; 
    }
    
    


}
