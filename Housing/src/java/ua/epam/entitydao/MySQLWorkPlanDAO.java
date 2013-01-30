package ua.epam.entitydao;

import java.sql.Connection;
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
 * DAO for Works Plan
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
                    System.out.println(ex.getMessage());
                }
            }
        }
        return generKey;
    }

    @Override
    public List<WorkPlan> getWorkPlans() {
        List<WorkPlan> myNew = new ArrayList<WorkPlan>();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from work_plan");
            while (result.next()) {
                DAOFactory daof = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                WorkPlan myPlan = new WorkPlan();
                myPlan.setIdPlan(result.getInt("idplan"));

                //take Date
                GregorianCalendar gcal = new GregorianCalendar();
                gcal.setTimeInMillis(result.getDate("plan_date").getTime());
                myPlan.setPlanDate(gcal);

                AddressDAO adao = daof.getAddressDAO();
                Address addr = adao.getAddress(result.getInt("address"));
                myPlan.setAddress(addr);

                WorkerDAO wdao = daof.getWorkerDAO();
                Worker foreman = wdao.getWorker(result.getInt("foreman"));
                Worker worker = wdao.getWorker(result.getInt("worker"));
                myPlan.setForeman(foreman);
                myPlan.setWorker(worker);

                myNew.add(myPlan);
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
}
