
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h3>Szukanie garniturów po rozmiarze</h3>
<body>
<form:form method="post" modelAttribute="suitsSearch"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/"/>">Powrót </a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>

    Wybierz rozmiar z listy<br/>
    <form:select
                 path="pSize" items="${AtrybutSuitsSizes}"/> <br/><br/>

    <br/><br/>
    <input type="submit" value="Szukaj" style="height:70px; width:150px; font-size:30px">

<%-- itemLabel="pSize"   itemValue="pSize"--%>
</form:form>
</body>
</html>
