<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@page  import="ua.epam.entitydao.*,ua.epam.servletcontroller.*" %>
<%@page import="ua.epam.entity.*" %>
<%@page  import="java.util.List"%>


<!DOCTYPE html >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Заказ работ</title>
    </head>
    <body>

        <h1>Заказать работы</h1>

        <form method="GET" action="addUser.do" name="add">
            <table border="1" bgcolor="#CCCCFF">

                <tr>
     
                    <%
                        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                        WorkTypeDAO typeDAO = daof.getWorkTypeDAO();
                        List<WorkType> workTypes = typeDAO.getAllWorkType();
                    %>



                </tr>
                <tr>
                    <td>К какому времени желаете начать: </td>
                    <td><input type="text" name="currentDate" value=""></input></td>
                </tr>
                <tr>
                    <td>Тип работ:</td>
                    <td><select name="workType"><option selected value=2>выбор</option>
                            <option value=1>покопать</option>
                            <option value=2>посапать</option>
                            <option value=3>покрасить стены</option>
                        </select></td>
                </tr>
                <tr>
                <tr>

                </tr>
                <tr>
                    <td><input type="submit" value="создать заказ"> <input
                            type="reset" value="Сбросить"> <input type="submit"
                            value="Back"></td>
                </tr>
            </table>

        </form>

    </body>
</html>
