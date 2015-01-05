/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Olivier
 */
public class Coupe {

    Poule poule;
    EliminationDirect elimination;
    Barrage barrage;
    ArrayList<Equipe> equipe;
    final int annee;

    public Coupe() {
        this.annee = getAnnee();
        poule = new Poule(initEquipe());
    }

    private ArrayList<Equipe> initEquipe() {//fonction qui recuper les donnée de la BD
        ArrayList<Equipe> tmp = new ArrayList();
        
        
        return tmp;
    }

    private int getAnnee() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String dateStr = simpleDateFormat.format(new Date());
        return Integer.parseInt(dateStr);
    }
}
