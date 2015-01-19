/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.Coupe;
import fifa.Equipe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antoine
 */
public class test extends JFrame {

    private Coupe c;
    private JTable table;
    private int numGrp;
/**
 * 
 * @param c coupe
 */
    public test(Coupe c) {
        this.c = c;
        table = initab();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }
/**
 * 
 * @return Jtable du classement
 */
    JTable initab() {
        ArrayList<Equipe> equipe;
        equipe = c.getPoule().getGroupe().get(numGrp).getEquipe();
        Collections.sort(equipe);
        Object[][] o = new Object[4][7];
        for (int i = 0; i < 4; i++) {
            o[i][0] = i + 1;
            o[i][1] = equipe.get(i).getNom();
            o[i][2] = equipe.get(i).getPoint();
            o[i][3] = equipe.get(i).getNbButPour();
            o[i][4] = equipe.get(i).getNbButContre();
            o[i][5] = equipe.get(i).getDiffBut();
            o[i][6] = equipe.get(i).getPays();

        }
        String[] title = {"classement", "nom", "point", "BP", "BC", "Diff", "PAYS"};
        return new TableM(o, title);
    }

    public class EcouteurNext implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (numGrp < c.getPoule().getGroupe().size()-1) {
                numGrp++;
            }
            table = initab();
            init();
        }
    }
    
    public class EcouteurLast implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (numGrp > 0) {
                numGrp--;
            }
            table = initab();
            init();
        }
    }
/**
 * initialisation de la vue
 */
    void init() {
        JScrollPane scroll = new JScrollPane(table);
        JPanel pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;

        

        JButton next = new JButton("next");
        next.addActionListener(new EcouteurNext());
        cont.gridy = 1;
        cont.gridx=1;
        pano.add(next, cont);
        
        JButton last = new JButton("last");
        last.addActionListener(new EcouteurLast());
        cont.gridy = 1;
        cont.gridx=0;
        pano.add(last, cont);
        
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth=2;
        pano.add(scroll, cont);

        this.setContentPane(pano);
        this.pack();
    }

    public class TableM extends JTable {

        public TableM() {
        }

        public TableM(Object[][] o, String[] s) {
            super(new DefaultTableModel(o, s));
        }

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    }

}
