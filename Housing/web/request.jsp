<%-- 
    Document   : request
    Created on : 24.01.2013, 11:18:53
    Author     : Alexandr Ivanov
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@page import="ua.epam.entitydao.*" %>
<%@page import="ua.epam.entity.*" %>
<%@page import="java.util.*"%>
<%!Locale client;%>
<%!Locale sess;%>


<!DOCTYPE html >
<html>
    <head>
        <link rel="icon" href="images/favicon.ico" type="x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Заказ работ</title>
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

        <h1><%=bundle.getString("request.page.order")%></h1>

        <form method="POST" action="./Control">
            <table border="1">

                <tr>

                    <%
                        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                        WorkTypeDAO typeDAO = daof.getWorkTypeDAO();
                        List<WorkType> workTypes = typeDAO.getAllWorkType();
                    %>



                </tr>
                <tr>
                    <td><%=bundle.getString("request.page.date")%></td>
                    <td>
                        <input type="date" name="orderDate"></input>
                    </td>
                </tr>
                <tr>
                    <td><%=bundle.getString("request.page.type")%></td>
                    <td>
                        <select name="workType"><option selected value=1></option>
                            <%
                                for (WorkType wrktp : workTypes) {
                                    out.println("<option value=" + wrktp.getIdWorkType() + ">" + wrktp.getName() + "</option>");
                                }

                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="<%=bundle.getString("request.page.button.create")%>" name="create">
                        <input type="reset" value="<%=bundle.getString("request.page.button.cancel")%>">
                        <input type="submit" value="<%=bundle.getString("page.button.back")%>" name="back"></td>
                </tr>
            </table>

        </form>

    </body>
</html>
