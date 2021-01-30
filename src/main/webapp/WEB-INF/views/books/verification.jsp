<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warning</title>
</head>
<body>
<p> Are you sure you want to delete book: <b>"${book.title}"</b>?</p>
<p>
<form method="post">
    <button type="submit" name="decision" value="true">YES</button>
    <button type="submit" name="decision" value="false">NO</button>
</form>
</p>
</body>
</html>
