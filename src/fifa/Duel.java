/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author antoine
 */
public class Duel {

    Confrontation c1, c2;
    ArrayList<Arbitre> arbitre;
    Date date;
    Equipe e1, e2;

    public Confrontation getC1() {
        return c1;
    }

    public Confrontation getC2() {
        return c2;
    }

    public Equipe getE1() {
        return e1;
    }

    public Equipe getE2() {
        return e2;
    }

    public Duel(ArrayList<Arbitre> arbitre, Equipe e1, Equipe e2, Date date) {
        this.arbitre = arbitre;
        this.e1 = e1;
        this.e2 = e2;
        this.date = date;
        initConfrontation();
    }

    /**
     * initialisation Confrontation
     */
    private void initConfrontation() {
        c1 = new Confrontation(e1, e2, getArbitre(e1, e2));
        date = ajouterJour(date, 7);
        c2 = new Confrontation(e2, e1, getArbitre(e1, e2));
    }

    public Equipe getGagnant() {

        //premier match
        int nbButDom = (int) (Math.random() * 3);
        int nbButExt = (int) (Math.random() * 3);
        c1.setScore(nbButDom, nbButExt);
        //deuxieme match
        nbButDom = (int) (Math.random() * 3);
        nbButExt = (int) (Math.random() * 3);
        c2.setScore(nbButDom, nbButExt);

        //si e1 gagne premier match
        if (c1.domWin() == 1) {
            if (c2.domWin() == -1) {
                //si e1 gagne deuxieme match
                return e1;
            } else if (c2.domWin() == 2) {
                //si egalité deuxieme match
                return e1;
            } else {
                //si matche perdu/gagné
                return gagnantDiffBut();
            }
        } else if (c1.domWin() == 2) {
            //si eqgalite
            if (c2.domWin() == 1) {
                //si e2 gagne deuxieme
                return e2;
            } else if (c2.domWin() == -1) {
                return e1;
            } else {
                //null null
                return gagnantDiffBut();
            }
        } else {
            //si e2 gagne premier match
            if (c2.domWin() == 1) {
                //si e2 gange deuxieme
                return e2;
            } else if (c2.domWin() == 2) {
                //si null
                return e2;
            } else {
                //si e2 perd/gagne  
                return gagnantDiffBut();
            }
        }
    }
/**
 * 
 * @return gangant des deux match cumulé en fonction de difference de but 
 */
    private Equipe gagnantDiffBut() {
        if(c1.getScoreDom()+c2.getScoreExt()>c1.getScoreExt()+c2.getScoreDom())
            //si le score d'e1 > e2
            return e1;
        else if(c1.getScoreDom()+c2.getScoreExt()<c1.getScoreExt()+c2.getScoreDom()){
            //si score d'e2 >e1
            return e2;
        }else{
            //si totaux de score égaux
            if(c1.getScoreDom()+c2.getScoreExt()*2>c1.getScoreExt()*2+c2.getScoreDom()){
                //devant grace aux buts exterieurs
                return e1;
            }else if(c1.getScoreDom()+c2.getScoreExt()*2<c1.getScoreExt()*2+c2.getScoreDom()){
                //devant grace aux buts exterieurs
                return e2;
            }else{
                //si egalité:tir aux but , donc aléatoire
                if(Math.random()*2<1){
                    return e1;
                }else
                    return e2;
            }
        }
    }

    /**
     * Ajouter jour a une date.
     *
     * @param date data actuel.
     * @param nbJour jour à ajouter
     *
     * @return la date mise a jour;
     */
    public static Date ajouterJour(Date date, int nbJour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, nbJour);
        return cal.getTime();
    }

    /**
     * Recherche un arbitre disponible pour cette rencontre
     *
     * @param e1 equipe dom
     * @param e2 equipe ext
     *
     * @return Arbitre disponible
     */
    private Arbitre getArbitre(Equipe e1, Equipe e2) {
        for (Arbitre arbitre1 : arbitre) {
            //parcours de tous les arbitres
            ArrayList<Date> calendrier = arbitre1.getCalendrier();
            if (!arbitre1.getPays().equalsIgnoreCase(e2.getPays()) && !arbitre1.getPays().equalsIgnoreCase(e1.getPays())) {
                if (calendrier.isEmpty()) {
                    return arbitre1;
                } else {
                    boolean tmp = true;
                    for (Date calendrier1 : calendrier) {
                        //parcours du calendrier de chaques arbitres
                        if (calendrier1.compareTo(this.date) == 0) {
                            tmp = false;
                        }
                    }
                    if (tmp) {
                        return arbitre1;
                    }
                }
            }
        }
        System.out.println("pas d'arbitre disponible pour le : " + date);
        return null;
    }

    @Override
    public String toString() {
        return e1 + " VS " + e2;
    }

}
