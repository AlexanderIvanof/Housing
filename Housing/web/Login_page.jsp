<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ page import="java.util.*, ua.epam.servlet.filter.*, ua.epam.servletcontroller.*"%>
<html>
    <head>
        <link rel="icon" href="images/favicon.ico" type="x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ЖЕК №81</title>
    </head>

    <body bgcolor="#7FFFD4">
        <form name="auth" action="WauthUser.do" method="POST">
            <p align="center"></p>

            <table>
                <tr>

                <hr>
                <table border="0" width="100%" height="42">
                    <tr>
                        <td width="60%" height="36"><b><font face="monospace" size="5"><i>Добро пожаловать на страницу ЖЕК</i> </font> </b>
                        </td>
                        <td width="40%" height="36"></td>
                    </tr>
                    <tr>
                        <td width="60%" height="36"><b><font face="monospace" size="5"><i>Для продолжения работы необходимо авторизоваться</i> </font> </b>
                        </td>
                        <td width="40%" height="36"></td>
                    </tr>
                </table>
                <p align="left">
                    <%
                        String url = request.getRequestURI();
                        String message;

                        if ((request.getAttribute(UMConstants.ERRORMESSAGE) != null)) {
                            String theName = request.getParameter("txtUserName");
                            String thePass = request.getParameter("txtUsrPwd");
                            message = (String) request.getAttribute(UMConstants.ERRORMESSAGE);
                    %>
                    <b><font size="4" color="red"><%=message%></b></font><br></br>

                    <%
                        }
                    %>
                </p>
                <jsp:include page="WhatsNew.jsp" flush="true"/>
                <p></p>
                <table border="0">
                    <tr>
                        <td align="right">
                            <font face="monospace"><b>Имя пользователя:</b></font>
                        </td>
                        <td>
                            <input type="text" name="txtUserName" size="20">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <font face="monospace"><b>Пароль</b></font>
                        </td>
                        <td>
                            <input type="password" name="txtUsrPwd" size="20">
                        </td>
                    </tr>
                    <tr align="left">
                        <td></td>
                        <td align="right">
                            <input type="submit" value="Принять" name="login">&nbsp;
                            <input type="button" value="Отменить" name="cancel" onClick="home()">
                        </td>
                    </tr>
                </table>
        </form>
        <p>&nbsp;</p>
        <script language="JavaScript">
            function home() {
                open("WelcomePage.jsp");
            }
        </script>
    </body>
</html>
