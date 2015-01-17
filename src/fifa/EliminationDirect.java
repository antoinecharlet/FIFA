/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fifa;

import java.util.ArrayList;

/**
 *
 * @author Olivier
 */
public class EliminationDirect {
    ArrayList<Equipe> equipe;
    ArrayList<Arbitre>arbitre;
    ArrayList<Tour>tour;
    private int numTour;


    public EliminationDirect(ArrayList<Equipe>equipe,ArrayList<Arbitre>arbitre) {
        this.equipe=equipe;
        numTour=(int) Math.sqrt((double)equipe.size());
        this.arbitre=arbitre; 
        tour=new ArrayList();
        tour.add(new Tour(numTour,arbitre,equipe));
    }

    public void simulationTour(){
        equipe=tour.get(tour.size()-1).simulationMatch();
        if(equipe.size()>2)
            numTour=(int) Math.sqrt((double)equipe.size());
        else 
            System.out.println("Final "+equipe.get(0)+" "+equipe.get(1));
        tour.add(new Tour(numTour,arbitre,equipe));
    }
    
}
