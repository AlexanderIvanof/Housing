<%-- 
    Document   : index
    Created on : 12.01.2013, 22:23:12
    Author     : Alexander Ivanon
--%>

<%@page import="java.util.Locale, java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@taglib prefix="table" uri="tlds/table.tld" %>
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

            ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.LanguageBundle", client);
        %>
        <h1><b><%=bundle.getString("locale.page.choose")%></b></h1>
        <table border="2" align="center" width="50%">
        <table:row onumber="1" foreman="Sash" worker="Alex" address="STR" date="3-1-2013"/>
        <table:row onumber="3" foreman="Sash2" worker="Alex2" address="STR2" date="15-3-2013"/>
        </table>
        
        <%
            throw new JspException("+++++No access+++++++");
        %>
    </body>
</html>
