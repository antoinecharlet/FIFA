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
class Groupe {

    private int num;
    private ArrayList<Equipe> equipe;
    private Journee[] match;
    private ArrayList<Arbitre> arbitre;
    Date date = new Date(2015, 9, 15);

    /**
     * Ajouter d'un groupe
     *
     * @paramarbitre liste des arbitres
     * @param num numero de groupe
     * @param equipe equipe du groupe
     *
     */
    public Groupe(ArrayList<Arbitre> arbitre, int num, ArrayList<Equipe> equipe) {
        this.num = num;
        this.equipe = equipe;
        match = new Journee[(equipe.size()) * 2];
        this.arbitre = arbitre;
        initJournee();
    }

    /**
     * Initialisation des rencontres
     *
     */
    private void initJournee() {
        System.out.println("  ");
        boolean[][] tmp = initTab();//tableau 2d qui met a true les matchs joués entre deux equipes
        for (int i = 0; i < equipe.size(); i++) {//match allé  
            if (i % 2 == 1) {
                date = ajouterJour(date, 7);
            }
            match[i] = new Journee(arbitre, i, true, date);
            for (int j = 0; j < tmp.length; j++) {
                for (int k = 0; k < tmp.length; k++) {
                    if (!tmp[j][k] && equipe.get(j).dispo(date) && equipe.get(k).dispo(date)) {//si match non joué
                        match[i].addConfrontation(equipe.get(j), equipe.get(k));//ajout confontation
                        equipe.get(j).ajoutMatch(equipe.get(k), date, true);
                        equipe.get(k).ajoutMatch(equipe.get(j), date, false);
                        tmp[j][k] = true;
                        tmp[k][j] = true;
                    }
                }
            }

        }System.out.println("match retour");
        for (int i = 0; i < equipe.size(); i++) {// match retour 
            if (i % 2 == 1) {
                date = ajouterJour(date, 7);
            }
            match[i + 3] = new Journee(arbitre, i, false, date);
            ArrayList<Confrontation> confron = match[3-i].getConfrontation();
            //System.out.println(confron.size());
            for (int j = 0; j < confron.size(); j++) {
                match[i+3].addConfrontation(confron.get(j).getEquipeExt(), confron.get(j).getEquipeDom());
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
     * initialisation du tableau : true pour les equipe ayant deja joué l'une
     * contre l'autre.
     *
     */
    private boolean[][] initTab() {
        boolean tmp[][] = new boolean[equipe.size()][equipe.size()];
        for (int i = 0; i < equipe.size(); i++) {
            for (int j = 0; j < equipe.size(); j++) {
                tmp[i][j] = i == j;
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < equipe.size(); i++) {
            tmp = tmp + " " + equipe.get(i).getNom();
        }
        return "Groupe " + num + ", equipe=" + equipe + '}';
    }

}
