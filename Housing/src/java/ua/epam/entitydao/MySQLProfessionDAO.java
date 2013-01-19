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
import javax.naming.NamingException;
import ua.epam.entity.*;

/**
 *
 * @author Ivanov Alexander
 */
public class MySQLProfessionDAO implements ProfessionDAO {

    private Connection accessConn;

    @Override
    public Profession getProfession(int idprofession) {
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
        } finally {
            if (accessConn != null) {
                try {
                    accessConn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return generKey;
    }
}
