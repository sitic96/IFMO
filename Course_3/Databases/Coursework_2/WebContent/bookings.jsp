<%--
  Created by IntelliJ IDEA.
  User: sitora
  Date: 29.11.16
  Time: 2:45
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
    <c:if test="${requestScope.booking ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            <input type="hidden" name="clazz" value="Booking">
            id: <input type="text" value="${requestScope.booking.id}"
                       readonly="readonly" name="id"><br>
            Cat ID: <input
                type="text" value="${requestScope.booking.cat_id}" name="cat_id"><br>
            From: <input type="date" value="${requestScope.booking.from}"
                         name="from"><br>
            To: <input type="date" value="${requestScope.booking.to}" name="to"><br>
            Room Category <input type="text" value="${requestScope.booking.room_category}" name="room_category"><br>
            Price: <input type="text" value="${requestScope.booking.price}" name="price"><br>
            <input type="submit" value="Edit Booking">
        </form>
    </c:if>
</div>

<%-- Add Request --%>
<c:if test="${requestScope.booking eq null}">
    <form action='<c:out value="${addURL}"></c:out>' method="post">
        <input type="hidden" name="clazz" value="Booking">
        Cat ID: <input
            type="text" value="${requestScope.booking.cat_id}" name="cat_id"><br>
        From: <input type="date" value="${requestScope.booking.from}"
                     name="from"><br>
        To: <input type="date" value="${requestScope.booking.to}" name="to">
        Room Category <input type="text" value="${requestScope.booking.room_category}" name="room_category"><br>
        Price: <input type="text" value="${requestScope.booking.price}" name="price"><br>
        <input type="submit" value="Add Booking">
    </form>
</c:if>

<%-- Persons List Logic --%>
<c:if test="${not empty requestScope.bookings}">
    <table>
        <tbody>
        <tr>
            <th>id</th>
            <th>Cat ID</th>
            <th>From</th>
            <th>To</th>
            <th>Room Category</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.bookings}" var="booking">
            <c:url value="/edit" var="editURL">
                <c:param name="id" value="${booking.id}"/>
            </c:url>
            <c:url value="/remove" var="deleteURL">
                <c:param name="id" value="${booking.id}"/>
                <c:param name="clazz" value="Booking"/>
            </c:url>
            <tr>
                <td><c:out value="${booking.id}"/></td>
                <td><c:out value="${booking.cat_id}"/></td>
                <td><c:out value="${booking.from}"/></td>
                <td><c:out value="${booking.to}"/></td>
                <td><c:out value="${booking.room_category}"/></td>
                <td><c:out value="${booking.price}"/></td>

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
<a href="hosts.jsp">Hosts</a><br>
</body>
</html>

