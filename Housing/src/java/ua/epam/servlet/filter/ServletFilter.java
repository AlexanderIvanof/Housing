package ua.epam.servlet.filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter add rows to standart server logger
 *
 * @author Alexandr Ivanov
 */
public class ServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        //Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();

        //Log the IP address and current timestamp.
        System.out.println(">>>>>>>>>>>>>>> IP " + ipAddress + ", Time " + new Date().toString());

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        //Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    @Override
    public void destroy() {
        //add code to release any resource
    }
}
