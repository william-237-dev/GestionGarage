package com.axitech.controller;

import java.io.IOException;
import java.util.List;

import com.axitech.dao.entities.Produit;
import com.axitech.services.ProduitService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/produit")
public class ProduitController extends HttpServlet{

    private ProduitService produitService = new ProduitService();
    

    public ProduitController() {
        
    }

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
     req.getRequestDispatcher("/formproduit.html").forward(req, resp);
     
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String designation = req.getParameter("designation");
    double prix = Double.parseDouble(req.getParameter("prix"));

    Produit produit = new Produit();
    produit.setDesignation(designation);
    produit.setPrix(prix);

    produitService.ajouterProduit(produit);

    resp.sendRedirect(req.getContextPath() + "/produit");
}


}
