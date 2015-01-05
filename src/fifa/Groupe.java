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
    Date date = new Date(2014, 9, 15);

    public Groupe(ArrayList<Arbitre> arbitre, int num, ArrayList<Equipe> equipe) {
        this.num = num;    
            this.equipe=equipe;
        match = new Journee[(equipe.size() - 1) * 2];
        this.arbitre = arbitre;
        initJournee();
    }

    public String get(){
        return match[0].toString();
    }
    private void initJournee() {
        boolean[][] tmp = initTab();//tableau 2d qui met a true les matchs joués entre deux equipes
        for (int i = 0; i < equipe.size() - 1; i++) {//match allé
            date=date;
            match[i] = new Journee(arbitre, i, true, date, equipe); //
            for (int j = 0; j < tmp.length; j++) {
                for (int k = 0; k < tmp.length; k++) {
                    if (!tmp[i][j]) {//si match non joué
                        match[i].addConfrontation(equipe.get(i), equipe.get(j));//ajout confontation
                        tmp[i][j]=true;
                        tmp[j][i]=true;
                    }
                }
            }

        }
        
    }

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
        String tmp="";
        for(int i =0;i<equipe.size();i++){
            tmp=tmp+" "+equipe.get(i).getNom();
        }
        return "Groupe{" + "num=" + num + ", equipe=" + equipe +'}';
    }
    
    
}
