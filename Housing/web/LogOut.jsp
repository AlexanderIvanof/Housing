<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@page  import="java.util.*"%>
<%!Locale client;%>
<%!Locale sess;%>
<!DOCTYPE html >
<html>
    <head>
        <link rel="icon" href="images/favicon.ico" type="x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Подтверждение выхода</title>
    </head>
    <body bgcolor="#F0FFFF">
        <%
            sess = (Locale) session.getAttribute("language");
            if (sess != null) {
                client = sess;
            } else {
                client = request.getLocale();
            }

            ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.LanguageBundle", client);
        %>

        <h1><%=bundle.getString("logout.page.leave")%></h1>
        <form method="POST" action="./LogOut">

            <hr>
            <td>
                <input type="submit" value="<%=bundle.getString("welcome.page.button")%>" name="exit"> 
                <input type="submit" value="<%=bundle.getString("page.button.back")%>" name="back">
            </td>
        </form>

    </body>
</html>
