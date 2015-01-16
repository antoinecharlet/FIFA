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
    ArrayList<Journee>match;
    private int tour;

    public EliminationDirect(ArrayList<Equipe>equipe,ArrayList<Arbitre>arbitre) {
        this.equipe=equipe;
        tour=(int) Math.sqrt((double)equipe.size());
        this.arbitre=arbitre;
        creation1erTour();
    }
    
    private void creation1erTour(){
        for(int i=0;i<tour;i++){
            
        }
    }
    
    
}
