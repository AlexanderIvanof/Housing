/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Ivanov Alexander
 */
public class MySQLWorkerDAO implements WorkerDAO {

    private Connection accessConn;

    @Override
    public int insertWorker(Worker wrk) {
        int generKey = 0;
        return generKey;
    }

    @Override
    public Worker getWorker(int idworker) {
        Worker myNew = new Worker();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from workers where idworker = " + idworker);
            result.next();

            myNew.setIdworker(idworker);
            myNew.setFirstName(result.getString("first_name"));
            myNew.setFirstName(result.getString("second_name"));
            int _profession = result.getInt("profession");

            /* get Profession in DAO */
            MySQLProfessionDAO profDAO = new MySQLProfessionDAO();
            Profession _prof = profDAO.getProfession(_profession);

            myNew.setProf(_prof);

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

    @Override
    public Worker getWorker(String firstName, String lastName) {
        Worker myNew = new Worker();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from workers where first_name = '" + firstName
                    + "' and last_name = '" + lastName + "'");
            result.next();

            myNew.setIdworker(result.getInt("idworker"));
            myNew.setFirstName(result.getString("first_name"));
            myNew.setFirstName(result.getString("second_name"));
            int _profession = result.getInt("profession");

            /* get Profession in DAO */
            MySQLProfessionDAO profDAO = new MySQLProfessionDAO();
            Profession _prof = profDAO.getProfession(_profession);

            myNew.setProf(_prof);

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

    @Override
    public List<Worker> getAllWorkers() {
        Statement statement = null;
        List<Worker> allWorkers = new ArrayList<Worker>();
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from workers");
            while (result.next()) {
                Worker _wrkr = new Worker();
                _wrkr.setIdworker(result.getInt("idworker"));
                _wrkr.setFirstName(result.getString("first_name"));
                _wrkr.setFirstName(result.getString("second_name"));
                int _profession = result.getInt("profession");

                /* get Profession in DAO */
                MySQLProfessionDAO profDAO = new MySQLProfessionDAO();
                Profession _prof = profDAO.getProfession(_profession);
                _wrkr.setProf(_prof);

                allWorkers.add(_wrkr);

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
                }
            }
        }

        return allWorkers;
    }

    @Override
    public List<Worker> getWorkerByProfession(Profession prof) {
        Statement statement = null;
        List<Worker> allWorkers = new ArrayList<Worker>();
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet res = statement.executeQuery("Select * from profession where nameprof = '" + prof.getNameprof() + "'");
            res.next();
            int prfs = res.getInt("idprofession");

            ResultSet result = statement.executeQuery("Select * from workers where profession = " + prfs);
            while (result.next()) {
                Worker _wrkr = new Worker();
                _wrkr.setIdworker(result.getInt("idworker"));
                _wrkr.setFirstName(result.getString("first_name"));
                _wrkr.setFirstName(result.getString("second_name"));
                _wrkr.setProf(prof);

                allWorkers.add(_wrkr);

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
                }
            }
        }

        return allWorkers;
    }
}
