package ua.epam.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.epam.entity.UserType;
import ua.epam.servlet.filter.UMConstants;

/**
 * Model class for exit
 *
 * @author Ivanov Alexander
 */
public class GoOut {

    /**
     * Invalidate session and redirect to Login_page.jsp
     *
     * @param request
     * @param response
     */
    public static void goOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        try {
            request.getRequestDispatcher("Login_page.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Go back to page
     *
     * @param request
     * @param response
     */
    public static void goBack(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession sess = request.getSession(true);
            UserType user = (UserType) sess.getAttribute(UMConstants.USER_TYPE);
            if (user == UserType.ADMINISTRATOR) {
                request.getRequestDispatcher("Dispatcher.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WelcomePage.jsp").forward(request, response);
            }
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
