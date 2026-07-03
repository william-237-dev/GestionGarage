package com.axitech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    
    // On retire la variable d'instance 'connection' globale
    private final String url = "jdbc:mysql://mysql:3306/gestion_garage";
    private final String username = "root";
    private final String password = "Q1W2E3R4T5Y6";

    public DataBase() throws ClassNotFoundException {
        // Le constructeur ne sert plus qu'à charger le pilote une seule fois
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * Cette méthode doit OBLIGATOIREMENT ouvrir une nouvelle connexion à chaque appel.
     * C'est le try-with-resources de ton Repository qui se chargera de la fermer proprement.
     */
    public Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion à la base de données réussie.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ouverture de la connexion JDBC : " + e.getMessage());
            throw e; // On propage l'exception pour que le Repository soit au courant en cas de crash
        }
    }
}