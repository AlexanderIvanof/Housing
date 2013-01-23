<%@page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>

<%@page  import="ua.epam.entitydao.*,ua.epam.servletcontroller.*" %>
<%@page import="ua.epam.entity.*" %>
<%@page  import="java.util.List"%>


<!DOCTYPE html >
<html>
    <head>
        <link rel="icon" href="images/favicon.ico" type="x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Заказ работ</title>
    </head>
    <body bgcolor="#7FFFD4">

        <h1>Заказать работы</h1>

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
                    <td>К какому времени желаете начать:</td>
                    <td>
                        <input type="date" name="orderDate"></input>
                    </td>
                </tr>
                <tr>
                    <td>Тип работ:</td>
                    <td>
                        <select name="workType"><option selected value=2></option>
                            <%
                                for (WorkType wrktp : workTypes) {
                                    out.println("<option value=" + wrktp.getIdWorkType() + ">" + wrktp.getName() + "</option>");
                                }

                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Объем работ: </td>
                    <td><input type="text" name="workScope"></input></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Создать заказ" name="create">
                        <input type="reset" value="Сбросить">
                        <input type="submit" value="Back" name="back"></td>
                </tr>
            </table>

        </form>

    </body>
</html>
