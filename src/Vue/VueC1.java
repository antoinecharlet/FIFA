/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.Coupe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author antoine
 */
public class VueC1 extends VueCoupe {

    
    public VueC1(Coupe c) {
        super(c);
    }

    @Override
    void init() {
        this.setTitle("Coupe C1");
         JPanel pano = new JPanel();

        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        table=initTable();
        cont.gridx=0;
        cont.gridy=0;
        pano.add(table,cont);
        
        this.setContentPane(pano);
        this.pack();
    }

}
