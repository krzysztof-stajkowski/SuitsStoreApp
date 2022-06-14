<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h1 style="text-align:center;">Dodawanie towarów poza garniturami</h1>

<body>
<form:form method="post"
           modelAttribute="suits"> <%--Klucz z kontrolera add (linia 43) CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    <a href="<c:url value="/products"/>">Powrót </a>
    <br/><br/>  <%--adres do www CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>

    <form:hidden path="id"/>

    <%-- JAK TO DZIAŁA [ itemLabel jest polem z encji (product_list) z której pobieramy co ma być wyświetolne w liście rozwijanej selecta ]  --%>
    <%-- JAK TO DZIAŁA [ itemValue jest polem z encji (product_list) z której pobieramy wartości do selecta ]  --%>
    <%-- JAK TO DZIAŁA [ path jest polem z encji (suits) do której będą wgrywane dane z formularza ]   --%>
    <%-- JAK TO DZIAŁA [ nie można używać nazw tabel z bazy bo mogą być inne, tylko z modelu projektu  ]--%>
    <%-- JAK TO DZIAŁA [ ${AtrybutMarynarkiSpodnie} jest to taki klucz z metody w kontrolerze przy @ModelAttribute  ]--%>

    Nazwa<br/>
    <form:select cssStyle="width: 200" itemLabel="name" itemValue="id"
                 path="productlist.id" items="${Atrybut}"/> <br/><br/>

    Model<br/>
    <form:input cssStyle="width: 200" path="pModel"/> <br/>
    <form:errors cssStyle="margin: 30px; color: crimson; font-size: 13px; font-style: italic"  path="pModel"/><br/><br/>
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
                 path="category.id" items="${AtrybutCategoryList}"/>  <%-- odwołanie do innej tabeli po relacji--%>

    <br/><br/>
    Zatwierdź zmiany <br/>
    <input type="submit" value="Save" style="background-color: darkolivegreen;  height:50px; width:200px; font-size:16px ; color: azure">



</form:form>
</body>
</html>
