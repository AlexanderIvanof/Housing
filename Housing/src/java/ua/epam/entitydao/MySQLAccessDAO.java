package ua.epam.entitydao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import ua.epam.entity.Access;
import ua.epam.entity.UserType;

/**
 * DAO Access for MySQL
 *
 * @author Ivanov Alexander
 */
public class MySQLAccessDAO implements AccessDAO {

    private Connection accessConn;
    public final static String LOGFILE = "./logs/log4j.log";
    private static Logger logger = Logger.getLogger(MySQLAccessDAO.class);

    /**
     * Construct an empty access DAO. Also create loggining for log4j
     */
    public MySQLAccessDAO() {
        super();
        try {
            logger.addAppender(new FileAppender(new PatternLayout("%p %d{HH:mm:ss}: %m"), LOGFILE, false));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        logger.info("MysqlAccessDAO init ..........");
        Date inDate = new Date(System.currentTimeMillis());
        logger.info("Time: " + inDate);

    }

    @Override
    public int insertAccess(Access acs) {
        logger.info("MysqlAccessDAO insert ACCESS to DB");
        int generKey = 0;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            logger.info("Get connection to MySQL with DAO;");
            PreparedStatement query = accessConn.prepareStatement("Insert into access (username, passwd, user_type) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, acs.getUsername());
            query.setString(2, acs.getPassword());
            switch (acs.getUserType()) {
                case USER:
                    query.setInt(3, 2);
                    break;
                case ADMINISTRATOR:
                    query.setInt(3, 1);
                    break;
            }

            query.executeUpdate();
            logger.info("Exequte query;");
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
    public Access getAccess(int idaccess) {
        logger.info("MysqlAccessDAO getting access by: " + idaccess);
        Access myNew = new Access();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from access where idaccess = " + idaccess);
            result.next();
            UserType type = UserType.EMPTY;
            switch (result.getInt("user_type")) {
                case 1:
                    type = UserType.ADMINISTRATOR;
                    break;
                case 2:
                    type = UserType.USER;
                    break;
                default:
                    type = UserType.EMPTY;
                    break;
            }
            myNew.setIdAccess(result.getInt("idaccess"));
            myNew.setUsername(result.getString("username"));
            myNew.setPassword(result.getString("passwd"));
            myNew.setUserType(type);

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
    public Access getAccess(String username) {
        logger.info("MysqlAccessDAO getting access by: <" + username + ">;");
        Access myNew = new Access();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from access where username = '" + username + "'");
            result.next();
            UserType type;
            switch (result.getInt("user_type")) {
                case 1:
                    type = UserType.ADMINISTRATOR;
                    break;
                case 2:
                    type = UserType.USER;
                    break;
                default:
                    type = UserType.EMPTY;
                    break;
            }
            myNew.setIdAccess(result.getInt("idaccess"));
            myNew.setUsername(result.getString("username"));
            myNew.setPassword(result.getString("passwd"));
            myNew.setUserType(type);
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
    public List<Access> getAllLoggins() {
        logger.info("MysqlAccessDAO getting all logins");
        Statement statement = null;
        List<Access> allLoggins = new ArrayList<Access>();
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from access");
            while (result.next()) {
                UserType type;
                switch (result.getInt("user_type")) {
                    case 1:
                        type = UserType.ADMINISTRATOR;
                        break;
                    case 2:
                        type = UserType.USER;
                        break;
                    default:
                        type = UserType.EMPTY;
                        break;
                }
                Access _acc = new Access(result.getString("username"),
                        result.getString("passwd"),
                        type);
                _acc.setIdAccess(result.getInt("idaccess"));
                allLoggins.add(_acc);

            }
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

        return allLoggins;
    }
}
