<%-- 
    Document   : listworker
    Created on : 24.01.2013, 11:16:10
    Author     : Alexandr Ivanov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*"%> 
<%!Locale client;%>
<%!Locale sess;%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список работников</title>
    </head>
    <%
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        WorkerDAO wdao = daof.getWorkerDAO();
        List<Worker> list = wdao.getAllWorkers();
    %>
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

    <center><h2><%=bundle.getString("listworker.page.list")%></h2></center>
    <table align="center" border="4" width="60%"
           <tr>
            <td align="center" width="5%"><font>ID</font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listworker.page.table.name")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listworker.page.table.lastname")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listworker.page.table.prof")%></font></td>
            <td align="center" width="15%"><font><%=bundle.getString("listworker.page.table.busy")%></font></td>
        </tr>
        <%
            if (!list.isEmpty()) {
                for (Worker wrkr : list) {
                    out.println("<tr>");
                    out.println("<td align=\"center\">" + wrkr.getIdworker() + "</td>");
                    out.println("<td>" + wrkr.getFirstName() + "</td>");
                    out.println("<td>" + wrkr.getLastName() + "</td>");
                    out.println("<td>" + wrkr.getProf() + "</td>");
                    if (wrkr.isBusy()) {
                        out.println("<td>" + bundle.getString("listworker.page.busy") + "</td>");
                    } else {
                        out.println("<td>" + bundle.getString("listworker.page.free") + "</td>");
                    }
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                out.println("<td>" + bundle.getString("listworker.page.table.empty") + "</td>");
                out.println("</tr>");
            }
        %>
        <table/>
        <table width="100%" border="0">
            <tr align="right">
                <td>
                <input type="button" value="<%=bundle.getString("page.button.back")%>" onclick="goBack()"/>
                </td>
            </tr>
        </table>        
        <script language="JavaScript">
            function goBack()
            {
                window.history.back();
            }
        </script>
    </body>
</html>
