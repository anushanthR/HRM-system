<%-- 
    Document   : UserDashboard
    Created on : 03/09/2018, 1:29:24 PM
    Author     : Anushanth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script  src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <title>JSP Page</title>
        <c:if test="${userName==null}">
            <% response.sendRedirect("index.jsp");%>
        </c:if>
    </head>
    <body>        
        <form action="LogoutController" method="Post">
            <input type="submit" name="submit" value="Logout"/>
        </form>

        <form action="" method="">
            <input type="text" id="username" name="username" value="${userName}" hidden/>
            <select>
                <option value="0" default selected hidden>
                    Leave Type
                </option>                
            </select>
            <input type="number" id="noOfDays" name="noOfDays" value="" />
            <input type="date" id="startdate" name="startdate" />
            <input type="date" id="enddate" name="enddate" />
            <textarea id="reason" name="reason" ></textarea>
            <input type="submit" id="submit" name="submit" value="Apply" />            
        </form>
        <script>
            $(function () {
                var dtToday = new Date();

                var month = dtToday.getMonth()+1;
                var day = dtToday.getDate();
                var year = dtToday.getFullYear();

                if (month < 10)
                    month = '0' + month.toString();
                else 
                    month = month.toString();
                
                if (day < 10)
                    day = '0' + day.toString();

                var minDate = year + '-' + month + '-' + day;
                var maxDate = year + '-' + month + '-' + day;
                $('#enddate').attr('min', minDate);
                
                
            });
            
            $(function () {
                var dtToday = new Date();

                var month = dtToday.getMonth();
                var day = dtToday.getDate();
                var year = dtToday.getFullYear();

                if (month < 10)
                    month = '0' + month.toString();
                else 
                    month = month.toString();
                
                if (day < 10)
                    day = '0' + day.toString();

                var maxDate = year + '-' + month + '-' + day;
                $('#enddate').attr('min', maxDate);
                
            });
            
        </script>
</html>
