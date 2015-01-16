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
 * @author Olivier
 */
public class Equipe implements java.lang.Comparable {

    private final String nom;
    private int point;
    private int nbButPour, nbButContre;
    private final String pays;
    private ArrayList<Match> match;

    public Equipe(String nom, String pays) {
        this.match = new ArrayList();
        this.nom = nom;
        point = 0;
        this.pays = pays.toUpperCase();
        nbButPour = nbButContre = 0;
    }

    /**
     * Verifie la disponibiliré d'une equipe.
     *
     * @param date date a verifier.
     *
     * @return true si l'equipe est disponible;
     */
    boolean dispo(Date date) {
        boolean tmp = true;
        for (int i = 0; i < match.size(); i++) {
            if (date.compareTo(match.get(i).getDate()) == 0) {
                tmp = false;
            }
        }
        return tmp;
    }

    /**
     * Mise a jour du score d'un match pour cette equipe.
     *
     * @param e equipe joué.
     * @param victoire1 victoire ,2 null,0 defaite
     * @param nbBut nombre de but marqué
     * @param nbButContre
     */
    public void setMatch(Equipe e, int victoire, int nbBut, int nbButContre) {
        match.get(match.indexOf(e) + 1).setVictoire(victoire);
        match.get(match.indexOf(e) + 1).setButPour(nbBut);
        match.get(match.indexOf(e) + 1).setButContre(nbButContre);
        if (victoire == 1) {//si victoire
            this.point += 3;
        } else if (victoire == 2) {//si null
            this.point += 1;
        } else {//si defaite
            this.point += 0;
        }
        this.nbButPour += nbBut;//maj des buts
        this.nbButContre += nbButContre;
    }

    /**
     * Ajout d'un match pour cette equipe.
     *
     * @param date data du match.
     * @param equipe equipe a jouer
     * @param domicil true si domicil
     *
     */
    public void ajoutMatch(Equipe equipe, Date date, boolean dom) {
        match.add(new Match(equipe, date));
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNbButPour() {
        return nbButPour;
    }

    public int getNbButContre() {
        return nbButContre;
    }

    public ArrayList<Match> getMatch() {
        return match;
    }

    public void setNbButPour(int nbBut) {
        this.nbButPour = nbBut;
    }

    public void setNbButContre(int nbButContre) {
        this.nbButContre = nbButContre;
    }

    public int getPoint() {
        return point;
    }

    public int getDiffBut() {
        return nbButPour - nbButContre;
    }

    public String getNom() {
        return nom;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public int compareTo(Object t) {
        //retourne -1 si meilleur classmeent,0identique,1en dessous
        Equipe tmp = (Equipe) t;
        if (this.point > tmp.point) {
            return -1;
        } else if (this.point < tmp.point) {
            return 1;
        } else {
            if (this.getDiffBut() > tmp.getDiffBut()) {
                return -1;
            } else if (this.getDiffBut() < tmp.getDiffBut()) {
                return 1;
            } else {
                if (this.nbButPour > tmp.nbButPour) {
                    return -1;
                } else if (this.nbButPour < tmp.nbButPour) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public class Match {

        private int butPour = -1;
        private int butContre = -1;
        private Equipe equipe;
        private Date date;
        private int victoire = -1;//1 : vicotire 
        //0 defaite
        //2 null

        public Match(Equipe equipe, Date date) {
            this.equipe = equipe;
            this.date = date;
        }

        public int getButPour() {
            return butPour;
        }

        public int getButContre() {
            return butContre;
        }

        public int getVictoire() {
            return victoire;
        }

        public void setButPour(int butPour) {
            this.butPour = butPour;
        }

        public void setButContre(int butContre) {
            this.butContre = butContre;
        }

        public void setVictoire(int victoire) {
            this.victoire = victoire;
        }

        public Equipe getEquipe() {
            return equipe;
        }

        public Date getDate() {
            return date;
        }

    }

}
