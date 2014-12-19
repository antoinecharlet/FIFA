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
    private Confrontation confrontation=null;

    Journee(ArrayList<Arbitre> arbitre,int num,boolean alle,Date date,ArrayList<Equipe> equipe) {
        this.alle=alle;
        this.num=num;
        this.date=date;
        this.arbitre=arbitre;
        initConfrontation(); 
    }
    private void initConfrontation(){
        ArrayList<Date> calendrierArbitre; 
        for(int i=0;i<arbitre.size();i++){//parcours chaque arbitre
            calendrierArbitre= arbitre.get(i).getCalendrier();
            for(int j=0;j<calendrierArbitre.size();j++){//parcours matchs des arbitres
                if(calendrierArbitre.get(j)!=date && arbitre.get(i).getPays()!=)
            }
        }
        confrontation=new Confrontation(domicil,exterieur,);
    }
}
