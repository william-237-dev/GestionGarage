package com.axitech.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/somme")
public class Addition extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String number1 = req.getParameter("number1");
    String number2 = req.getParameter("number2");

    if (number1 == null || number2 == null) {

        req.getRequestDispatcher("/somme.html").forward(req, resp);

    } else {

        int n1 = Integer.parseInt(number1);
        int n2 = Integer.parseInt(number2);

        int somme = n1 + n2;

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String html = String.format("""
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Résultat</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary shadow">

<div class="container">

<span class="navbar-brand">
<i class="bi bi-calculator-fill"></i>
AXITECH
</span>

</div>

</nav>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow-lg border-0">

<div class="card-header bg-success text-white">

<h3 class="mb-0">

<i class="bi bi-check-circle-fill"></i>

Résultat du calcul

</h3>

</div>

<div class="card-body text-center">

<h1 class="display-4 text-primary">
%s
</h1>

<p class="lead">

La somme des deux nombres est de

<strong>%s</strong>

</p>

<hr>

<a href="/www.axitech.com/somme"
class="btn btn-primary">

<i class="bi bi-arrow-left-circle"></i>

Nouveau calcul

</a>

</div>

</div>

</div>

</div>

</div>

</body>

</html>
""", somme, somme);

        out.println(html);
    }
}
            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String number1 = req.getParameter("number1");
    String number2 = req.getParameter("number2");
        int n1 = Integer.parseInt(number1);
        int n2 = Integer.parseInt(number2);

        int somme = n1 + n2;

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String html = String.format("""
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Résultat</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary shadow">

<div class="container">

<span class="navbar-brand">
<i class="bi bi-calculator-fill"></i>
AXITECH
</span>

</div>

</nav>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow-lg border-0">

<div class="card-header bg-success text-white">

<h3 class="mb-0">

<i class="bi bi-check-circle-fill"></i>

Résultat du calcul

</h3>

</div>

<div class="card-body text-center">

<h1 class="display-4 text-primary">
%s
</h1>

<p class="lead">

La somme des deux nombres est de

<strong>%s</strong>

</p>

<hr>

<a href="/www.axitech.com/somme"
class="btn btn-primary">

<i class="bi bi-arrow-left-circle"></i>

Nouveau calcul

</a>

</div>

</div>

</div>

</div>

</div>

</body>

</html>
""", somme, somme);

        out.println(html);
            }

}
