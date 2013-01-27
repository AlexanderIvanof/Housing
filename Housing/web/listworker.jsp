<%-- 
    Document   : listworker
    Created on : 24.01.2013, 11:16:10
    Author     : Alexandr Ivanov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*"%> 
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
    <body bgcolor="#7FFFD4">
    <center><h3>Список рабочих жека.</h3></center>
    <table align="center" border="4" width="60%"
           <tr>
            <td align="center" width="5%"><font>ID</font></td>
            <td align="center" width="20%"><font>Имя</font></td>
            <td align="center" width="20%"><font>Фамилия</font></td>
            <td align="center" width="20%"><font>Специальность</font></td>
            <td align="center" width="15%"><font>Номер команды</font></td>
            <td align="center" width="15%"><font>Занятость</font></td>
        </tr>
        <%
            if (!list.isEmpty()) {
                for (Worker wrkr : list) {
                    out.println("<tr>");
                    out.println("<td align=\"center\">" + wrkr.getIdworker() + "</td>");
                    out.println("<td>" + wrkr.getFirstName() + "</td>");
                    out.println("<td>" + wrkr.getLastName() + "</td>");
                    out.println("<td>" + wrkr.getProf() + "</td>");
                    if (wrkr.getTeam() == -1) {
                        out.println("<td>Нет команды</td>");
                    } else {
                        out.println("<td>" + wrkr.getTeam() + "</td>");
                    }
                    if (wrkr.isBusy()) {
                        out.println("<td>Занят</td>");
                    } else {
                        out.println("<td>Свободен</td>");
                    }
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                out.println("<td>Рабочих нет!</td>");
                out.println("</tr>");
            }
        %>
        <table/>
        <table width="100%" border="0"><tr align="right"><input type="button" value="Назад" onclick="goBack()"/></tr></table>        
        <script language="JavaScript">
            function goBack()
            {
                window.history.back();
            }
        </script>
    </body>
</html>
