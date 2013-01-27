/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.model;

import java.io.IOException;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.epam.entitydao.*;
import ua.epam.entity.*;

/**
 *
 * @author Ivanov Alexander
 */
public class WorkPlanAdd {

    public static void addWorkPlanRow(HttpServletRequest request, HttpServletResponse response, int idRequest) {
        
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        RequestEntityDAO redao = daof.getRequestEntityDAO();

        RequestEntity re = redao.getRequest(idRequest);
        User user= re.getUser();
        Address address = user.getAddress();
        int adress = address.getIdAddress();
        String workerStr = request.getParameter("worker");
        int worker = Integer.parseInt(workerStr);
        String foremanStr = request.getParameter("foreman");
        int foreman;
        if (foremanStr.equals("0")){
            foreman = worker;
        } else {
            foreman = Integer.parseInt(foremanStr);
        }

        GregorianCalendar date_plan = re.getOrderFullfillment();
        WorkPlanDAO wpdao = daof.getWorkPlanDAO();
        // add row to work_plan table 
        wpdao.insertRow(foreman, adress, date_plan, worker);

        WorkerRequestDAO wrdao = daof.getWorkerRequestDAO();


        // update workers state
        WorkerDAO wrk = daof.getWorkerDAO();
        Worker first = wrk.getWorker(worker);
        Worker second = wrk.getWorker(foreman);
        wrk.setWorkerBusy(worker, true);
        // add row to worker_request table
        wrdao.setRow(worker, idRequest);
        if (worker != foreman) {
            wrk.setWorkerBusy(foreman, true);
            wrdao.setRow(foreman, idRequest);
        }
        redao.setApprove(idRequest, Approve.APPROVE);
        try {
            request.getRequestDispatcher("./Dispatcher.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deniedRequest(HttpServletRequest request, HttpServletResponse response, int idRequest){
        
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        RequestEntityDAO redao = daof.getRequestEntityDAO();

        redao.setApprove(idRequest, Approve.COULD_NOT_BE);
        try {
            request.getRequestDispatcher("./Dispatcher.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
