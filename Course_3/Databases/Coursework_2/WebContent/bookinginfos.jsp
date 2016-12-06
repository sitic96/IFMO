<%--
  Created by IntelliJ IDEA.
  User: sitora
  Date: 06.12.16
  Time: 0:35
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
    <title>Create new Booking!</title>
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
<c:url value="/addnewbooking" var="addURL"></c:url>
<c:url value="/edit" var="editURL"></c:url>

<%-- Edit Request --%>
<div class="inputForm">
    <c:if test="${requestScope.bookinginfo ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            <input type="hidden" name="clazz" value="BookingInfo">
            id: <input type="text" value="${requestScope.bookinginfo.id}"
                       readonly="readonly" name="id"><br>
            Cat Name: <input
                type="text" value="${requestScope.bookinginfo.catName}" name="catName"><br>
            Chip Number: <input type="text" value="${requestScope.bookinginfo.chipNumber}"
                                name="chipNumber"><br>
            Host Name: <input type="text" value="${requestScope.bookinginfo.hostName}" name="hostName"><br>

            Cat Pass <input type="text" value="${requestScope.bookinginfo.passNumber}" name="passNumber"><br>

            Favorite Meal: <input type="text" value="${requestScope.bookinginfo.favoriteMeal}" name="favoriteMeal"><br>

            Phone Number: <input type="text" value="${requestScope.bookinginfo.phoneNumber}" name="phoneNumber"><br>

            Host Pass: <input type="text" value="${requestScope.bookinginfo.hostPass}" name="hostPass"><br>

            Room Category: <input type="text" value="${requestScope.bookinginfo.roomCategory}" name="roomCategory"><br>

            Room Price: <input type="text" value="${requestScope.bookinginfo.roomPricePerNight}"
                               name="roomPricePerNight"><br>

            <input type="submit" value="Edit Booking">
        </form>
    </c:if>
</div>

<%-- Add Request --%>
<c:if test="${requestScope.bookinginfo eq null}">
    <form action='<c:out value="${addURL}"></c:out>' method="post">
        <input type="hidden" name="clazz" value="BookingInfo">
        Cat Name: <input
            type="text" value="${requestScope.bookinginfo.cat.catName}" name="catName"><br>
        Chip Number: <input type="text" value="${requestScope.bookinginfo.cat.chipNumber}"
                            name="chipNumber"><br>
        Host Name: <input type="text" value="${requestScope.bookinginfo.host.hostName}" name="hostName"><br>

        Cat Pass <input type="text" value="${requestScope.bookinginfo.cat.passNumber}" name="passNumber"><br>

        Favorite Meal: <input type="text" value="${requestScope.bookinginfo.cat.favoriteMeal}" name="favoriteMeal"><br>

        Phone Number: <input type="text" value="${requestScope.bookinginfo.host.phoneNumber}" name="phoneNumber"><br>

        Host Pass: <input type="text" value="${requestScope.bookinginfo.host.hostPass}" name="hostPass"><br>

        Room Category: <input type="text" value="${requestScope.bookinginfo.room.roomCategory}" name="roomCategory"><br>

        Room Price: <input type="text" value="${requestScope.bookinginfo.room.roomPricePerNight}"
                           name="roomPricePerNight"><br>
        <input type="submit" value="Add Booking">
    </form>
</c:if>

<%-- Persons List Logic --%>
<c:if test="${not empty requestScope.bookinginfos}">
    <table>
        <tbody>
        <tr>
            <th>id</th>
            <th>Cat Name</th>
            <th>Chip Number</th>
            <th>Host Pass</th>
            <th>Cat Pass</th>
            <th>Favorite Meal</th>
            <th>Phone Number</th>
            <th>Host Name</th>
            <th>Room Category</th>
            <th>Room Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.bookinginfos}" var="bookinginfo">
            <c:url value="/edit" var="editURL">
                <c:param name="id" value="${bookinginfo.id}"/>
            </c:url>
            <c:url value="/remove" var="deleteURL">
                <c:param name="id" value="${bookinginfo.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${bookinginfo.id}"/></td>
                <td><c:out value="${bookinginfo.cat.catName}"/></td>
                <td><c:out value="${bookinginfo.cat.chipNumber}"/></td>
                <td><c:out value="${bookinginfo.host.hostPass}"/></td>
                <td><c:out value="${bookinginfo.cat.passNumber}"/></td>
                <td><c:out value="${bookinginfo.cat.favoriteMeal}"/></td>
                <td><c:out value="${bookinginfo.host.phoneNumber}"/></td>
                <td><c:out value="${bookinginfo.host.hostName}"/></td>
                <td><c:out value="${bookinginfo.room.roomCategory}"/></td>
                <td><c:out value="${bookinginfo.room.roomPricePerNight}"/></td>

                <td><a
                        href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                <td><a
                        href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>

