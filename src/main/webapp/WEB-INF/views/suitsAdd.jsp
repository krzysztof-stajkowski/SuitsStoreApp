
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h3>Add suit to database</h3>
<body>
<form:form method="post" modelAttribute="suits"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/suits"/>">Go back </a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>
<%-- Name w garniturach będzie zawsze Garnitur   --%>
<%--    name--%>
<%--    <form:input path="pName"/> <br/>--%>
<%--    <form:errors path="pName"/><br/>--%>
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
                 path="category.id" items="${categoryList}"/>  <%-- odwołanie do innej tabeli po relacji--%>

    <br/><br/>
    Submit new suit <br/>
    <input type="submit" value="Save">



</form:form>
</body>
</html>
