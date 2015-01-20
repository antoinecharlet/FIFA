/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author antoine
 */
public class Acceuil extends JInternalFrame{

    public Acceuil() {
        this.add(new JLabel(new ImageIcon("FIFA.png")));
        this.setVisible(true);
        this.pack();
    }
    
}
