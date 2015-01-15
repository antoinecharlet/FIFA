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
public class Equipe {

    private final String nom;
    private int point;
    private int nbBut;
    private final String pays;
    private ArrayList<Match> match;

    public Equipe(String nom, String pays) {
        this.match = new ArrayList();
        this.nom = nom;
        point = 0;
        this.pays = pays.toUpperCase();
        nbBut = 0;
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
        return nom;
    }

    public class Match {

        Equipe equipe;
        Date date;

        public Match(Equipe equipe, Date date) {
            this.equipe = equipe;
            this.date = date;
        }

        public Equipe getEquipe() {
            return equipe;
        }

        public Date getDate() {
            return date;
        }

    }

}
