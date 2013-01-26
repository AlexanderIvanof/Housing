<%-- 
    Document   : index
    Created on : 12.01.2013, 22:23:12
    Author     : Alexander Ivanon
    Hello
--%>

<%@page import="java.util.Locale, java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!Locale client;%>
<%!Locale sess;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            sess = (Locale) session.getAttribute("language");
            if (sess != null) {
                client = sess;
            } else {
                client = request.getLocale();
            }

            ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.WelcomePage", client);
        %>
        <h1><b><%=bundle.getString("locale.page.choose")%></b></h1>
        <jsp:include page="locale.jsp" flush="true"/>
    </body>
</html>
