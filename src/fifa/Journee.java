/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.Date;

/**
 *
 * @author antoine
 */
public class Journee {
    private final int num;
    private final Date date;
    private final boolean alle;
    private final Confrontation confrontation;

    Journee(int num,boolean alle,Date date,Equipe domicil,Equipe exterieur) {
        this.alle=alle;
        this.num=num;
        this.date=date;
        confrontation=new Confrontation(domicil,exterieur);
    }
    
}
