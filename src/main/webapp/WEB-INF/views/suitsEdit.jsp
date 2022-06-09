
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>SUITS PAGE</title>
</head>
<h3>Edit suit in database</h3>
<body>
<h2>Select id and edit positions</h2>

<form:form method="post" modelAttribute="suits"> <%--Klucz z kontrolera CZERWONY ALE JEST OK to inteliJ tak pokazuje--%>
    Suit id
    <form:input path="id"/> <br/>

    model
    <form:input path="pModel"/> <br/>
    <form:errors path="pModel"/><br/>
    size
    <form:input path="pSize"/> <br/>
    <form:errors path="pSize"/><br/>
    color
    <form:input path="pColor"/> <br/>
    <form:errors path="pColor"/><br/>
    description
    <form:textarea path="pDescription"/> <br/>
    <form:errors path="pDescription"/><br/>
    composition
    <form:input path="pComposition"/> <br/>
    <form:errors path="pComposition"/><br/>
    category
    <form:select itemLabel="name" itemValue="id"
                 path="category.id" items="${categoryList}"/>

    <br/><br/>
    <input type="submit" value="Save"> <br/>
    <form:errors path="*"/> <%--display all error messages associated with any fields.--%>


</form:form>
</body>
</html>
