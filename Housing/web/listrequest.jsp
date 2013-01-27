<%-- 
    Document   : listrequest
    Created on : 24.01.2013, 11:18:53
    Author     : Alexandr Ivanov
--%>
<%@page import="ua.epam.servlet.filter.UMConstants" %>
<%@page import="java.util.List"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*"%> 
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Необработанные заявки</title>
    </head>
    <body bgcolor="#7FFFD4">
    <center><h2>Необработанные заявки</h2></center>
    <%
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        RequestEntityDAO requests = daof.getRequestEntityDAO();

        String _user = (String) session.getAttribute(UMConstants.PRINCIPAL);

        List<RequestEntity> list = requests.getAllRequests();
    %>

    <table align="center" border="2" width="60%"
           <tr>
            <td align="center" width="20%"><font>Номер заказа</font></td>
            <td align="center" width="20%"><font>Адрес</font></td>
            <td align="center" width="20%"><font>Дата заказа</font></td>
            <td align="center" width="20%"><font>Наименование работ</font></td>
            <td align="center" width="20%"><font>Дата выполнения заказа</font></td>
            <td align="center" width="20%"><font>Редактировать</font></td>
        </tr>
        <%
            if (!list.isEmpty()) {
                for (RequestEntity requ : list) {
                    if (requ.getApprove() == Approve.WAIT_APPROVE) {
                        out.println("<tr>");
                        out.println("<td>" + requ.getIdRequest() + "</td>");
                        out.println("<td>" + requ.getUser().getAddress() + "</td>");
                        out.println("<td>" + RequestEntity.showDate(requ.getRequestDate()) + "</td>");
                        out.println("<td>" + requ.getTypeWork().getName() + "</td>");
                        out.println("<td>" + RequestEntity.showDate(requ.getOrderFullfillment()) + "</td>");
                        out.println("<td>" + "<a href=\"EditRequest.jsp?idRequest=" + requ.getIdRequest() + "\">Редактировать</a></td>>" + "</td>");
                        out.println("</tr>");
                    }
                }
            } else {
                out.println("<tr>");
                out.println("<td>Заказов нет!</td>");
                out.println("</tr>");
            }
        %>
        <table width="100%" border="0"><tr><td  align="right"><input type="button" value="Назад" onclick="goBack()"/></td></tr></table>        
        <script language="JavaScript">
            function goBack()
            {
                window.history.back();
            }
        </script>
    </body>
</html>
