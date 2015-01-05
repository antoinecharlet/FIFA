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
        poule = new Poule(initEquipe(),arbitre);
    }

    private ArrayList<Equipe> initEquipe() {//fonction qui recuper les donnée de la BD
        ArrayList<Equipe> tmp = new ArrayList();
        
        
        return tmp;
    }

    private ArrayList<Arbitre> initArbitre(){
        ArrayList<Arbitre> tmp=new ArrayList();
        
        try {
            Statement st = ConnexionBD.getConnexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM 'arbitre'");
            while (rs.next()) {
                String nom=rs.getString("nom");//recuperer le nom
                String prenom=rs.getString("prenom");//recuperer le prenom
                int id=rs.getInt("id");
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
