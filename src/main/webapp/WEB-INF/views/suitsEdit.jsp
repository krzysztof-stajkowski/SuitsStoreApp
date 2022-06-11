
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h3>Edycja garniturów</h3>
<a href="<c:url value="/suits"/>">Powrót</a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
<jsp:include page="suitListDuplicate.jsp"></jsp:include>

<body>
<p>Tutaj na górze jest widok z listą wstawiony za pomocą include suitListDuplicate.jsp ,ale c:ForEach nie chce działać i jest puste
    <br> nie wiem jak to naprawić</p> <br><br>

<h2>Wybierz id garnituru do edycji</h2>

<form:form method="post" modelAttribute="suits"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    Suit id
    <form:input path="id"/> <br/>

    Model
    <form:input path="pModel"/> <br/>
    <form:errors path="pModel"/><br/>
    Size
    <form:input path="pSize"/> <br/>
    <form:errors path="pSize"/><br/>
    Color
    <form:input path="pColor"/> <br/>
    <form:errors path="pColor"/><br/>
    Description
    <form:textarea path="pDescription"/> <br/>
    <form:errors path="pDescription"/><br/>
    Composition
    <form:input path="pComposition"/> <br/>
    <form:errors path="pComposition"/><br/>
    Category
    <form:select path="category.id" items="${categoryList}" itemLabel="name" itemValue="id"/>

    <br/><br/>
    <input type="submit" value="Save"> <br/>
    <form:errors path="*"/> <%--display all error messages associated with any fields.--%>


</form:form>
</body>
</html>
