/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.servletcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.epam.entity.UserType;
import ua.epam.servlet.filter.UMConstants;

/**
 *
 * @author Alexandr Ivanov
 */
@WebServlet(name = "LangChange", urlPatterns = {"/LangChange"})
public class LangChange extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LangChange</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LangChange at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lang = request.getParameter("lang");
        if (lang.equalsIgnoreCase("GB")) {
            request.getSession().setAttribute("language", Locale.UK);
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
        if (lang.equalsIgnoreCase("RU")) {
            request.getSession().setAttribute("language", new Locale("ru_RU"));
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
