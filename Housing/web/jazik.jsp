<%-- 
    Document   : jazik
    Created on : 25.01.2013, 17:16:29
    Author     : Alexandr Ivanov
--%>

<%@page import="java.util.List"%>
<%@page import="ua.epam.entitydao.WorkerDAO"%>
<%@page import="ua.epam.entitydao.DAOFactory, ua.epam.entity.*"%>
<%@page import="java.util.Locale, java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!Locale client;%>
<%!Locale sess;%>

<%
    sess = (Locale) session.getAttribute("language");
    if (sess != null) {
        client = sess;
    } else {
        client = request.getLocale();
    }

    ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.WelcomePage", client);
%>

<table align="center">
    <tr>
        <td><%=bundle.getString("locale.page.choose")%></td>
        <td><image src="images/flag_GB.jpg" width="150" height="100"/></td>
        <td><image src="images/flag_ru.gif" width="150" height="100"/></td>
    </tr>
</table>
<%
//    DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//    WorkerDAO wdao = daof.getWorkerDAO();
//    Profession prof = new Profession("столяр");
//    List<Worker> list = wdao.getWorkerByProfession(prof);
//    for(Worker wrk: list){
//    out.println(wrk + "<br>");
//       }
%>
