<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add book</title>
    <meta charset="utf-8">
    <link href="<c:url value="/css/myStyle.css" />" rel="stylesheet">
</head>
<body>
<form:form method="post" modelAttribute="book">
    <p>
        <label for="isbn">Isbn:</label>
        <form:input path="isbn"></form:input>
        <form:errors path="isbn" cssClass="validation" />
    </p>
    <p>
        <label for="title">Title:</label>
        <form:input path="title"></form:input>
        <form:errors path="title" cssClass="validation" />
    </p>
    <p>
        <label for="publisher">Publisher:</label>
        <form:input path="publisher"></form:input>
        <form:errors path="publisher" cssClass="validation" />
    </p>

    <p>
        <label for="author">Author:</label>
        <form:input path="author"></form:input>
        <form:errors path="publisher" cssClass="validation" />
    </p>
    <p>
        <label for="type">Type:</label>
        <form:input path="type"></form:input>
    </p>
    <input type="submit">
</form:form>


</body>
</html>
