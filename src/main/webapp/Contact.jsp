<%--
  Created by IntelliJ IDEA.
  User: rdaco
  Date: 16.03.2020
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add/Edit New Contact</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<h1>Add/Edit Contact Page</h1>
<div class="container container-default">
    <div class="well">
        <form action="ContactServlet.do" method="post">
            <div class="form-group row">
                <label for="Id" class="col-2 col-form-label">Contact ID</label>
                <div class="col-10">
                    <input type="text" class="form-control"
                           name="Id" value="<c:out value="${contact.id}" />"
                           readonly="readonly" placeholder="Read only field" />
                </div>
            </div>
            <div class="form-group row">
                <label for="Name" class="col-2 col-form-label">Name</label>
                <div class="col-10">
                    <input class="form-control" type="text" Name="Name"
                           value="<c:out value="${contact.name}"/>" id="Name"
                           placeholder="Name">
                </div>
            </div>
            <div class="form-group row">
                <label for="Family" class="col-2 col-form-label">Family</label>
                <div class="col-10">
                    <input class="form-control" type="text" name="Family"
                           value="<c:out value="${contact.family}"/>" id="family"
                           placeholder="Family">
                </div>
            </div>

            <div class="form-group row">
                <label for="phoneNumber" class="col-2 col-form-label">phoneNumber</label>
                <div class="col-10">
                    <input class="form-control" type="text" name="phoneNumber"
                           value="<c:out value="${contact.phoneNumber}"/>" id="phoneNumber"
                           placeholder="Course">
                </div>
            </div>

            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
