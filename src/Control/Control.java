/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import fifa.Arbitre;
import fifa.Coupe;
import fifa.Equipe;

/**
 *
 * @author antoine
 */
public class Control {
/**
 * controle ajout d'équipe
 * @param c coupe
 * @param nom nom
 * @param pays pays
 */
    public static void ajoutEquipe(Coupe c, String nom, String pays) {
        if (nom.matches("([a-z]|[A-Z])*") && pays.matches("([a-z]|[A-Z])*")) {
            if(!c.getEquipe().contains(new Equipe(nom,pays.toUpperCase())))
                c.ajoutEquipe(nom, pays.toUpperCase());
        }

    }
    /**
     * controle ajout Arbitre
     * @param c coupe
     * @param prenom prenom
     * @param nom nom
     * @param pays pays
     */
        public static void ajoutArbitre(Coupe c,String prenom, String nom, String pays) {
        if (nom.matches("([a-z]|[A-Z])*") && pays.matches("([a-z]|[A-Z])*") && !pays.matches("([a-z]|[A-Z])*") && pays.matches("([a-z]|[A-Z])*")) {
            if(!c.getArbitre().contains(new Arbitre(Integer.parseInt(pays),prenom,nom,pays.toUpperCase())))
                c.AjoutArbitre(String.valueOf(c.getArbitre().size()),nom,prenom, pays.toUpperCase());
        }

    }
}
