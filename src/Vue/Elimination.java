/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.Duel;
import fifa.EliminationDirect;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author antoine
 */
public class Elimination extends JFrame {

    EliminationDirect elim;

    public Elimination(EliminationDirect elim) {
        this.elim = elim;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        JPanel pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        for (int t = 0; t < elim.getTour().size(); t++) {
            int i=0;
            for (Duel duel : elim.getTour().get(t).getDuel()) {
                cont.gridx = t*1;
                cont.gridy = i*1;
                pano.add(new VueMatch(duel), cont);
                i++;
            }
        }
        this.setContentPane(pano);
        this.pack();

    }
}
