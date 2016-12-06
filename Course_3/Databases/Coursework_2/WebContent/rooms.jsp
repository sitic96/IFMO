<%--
  Created by IntelliJ IDEA.
  User: sitora
  Date: 29.11.16
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/mainDesign.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rooms Manage Page</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<%-- Host Add/Edit logic --%>
<c:if test="${requestScope.error ne null}">
    <strong style="color: red;"><c:out
            value="${requestScope.error}"></c:out></strong>
</c:if>
<c:if test="${requestScope.success ne null}">
    <strong style="color: green;"><c:out
            value="${requestScope.success}"></c:out></strong>
</c:if>
<c:url value="/add" var="addURL"></c:url>
<c:url value="/edit" var="editURL"></c:url>

<%-- Edit Request --%>
<div class="inputForm">
    <c:if test="${requestScope.room ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            <input type="hidden" name="clazz" value="Room">
            id: <input type="text" value="${requestScope.room.id}"
                       readonly="readonly" name="id"><br>
            Category Name: <input
                type="text" value="${requestScope.room.category_name}" name="category_name"><br>
            Price per night: <input type="text" value="${requestScope.room.price_per_night}"
                                 name="price_per_night"><br>
            <input type="submit" value="Edit Room">
        </form>
    </c:if>
</div>

<%-- Add Request --%>
<c:if test="${requestScope.room eq null}">
    <form action='<c:out value="${addURL}"></c:out>' method="post">
        <input type="hidden" name="clazz" value="Room">
        Category Name: <input
            type="text" value="${requestScope.room.category_name}" name="category_name"><br>
        Price per night: <input type="text" value="${requestScope.room.price_per_night}"
                                name="price_per_night"><br>

        <input type="submit" value="Add Room">
    </form>
</c:if>

<%-- Persons List Logic --%>
<c:if test="${not empty requestScope.rooms}">
    <table>
        <tbody>
        <tr>
            <th>id</th>
            <th>Category Name</th>
            <th>Price per night</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.rooms}" var="room">
            <c:url value="/edit" var="editURL">
                <c:param name="id" value="${room.id}"/>
            </c:url>
            <c:url value="/remove" var="deleteURL">
                <c:param name="id" value="${room.id}"/>
                <c:param name="clazz" value="Room"></c:param>

            </c:url>
            <tr>
                <td><c:out value="${room.id}"/></td>
                <td><c:out value="${room.category_name}"/></td>
                <td><c:out value="${room.price_per_night}"/></td>

                <td><a
                        href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                <td><a
                        href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<a href="cats.jsp">Cats</a><br>
<a href="bookings.jsp">Bookings</a><br>
<a href="hosts.jsp">Hosts</a>
</body>
</html>
