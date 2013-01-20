<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*,ua.epam.entitydao.*, ua.epam.servletcontroller.*, ua.epam.servlet.filter.*"%>


<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exiting from account</title>
    </head>
    <body bgcolor="#CCCCFF">

        <h1>Вы действительно хотите выйти?</h1>
        <form method="POST" action="./LogOut">

            <hr>
            <td>
                <input type="submit" value="Ok" name="exit"> 
                <input type="submit" value="Back" name="exit">
            </td>
        </form>

    </body>
</html>
