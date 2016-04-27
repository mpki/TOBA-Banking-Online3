<%@page import="Beans.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->        
    <sql:setDataSource
        var="AccountInfo"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/toba?zeroDateTimeBehavior=convertToNull"
        user="root" password="sesame"
    />
    
    <sql:query var="listUserInfo"   dataSource="${AccountInfo}">
        SELECT * FROM users WHERE Username = ?;
        <sql:param value="${User.username}" />
    </sql:query>
        
    <sql:query var="listTransactionInfo"   dataSource="${AccountInfo}">
    SELECT * FROM account WHERE User = ?;
    <sql:param value="${User}" />
    </sql:query>

<jsp:include page="header.html"/>
<html>
    <head>
        <title>Account Page</title>
        <link rel="stylesheet" href="CSS/TOBA.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
        <c:if test="${pageContext.request.getSession(false) != null}">
            <c:if test="${User.username == null}">
            <h5>Hello J Smith!</h5>
            <h4>Login Successful!</h4>
            </c:if>
            <c:if test="${User.username != null}">
                <h5>Hello ${User.firstname} ${User.lastname}!</h5>
                <h4>Login Successful!</h4> 
            </c:if>
        </c:if>
        <c:if test = "${pageContext.request.getSession(false) == null}">
        <h5>Not logged in</h5>
        </c:if>
        </div>
        
        
        
        
        
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>My Account Information</h2></caption>
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>State</th>
                <th>City</th>
                <th>Address</th>
                <th>Zip</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            <c:forEach var="account" items="${listUserInfo.rows}">
                <tr>
                    <td><c:out value="${account.username}" /></td>
                    <td><c:out value="${account.firstname}" /></td>
                    <td><c:out value="${account.lastname}" /></td>
                    <td><c:out value="${account.state}" /></td>
                    <td><c:out value="${account.city}" /></td>
                    <td><c:out value="${account.address}" /></td>
                    <td><c:out value="${account.zip}" /></td>
                    <td><c:out value="${account.phone}" /></td>
                    <td><c:out value="${account.email}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
        
        
    
        <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>My Transactions</h2></caption>
            <tr>
                <th>User</th>
                <th>Checking</th>
                <th>Savings</th>
                <th>Amount</th>
            </tr>
            <c:forEach var="account" items="${listTransactionInfo.rows}">
                <tr>
                </tr>
            </c:forEach>
        </table>
    </div>
        
        
        
        
        
        
    </body>
    

    
</html>
<jsp:include page="footer.jsp"/>