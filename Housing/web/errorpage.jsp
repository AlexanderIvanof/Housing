<%-- 
    Document   : errorpage
    Created on : 22.01.2013, 18:28:53
    Author     : Alexandr Ivanov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/warning.ico" type="x-icon">
        <link rel="shortcut icon" href="images/warning.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error!</title>
    </head>
    <body bgcolor="#FAF0E6">
        <table align="center">
            <tr>
                <td align="center">
                    <image src="images/dead.jpg" width="100" heigth="100"/>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <font face="monospace">При выполнении страници JSP выброшено исключение!</font>
                </td>
            </tr>
            <tr>
                <td>
                    <%= exception%>
                </td>
            </tr>
        </table>
    </body>
</html>
