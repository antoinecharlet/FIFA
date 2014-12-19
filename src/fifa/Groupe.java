/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;

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
        boolean joue[][]= new boolean[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                joue[i][j] = j==i;
            }
        }
                
        for(int i=0;i<8;i++){
            
        }
    }
}
