package com.axitech.dao.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.axitech.dao.DataBase;
import com.axitech.dao.entities.Employer;

public class EmployerRepository {

    private final DataBase db;

    public EmployerRepository() throws ClassNotFoundException {
        this.db = new DataBase();
    }

    public void save(Employer employer) {

        String sql = "INSERT INTO employer(nom, prenom, email) VALUES (?, ?, ?)";

        try (Connection connection = db.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employer.getNom());
            ps.setString(2, employer.getPrenom());
            ps.setString(3, employer.getEmail());

            ps.executeUpdate();

            System.out.println("Employer enregistré avec succès.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employer> findAll() {

        List<Employer> employers = new ArrayList<>();

        String sql = "SELECT * FROM employer";

        try (Connection connection = db.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Employer employer = new Employer();

                employer.setId(rs.getInt("id"));
                employer.setNom(rs.getString("nom"));
                employer.setPrenom(rs.getString("prenom"));
                employer.setEmail(rs.getString("email"));

                employers.add(employer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employers;
    }
}