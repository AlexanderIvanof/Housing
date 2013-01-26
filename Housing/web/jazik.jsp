<%-- 
    Document   : jazik
    Created on : 25.01.2013, 17:16:29
    Author     : Alexandr Ivanov
--%>

<%@page import="java.util.Locale, java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!Locale client;%>
<%!Locale sess;%>

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