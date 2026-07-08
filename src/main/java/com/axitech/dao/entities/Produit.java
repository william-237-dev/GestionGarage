package com.axitech.dao.entities;

public class Produit {
    private String id;
    private String designation;
    private double prix ;

    public Produit() {
    }

    public Produit(String id, String designation, double prix) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    

    

}
