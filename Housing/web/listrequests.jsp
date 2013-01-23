<%-- 
    Document   : listrequests
    Created on : 20.01.2013, 20:49:58
    Author     : Alexandr Ivanov
--%>

<%@page import="ua.epam.servlet.filter.UMConstants" %>
<%@page import="java.util.List"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*;"%> 
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/favicon.ico" type="x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Мои заявки</title>
    </head>
    <body bgcolor="#7FFFD4">
    <center> <h1>СПИСОК ЗАЯВОК</h1></center>
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
            <td align="center" width="20%"><font>Номер заказа</font></td>
            <td align="center" width="20%"><font>Дата заказа</font></td>
            <td align="center" width="20%"><font>Наименование работ</font></td>
            <td align="center" width="20%"><font>Объем работ</font></td>
            <td align="center" width="20%"><font>К какой дате завершить</font></td>
        </tr>
        <%
            if (!list.isEmpty()) {
                for (RequestEntity requ : list) {
                    out.println("<tr>");
                    out.println("<td>" + requ.getIdRequest() + "</td>");
                    out.println("<td>" + RequestEntity.showDate(requ.getRequestDate()) + "</td>");
                    out.println("<td>" + requ.getTypeWork().getName() + "</td>");
                    out.println("<td>" + requ.getWorkScope() + "</td>");
                    out.println("<td>" + RequestEntity.showDate(requ.getOrderFullfillment()) + "</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                out.println("<td>Заказов нет!</td>");
                out.println("</tr>");
            }
        %>
        <table/>
    </body>
</html>
