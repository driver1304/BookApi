<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<p><input type="submit" value="Add new book"
          onclick="window.location='/admin/books/add';"/>
</p>
<table border="1">
    <thead>
    <th colspan="4" style="font-size: x-large"><b> List of books</b></th>
    </thead>
    <thead>
    <th>Isbn</th>
    <th>Title</th>
    <th>Author</th>
    <th>Action</th>
    </thead>
    <tbody>

    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/books/edit/${book.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/admin/books/delete/${book.id}">Delete</a>
                <a href="${pageContext.request.contextPath}/admin/books/show/${book.id}">Show</a>

            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>