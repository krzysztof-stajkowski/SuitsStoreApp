
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h1 style="text-align:center;">Lista towarów poza garniturami</h1>
<body>

<jsp:include page="Tablelayout.jsp"></jsp:include>

<table>
    <thead>
    <tr>
        <th>Pozycja</th>
        <th>Nazwa</th>
        <th>Model</th>
        <th>Rozmiar</th>
        <th>Kategoria</th>
        <th>Kolor</th>
        <th>Opis</th>
        <th>Skład</th>
    </tr>
    <a href="<c:url value="/products"/>">Powrót</a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    </thead>
    <tbody>
    <c:forEach items="${productNameList}" var="prod">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.productlist.name}</td>
            <td>${prod.pModel}</td>
            <td>${prod.pSize}</td>
            <td>${prod.category.name}</td> <%-- odwołanie do innej tabeli po relacji--%>
            <td>${prod.pColor}</td>
            <td>${prod.pDescription}</td>
            <td>${prod.pComposition}</td>
            <td>${prod.pAvailable}</td>

            <td>
<%--             Tutaj można wstawić jakiś opis lub link i b ędzie obok każdego wiersza--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
