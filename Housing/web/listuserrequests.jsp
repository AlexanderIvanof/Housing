<%-- 
    Document   : listuserrequests
    Created on : 20.01.2013, 20:49:58
    Author     : Alexandr Ivanov
--%>

<%@page import="ua.epam.servlet.filter.UMConstants" %>
<%@page import="java.util.*"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*;"%>
<%!Locale client;%>
<%!Locale sess;%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/favicon.ico" type="x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Мои заявки</title>
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
    <center> <h1><%=bundle.getString("listuser.page.list")%></h1></center>
    <%
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        RequestEntityDAO requests = daof.getRequestEntityDAO();

        String _user = (String) session.getAttribute(UMConstants.PRINCIPAL);

        UserDAO udao = daof.getUserDAO();
        User user = udao.getUser(_user);

        List<RequestEntity> list = requests.getRequestsByUser(user.getIdUser());
    %>

    <table align="center" border="2" width="60%"
           <tr>
            <td align="center" width="20%"><font><%=bundle.getString("listuser.page.table.number")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listuser.page.table.date")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listuser.page.table.workname")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listuser.page.table.workdate")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listuser.page.table.state")%></font></td>
        </tr>
        <%
            if (!list.isEmpty()) {
                for (RequestEntity requ : list) {
                    out.println("<tr>");
                    out.println("<td align=\"center\">" + requ.getIdRequest() + "</td>");
                    out.println("<td>" + RequestEntity.showDate(requ.getRequestDate()) + "</td>");
                    out.println("<td>" + requ.getTypeWork().getName() + "</td>");
                    out.println("<td>" + RequestEntity.showDate(requ.getOrderFullfillment()) + "</td>");
                    out.println("<td>" + requ.getApprove().getName() + "</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                out.println("<td>" + bundle.getString("listuser.page.table.empty") + "</td>");
                out.println("</tr>");
            }
        %>
        <table/>
        <table width="100%" border="0"><tr align="right"><td><input type="button" value="<%=bundle.getString("page.button.back")%>" onclick="goBack()"/></td></tr></table>        
        <script language="JavaScript">
            function goBack()
            {
                window.history.back();
            }
        </script>
    </body>
</html>
