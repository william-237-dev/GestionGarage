package com.axitech.dao.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.axitech.dao.DataBase;
import com.axitech.dao.entities.Produit;

public class ProduitRepository {

     private DataBase db;

     public ProduitRepository() throws ClassNotFoundException {
        this.db = new DataBase();
     }

     // methode pour ajouter un produit a la bd

     public void saveProduct(Produit produit){
        Connection connect;
        try {
            String id = UUID.randomUUID().toString();
            connect = db.getConnection();
            String sql = "INSERT INTO produit VALUE(?,?,?)";
        PreparedStatement pStatement = connect.prepareStatement(sql);
        // chargement des parametre
        pStatement.setString(1, id);
        pStatement.setString(2, produit.getDesignation());
        pStatement.setDouble(3, produit.getPrix());
        // excecute
        int val =pStatement.executeUpdate();
        System.out.println("excecution de la methode save");
        System.out.println("succes");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
     }

     public List<Produit> getAllProducts() {

    List<Produit> produits = new ArrayList<>();

    try {
        Connection connect = db.getConnection();

        String sql = "SELECT * FROM produit";

        PreparedStatement pStatement = connect.prepareStatement(sql);

        ResultSet rs = pStatement.executeQuery();

        while (rs.next()) {

            Produit produit = new Produit();

            produit.setId(rs.getString("id"));
            produit.setDesignation(rs.getString("designation"));
            produit.setPrix(rs.getDouble("prix"));

            produits.add(produit);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return produits;
}

     




}
