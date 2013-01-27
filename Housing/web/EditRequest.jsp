<%-- 
    Document   : listrequest
    Created on : 24.01.2013, 11:18:53
    Author     : Alexandr Ivanov
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@page  import="ua.epam.entitydao.*,ua.epam.servletcontroller.*" %>
<%@page import="ua.epam.entity.*" %>

<%!  RequestEntity currentRequest;%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/dispatch.ico" type="x-icon">
        <link rel="shortcut icon" href="images/dispatch.ico" type="x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактор</title>
    </head>
    <%
        String idReques = request.getParameter("idRequest");
        int i = Integer.parseInt(idReques);
        request.getSession().setAttribute("idRequest", i);
       
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
    <body bgcolor="#7FFFD4">
        <h2>Редактирование заявок</h2>
        <h3>Тип выполняемой работы: <%=currentRequest.getTypeWork()%></h3>

        <form action="./Process" method="POST">
            <table align="center" border="2" width="50%"
                   <tr>
                    <td align="right">Выполняющий:</td>
                    <td><select name="worker"><option selected value=1></option>
                            <%
                                WorkerDAO wdao = daof.getWorkerDAO();
                                Profession cprof = currentRequest.getTypeWork().getWhoDo();
                                List<Worker> workers = wdao.getWorkerByProfession(cprof);
                                WorkerRequestDAO wrdao = daof.getWorkerRequestDAO();
                                RequestEntityDAO redao = daof.getRequestEntityDAO();
                                Boolean isBusy = false;
                                for (int j = 0; j < workers.size(); j++) {
                                    if (workers.get(j).isBusy()) {
                                        List<Integer> idreqs = wrdao.getListRequest(workers.get(j).getIdworker());
                                        for (int ii = 0; ii < idreqs.size(); i++) {
                                            RequestEntity re = redao.getRequest(idreqs.get(ii));
                                            if (currentRequest.getOrderFullfillment().equals(re.getOrderFullfillment())) {
                                                isBusy = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!isBusy) {
                                        out.println("<option value=" + (workers.get(j).getIdworker()) + ">"
                                                + workers.get(j).getLastName() + " "
                                                + workers.get(j).getFirstName() + "</option>");
                                    }
                                     isBusy = false;
                                }

                            %>
                        </select></td>
                </tr>
                <tr>
                    <td align="right">Ответственный за выполнение: </td>
                    <td>
                        <select name="foreman"><option selected value=0></option>
                            <%
                                // add all formans
                                ProfessionDAO profession = daof.getProfessionDAO();
                                Profession frmn = profession.getProfession(1);
                                List<Worker> formans = wdao.getWorkerByProfession(frmn);
                                boolean isBusyForeman = false;
                                for (int j = 0; j < formans.size(); j++) {
                                    if (formans.get(j).isBusy()) {
                                        List<Integer> idreqs = wrdao.getListRequest(formans.get(j).getIdworker());
                                        for (int ii = 0; ii < idreqs.size(); i++) {
                                            RequestEntity re = redao.getRequest(idreqs.get(ii));
                                            if (currentRequest.getOrderFullfillment().equals(re.getOrderFullfillment())) {
                                                isBusyForeman = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!isBusyForeman) {
                                        out.println("<option value=" + (formans.get(j).getIdworker()) + ">"
                                                + formans.get(j).getLastName() + " "
                                                + formans.get(j).getFirstName() + "</option>");
                                    }
                                        isBusyForeman = false;
                                }
                            %>
                    </td>
                </tr>
                <tr  border="0">
                    <td></td>
                    <td>
                        <input type="submit" value="Отказать" name="denied"/>
                        <input type="submit" value="Обработать" name="process"/>
                    </td>
                </tr>
            </table>
        </form>
        <table width="100%" border="0"><tr align="right"><input type="button" value="Назад" onclick="goBack()"/></tr></table>        
    <script language="JavaScript">
        function goBack()
        {
            window.history.back();
        }
    </script>
</body>
</html>
