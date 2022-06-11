
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
<form:form method="post" modelAttribute="products"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/products"/>">Powrót </a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>
<%-- Name w garniturach będzie zawsze Garnitur - Tutaj lista innych produktów   --%>
<%--    Name--%>
<%--    <form:input path="pName"/> <br/>--%>
<%--    <form:errors path="pName"/><br/>--%>
    Name
    <form:radiobuttons items="${AtrybutProductNameList}" path="product_list" />

<%--    Name--%>
<%--    <form:select itemLabel="p_name" itemValue="id"--%>
<%--                 path="product_list" items="${AtrybutProductNameList}"/>  &lt;%&ndash; odwołanie do innej tabeli po relacji&ndash;%&gt;--%>

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
    <input type="submit" value="Save" style="height:50px; width:150px; font-size:20px" >



</form:form>
</body>
</html>
