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
    int nbGroup;

    public Poule(ArrayList<Equipe> equipe) {
        this.equipe = equipe;
        this.groupe = new ArrayList();
        initGroupe();
    }

    private void initGroupe() {
        if (!equipe.isEmpty()) {
            nbGroup = equipe.size() / 4;
        } else //mal initialisé
        {
            
        }
    }

}
