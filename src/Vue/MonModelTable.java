/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brice.effantin
 */
public class MonModelTable extends DefaultTableModel {

    public class Ligne {

        private final String nom;
        private final int point;
        private final int butPour;
        private final int butContre;
        private final int diffBut;

        public Ligne(String nom, int point, int butPour, int butContre) {
            this.nom = nom;
            this.point = point;
            this.butPour = butPour;
            this.butContre = butContre;
            this.diffBut = butPour - butContre;
        }

    }

    private String[] entetes = {"Classement", "Nom", "Point", "butPour", "butContre", "DiffBut"};
    private ArrayList<Ligne> liste = new ArrayList();

    public MonModelTable() {
        super();
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public int getRowCount() {
        try {
            return liste.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int column) {
        return entetes[column];
    }
/**
 * ajouter une ligne dans le tableau
 * @param nom nom
 * @param point point
 * @param nbButPour But pour
 * @param nbButContre But contre
 */
    public void addLigne(String nom,int point, int nbButPour, int nbButContre) {
        addLigne(new Ligne(nom,point,nbButPour,nbButContre));
    }

    private void addLigne(Ligne l) {
        liste.add(l);
        fireTableRowsInserted(liste.size() - 1, liste.size() - 1);
    }
/**
 * supression de la ligne 
 * @param index index de la ligne a suprimmer
 */
    public void removeLigne(int index) {
        liste.remove(index);
        fireTableRowsDeleted(index, index);
    }
}
