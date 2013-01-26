<%-- 
    Document   : Dispatcher
    Created on : 23.01.2013, 12:15:20
    Author     : Alexandr Ivanov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Locale, java.util.ResourceBundle"%>
<%!Locale client;%>
<%!Locale sess;%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="/images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="/images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Диспетчер</title>
    </head>
    <body bgcolor="#7FFFD4">
        <jsp:include page="locale.jsp" flush="true"/>
        <%
            sess = (Locale) session.getAttribute("language");
            if (sess != null) {
                client = sess;
            } else {
                client = request.getLocale();
            }

            ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.Dispatcher", client);
        %>
        <h1><%=bundle.getString("dispatcher.welcome")%></h1>
        <table border="2" align="center">
            <tr>
                <td align="center"><a href="listworker.jsp"><%=bundle.getString("dispatcher.list.worker")%></a></td>
                <td align="center"><a href="workplan.jsp"><%=bundle.getString("dispatcher.list.workplan")%></a></td>
                <td align="center"><a href="listrequest.jsp"><%=bundle.getString("dispatcher.list.request")%></a></td>
            </tr>
        </table>
            <p align="right">
            <font size="3"><%=bundle.getString("dispatcher.exit")%></font>
            <input type="button" value="<%=bundle.getString("dispatcher.button")%>" name="btLogin" onClick="showLoginHtm()">
        </p>
        <p>&nbsp;</p>
        <script language="JavaScript">
            function showLoginHtm()
            {
                open("LogOut.jsp");
            }
        </script>
            
    </body>
</html>
