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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добро пожаловать на стартовую страницу!</h1>
        <h1>
            Вы авторизовались как <>
            <%
            String usr = (String) session.getAttribute(UMConstants.PRINCIPAL);
            DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

            UserDAO user = daof.getUserDAO();
            User _usr = user.getUser(usr);
            out.println(_usr.getFirstName() + " " + _usr.getLastName());
            %>
        </h1>
        <table border="2" width="100%">
            <tr>
                <td width="50%">
                    <b><font size="4">
                        <a href="./request.jsp">Сделать заявку.</a>
                    </font></b>
                </td>
                <td width="50%"><b><font size="4">работникам ЖЕКа</font>
                    </b>
                </td>
            </tr>
        </table>
    </body>
</html>
