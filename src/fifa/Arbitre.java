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
 * @author Olivier
 */
public class Arbitre {
    private String nom,prenom,pays;
    private ArrayList<Date> calendrier;

    public Arbitre(String nom, String prenom,String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays=pays;
        this.calendrier=new ArrayList();
    }
    
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
    
}
