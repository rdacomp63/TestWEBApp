<%--
  Created by IntelliJ IDEA.
  User: rdaco
  Date: 16.03.2020
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Contact</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container container-default">
    <h1>Contact List Page</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Family</th>
            <th>PhoneNumber</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Contact}" var="contact">
            <tr>
                <td><c:out value="${contact.id}" /></td>
                <td><c:out value="${contact.name}" /></td>
                <td><c:out value="${contact.family}" /></td>
                <td><c:out value="${contact.phoneNumber}" /></td>
                <td><a class="btn btn-primary" role="button"
                       href="ContactServlet.do?action=edit&id=<c:out value="${contact.id }"/>">Update</a>
                    <a class="btn btn-primary" role="button" style="padding-left:5px;"
                       href="ContactServlet.do?action=delete&id=<c:out value="${contact.id }"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="ContactServlet.do?action=insert" class="btn btn-primary" role="button">Add Contact</a>
    </p>
</div>
</body>
</html>