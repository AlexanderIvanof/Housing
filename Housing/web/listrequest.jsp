<%-- 
    Document   : listrequest
    Created on : 24.01.2013, 16:19:33
    Author     : Alexandr Ivanov
--%>

<%@page import="ua.epam.servlet.filter.UMConstants" %>
<%@page import="java.util.*"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*"%> 
<%!Locale client;%>
<%!Locale sess;%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Необработанные заявки</title>
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
    <center><h2><%=bundle.getString("listrequest.page.name")%></h2></center>
    <%
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        RequestEntityDAO requests = daof.getRequestEntityDAO();

        String _user = (String) session.getAttribute(UMConstants.PRINCIPAL);

        List<RequestEntity> list = requests.getAllRequests();
    %>

    <table align="center" border="2" width="60%"
           <tr>
            <td align="center" width="15%"><font><%=bundle.getString("listrequest.page.table.number")%></font></td>
            <td align="center" width="25%"><font><%=bundle.getString("listrequest.page.table.address")%></font></td>
            <td align="center" width="15%"><font><%=bundle.getString("listrequest.page.table.requdate")%></font></td>
            <td align="center" width="20%"><font><%=bundle.getString("listrequest.page.table.name")%></font></td>
            <td align="center" width="15%"><font><%=bundle.getString("listrequest.page.table.workdate")%></font></td>
            <td align="center" width="10%"><font><%=bundle.getString("listrequest.page.table.edit")%></font></td>
        </tr>
        <%
            if (!list.isEmpty()) {
                for (RequestEntity requ : list) {
                    if (requ.getApprove() == Approve.WAIT_APPROVE) {
                        out.println("<tr>");
                        out.println("<td align=\"center\">" + requ.getIdRequest() + "</td>");
                        out.println("<td>" + requ.getUser().getAddress() + "</td>");
                        out.println("<td>" + RequestEntity.showDate(requ.getRequestDate()) + "</td>");
                        out.println("<td>" + requ.getTypeWork().getName() + "</td>");
                        out.println("<td>" + RequestEntity.showDate(requ.getOrderFullfillment()) + "</td>");
                        out.println("<td><a href=\"EditRequest.jsp?idRequest=" + requ.getIdRequest() + "\">"+bundle.getString("listrequest.page.table.edit") +"</a></td>");
                        out.println("</tr>");
                    }
                }
            } else {
                out.println("<tr>");
                out.println("<td>" + bundle.getString("listrequest.page.table.empty") + "</td>");
                out.println("</tr>");
            }
        %>
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
