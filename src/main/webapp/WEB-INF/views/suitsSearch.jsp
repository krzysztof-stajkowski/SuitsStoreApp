
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h1 style="text-align:center;">Szukanie garniturów po rozmiarze</h1>
<body>
<form:form method="post" modelAttribute="suitsSearch"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/"/>">Powrót </a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>

    Wybierz rozmiar z listy<br/>
    <p><small><i>Poniżej są tylko dostępne na stanie rozmiary garniturów</i></small></p>
    <form:select cssStyle="width: 200"
                 path="pSize" items="${AtrybutSuitsSizes}"/> <br/><br/>

    <br/><br/>
    <input type="submit" value="Save" style="background-color: darkolivegreen;  height:50px; width:200px; font-size:16px ; color: azure">

    <%-- USUNIĘTE BO NIE DZIAŁAŁ DISTINCT w DAO z tymi parametrami itemLabel="pSize"   itemValue="pSize"--%>

</form:form>
</body>
</html>
