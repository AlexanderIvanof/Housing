<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>

<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Подтверждение выхода</title>
    </head>
    <body bgcolor="#7FFFD4">

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
