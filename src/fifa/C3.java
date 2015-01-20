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
public class C3 extends Coupe {
    boolean pouleJoue=false;
    C1 c1;

    public C3(C1 c1) {
        super();
        this.c1 = c1;
    }

    @Override
    public void simulationPoule() {

        if (!pouleJoue) {
            poule.simulation();
            ArrayList<Equipe> qualifiees = new ArrayList();
            ArrayList<Equipe> classement = new ArrayList();
            for (Groupe groupe1 : poule.getGroupe()) {
                classement = groupe1.getClassement();//ajout 1er,deuxieme et troisieme classement
                qualifiees.add(classement.get(0));
                qualifiees.add(classement.get(1));
                qualifiees.add(classement.get(2));
            }
            for (Equipe equipe1 : c1.get3em()) {
                qualifiees.add(equipe1);
            }
            this.elimination = new EliminationDirect(qualifiees, arbitre);
            pouleJoue=true;
        }
    }
}
