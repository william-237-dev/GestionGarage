package com.axitech.controller;

import java.sql.Connection;
import java.util.List;

import com.axitech.dao.DataBase;
import com.axitech.dao.entities.Employer;
import com.axitech.dao.repository.EmployerRepository;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/employer/*")
public class EmployerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployerRepository employerRepository;

    public EmployerController() throws ClassNotFoundException {
        this.employerRepository = new EmployerRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws jakarta.servlet.ServletException, java.io.IOException {
        // Handle GET requests for /employer/*
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            request.getRequestDispatcher("/form.html").forward(request, response);
        } else {
            response.getWriter().write("GET request received for /employer/*");
        }
        List<Employer> employers = employerRepository.findAll();

        response.getWriter().write("Bienvenue chez axitech"+"\nListe des employeurs :\n");
        for (Employer employer : employers) {
            response.getWriter().write(employer.getNom() + " " + employer.getPrenom() + " - " + employer.getEmail() + "\n");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws jakarta.servlet.ServletException, java.io.IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        Employer employer = new Employer();
        
        employer.setNom(nom);
        employer.setPrenom(prenom);
        employer.setEmail(email);

        employerRepository.save(employer);

        response.getWriter().write("POST request received for /employer/*");
    }
    
    

}
