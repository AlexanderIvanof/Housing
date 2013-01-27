package ua.epam.entitydao;

/**
 *
 * @author Ivanov Alexander
 */
public abstract class DAOFactory {

    public static final int MYSQL = 1;

    public abstract AccessDAO getAccessDAO();

    public abstract AddressDAO getAddressDAO();

    public abstract ProfessionDAO getProfessionDAO();

    public abstract RequestEntityDAO getRequestEntityDAO();

    public abstract UserDAO getUserDAO();

    public abstract WorkTypeDAO getWorkTypeDAO();

    public abstract WorkerDAO getWorkerDAO();
    
    public abstract WorkerRequestDAO getWorkerRequestDAO();
    
    public abstract WorkPlanDAO getWorkPlanDAO();

    public static DAOFactory getDAOFactory(int wichDB) {
        switch (wichDB) {
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }

    }
}
