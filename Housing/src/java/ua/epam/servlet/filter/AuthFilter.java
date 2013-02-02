package ua.epam.servlet.filter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ua.epam.entity.*;
import ua.epam.entitydao.*;

/**
 * This filter get access to start page and open session.
 *
 * @author Alexandr Ivanov
 */
public class AuthFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        boolean isPassMatch = false;
        try {
            String redirectURL = filterConfig.getInitParameter(UMConstants.REDIRECT_URL);
            String loginURI = filterConfig.getInitParameter(UMConstants.LOGIN_PAGE);
            String homeURL = filterConfig.getInitParameter(UMConstants.HOME_URL);
            String stringFatal = "Wrong user name or password";

            if (request instanceof HttpServletRequest) {

                HttpServletRequest req = (HttpServletRequest) request;
                HttpSession session = req.getSession(true);
                req.setAttribute("curTime", new Date());
                req.setAttribute("curTimeMillis", System.currentTimeMillis());
                Object auth = session.getAttribute(UMConstants.PRINCIPAL);
                UserType uType = (UserType) session.getAttribute(UMConstants.USER_TYPE);


                if (auth != null) {
                    chain.doFilter(req, response);
                    System.out.println("===Authorized user =<" + auth.toString() + "> type <" + uType.toString() + ">===");
                } else if (req.getServletPath() != null && req.getServletPath().endsWith(loginURI)) {
                    // client trying to login - let him do this
                    System.out.println("go to login page<" + loginURI + ">");
                    chain.doFilter(request, response);

                } else if (req.getServletPath() != null && req.getServletPath().endsWith("Out")) {

                    RequestDispatcher rd = request.getRequestDispatcher(loginURI);
                    rd.forward(request, response);


                } else if (req.getServletPath() != null && req.getServletPath().endsWith("authUser.do")) {

                    // Connection to database and user confirmation
                    try {

                        MySQLAccessDAO nrm = new MySQLAccessDAO();
                        List<Access> all = nrm.getAllLoggins();

                        String userNameFromBlank, password;

                        userNameFromBlank = request.getParameter("txtUserName");
                        System.out.println("========= Entered username is <" + userNameFromBlank + ">=======");
                        password = request.getParameter("txtUsrPwd");
                        password = password.trim();
                        userNameFromBlank = userNameFromBlank.trim();

                        for (Access acs : all) {

                            //user Authentificartion by name & password
                            if ((acs.getUsername().equals(userNameFromBlank)) && (userNameFromBlank.length() != 0) && (password.length() != 0)) {
                                if (acs.getPassword().equals(password)) {
                                    isPassMatch = true;
                                    System.out.println("######AUTH_FILTER######### "
                                            + "\n AUTHENTIFICATION SUCCESS ");
                                    session.setAttribute(UMConstants.PRINCIPAL, acs.getUsername());
                                    session.setAttribute(UMConstants.USER_TYPE, acs.getUserType());
                                    break;
                                } else {
                                    System.out.print(".");
                                }
                            } else {
                                System.out.print(".");
                            }
                        }

                        if (isPassMatch) {
                            System.out.println(">>>>>>>> LOGIN");
                            RequestDispatcher rd = null;
                            UserType type = (UserType) session.getAttribute(UMConstants.USER_TYPE);
                            if (type == UserType.USER) {
                                rd = request.getRequestDispatcher(homeURL);
                            }
                            if (type == UserType.ADMINISTRATOR) {
                                rd = request.getRequestDispatcher(redirectURL);
                            }
                            request.removeAttribute(UMConstants.ERRORMESSAGE);
                            if (rd != null) {
                                rd.forward(request, response);
                            }

                        } else {
                            //((HttpServletResponse)response).sendRedirect("http://localhost:8888/usrmgr/Login_page.jsp");
                            RequestDispatcher rd = request.getRequestDispatcher(loginURI);
                            request.setAttribute(UMConstants.ERRORMESSAGE, stringFatal);
                            rd.forward(request, response);
                            System.out.println("######AUTH_FILTER######### "
                                    + " WRONG USER NAME OR PASSWORD");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    // unauthorized client trying to access site - let's redirect him to the login page
                    System.err.println("Unauthorized user from [" + req.getRemoteHost() + "] has tried to access the site");
                    RequestDispatcher rd = request.getRequestDispatcher(loginURI);

                    if (rd == null) {
                        System.err.println("Bad Login URI [" + loginURI + "]. AuthFilter getRequestDispatcher() returned null.");
                    } else {
                        //request.setAttribute(UMConstants.ERRORMESSAGE, stringFatal);
                        rd.forward(request, response);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            throw ex;
        } catch (ServletException ex) {
            ex.printStackTrace(System.err);
            throw ex;
        }


    }
}
