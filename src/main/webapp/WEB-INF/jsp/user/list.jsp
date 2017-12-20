<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/12/2017 AD
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>List</title>
</head>
<body>

    <spring:url value="/user/add" var="addURL">Add</spring:url>
    <a href="${addURL}">Add user</a>

    <h1>List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listUser}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>
                        <spring:url value="/user/update/${user.id}" var="updateURL" ></spring:url>
                        <a href="${updateURL}">Update</a>
                    </td>
                    <td>
                        <spring:url value="/user/delete/${user.id}" var="deleteURL" ></spring:url>
                        <a href="${deleteURL}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
