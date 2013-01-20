<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*,ua.epam.entitydao.*, ua.epam.servletcontroller.*, ua.epam.servlet.filter.*"%>


<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exiting from account</title>
    </head>
    <body bgcolor="#CCCCFF">

        <h1>Вы хотите выйти?</h1>
        <form method="GET" action="goOut" name="outAuth">

            <hr>
            <%
                session.invalidate();
            %>
            <td>
                <input type="submit" value="Ok"> 
                <input type="submit" value="Back">
            </td>

    </body>
</html>
