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
    private String nom;
    private int point;
    private int nbBut;
    private String pays;

    public Equipe(String nom,String pays) {
        this.nom=nom;
        point=0;
        this.pays=pays;
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

    public String getNom() {
        return nom;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public String toString() {
        return "Equipe{" + "nom=" + nom + '}';
    }
    
    
}
