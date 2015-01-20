/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.Coupe;
import fifa.Duel;
import fifa.EliminationDirect;
import fifa.Equipe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antoine
 */
public abstract class VueCoupe extends JInternalFrame {

    private final Coupe c;
    protected JTable table;
    private int numGrp = 0;
    protected JLabel grp = new JLabel("Num grp: " + (numGrp + 1));
    protected JButton last, next, simulation;

    public VueCoupe(Coupe c) {
        this.c = c;
        this.setVisible(true);
        this.initButton();
    }

    /**
     * initialisation des buttons
     */
    private void initButton() {
        last = new JButton("Precedent");
        next = new JButton("Suivant");
        simulation = new JButton("Simulation Matchs");
        this.last.addActionListener((ActionEvent ae) -> {
            if (this.numGrp > 0) {
                numGrp--;
                this.grp.setText("Num grp :" + (numGrp + 1));
                init();
                this.pack();
                this.setVisible(true);
            }

        });

        this.next.addActionListener((ActionEvent ae) -> {
            if (this.numGrp < c.getPoule().getGroupe().size() - 1) {
                numGrp++;
                this.grp.setText("Num grp :" + (numGrp + 1));
                init();
                this.pack();
                this.setVisible(true);
            }
        });
        this.simulation.addActionListener((ActionEvent ae) -> {
            if (simulation.getText().equals("Simulation Matchs")) {
                c.simulationPoule();
                init();
                this.pack();
                this.setVisible(true);
                simulation.setText("Jouer Tour");
            } else if(c.getElimination().getEquipe().size()>1){
                c.simulTour();
                initTour();
                this.pack();
                this.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(this,
                "Le gagnant est "+c.getElimination().getEquipe().get(0),
                "Inane error",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
/**
 * initialisation de l'affichage des tour 
 */
    private void initTour() {
        EliminationDirect elim = c.getElimination();
        JPanel pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        JLabel tour=new JLabel();
        for (int t = 0; t < elim.getTour().size(); t++) {
            int i = 1;
            for (Duel duel : elim.getTour().get(t).getDuel()) {
                cont.gridx = t;
                cont.gridy = i;
                pano.add(new VueMatch(duel), cont);
                i++;
            }
        }
        cont.gridy=0;
        cont.gridx=0;
        cont.gridwidth=elim.getTour().size();
        pano.add(this.simulation,cont);
        
        this.setContentPane(pano);
    }

    /**
     * initialisation du tableau des equipes et classement
     *
     * @return tableau du classement
     */
    JTable initTable() {

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

    /**
     * initialisation
     */
    abstract
            void init();

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
