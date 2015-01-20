/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import Vue.Elimination;
import Vue.Fenetre;
import Vue.test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Olivier
 */
public class Fifa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coupe c=new C1();
        Fenetre fe=new Fenetre(c);
        fe.setVisible(true);
//        
//        c.simulationPoule();
//        c.simulTour();
//        c.simulTour();
//        c.simulTour();
//        test nt=new test(c);
//        Elimination  t=new Elimination(c.getElimination());
//        t.setVisible(true);
//        nt.setVisible(true);
    }

}
