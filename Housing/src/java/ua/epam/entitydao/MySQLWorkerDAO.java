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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import ua.epam.entity.*;

/**
 * DAO for Worker
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
            myNew.setLastName(result.getString("last_name"));
            myNew.setBusy(result.getBoolean("busy"));
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
                    System.out.println(ex.getMessage());
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
            myNew.setLastName(result.getString("last_name"));
            myNew.setBusy(result.getBoolean("busy"));
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
                    System.out.println(ex.getMessage());
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
                _wrkr.setLastName(result.getString("last_name"));
                _wrkr.setBusy(result.getBoolean("busy"));
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
                    System.out.println(ex.getMessage());
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
            res.close();

            ResultSet result = statement.executeQuery("Select * from workers where profession = " + prfs);
            while (result.next()) {
                Worker _wrkr = new Worker();
                _wrkr.setIdworker(result.getInt("idworker"));
                _wrkr.setFirstName(result.getString("first_name"));
                _wrkr.setLastName(result.getString("last_name"));
                _wrkr.setBusy(result.getBoolean("busy"));
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
                    System.out.println(ex.getMessage());
                }
            }
        }

        return allWorkers;
    }

    @Override
    public void setWorkerBusy(int idworker, boolean busy) {
        try {
            accessConn = MySQLDAOFactory.createConnection();
            PreparedStatement query = accessConn.prepareStatement("Update workers set busy = ? where idworker = " + idworker);
            query.setBoolean(1, busy);
            query.executeUpdate();
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

    }
}
