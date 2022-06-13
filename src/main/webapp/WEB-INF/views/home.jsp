<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Strona startowa</title>
</head>
<body>
<h1 style="text-align:center;">SUITS STORE APP</h1>
<div>
    <h3>ZARZĄDZANIE GARNITURAMI</h3>
    <p><i>Dodawanie, edycja i kasowanie zasobów garniturowych</i></p>
    <a href="suits">GO-></a> <br><br>  <%--odnośnik do get mapping w HomeController--%>
    <h3>ZARZĄDZANIE INNYMI UBIORAMI</h3>
    <p><i>Dodawanie, edycja i kasowanie innych towarów</i></p>
    <a href="products">GO-></a><br><br>
    <h3>PAROWANIE GARNITURÓW</h3>
    <p><i>Mechanizm parowania spodni i marynarek tego samego modelu</i></p>
    <a href="match">GO-></a>
    <h3>SZUKANIE GARNITURÓW</h3>
    <p><i>Wyświetlanie listy dostępnych na stanie garniturów po modelu</i></p>
    <a href="suits/search">GO-></a>
</div>
</body>
</html>
