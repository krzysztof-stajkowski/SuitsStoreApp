
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h1 style="text-align:center;">Dodawanie garniturów</h1>
<body>
<form:form method="post" modelAttribute="suits"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/suits"/>">Powrót </a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>
<%-- Name w garniturach będzie zawsze Garnitur   --%>
    Nazwa<br/>
    <form:select cssStyle="width: 200" itemLabel="name" itemValue="id"
                 path="productlist.id" items="${AtrybutSuits}"/> <br/><br/><br/>

    Model<br/>
    <form:input cssStyle="width: 200" path="pModel"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic" path="pModel"/><br/><br/>
    Rozmiar<br/>
    <form:input cssStyle="width: 200" path="pSize"/> <br/>
     <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic"  path="pSize"/><br/><br/>
    Kolor<br/>
    <form:input cssStyle="width: 200" path="pColor"/> <br/>
     <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic"  path="pColor"/><br/><br/>
    Opis<br/>
    <form:textarea cssStyle="width: 200" path="pDescription"/> <br/>
     <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic"  path="pDescription"/><br/><br/>
    Skład<br/>
    <form:input cssStyle="width: 200" path="pComposition"/> <br/>
     <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic"  path="pComposition"/><br/><br/>
    Kategoria<br/>
    <form:select cssStyle="width: 200" itemLabel="name" itemValue="id"
                 path="category.id" items="${categoryList}"/>  <%-- odwołanie do innej tabeli po relacji--%>

    <br/><br/>
    Zatwierdź zmiany <br/>
    <input type="submit" value="Save" style="background-color: darkolivegreen;  height:50px; width:200px; font-size:16px ; color: azure">



</form:form>
</body>
</html>
