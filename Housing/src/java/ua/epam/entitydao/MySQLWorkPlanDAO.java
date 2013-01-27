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
import java.util.GregorianCalendar;
import javax.naming.NamingException;

/**
 *
 * @author Ivanov Alexander
 */
public class MySQLWorkPlanDAO implements WorkPlanDAO {

    private Connection accessConn;

    @Override
    public int insertRow(int foreman, int address, GregorianCalendar planDate, int worker) {
        int generKey = 0;
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();

            PreparedStatement query = accessConn.prepareStatement("Insert into work_plan (foreman, address, plan_date, worker) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);


            query.setInt(1, foreman);
            query.setInt(2, address);
            query.setInt(4, worker);
            query.setDate(3, new java.sql.Date(planDate.getTimeInMillis()));

            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();

            if (rs.next()) {
                generKey = rs.getInt(1);
            }
            rs.close();
            query.close();


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
        return generKey;
    }
}
