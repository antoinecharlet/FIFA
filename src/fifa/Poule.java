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
public class Poule {

    ArrayList<Groupe> groupe;
    ArrayList<Equipe> equipe;
    ArrayList<Arbitre> arbitre;
    int nbGroup;

    public Poule(ArrayList<Equipe> equipe,ArrayList<Arbitre> arbitre) {
        this.arbitre=arbitre;
        this.equipe = equipe;
        this.groupe = new ArrayList();
        initGroupe();
    }

    private void initGroupe() {
        if (equipe.size()<4) {
            nbGroup = equipe.size() / 4;
            for(int i=0;i<nbGroup;i++){
                Equipe[] listEquipe=new Equipe[4];
                for(int j=0;j<4;j++){//initialiation equipe du groupe
                    listEquipe[j]=equipe.get(j+i*4);
                } 
                groupe.add(new Groupe(arbitre,i,listEquipe));
            }
            
        } else //mal initialisé
        {
            System.out.println("Pas d'équipe");
        }
    }

}
