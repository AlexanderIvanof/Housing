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
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * Add rows to logger
 *
 * @author Alexandr Ivanov
 */
public class LoggingFilter implements Filter {

    public final static String LOGFILE = "./logs/log4j.log";
    Logger logger;

    public LoggingFilter() throws IOException {
        logger = Logger.getLogger(LoggingFilter.class);
        logger.addAppender(new FileAppender(new SimpleLayout(), LOGFILE, false));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        Date inDate = new Date(System.currentTimeMillis());
        logger.info("Time: " + inDate);
        HttpServletRequest request = (HttpServletRequest) req;

        //Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();
        String localAddr = request.getLocalAddr();
        String userName = request.getLocalName();
        String URL = request.getRequestURI();


        //Log the IP address and current timestamp + username.
        logger.info(">>>>>>>>>>>>>>>> IP=<" + ipAddress + "> URL=<" + URL + ">, user=<" + userName + ">, on time " + new Date().toString());
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        //Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        logger.info("Test Param: " + testParam);
    }

    @Override
    public void destroy() {
        //add code to release any resource
    }
}
