<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create contact page</title>
</head>
<body>
    <div class="container">

        <form:form action="/add" modelAttribute="contact" method="POST">
                    <form:input path="firstName" type="text" />
                    <form:input path="lastName" type="text" />
                    <form:input path="email" type="text" />
                    <input type="submit">
                </form:form>

<c:forEach items="${errorList}" var="error">
    ${error}</td>
</c:forEach>

    </div>
</body>
</html>