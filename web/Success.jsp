<%@page import="Beans.User"%>
<%@ page session="true" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<jsp:include page="header.html"/>
<html>
    <head>
        <title>Congratulations!</title>
        <link rel="stylesheet" href="CSS/TOBA.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h3>The Account has been created Successfully!</h3></div>
        <div>
            <label> Username:</label>
            <span>${User.username}</span><br>
            <label> Password:</label>
            <span>${User.password}</span><br><br>
            <label> First Name:</label>
            <span>${User.firstname}</span><br>
            <label> Last Name:</label>
            <span>${User.lastname}</span><br><br>
            <label> Email:</label>
            <span>${User.email}</span><br>
            <label> Address:</label>
            <span>${User.address}</span><br>
            <label> Phone:</label>
            <span>${User.phone}</span><br><br>
            <label> State:</label>
            <span>${User.state}</span><br>
            <label> City:</label>
            <span>${User.city}</span><br>
            <label> Zip Code:</label>
            <span>${User.zipcode}</span><br>
            
            
        </div>
    </body>
</html>
<jsp:include page="footer.jsp"/>