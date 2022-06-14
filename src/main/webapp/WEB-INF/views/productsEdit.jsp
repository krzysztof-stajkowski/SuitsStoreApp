
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h1 style="text-align:center;">Edycja towarów poza garniturami</h1>
<a href="<c:url value="/products"/>">Powrót</a> <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
<body>
<h2>Wybierz id ubrania do edycji</h2>
<%--Pomysły stylowania z https://www.w3schools.com/html--%>

                                        <%--  MUSI BYĆ modelAttribute="suits" W PRODUKTACH BO TO ODNIESIENIE DO BAZY. W KONTROLERZE TEŻ suits LINIA 63  --%>
<form:form method="post" modelAttribute="suits"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    Wybierz id produktu do edycji<br/>
    <form:input path="id"/> <br/><br/>

    Nowy model<br/>
    <form:input cssStyle="width: 200" path="pModel"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic" path="pModel"/><br/>
    Nowy rozmiar<br/>
    <form:input cssStyle="width: 200" path="pSize"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic" path="pSize"/><br/>
    Nowy kolor<br/>
    <form:input cssStyle="width: 200" path="pColor"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic" path="pColor"/><br/>
    Nowy opis<br/>
    <form:textarea cssStyle="width: 200" path="pDescription"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic" path="pDescription"/><br/>
    Nowy skład<br/>
    <form:input cssStyle="width: 200" path="pComposition"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic" path="pComposition"/><br/>
    Nowa kategoria<br/>
    <form:select cssStyle="width: 200" path="category.id" items="${AtrybutCategoryList}" itemLabel="name" itemValue="id"/>
    <br>
    <small style="color: blue">>--- Podczas edycji nie updatuje mi się kategoria w bazie</small>
    <br/><br/>
    Zatwierdź zmiany <br>
    <input type="submit" value="Save" style="background-color: darkolivegreen;  height:50px; width:200px; font-size:16px ; color: azure"><br/><br/>
    <a href="<c:url value="/products/edit"/>">Wczytaj stronę jeszcze raz</a> <br/><br/>
</form:form>
<h1>Lista dostępnych pozycji do edycji</h1>

<jsp:include page="productListDuplicate.jsp"></jsp:include>

</body>
</html>