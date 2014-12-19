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
public class Equipe {
    private int point;
    private int nbBut;

    public Equipe() {
        point=0;
        nbBut=0;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setNbBut(int nbBut) {
        this.nbBut = nbBut;
    }

    public int getPoint() {
        return point;
    }

    public int getNbBut() {
        return nbBut;
    }
    
    
}
