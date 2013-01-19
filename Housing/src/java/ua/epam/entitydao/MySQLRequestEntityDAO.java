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
            while(result.next()){
               RequestEntity myReq = new RequestEntity();
               myReq.setIdRequest(result.getInt("idrequest"));
               myReq.setWorkScope(result.getString("work_scope"));
               
               Date requestDate = result.getDate("request_date");
               Date orderDate = result.getDate("order_fulfillment");
               int wrkType = result.getInt("work_type");
               int user = result.getInt("userid");
               
               /* convert Date to GregorianCalendar */
               GregorianCalendar greg = new GregorianCalendar();
               greg.setTimeInMillis(requestDate.getTime());
               myReq.setRequestDate(greg);
               greg.setTimeInMillis(orderDate.getTime());
               myReq.setOrderFullfillment(greg);
               
               MySQLUserDAO usrDAO = new MySQLUserDAO();
               User usr = usrDAO.getUser(user);
               myReq.setUser(usr);
               
               MySQLWorkTypeDAO workDAO = new MySQLWorkTypeDAO();
               WorkType myWork = workDAO.getWorkType(wrkType);
               myReq.setTypeWork(myWork);
               
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
            PreparedStatement query = accessConn.prepareStatement("Insert into request (request_date, work_type, work_scope, order_fulfillment, userid) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            int _user = set.getUser().getIdUser();
            int _workType = set.getTypeWork().getIdWorkType();
            
            /* convert GregorianCalendar to java.sql.Date */
            java.sql.Date requDate = new java.sql.Date(set.getRequestDate().getTimeInMillis());
            java.sql.Date orderDate = new java.sql.Date(set.getOrderFullfillment().getTimeInMillis());
            
            query.setDate(1, requDate);
            query.setInt(2, _workType);
            query.setString(3, set.getWorkScope());
            query.setDate(4, orderDate);
            query.setInt(5, _user);

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

}
