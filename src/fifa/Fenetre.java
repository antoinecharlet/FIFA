/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fifa;

import java.util.Calendar;

/**
 *
 * @author Olivier
 */
public class Fenetre {
    Coupe coupe;
    public Fenetre() {
        coupe=new C1();
        System.out.print(coupe.poule.groupe.get(1)+" "+coupe.poule.groupe.get(1).get());
    }
    
}
