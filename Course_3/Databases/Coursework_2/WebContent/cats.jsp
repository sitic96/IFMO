<%--
  Created by IntelliJ IDEA.
  User: sitora
  Date: 28.11.16
  Time: 17:58
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
    <title>Cats Manage Page</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<%-- Cat Add/Edit logic --%>
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
    <c:if test="${requestScope.cat ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            <input type="hidden" name="clazz" value="Cat">
            id: <input type="text" value="${requestScope.cat.id}"
                       readonly="readonly" name="id"><br>
            Name: <input
                type="text" value="${requestScope.cat.name}" name="name"><br>
            Microchip Number: <input type="text" value="${requestScope.cat.microchip_number}"
                                 name="microchip_number"><br>
            Pass Number: <input type="text" value="${requestScope.cat.pass_number}">
            <input type="submit" value="Edit Cat">
        </form>
    </c:if>
</div>

<%-- Add Request --%>
<c:if test="${requestScope.cat eq null}">
    <form action='<c:out value="${addURL}"></c:out>' method="post">
        <input type="hidden" name="clazz" value="Cat">
        Name: <input type="text" name="name"><br>
        Microchip Number: <input type="text" name="microchip_number"><br>
        Pass Number: <input type="text" name="pass_number"><br>
        Host ID: <input type="text" name="host_id"><br>
        Favorite Meal: <input type="text" name="favorite_meal_id">

        <input type="submit" value="Add Cat">
    </form>
</c:if>

<%-- Persons List Logic --%>
<c:if test="${not empty requestScope.cats}">
    <table>
        <tbody>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Microchip Number</th>
            <th>Pass Number</th>
            <th>Host ID</th>
            <th>Favorite Meal</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.cats}" var="cat">
            <c:url value="/edit" var="editURL">
                <c:param name="id" value="${cat.id}"/>
            </c:url>
            <c:url value="/remove" var="deleteURL">
                <c:param name="id" value="${cat.id}"/>
                <c:param name="clazz" value="Cat"></c:param>
            </c:url>
            <tr>
                <td><c:out value="${cat.id}"/></td>
                <td><c:out value="${cat.name}"/></td>
                <td><c:out value="${cat.microchip_number}"/></td>
                <td><c:out value="${cat.pass_number}"/></td>
                <td><c:out value="${cat.host_id}"/></td>
                <td><c:out value="${cat.favorite_meal_id}"/></td>

                <td><a
                        href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                <td><a
                        href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<a href="hosts.jsp">Hosts</a><br>
<a href="bookings.jsp">Bookings</a><br>
</body>
</html>
