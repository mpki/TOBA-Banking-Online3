<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<jsp:include page="header.html"/>
<html>
    <head>
        <title>Create new Customer</title>
        <link rel="stylesheet" href="CSS/TOBA.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
        <div>
            <br>
            <form action="NewCustomer">
                First Name :<br>
                <input type="text" name ="FirstName" required>
                <br>
                Last Name :<br>
                <input type="text" name="LastName" required>
                <br>
                Phone :<br>
                <input type="text" name="Phone" required>
                <br>
                Address :<br>
                <input type="text" name="Address" required>
                <br>
                City :<br>
                <input type="text" name="City" required>
                <br>
                State :<br>
                <input type="text" name="State" required>
                <br>
                Zip Code :<br>
                <input type="text" name="Zipcode" required>
                <br>
                Email :<br>
                <input type="text" name="Email" required>
                <br>
                <input type="submit" value="Submit">
            </form>
            <br>
        </div>
    </body>
</html>
<jsp:include page="footer.jsp"/>