package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.*;

/**
 * DAO to tenant
 * 
 * @author Alexandr Ivanov
 */
public interface UserDAO {

    int insertUser(User _new);

    User getUser(int idusers);

    User getUser(String firstName, String lastName);

    User getUser(String username);

    List<User> getAllUsers();
}
