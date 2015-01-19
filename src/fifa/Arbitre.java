/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fifa;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author antoine
 */
public class Arbitre {
    private String nom,prenom,pays;
    private int id;
    private ArrayList<Date> calendrier;
/**
 * 
 * @param id identifiant
 * @param nom nom
 * @param prenom prenom
 * @param pays pays
 */
    public Arbitre(int id,String nom, String prenom,String pays) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays=pays;
        this.calendrier=new ArrayList();
    }
    /**
     * 
     * @param date date a jouter au calendrier
     */
    public void AjoutDate(Date date){
        calendrier.add(date);
    }
    
    public ArrayList<Date> getCalendrier(){
        return calendrier;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public String toString() {
        return nom + " "+ prenom + " " + id ;
    }
    
}
