/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Control.Control;
import fifa.Coupe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author antoine
 */
public class AjoutArbitre extends JInternalFrame implements ActionListener {

    private Coupe c;
    private JTextField txtNom, txtPays,txtPrenom,txtId;
    private JLabel nom, pays,prenom,id;
    private JButton button;

    public AjoutArbitre(Coupe c) {
        this.c = c;
        init();
        this.setVisible(true);
    }
/**
 * initialisation des bouttons
 */
    private void init() {
        txtNom = new JTextField("");
        txtNom.setColumns(20);

        txtPays = new JTextField("");
        txtPays.setColumns(20);

        txtPrenom = new JTextField("");
        txtPrenom.setColumns(20);
        
        txtId = new JTextField("");
        txtId.setColumns(20);
        
        button = new JButton("Valider");
        button.addActionListener(this);

        nom = new JLabel("Nom: ");
        pays = new JLabel("Pays: ");
        id=new JLabel("identifiant: ");
        prenom=new JLabel("Prenom: ");

        JPanel pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;

        cont.gridx = 0;
        cont.gridy = 0;
        pano.add(nom, cont);

        cont.gridy = 1;
        pano.add(txtNom, cont);
        
        cont.gridy = 2;
        pano.add(prenom, cont);

        cont.gridy = 3;
        pano.add(txtPrenom, cont);

        cont.gridy = 4;
        pano.add(pays, cont);

        cont.gridy = 5;
        pano.add(txtPays, cont);

        cont.gridy = 6;
        pano.add(button, cont);

        this.setContentPane(pano);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            Control.ajoutArbitre(c,txtPrenom.getText(),txtNom.getText(),txtPays.getText());
            txtNom.setText("");txtPays.setText("");txtPrenom.setText("");
        }
    }
}
