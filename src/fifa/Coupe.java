/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fifa;

/**
 *
 * @author Olivier
 */
public class Coupe {
    private Poule poule;
    private EliminationDirect elimination;
    private Barrage barrage;
    private int annee;

    public Coupe(int annee) {
        this.annee = annee;
    }
}
