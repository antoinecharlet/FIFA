/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

/**
 *
 * @author antoine
 */
class Confrontation {
    private final Arbitre arbitre;
    private final Equipe equipeDom,equipeExt;//equipe 1 a domicile

    public Confrontation(Equipe equipeDom, Equipe equipeExt,Arbitre arbitre) {
        this.equipeDom = equipeDom;
        this.equipeExt= equipeExt;
        this.arbitre=arbitre;
    }

    public Equipe getEquipeDom() {
        return equipeDom;
    }

    public Equipe getEquipeExt() {
        return equipeExt;
    }

    @Override
    public String toString() {
        return "arbitre=" + arbitre + ", equipe dom=" + equipeDom + " VS " + equipeExt;
    }
    
}
