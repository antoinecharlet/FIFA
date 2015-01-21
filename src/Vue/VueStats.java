/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.Coupe;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author antoine
 */
public class VueStats extends JInternalFrame{
    Coupe c;
    private JButton valider;
    private JScrollPane scrollPane;

    public VueStats(Coupe c) {
        this.c = c;
        this.setTitle("Stats Equipe");
        init();
    }
    
    /**
     * initialisation
     */
    private void init(){
        
    }
}
