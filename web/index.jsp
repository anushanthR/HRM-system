<%-- 
    Document   : index
    Created on : 25/08/2018, 6:49:18 PM
    Author     : Anushanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>        
        
    </head>
    <body>
        <form id="loginform" name="loginform" action="LoginController" method="post">
            <input type="text" name="username" id="username"/>
            <input type="password" name="password" id="password"/>
            <button type="submit" name="submit" value="login">Login</button>
        </form>
    </body>
</html>