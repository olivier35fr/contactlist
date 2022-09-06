<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
</head>
<body>
    <div class="container">
    <div>
        <c:forEach items="${errorList}" var="error">
            ${error}</td>
        </c:forEach>
    </div>
        <a href="/new-contact">Create contact</a>
        <div>${count}</div>
        <table id="contacts">
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td>${contact.firstName}</td>
                    <td>${contact.lastName}</td>
                    <td>${contact.email}</td>
                    <td><a href="/contact/${contact.id}">Update</a><form action="/delete/${contact.id}" method="POST"><input type="submit" value="Delete" /></form></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>