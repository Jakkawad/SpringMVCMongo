<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/12/2017 AD
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>User</title>
</head>
<body>

    <spring:url value="/user/save" var="saveURL"></spring:url>

    <form:form action="${saveURL}" modelAttribute="userForm" method="POST">
        <form:hidden path="id"></form:hidden>
        <label>Name: </label>
        <form:input path="name"></form:input><br>
        <button type="submit">Save</button>

    </form:form>
</body>
</html>
