<%-- 
    Document   : WelcomPage
    Created on : 20.01.2013, 20:20:37
    Author     : Alexandr Ivanov
--%>

<%@page import="ua.epam.entitydao.*;"%>
<%@page import="ua.epam.entity.*;"%>
<%@page import="ua.epam.servlet.filter.UMConstants;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Начальная</title>
    </head>
    <body bgproperties="fixed" bgcolor="#CCCCFF">
        <h1>Добро пожаловать на стартовую страницу!</h1>
        <h1>
            Вы авторизовались как <b>
            <%
            String usr = (String) session.getAttribute(UMConstants.PRINCIPAL);
            DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

            UserDAO user = daof.getUserDAO();
            User _usr = user.getUser(usr);
            out.println(_usr.getFirstName() + " " + _usr.getLastName() + ".");
            %></b>
        </h1>
        <table border="2" width="100%">
            <tr>
                <td align="center" width="50%">
                    <b><font size="4">
                        <a href="./request.jsp">Создать заявку.</a>
                    </font></b>
                </td>
                <td align="center" width="50%">
                    <b><font size="4">
                        <a href="./listrequests.jsp">Просмотреть заявки.</a>
                    </font></b>
                </td>
            </tr>
        </table>
        
        <p align="right">
            <font size="3">Для выхода нажмите</font> <input
                type="button" value="Выход" name="btLogin" onClick="showLoginHtm()">
        </p>
        <p>&nbsp;</p>
        <script language="JavaScript">
            function showLoginHtm()
            {
                open("LogOut.jsp");
            }
        </script>
    </body>
</html>
