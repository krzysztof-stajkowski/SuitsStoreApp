
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h3>Delete suits from database</h3>
<body>

<table>
    <thead>
    <tr>
        <th>Position</th>
        <th>Name</th>
        <th>Model</th>
        <th>Size</th>
        <th>Category</th>
        <th>Color</th>
        <th>Description</th>
        <th>Composition</th>
        <th>Available</th>
    </tr>
    <a href="<c:url value="/suits"/>">Go back </a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    </thead>
    <tbody>
    <c:forEach items="${suits}" var="suit">
        <tr>
            <td>${suit.id}</td>
            <td>${suit.pName}</td>
            <td>${suit.pModel}</td>
            <td>${suit.pSize}</td>
            <td>${suit.category.name}</td>   <%-- odwołanie do innej tabeli po relacji--%>
            <td>${suit.pColor}</td>
            <td>${suit.pDescription}</td>
            <td>${suit.pComposition}</td>
            <td>${suit.pAvailable}</td>

            <td>
             <a href="<c:url value="delete/${suit.id}"/>">Delete from database</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
