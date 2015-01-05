/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Olivier
 */
public class Coupe {

    Poule poule;
    ArrayList<Arbitre> arbitre;
    EliminationDirect elimination;
    Barrage barrage;
    ArrayList<Equipe> equipe;
    final int annee;

    public Coupe() {
        this.annee = getAnnee();
        arbitre=initArbitre();
        System.out.println(arbitre.size());
        poule = new Poule(initEquipe(),arbitre);
    }

    private ArrayList<Equipe> initEquipe() {//fonction qui recuper les donnée de la BD
        ArrayList<Equipe> tmp = new ArrayList();
        tmp.add(new Equipe("lapin","coucou"));
        tmp.add(new Equipe("lapin1","couc4ou"));
        tmp.add(new Equipe("lapin2","cou4cou"));
        tmp.add(new Equipe("lapin3","couco4u"));
        tmp.add(new Equipe("lapin4","coucou"));
        tmp.add(new Equipe("lapin5","coucou"));
        tmp.add(new Equipe("lapin6","coucou"));
        tmp.add(new Equipe("lapin7","coucou"));
        return tmp;
    }

    private ArrayList<Arbitre> initArbitre(){
        ArrayList<Arbitre> tmp=new ArrayList();
        
        try {
            Statement st = ConnexionBDarbitre.getConnexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM 'arbitre'");
            while (rs.next()) {
                String nom=rs.getString("nom");//recuperer le nom
                String prenom=rs.getString("prenom");//recuperer le prenom
                int id=rs.getInt("arbitre_id");
                String pays=rs.getString("pays");
                pays.toUpperCase();
                tmp.add(new Arbitre(id,nom,prenom,pays));
            }
        } catch (Exception ex) {
            return tmp;
        }
        
        return tmp;
    }
    
    private int getAnnee() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String dateStr = simpleDateFormat.format(new Date());
        return Integer.parseInt(dateStr);
    }
}
