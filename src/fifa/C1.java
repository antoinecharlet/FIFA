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
public class C1 extends Coupe {
boolean pouleJoue=false;
    //private Poule poule;
    //private EliminationDirect elimination;
    //private Barrage barrage;
    public C1() {
        super();
    }

    /**
     *
     * @return liste des Equipes qui ont finit 3em de grp
     */
    public ArrayList<Equipe> get3em() {
        ArrayList<Equipe> troisieme = new ArrayList();
        ArrayList<Equipe> classement = new ArrayList();
        for (Groupe groupe1 : poule.getGroupe()) {
            classement = groupe1.getClassement();//ajout 3em classement
            troisieme.add(classement.get(2));
        }
        return troisieme;
    }

    public boolean isPouleJoue() {
        return pouleJoue;
    }
    @Override
    public void simulationPoule() {

        if (!pouleJoue) {
            poule.simulation();

            ArrayList<Equipe> qualifiees = new ArrayList();
            ArrayList<Equipe> classement = new ArrayList();
            for (Groupe groupe1 : poule.getGroupe()) {
                classement = groupe1.getClassement();//ajout 1er et deuxieme classement
                qualifiees.add(classement.get(0));
                qualifiees.add(classement.get(1));
            }
            this.elimination = new EliminationDirect(qualifiees, arbitre);
            pouleJoue=true;
        }
    }

    @Override
    ArrayList<Equipe> initEquipe() {
         {//fonction qui recuper les donnée de la BD
        ArrayList<Equipe> tmp = new ArrayList();
        
        for (int i = 0; i < 16; i++) {
            tmp.add(new Equipe("lapin" + (8 + i), "coucou"));
        }
        equipe = tmp;
        return tmp;
    }

    }
}
