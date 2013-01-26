/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.entitydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import ua.epam.entity.Approve;

/**
 *
 * @author Ivanov Alexander
 */
public class MySQLApproveDAO implements ApproveDAO {

    private Connection accessConn;

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
            PreparedStatement query = accessConn.prepareStatement("Insert into request (approved) values (?)");
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
