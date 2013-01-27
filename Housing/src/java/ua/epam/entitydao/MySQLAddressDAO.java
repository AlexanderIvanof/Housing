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
import org.apache.log4j.Logger;
import ua.epam.entity.*;

/**
 *
 * @author Ivanov Alexander
 */
public class MySQLAddressDAO implements AddressDAO {

    private Connection accessConn;
    
    private static Logger logger = Logger.getLogger(MySQLAccessDAO.class);
     
    public MySQLAddressDAO(){
        super();
        logger.debug("MySQLAddressDAO init  ........");
    } 

    @Override
    public int insertAddress(Address myadd) {
        int generKey = 0;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            PreparedStatement query = accessConn.prepareStatement("Insert into address (street, building, flat) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, myadd.getStreet());
            query.setString(2, myadd.getBuilding());
            query.setString(3, myadd.getFlat());

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
    public Address getAddress(int idaddress) {
        logger.debug("MySQLAddressDAO get addres by id: " + idaddress);
        Address myNew = new Address();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from address where idaddress = " + idaddress);
            result.next();
            myNew.setStreet(result.getString("street"));
            myNew.setBuilding(result.getString("building"));
            myNew.setFlat(result.getString("flat"));

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
}
