/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olivier
 */
public abstract class Coupe {

    Poule poule;
    ArrayList<Arbitre> arbitre;
    EliminationDirect elimination;
    ArrayList<Equipe> equipe = new ArrayList();
    final int annee;

    public EliminationDirect getElimination() {
        return elimination;
    }

    /**
     *
     * @param nom nomEquipe
     * @param pays paysEquipe
     */
    public void ajoutEquipe(String nom, String pays){
        equipe.add(new Equipe(nom,pays));
    }

    public ArrayList<Arbitre> getArbitre() {
        return arbitre;
    }

    public ArrayList<Equipe> getEquipe() {
        return equipe;
    }

    /**
     *
     * @param id identifiant
     * @param nom nom
     * @param prenom prenom
     * @param pays pays
     */
    public void AjoutArbitre(String id, String nom, String prenom, String pays) {
        arbitre.add(new Arbitre(Integer.parseInt(id), nom, prenom, pays));
    }

    /**
     *
     */
    public Coupe() {
        this.annee = getAnnee();
        arbitre = initArbitre();
        System.out.println(arbitre.size());
        poule = new Poule(initEquipe(), arbitre);
    }

    /**
     * Initialisation des equipe depuis le BD
     */
    abstract ArrayList<Equipe> initEquipe();
    /**
     * simulation des matchs de poules et mise a jour des match de qualification
     */
    public abstract void simulationPoule();

    public Poule getPoule() {
        return poule;
    }

    /**
     * Simulation d'un tour de coupe
     */
    public void simulTour() {
        this.elimination.simulationTour();
    }

    /**
     * Initialisation depuis la BD des arbitres
     */
    private ArrayList<Arbitre> initArbitre() {
        ArrayList<Arbitre> tmp = new ArrayList();

        try {
            Statement st = ConnexionBDarbitre.getConnexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM 'arbitre'");
            while (rs.next()) {
                String nom = rs.getString("nom");//recuperer le nom
                String prenom = rs.getString("prenom");//recuperer le prenom
                int id = rs.getInt("arbitre_id");
                String pays = rs.getString("pays");
                pays.toUpperCase();
                tmp.add(new Arbitre(id, nom, prenom, pays));
            }
        } catch (Exception ex) {
            return tmp;
        }

        return tmp;
    }

    /**
     * Recuperer l'anné actuel
     *
     * @return l'année actuel;
     */
    private int getAnnee() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String dateStr = simpleDateFormat.format(new Date());
        return Integer.parseInt(dateStr);
    }
}
