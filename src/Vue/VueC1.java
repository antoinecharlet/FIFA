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
import javax.swing.JScrollPane;

/**
 *
 * @author antoine
 */
public class VueC1 extends VueCoupe {

    
    public VueC1(Coupe c) {
        super(c);
        init();
    }

    @Override
    void init() {
        this.setTitle("Coupe C1");
        JPanel pano = new JPanel();

        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        table=initTable();
        
        
        cont.gridx=1;
        cont.gridy=1;
        pano.add(next,cont);
        
        cont.gridx=0;
        cont.gridy=1;
        pano.add(last,cont);
        
        cont.gridx=0;
        cont.gridy=2;
        pano.add(grp,cont);
        
        cont.gridx=1;
        cont.gridy=2;
        pano.add(this.simulation,cont);
        
        JScrollPane scroll=new JScrollPane(table);
        cont.gridx=0;
        cont.gridy=0;
        cont.gridwidth=2;
        pano.add(scroll,cont);
        
        
        
        this.setContentPane(pano);
        this.pack();
    }

}
