/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Olivier
 */
public class Poule {

    private final ArrayList<Groupe> groupe;
    private final ArrayList<Equipe> equipe;
    private final ArrayList<Arbitre> arbitre;
    private int nbGroup;

    /**
     * ajout d'une poule de plusieurs equipes
     *
     * @param equipe equipe de la poule
     * @param arbitre liste des arbitre
     *
     */
    public Poule(ArrayList<Equipe> equipe, ArrayList<Arbitre> arbitre) {
        this.arbitre = arbitre;
        this.equipe = equipe;
        this.groupe = new ArrayList();
        initGroupe();
    }
/**
 * 
 * @return tableau des groupes
 */
    public ArrayList<Groupe> getGroupe() {
        return groupe;
    }
      
    
/**
     * simulation de tous les matchs de poule
     */
    public void simulation(){
        for(Groupe groupe1:groupe){
            groupe1.simulationMatchs();
        }
    }
    /**
     * Initialisation des groupes
     *
     */
    private void initGroupe() {
        if (equipe.size() > 3) {
            nbGroup = equipe.size() / 4;
            for (int i = 0; i < nbGroup; i++) {
                ArrayList<Equipe> listEquipe = new ArrayList();
                for (int j = 0; j < 4; j++) {//initialiation equipe du groupe
                    listEquipe.add(equipe.get(j + i * 4));
                }
                groupe.add(new Groupe(arbitre, i, listEquipe));
            }
        } else //mal initialisé
        {
            System.out.println("Pas d'équipe");
        }
    }

}
