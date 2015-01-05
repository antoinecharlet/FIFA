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
    private final Equipe equipe1,equipe2;//equipe 1 a domicile

    public Confrontation(Equipe equipe1, Equipe equipe2,Arbitre arbitre) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.arbitre=arbitre;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    @Override
    public String toString() {
        return "Confrontation{" + "arbitre=" + arbitre + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + '}';
    }
    
}
