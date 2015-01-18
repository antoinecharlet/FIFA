/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author antoine
 */
public class Tour {
    private int numTour;
    private ArrayList<Arbitre>arbitre;
    private ArrayList<Equipe>equipe;
    private ArrayList<Duel>duel;

    public Tour(int numTour, ArrayList<Arbitre> arbitre, ArrayList<Equipe> equipe) {
        this.numTour = numTour;
        this.arbitre = arbitre;
        this.equipe = equipe;
        this.duel=new ArrayList();
        initDuel();
    }

    public int getNumTour() {
        return numTour;
    }

    public ArrayList<Duel> getDuel() {
        return duel;
    }
    
    public ArrayList<Equipe> simulationMatch(){
        ArrayList<Equipe> tmp = new ArrayList();
        for(Duel duel1:duel){
            tmp.add(duel1.getGagnant());
        }
        return tmp;
    }
    
    /**
     * initialisation des matchs de qualifications
     */
    private void initDuel(){
        Date date=new Date(2015,06,01);
        date=ajouterJour(date,-numTour*7);
        for(int i=0;i<equipe.size();i+=2){
            duel.add(new Duel(arbitre,equipe.get(i),equipe.get(i+1),date));
        }
    }
    
    /**
     * Ajouter jour a une date.
     *
     * @param date data actuel.
     * @param nbJour jour à ajouter
     *
     * @return la date mise a jour;
     */
    public static Date ajouterJour(Date date, int nbJour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, nbJour);
        return cal.getTime();
    }

    @Override
    public String toString() {
        String tmp=new String();
        for(int i=0;i<duel.size();i++){
            tmp+=duel.get(i)+" \n";
        }
        return tmp;
    }
 
}
