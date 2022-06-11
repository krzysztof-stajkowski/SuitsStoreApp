<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h3>Dodawanie towarów poza garniturami</h3>
<body>
<form:form method="post"
           modelAttribute="products"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/products"/>">Powrót </a>
    <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>

<%-- JAK TO DZIAŁA [ item label jest polem z encji z której pobieramy wartości do selecta ]  --%>
<%-- JAK TO DZIAŁA [ path jest polem z encji do której będzie wgrywane z formularza ]   --%>
<%-- JAK TO DZIAŁA [ nie można używać nazw tabel z bazy bo mogą być inne  ]--%>
<%-- JAK TO DZIAŁA [ ${AtrybutMarynarkiSpodnie} jest to taki klucz z metody przy @ModelAttribute  ]--%>

    Name
    <form:select itemLabel="name" itemValue="id"
                 path="pName" items="${AtrybutMarynarkiSpodnie}"/> <br/><br/> <%-- odwołanie do innej tabeli po relacji--%>

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
    <form:select itemLabel="name" itemValue="id"
                 path="category.id" items="${AtrybutCategoryList}"/>  <%-- odwołanie do innej tabeli po relacji--%>

    <br/><br/>
    Zatwierdź zmiany <br/>
    <input type="submit" value="Save" style="height:50px; width:150px; font-size:20px">


</form:form>
</body>
</html>
