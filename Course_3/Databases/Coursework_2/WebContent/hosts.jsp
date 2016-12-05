<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/mainDesign.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Persons Manage Page</title>
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
    <c:if test="${requestScope.host ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            <input type="hidden" name="clazz" value="Host">
            id: <input type="text" value="${requestScope.host.id}"
                       readonly="readonly" name="id"><br>
            Name: <input
                type="text" value="${requestScope.host.name}" name="name"><br>
            Phone Number: <input type="text" value="${requestScope.host.phone_number}"
                            name="phone_number"><br>
            Pass Number: <input type="text" value="${requestScope.host.pass_number}">
            <input type="submit" value="Edit Host">
        </form>
    </c:if>
</div>

<%-- Add Request --%>
<c:if test="${requestScope.host eq null}">
    <form action='<c:out value="${addURL}"></c:out>' method="post">
        <input type="hidden" name="clazz" value="Host">
        Name: <input type="text" name="name"><br>
        Phone Number: <input type="text" name="phone_number"><br>
        Pass Number: <input type="text" name="pass_number"><br>

        <input type="submit" value="Add Host">
    </form>
</c:if>

<%-- Persons List Logic --%>
<c:if test="${not empty requestScope.hosts}">
    <table>
        <tbody>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Pass Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.hosts}" var="host">
            <c:url value="/edit" var="editURL">
                <c:param name="id" value="${host.id}"/>
            </c:url>
            <c:url value="/remove" var="deleteURL">
                <c:param name="id" value="${host.id}"/>
                <c:param name="clazz" value="Host"></c:param>

            </c:url>
            <tr>
                <td><c:out value="${host.id}"/></td>
                <td><c:out value="${host.name}"/></td>
                <td><c:out value="${host.phone_number}"/></td>
                <td><c:out value="${host.pass_number}"/></td>

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
</body>
</html>