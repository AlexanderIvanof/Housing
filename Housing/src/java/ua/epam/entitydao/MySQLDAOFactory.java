package ua.epam.entitydao;

import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Rialization DAOFactory for MySQL
 *
 * @author Ivanov Alexander
 */
class MySQLDAOFactory extends DAOFactory {

    public static final String DBURL = "jdbc:mysql://localhost:3306/housing";

    /**
     * Create pool connection to MySQL
     *
     * @return connection
     * @throws SQLException - if can't connect to DB
     * @throws NamingException - if pool not create
     */
    public static Connection createConnection() throws SQLException, NamingException {
        // get pool connection to MySQL DB
        Connection con = null;

        InitialContext context = new InitialContext();
        DataSource mydata = (DataSource) context.lookup("jdbc/MySqlPool");

        if (mydata != null) {
            con = mydata.getConnection();
        } else {
            throw new RuntimeException("Has no connection");
        }
        return con;
    }

    @Override
    public AccessDAO getAccessDAO() {
        return new MySQLAccessDAO();
    }

    @Override
    public AddressDAO getAddressDAO() {
        return new MySQLAddressDAO();
    }

    @Override
    public ProfessionDAO getProfessionDAO() {
        return new MySQLProfessionDAO();
    }

    @Override
    public RequestEntityDAO getRequestEntityDAO() {
        return new MySQLRequestEntityDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public WorkTypeDAO getWorkTypeDAO() {
        return new MySQLWorkTypeDAO();
    }

    @Override
    public WorkerDAO getWorkerDAO() {
        return new MySQLWorkerDAO();
    }

    @Override
    public WorkerRequestDAO getWorkerRequestDAO() {
        return new MySQLWorkerRequestDAO();
    }

    @Override
    public WorkPlanDAO getWorkPlanDAO() {
        return new MySQLWorkPlanDAO();
    }
}
