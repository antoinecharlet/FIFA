/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antoine
 */
public class Journee {

    private final int num;
    private final Date date;
    private final boolean alle;
    private final ArrayList<Arbitre> arbitre;
    private final ArrayList<Equipe> equipe;
    private final ArrayList<Confrontation> confrontation;

    Journee(ArrayList<Arbitre> arbitre, int num, boolean alle, Date date, ArrayList<Equipe> equipe) {
        this.alle = alle;
        this.num = num;
        this.date = date;
        this.arbitre = arbitre;
        this.equipe = equipe;
        confrontation = new ArrayList();

    }

    public void addConfrontation(Equipe e1, Equipe e2) {
        Arbitre tmp = getArbitre(e1,e2);
        try {
            confrontation.add(new Confrontation(e1, e2, tmp));//confrontation=2equipes: arbitre
            System.out.println(e1 + " VS " + e2 + ", arbitre :" + tmp + " le : " + date);
            tmp.AjoutDate(date);
        } catch (Exception e) {
            System.out.println("Création de match impossible");
        }
    }

    private Arbitre getArbitre(Equipe e1, Equipe e2) {
        for (Arbitre arbitre1 : arbitre) {
            //parcours de tous les arbitres
            ArrayList<Date> calendrier = arbitre1.getCalendrier();
            if (!arbitre1.getPays().equals(e2.getPays()) || !arbitre1.getPays().equals(e1.getPays())) {
                if (calendrier.isEmpty()) {
                    return arbitre1;
                } else {
                    boolean tmp = true;
                    for (Date calendrier1 : calendrier) {
                        //parcours du calendrier de chaques arbitres
                        if (calendrier1.compareTo(this.date) != 0) {
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
        return "Journee{" + "num=" + num + ", date=" + date + ", arbitre=" + arbitre + ", equipe=" + equipe + ", confrontation=" + confrontation + '}';
    }

}
