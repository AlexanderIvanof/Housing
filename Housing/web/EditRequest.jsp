<%-- 
    Document   : listrequest
    Created on : 24.01.2013, 11:18:53
    Author     : Alexandr Ivanov
--%>
<%@page import="ua.epam.servlet.filter.UMConstants" %>
<%@page import="java.util.List"%>
<%@page import="ua.epam.entity.*, ua.epam.entitydao.*;"%> 
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@page  import="ua.epam.entitydao.*,ua.epam.servletcontroller.*" %>
<%@page import="ua.epam.entity.*" %>

<%!  RequestEntity currentRequest;%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="/images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="/images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List request</h1><%
            String idReques = request.getParameter("idRequest");
            int i = Integer.parseInt(idReques);

            DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            RequestEntityDAO requests = daof.getRequestEntityDAO();
            List<RequestEntity> list = requests.getAllRequests();
            for (RequestEntity req : list) {
                if (req.getIdRequest() == i) {
                    currentRequest = req;
                    break;
                }
            }
        %>

        <table align="center" border="2" width="60%"
               <tr>
                <td align="center" width="20%"><font>Номер заказа</font></td>
            </tr>
            <tr>
                <td>Тип работ:</td>
                <%=currentRequest.getTypeWork()%>
                <%
                    WorkTypeDAO typeDAO = daof.getWorkTypeDAO();
                    List<WorkType> workTypes = typeDAO.getAllWorkType();
                %>

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
    </body>
</html>
