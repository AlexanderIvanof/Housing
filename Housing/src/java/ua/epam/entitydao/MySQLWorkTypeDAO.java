package ua.epam.entitydao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import ua.epam.entity.*;

/**
 * DAO for Type of work
 *
 * @author Ivanov Alexander
 */
public class MySQLWorkTypeDAO implements WorkTypeDAO {

    private Connection accessConn;

    @Override
    public WorkType getWorkType(int idWorkType) {
        WorkType myNew = new WorkType();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from work_type where idworktype = " + idWorkType);
            result.next();
            myNew.setIdWorkType(result.getInt("idworktype"));
            myNew.setName(result.getString("name"));
            MySQLProfessionDAO prof = new MySQLProfessionDAO();
            myNew.setWhoDo(prof.getProfession(result.getInt("worker")));
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
    public List<WorkType> getAllWorkType() {
        Statement statement = null;
        List<WorkType> allLoggins = new ArrayList<WorkType>();
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from work_type");
            while (result.next()) {
                MySQLProfessionDAO prof = new MySQLProfessionDAO();
                Profession skil = prof.getProfession(result.getInt("worker"));

                allLoggins.add(new WorkType(result.getInt("idworktype"),
                        result.getString("name"),
                        skil));
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

        return allLoggins;
    }
}
