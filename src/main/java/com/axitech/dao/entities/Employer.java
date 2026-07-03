package com.axitech.dao.entities;

import java.util.List;

public class Employer extends Personne { 
    private String email;
    private List<TypeConges> typeConges;

    
    public Employer() {
    }
    
    public Employer(String email, List<TypeConges> typeConges) {
        this.email = email;
        this.typeConges = typeConges;
    }
    public Employer(int id, String nom, String prenom, String email, List<TypeConges> typeConges) {
        super(id, nom, prenom);
        this.email = email;
        this.typeConges = typeConges;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<TypeConges> getTypeConges() {
        return typeConges;
    }
    public void setTypeConges(List<TypeConges> typeConges) {
        this.typeConges = typeConges;
    }

    

}
