/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.entitydao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.naming.NamingException;
import ua.epam.entity.*;

/**
 * DAO for request
 *
 * @author Ivanov Alexander
 */
public class MySQLRequestEntityDAO implements RequestEntityDAO {

    private Connection accessConn;

    @Override
    public List<RequestEntity> getAllRequests() {
        List<RequestEntity> myNew = new ArrayList<RequestEntity>();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from request");
            while (result.next()) {
                RequestEntity myReq = new RequestEntity();
                myReq.setIdRequest(result.getInt("idrequest"));

                Date requestDate = result.getDate("request_date");
                Date orderDate = result.getDate("order_fulfillment");
                int wrkType = result.getInt("work_type");
                int user = result.getInt("userid");

                /* convert Date to GregorianCalendar */
                GregorianCalendar greg = new GregorianCalendar();
                greg.setTimeInMillis(requestDate.getTime());
                myReq.setRequestDate(greg);
                GregorianCalendar greg1 = new GregorianCalendar();
                greg1.setTimeInMillis(orderDate.getTime());
                myReq.setOrderFullfillment(greg1);

                MySQLUserDAO usrDAO = new MySQLUserDAO();
                User usr = usrDAO.getUser(user);
                myReq.setUser(usr);

                MySQLWorkTypeDAO workDAO = new MySQLWorkTypeDAO();
                WorkType myWork = workDAO.getWorkType(wrkType);
                myReq.setTypeWork(myWork);

                Approve app = Approve.EMPTY;
                String approve = result.getString("approved");
                if (approve.equalsIgnoreCase("wait app")) {
                    myReq.setApprove(Approve.WAIT_APPROVE);
                }
                if (approve.equalsIgnoreCase("approve")) {
                    myReq.setApprove(Approve.APPROVE);
                }
                if (approve.equalsIgnoreCase("not approve")) {
                    myReq.setApprove(Approve.COULD_NOT_BE);
                }

                myNew.add(myReq);
            }

            result.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return myNew;
    }

    @Override
    public int insertRequest(RequestEntity set) {
        int generKey = 0;
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            PreparedStatement query = accessConn.prepareStatement("Insert into request (request_date, work_type, order_fulfillment, userid) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            int _user = set.getUser().getIdUser();
            int _workType = set.getTypeWork().getIdWorkType();

            /* convert GregorianCalendar to java.sql.Date */
            java.sql.Date requDate = new java.sql.Date(set.getRequestDate().getTimeInMillis());
            java.sql.Date orderDate = new java.sql.Date(set.getOrderFullfillment().getTimeInMillis());

            query.setDate(1, requDate);
            query.setInt(2, _workType);
            query.setDate(3, orderDate);
            query.setInt(4, _user);

            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                generKey = rs.getInt(1);
            }
            rs.close();
            query.close();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }

        return generKey;
    }

    @Override
    public List<RequestEntity> getRequestsByUser(int userId) {
        List<RequestEntity> myNew = new ArrayList<RequestEntity>();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from request where userid = " + userId);
            while (result.next()) {
                RequestEntity myReq = new RequestEntity();
                myReq.setIdRequest(result.getInt("idrequest"));

                Date requestDate = result.getDate("request_date");
                Date orderDate = result.getDate("order_fulfillment");
                int wrkType = result.getInt("work_type");
                int user = result.getInt("userid");

                /* convert Date to GregorianCalendar */
                GregorianCalendar greg = new GregorianCalendar();
                greg.setTimeInMillis(requestDate.getTime());
                myReq.setRequestDate(greg);
                GregorianCalendar greg1 = new GregorianCalendar();
                greg1.setTimeInMillis(orderDate.getTime());
                myReq.setOrderFullfillment(greg1);

                MySQLUserDAO usrDAO = new MySQLUserDAO();
                User usr = usrDAO.getUser(user);
                myReq.setUser(usr);

                MySQLWorkTypeDAO workDAO = new MySQLWorkTypeDAO();
                WorkType myWork = workDAO.getWorkType(wrkType);
                myReq.setTypeWork(myWork);

                Approve app = Approve.EMPTY;
                String approve = result.getString("approved");
                if (approve.equalsIgnoreCase("wait app")) {
                    myReq.setApprove(Approve.WAIT_APPROVE);
                }
                if (approve.equalsIgnoreCase("approve")) {
                    myReq.setApprove(Approve.APPROVE);
                }
                if (approve.equalsIgnoreCase("not approve")) {
                    myReq.setApprove(Approve.COULD_NOT_BE);
                }

                myNew.add(myReq);
            }

            result.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return myNew;
    }

    @Override
    public RequestEntity getRequest(int idrequest) {
        RequestEntity myNew = new RequestEntity();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from request where idrequest = " + idrequest);
            result.next();

            myNew.setIdRequest(result.getInt("idrequest"));

            Date requestDate = result.getDate("request_date");
            Date orderDate = result.getDate("order_fulfillment");
            int wrkType = result.getInt("work_type");
            int user = result.getInt("userid");

            /* convert Date to GregorianCalendar */
            GregorianCalendar greg = new GregorianCalendar();
            greg.setTimeInMillis(requestDate.getTime());
            myNew.setRequestDate(greg);
            GregorianCalendar greg1 = new GregorianCalendar();
            greg1.setTimeInMillis(orderDate.getTime());
            myNew.setOrderFullfillment(greg1);

            MySQLUserDAO usrDAO = new MySQLUserDAO();
            User usr = usrDAO.getUser(user);
            myNew.setUser(usr);

            MySQLWorkTypeDAO workDAO = new MySQLWorkTypeDAO();
            WorkType myWork = workDAO.getWorkType(wrkType);
            myNew.setTypeWork(myWork);

            Approve app = Approve.EMPTY;
            String approve = result.getString("approved");
            if (approve.equalsIgnoreCase("wait app")) {
                myNew.setApprove(Approve.WAIT_APPROVE);
            }
            if (approve.equalsIgnoreCase("approve")) {
                myNew.setApprove(Approve.APPROVE);
            }
            if (approve.equalsIgnoreCase("not approve")) {
                myNew.setApprove(Approve.COULD_NOT_BE);
            }

            result.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return myNew;
    }

    @Override
    public Approve getApprove(int idrequest) {
        Approve app = Approve.EMPTY;
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from request where idrequest = " + idrequest);
            result.next();
            String approve = result.getString("approved");
            if (approve.equalsIgnoreCase("wait app")) {
                app = Approve.WAIT_APPROVE;
            }
            if (approve.equalsIgnoreCase("approve")) {
                app = Approve.APPROVE;
            }
            if (approve.equalsIgnoreCase("not approve")) {
                app = Approve.COULD_NOT_BE;
            }

            result.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return app;
    }

    @Override
    public void setApprove(int idrequest, Approve current) {

        try {
            String app = "empty";
            accessConn = MySQLDAOFactory.createConnection();
            PreparedStatement query = accessConn.prepareStatement("Update request set approved = ? where idrequest = " + idrequest);
            if (current == Approve.APPROVE) {
                app = "approve";
            }
            if (current == Approve.COULD_NOT_BE) {
                app = "not approve";
            }
            query.setString(1, app);

            query.executeUpdate();

            query.close();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
}
