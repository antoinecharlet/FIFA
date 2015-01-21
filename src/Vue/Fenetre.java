/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.C1;
import fifa.C3;
import fifa.Coupe;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author antoine
 */
public class Fenetre extends JFrame implements ActionListener{
    private Coupe c;
    private C1 c1;
    private C3 c3;
    private JMenuBar menuBar;
    private JMenu edit,coupe,stats;
    private JMenuItem ajoutEquipe,ajoutArbitre,LancerC1,LancerC2,statequipe;
    private JInternalFrame fen=new Acceuil();

    public Fenetre(Coupe c) {
        this.c = c;
        c1=new C1();
        c3=new C3(c1);
        initMenu();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * initialisation du menu
     */
    private void initMenu(){
        
        this.setPreferredSize(new Dimension(700,700));
        this.add(fen);
        menuBar=new JMenuBar();
        edit=new JMenu("Edit");
        coupe=new JMenu("Coupe");
        this.stats=new JMenu("Stats");
        ajoutEquipe=new JMenuItem("Ajout Equipe");
        this.statequipe=new JMenuItem("Stats Equipe");
        ajoutArbitre=new JMenuItem("Ajout Arbitre");
        this.LancerC1=new JMenuItem("Lancer C1");
        this.LancerC2=new JMenuItem("Lancer C3");
        coupe.add(LancerC1);
        coupe.add(LancerC2);
        menuBar.add(coupe);
        edit.add(ajoutEquipe);
        edit.add(ajoutArbitre);
        menuBar.add(edit);
        stats.add(statequipe);
        menuBar.add(stats);
        this.setJMenuBar(menuBar);
        
        statequipe.addActionListener(this);
        ajoutEquipe.addActionListener(this);
        ajoutArbitre.addActionListener(this);
        this.LancerC1.addActionListener(this);
        this.LancerC2.addActionListener(this);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ajoutEquipe){
            this.remove(fen);
            this.fen=new AjoutEquipe(c);
            this.add(fen);
            this.pack();
            this.repaint();
        }else if(e.getSource()==ajoutArbitre){
            this.remove(fen);
            this.fen=new AjoutArbitre(c);
            this.add(fen);
            this.pack();
            this.repaint();
        }else if(e.getSource()==this.LancerC1){
            this.remove(fen);
            this.fen=new VueC1(c1);
            this.add(fen);
            this.pack();
            this.repaint();
        }else if(e.getSource()==this.LancerC2){
            this.remove(fen);
            this.fen=new VueC3(c3);
            this.add(fen);
            this.pack();
            this.repaint();
        }else if(e.getSource()==this.statequipe){
            this.pack();
            this.repaint();
        }
    }
}
