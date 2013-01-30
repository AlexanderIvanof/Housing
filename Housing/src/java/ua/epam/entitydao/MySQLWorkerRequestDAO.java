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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 * DAO for worker to request
 *
 * @author Ivanov Alexander
 */
public class MySQLWorkerRequestDAO implements WorkerRequestDAO {

    private Connection accessConn;

    @Override
    public List<Integer> getListRequest(int idworker) {
        List<Integer> myNew = new ArrayList<Integer>();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from worker_request where idworker = " + idworker);
            while (result.next()) {
                myNew.add(Integer.parseInt(result.getString("idrequest")));
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
                    System.out.println(ex.getMessage());
                }
            }
        }
        return myNew;
    }

    @Override
    public int setRow(int idworker, int idrequest) {
        int generKey = 0;
        try {
            accessConn = MySQLDAOFactory.createConnection();

            PreparedStatement query = accessConn.prepareStatement("Insert into worker_request (idworker, idrequest) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, idworker);
            query.setInt(2, idrequest);
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
                    System.out.println(ex.getMessage());
                }
            }
        }

        return generKey;
    }
}
