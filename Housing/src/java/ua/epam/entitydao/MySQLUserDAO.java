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
 * DAO for tenant
 *
 * @author Ivanov Alexander
 */
public class MySQLUserDAO implements UserDAO {

    private Connection accessConn;

    @Override
    public int insertUser(User _new) {
        int generKey = 0;
        try {

            AddressDAO addr = new MySQLAddressDAO();
            int _addr = addr.insertAddress(_new.getAddress());
            AccessDAO acs = new MySQLAccessDAO();
            int _acs = acs.insertAccess(_new.getLoggin());

            accessConn = MySQLDAOFactory.createConnection();
            PreparedStatement query = accessConn.prepareStatement("Insert into users (first_name, last_name, address, authorization) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, _new.getFirstName());
            query.setString(2, _new.getLastName());
            query.setInt(3, _addr);
            query.setInt(4, _acs);
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
                    System.out.println(ex.getMessage());
                }
            }
        }

        return generKey;
    }

    @Override
    public User getUser(int idusers) {
        //create User
        User myNew = new User();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from users where idusers = " + idusers);
            result.next();
            /* 
             * fill fields of User
             * idUser, firstName, lastName
             */
            myNew.setFirstName(result.getString("first_name"));
            myNew.setLastName(result.getString("last_name"));
            myNew.setIdUser(idusers);
            int acs = result.getInt("authorization");
            int addr = result.getInt("address");

            /* Create Access and Address with DAO */
            MySQLAccessDAO myacdao = new MySQLAccessDAO();
            Access loggin = myacdao.getAccess(acs);

            MySQLAddressDAO myaddrdao = new MySQLAddressDAO();
            Address address = myaddrdao.getAddress(addr);

            myNew.setLoggin(loggin);
            myNew.setAddress(address);
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
    public User getUser(String firstName, String lastName) {
        //create User
        User myNew = new User();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from users where first_name = " + firstName + " and last_name = " + lastName);
            result.next();
            /* 
             * fill fields of User
             * idUser, firstName, lastName
             */
            myNew.setFirstName(result.getString("first_name"));
            myNew.setLastName(result.getString("last_name"));
            myNew.setIdUser(result.getInt("idusers"));
            int acs = result.getInt("authorization");
            int addr = result.getInt("address");

            /* Create Access and Address with DAO */
            MySQLAccessDAO myacdao = new MySQLAccessDAO();
            Access loggin = myacdao.getAccess(acs);

            MySQLAddressDAO myaddrdao = new MySQLAddressDAO();
            Address address = myaddrdao.getAddress(addr);

            myNew.setLoggin(loggin);
            myNew.setAddress(address);
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
    public User getUser(String username) {
        MySQLAccessDAO myaccess = new MySQLAccessDAO();
        Access acs = myaccess.getAccess(username);

        User myNew = new User();
        Statement statement = null;
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();

            ResultSet result = statement.executeQuery("Select * from users where authorization = " + acs.getIdAccess());
            result.next();
            /* 
             * fill fields of User
             * idUser, firstName, lastName
             */
            myNew.setFirstName(result.getString("first_name"));
            myNew.setLastName(result.getString("last_name"));
            myNew.setIdUser(result.getInt("idusers"));
            int addr = result.getInt("address");

            /* Create Address with DAO */
            MySQLAddressDAO myaddrdao = new MySQLAddressDAO();
            Address address = myaddrdao.getAddress(addr);

            myNew.setLoggin(acs);
            myNew.setAddress(address);
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
    public List<User> getAllUsers() {
        Statement statement = null;
        List<User> allLoggins = new ArrayList<User>();
        try {
            accessConn = MySQLDAOFactory.createConnection();
            statement = accessConn.createStatement();
            ResultSet result = statement.executeQuery("Select * from users");
            while (result.next()) {
                User myUser = new User();
                myUser.setFirstName(result.getString("first_name"));
                myUser.setLastName(result.getString("last_name"));
                myUser.setIdUser(result.getInt("idusers"));
                int acs = result.getInt("authorization");
                int addr = result.getInt("address");

                /* Create Access and Address with DAO */
                MySQLAccessDAO myacdao = new MySQLAccessDAO();
                Access loggin = myacdao.getAccess(acs);

                MySQLAddressDAO myaddrdao = new MySQLAddressDAO();
                Address address = myaddrdao.getAddress(addr);

                myUser.setLoggin(loggin);
                myUser.setAddress(address);
                allLoggins.add(myUser);

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
