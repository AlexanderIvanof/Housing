<%-- 
    Document   : workplan
    Created on : 24.01.2013, 11:17:15
    Author     : Alexandr Ivanov
--%>

<%@page import="java.util.*"%>
<%@page import="ua.epam.entitydao.*"%>
<%@page import="ua.epam.entity.*"%>
<%!Locale client;%>
<%!Locale sess;%>
<%! List<WorkPlan> wPlan;%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="table" uri="tlds/table.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>План работ</title>
    </head>
    <body bgcolor="#F0FFFF">

        <%
            // get locale from session 
            sess = (Locale) session.getAttribute("language");
            if (sess != null) {
                client = sess;
            } else {
                client = request.getLocale();
            }

            ResourceBundle bundle = ResourceBundle.getBundle("ua.epam.i18n.LanguageBundle", client);

            DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            WorkPlanDAO wpdao = daof.getWorkPlanDAO();
            wPlan = wpdao.getWorkPlans();
        %>   
    <center><h2><%=bundle.getString("workplan.page.plan")%></h2></center>
    <table width="50%" border="3" align="center">
        <%--
            This is sample of custom tag
        --%>
        <table:row onumber="№"
        foreman="<%=bundle.getString("workplan.page.table.response")%>"
        worker="<%=bundle.getString("workplan.page.table.perform")%>"
        date="<%=bundle.getString("workplan.page.table.date")%>"
        address="<%=bundle.getString("workplan.page.table.address")%>"/>
        <%
            if (!wPlan.isEmpty()) {
                int i = 0;
                for (WorkPlan row : wPlan) {
                    ++i;
        %>
        <table:row onumber="<%=Integer.toString(i)%>" 
        foreman="<%=row.getForeman().toString()%>"
        worker="<%=row.getWorker().toString()%>"
        date="<%=RequestEntity.showDate(row.getPlanDate())%>"
        address="<%=row.getAddress().toString()%>"/>
        <%
                }
            } else {
                out.println("<tr><td>" + bundle.getString("workplan.page.table.empty") + "</td></tr>");
            }
        %>

    </table>

    <table width="100%" border="0">
        <tr align="right">
            <td>
                <input type="button" value="<%=bundle.getString("page.button.back")%>" onclick="goBack()"/>
            </td>
        </tr>
    </table>        
    <script language="JavaScript">
        function goBack()
        {
            window.history.back();
        }
    </script>
</body>
</html>
