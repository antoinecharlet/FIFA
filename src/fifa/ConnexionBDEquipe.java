/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author antoine
 */
public class ConnexionBDEquipe {
     private static Connection connect = null;
/**
 * connection a la Bd 
 */
    private ConnexionBDEquipe() {
        if (connect == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                //on r�cup�re le nom de la bd dans le fichier nomBD.txt
                connect = DriverManager.getConnection("jdbc:sqlite:FootBase.sqlite");
            } catch (Exception ex) {
                connect = null;
                System.err.println(ex.getMessage());
            }
        }
    }
/**
 * 
 * @return la connextion
 */
    public static Connection getConnexion() {
        if (connect==null){
            new ConnexionBDEquipe();
            System.out.println("Connexion etablie");
        }
        //else
            //System.out.println("Connexion deja existante");
        return connect;
    }
}
