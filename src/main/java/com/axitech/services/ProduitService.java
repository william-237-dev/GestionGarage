package com.axitech.services;

import java.util.List;

import com.axitech.dao.entities.Produit;
import com.axitech.dao.repository.ProduitRepository;

public class ProduitService {
// controle et ajout dans la base
   private ProduitRepository produitRepository;

   

  public ProduitService() {
    try {
      produitRepository = new ProduitRepository();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


  //fonctionnalite

  public String ajouterProduit(Produit produit){
    // avant d'ajouter un produit 
    double  prix = produit.getPrix();
    if (prix <0){
        return "le prix doit avoir une valeur positive";
    }else{
        produitRepository.saveProduct(produit);
        return "ajout effectuer avec succes";
    }
  }
    public List<Produit> listeProduits() {
        return produitRepository.getAllProducts();
    }

}
