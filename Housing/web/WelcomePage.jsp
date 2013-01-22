<%-- 
    Document   : WelcomPage
    Created on : 20.01.2013, 20:20:37
    Author     : Alexandr Ivanov
--%>

<%@page import="ua.epam.entitydao.*;"%>
<%@page import="ua.epam.entity.*;"%>
<%@page import="ua.epam.servlet.filter.UMConstants;"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Начальная</title>
    </head>
    <body bgproperties="fixed" bgcolor="#CCCCFF">
        <%
        Locale client = request.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.WelcomePage", client);  
        %>
        <table border="0" align="right">
            <tr>
                <td>
                    <img src="<%=bundle.getString("welcome.page.flag")%>" width="75" heigth="50" />
                </td>
            </tr>
        </table>
                
        <h1><%=bundle.getString("welcome.page.welcome")%></h1>
        <h2>
            <%=bundle.getString("welcome.page.loggin") %> <b>
            <%
            String usr = (String) session.getAttribute(UMConstants.PRINCIPAL);
            DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

            UserDAO user = daof.getUserDAO();
            User _usr = user.getUser(usr);
            out.println(_usr.getFirstName() + " " + _usr.getLastName() + ".");
            %></b>
        </h2>
        <table border="2" width="100%">
            <tr>
                <td align="center" width="50%">
                    <b><font size="4">
                        <a href="./request.jsp"><%=bundle.getString("welcome.page.create")%></a>
                    </font></b>
                </td>
                <td align="center" width="50%">
                    <b><font size="4">
                        <a href="./listrequests.jsp"><%=bundle.getString("welcome.page.show")%></a>
                    </font></b>
                </td>
            </tr>
        </table>
        
        <p align="right">
            <font size="3"><%=bundle.getString("welcome.page.exit")%></font> <input
                type="button" value="<%=bundle.getString("welcome.page.button")%>" name="btLogin" onClick="showLoginHtm()">
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
