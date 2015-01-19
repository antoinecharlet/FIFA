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

    private ArrayList<Equipe> equipe;
    private ArrayList<Arbitre> arbitre;
    private ArrayList<Tour> tour;
    private int numTour;
/**
 * 
 * @param equipe liste Equipe qualifie
 * @param arbitre liste Arbitre
 */
    public EliminationDirect(ArrayList<Equipe> equipe, ArrayList<Arbitre> arbitre) {
        this.equipe = equipe;
        numTour = (int) Math.sqrt((double) equipe.size());
        this.arbitre = arbitre;
        tour = new ArrayList();
        tour.add(new Tour(numTour, arbitre, equipe));
    }
/**
 * Simulaition de tous les matchs du tour actuel
 */
    public void simulationTour() {

        if (equipe.size() > 2) {
            equipe = tour.get(tour.size() - 1).simulationMatch();
            numTour = (int) Math.sqrt((double) equipe.size());
            tour.add(new Tour(numTour, arbitre, equipe));
        } else if(equipe.size()==2){
            System.out.println("Final " + equipe.get(0) + " " + equipe.get(1));
            equipe = tour.get(tour.size() - 1).simulationMatch();
        }
        
    }

    public ArrayList<Tour> getTour() {
        return tour;
    }

}
