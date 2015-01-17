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

    protected final int num;
    protected  Date date;
    protected final boolean alle;
    protected final ArrayList<Arbitre> arbitre;
    protected final ArrayList<Confrontation> confrontation;

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
            arbitre.get(arbitre.indexOf(tmp)).AjoutDate(date);//ajout du match au calendrier arbitre
        } catch (Exception e) {
            System.out.println("Création de match impossible");
        }
    }

    public ArrayList<Confrontation> getConfrontation() {
        return confrontation;
    }

    /**
     * simulation des rencontres
     *
     */
    public void simulation() {
        //parcours des confrontation
        for (Confrontation confron1 : confrontation) {
            //les buts sont gnéré (random)
            int nbButDom = (int) (Math.random() * 3);
            int nbButExt = (int) (Math.random() * 3);
            confron1.setScore(nbButDom,nbButExt);
            if (nbButDom > nbButExt) {//mise a jour des matchs pour les équipes
                confron1.getEquipeDom().setMatch(confron1.getEquipeExt(), 1, nbButDom,nbButExt);
                confron1.getEquipeExt().setMatch(confron1.getEquipeDom(), 0, nbButExt,nbButDom);
            } else if (nbButExt > nbButDom) {
                confron1.getEquipeExt().setMatch(confron1.getEquipeDom(), 1, nbButExt,nbButDom);
                confron1.getEquipeDom().setMatch(confron1.getEquipeExt(), 0, nbButDom,nbButExt);
            }else {
                confron1.getEquipeExt().setMatch(confron1.getEquipeDom(), 2, nbButExt,nbButDom);
                confron1.getEquipeDom().setMatch(confron1.getEquipeExt(), 2, nbButDom,nbButExt);
            }
            System.out.println(confron1.getEquipeDom()+" "+nbButDom+" - "+nbButExt+" "+confron1.getEquipeExt());
        };
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
        return "Journee{" + "num=" + num + ", date=" + date + ", arbitre=" + arbitre + ", confrontation=" + confrontation + '}';
    }

}
