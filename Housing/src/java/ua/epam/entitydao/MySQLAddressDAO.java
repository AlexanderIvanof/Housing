/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.entitydao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import ua.epam.entity.*;

/**
 *
 * @author Ivanov Alexander
 */
public class MySQLAddressDAO implements AddressDAO {

    private Connection accessConn;
    private static Logger logger = Logger.getLogger(MySQLAddressDAO.class);
    public final static String LOGFILE = "./logs/log4j.log";

    public MySQLAddressDAO() {
        super();
        try {
            logger.addAppender(new FileAppender(new SimpleLayout(), LOGFILE, false));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        logger.info("MySQLAddressDAO init  ........");
        Date inDate = new Date(System.currentTimeMillis());
        logger.info("Time: " + inDate);
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
            logger.error(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
            logger.error(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                    logger.error(ex.getMessage());
                }
            }
        }

        return generKey;
    }

    @Override
    public Address getAddress(int idaddress) {
        logger.info("MySQLAddressDAO get addres by id: <" + idaddress +">;");
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
            myNew.setIdAddress(idaddress);

            result.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            logger.error(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
            logger.error(ex.getMessage());
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                    logger.error(ex.getMessage());
                }
            }
        }
        return myNew;
    }
}
