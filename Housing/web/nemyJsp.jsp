<%-- 
    Document   : nemyJsp
    Created on : 13.01.2013, 14:03:20
    Author     : Alexandr Ivanov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page  import="ua.epam.entitydao.*" %>
<%@page import="ua.epam.entity.*" %>
<%@page  import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connection Pool</title>
    </head>
    <body>
        <h1>Data in my Connection Pooled Database</h1>
        <br>
        <%
              MySQLRequestEntityDAO msqlredao = new MySQLRequestEntityDAO();
              List<RequestEntity> re = msqlredao.getAllRequests();
//            MySQLUserDAO userDAO = new MySQLUserDAO();
//            List<User> usr = userDAO.getAllUsers();
            for (RequestEntity user : re) {
                out.print(user + "<br>");
            }

           
        %>
    </body>
</html>
