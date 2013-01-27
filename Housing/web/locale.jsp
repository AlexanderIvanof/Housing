<%-- 
    Document   : locale
    Created on : 23.01.2013, 17:31:02
    Author     : Alexandr Ivanov
--%>

<%@page import="java.util.Locale, java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%!Locale client;%>
<%!Locale sess;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выбор языка</title>
    </head>
    <body bgcolor="#7FFFD4">
        
        <h2><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${curTime}" /></h2>
        
        <%
            sess = (Locale) session.getAttribute("language");
            if (sess != null) {
                client = sess;
            } else {
                client = request.getLocale();
            }

            ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.WelcomePage", client);
        %>
        <form action="./LangChange" method="GET">
            <table align="center">
                <tr>
                    <td><%=bundle.getString("locale.page.choose")%></td>
                    <td><input type="image" src="images/flag_GB.jpg" name="lang" value="GB"/></td>
                    <td><input type="image" src="images/flag_ru.gif" name="lang" value="RU"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
