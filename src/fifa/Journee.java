/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author antoine
 */
public class Journee {

    private final int num;
    private final Date date;
    private final boolean alle;
    private final ArrayList<Arbitre> arbitre;
    private final ArrayList<Confrontation> confrontation;

    /**
     * Ajouter journée.
     *
     * @param date date de journée
     * @param arbitre liste des arbitres
     * @param num numero de journée
     * @param alle true si les matchs sont "allés"
     *
     */
    Journee(ArrayList<Arbitre> arbitre, int num, boolean alle, Date date) {
        this.alle = alle;
        this.num = num;
        this.date = date;
        this.arbitre = arbitre;
        this.confrontation = new ArrayList();
    }

    /**
     * Ajouter confrontation.
     *
     * @param e1 Equipe domicil.
     * @param e2 Equipe exterieur
     *
     */
    public void addConfrontation(Equipe e1, Equipe e2) {
        Arbitre tmp = getArbitre(e1, e2);
        try {
            confrontation.add(new Confrontation(e1, e2, tmp));//confrontation=2equipes: arbitre
            System.out.println(e1 + " VS " + e2 + ", arbitre :" + tmp + " le : " + date);
            arbitre.get(arbitre.indexOf(tmp)).AjoutDate(date);//ajout du match au calendrier arbitre
        } catch (Exception e) {
            System.out.println("Création de match impossible");
        }
    }

    public ArrayList<Confrontation> getConfrontation() {
        return confrontation;
    }

    /**
     * Recherche un arbitre disponible pour cette rencontre
     *
     * @param e1 equipe dom
     * @param e2 equipe ext
     *
     * @return  Arbitre disponible
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
        return "Journee{" + "num=" + num + ", date=" + date + ", arbitre=" + arbitre + ", confrontation=" + confrontation + '}';
    }

}
