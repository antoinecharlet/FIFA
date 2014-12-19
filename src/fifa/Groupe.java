/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author antoine
 */
class Groupe {
    private int num;
    private Equipe[] equipe;
    private Journee[] match;

    public Groupe(int num,Equipe[] equipe) {
        this.num = num;
        this.equipe = equipe;
        match=new Journee[8];
        initJournee();
    }
    
    private void initJournee(){
        for(int i=0;i<4;i++){
            //match[i]=new Journee(i,true,new Date(Calendar.getInstance().getTime().getYear())); //int num,boolean alle,Date date,Equipe domicil,Equipe exterieur
            
        }
    }
}
