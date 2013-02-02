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
import org.apache.log4j.PatternLayout;
import ua.epam.entity.*;

/**
 * DAO for proffesion
 *
 * @author Ivanov Alexander
 */
public class MySQLProfessionDAO implements ProfessionDAO {

    private Connection accessConn;
    private static Logger logger = Logger.getLogger(MySQLProfessionDAO.class);
    public final static String LOGFILE = "./logs/log4j.log";

    /**
     * Construct an empty profession DAO. Also create loggining for log4j
     */
    public MySQLProfessionDAO() {
        super();
        try {
            logger.addAppender(new FileAppender(new PatternLayout("%p %d{HH:mm:ss}: %m"), LOGFILE, false));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        logger.info("MySQLProfessionDAO init  ........");
        Date inDate = new Date(System.currentTimeMillis());
        logger.info("Time: " + inDate);
    }

    @Override
    public Profession getProfession(int idprofession) {
        logger.info("MySQLProfessionDAO detting profession by id: " + idprofession);
        Profession myNew = new Profession();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from profession where idprofession = " + idprofession);
            result.next();
            myNew.setNameprof(result.getString("nameprof"));
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

    @Override
    public int insertProfession(Profession prof) {
        int generKey = 0;
        Statement statement = null;
        try {
            PreparedStatement query = accessConn.prepareStatement("Insert into profession (nameprof) values (?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, prof.getNameprof());
            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                generKey = rs.getInt(1);
            }
            rs.close();
            query.close();
        } catch (SQLException ex) {
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
}
