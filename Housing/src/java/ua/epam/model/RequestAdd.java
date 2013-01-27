/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.model;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.epam.entity.*;
import ua.epam.entitydao.*;
import ua.epam.servlet.filter.UMConstants;

/**
 *
 * @author Ivanov Alexander
 */
public class RequestAdd {

    /**
     *
     * @param request
     * @param response
     */
    public static void addToMySQL(HttpServletRequest request, HttpServletResponse response) {
        String orderDate = request.getParameter("orderDate");
        Date oDate = Date.valueOf(orderDate);//
        GregorianCalendar _orderDate = new GregorianCalendar();
        _orderDate.setTimeInMillis(oDate.getTime());

        String idWorkType = request.getParameter("workType");
        int workType = Integer.parseInt(idWorkType);//
        DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        WorkTypeDAO typeDAO = daof.getWorkTypeDAO();
        WorkType _workType = typeDAO.getWorkType(workType);

        String workScope = request.getParameter("workScope");//

        HttpSession session = request.getSession(true);
        String usr = (String) session.getAttribute(UMConstants.PRINCIPAL);


        UserDAO user = daof.getUserDAO();
        User _usr = user.getUser(usr);//

        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTimeInMillis(System.currentTimeMillis());//
        RequestEntity newRequest = new RequestEntity(currentDate, _workType, workScope, _orderDate, _usr);

        RequestEntityDAO req = daof.getRequestEntityDAO();
        int check = req.insertRequest(newRequest);
        if (check != 0) {
            try {
                request.getRequestDispatcher("./WelcomePage.jsp").forward(request, response);
            } catch (ServletException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     *
     * @param request
     * @param response
     */
    public static void goToHomePage(HttpServletRequest request, HttpServletResponse response){
        try {
                request.getRequestDispatcher("./WelcomePage.jsp").forward(request, response);
            } catch (ServletException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
    }
}
