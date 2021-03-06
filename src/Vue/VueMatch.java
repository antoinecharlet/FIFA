/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import fifa.Duel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

/**
 *
 * @author antoine
 */
public class VueMatch extends javax.swing.JPanel {

    Duel duel;

    /**
     * 
     * @param duel envoie le duel a acheter
     */
    public VueMatch(Duel duel) {
        this.duel=duel;
        this.setBorder(new TitledBorder(""));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        E1 = new javax.swing.JLabel();
        E2 = new javax.swing.JLabel();
        score1 = new javax.swing.JLabel();
        score2 = new javax.swing.JLabel();

        E1.setText(duel.getE1().getNom()+": ");

        E2.setText(duel.getE2().getNom()+": ");

        int tmp=duel.getC1().getScoreDom()+duel.getC2().getScoreExt();
        String text;
        if(tmp>=0){
            text=String.valueOf(tmp)+" ("+duel.getC1().getScoreDom()+")";
            if(duel.getGagnant().equals(duel.getE1())){
                score1.setForeground(new Color(0,255,0));
            }else
            score1.setForeground(new Color(255,0,0));
        }else
        text=" - ";
        score1.setText(text);

        tmp=duel.getC2().getScoreDom()+duel.getC1().getScoreExt();
        if(tmp>=0){
            text=String.valueOf(tmp)+" ("+duel.getC1().getScoreExt()+")";
            if(duel.getGagnant().equals(duel.getE2()))
            score2.setForeground(new Color(0,255,0));
            else
            score2.setForeground(new Color(255,0,0));
        }else
        text=" - ";
        score2.setText(text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(E1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(E2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E1)
                    .addComponent(score1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E2)
                    .addComponent(score2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel E1;
    private javax.swing.JLabel E2;
    private javax.swing.JLabel score1;
    private javax.swing.JLabel score2;
    // End of variables declaration//GEN-END:variables
}
