package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.*;

/**
 * DAO Access
 * 
 * @author Alexandr Ivanov
 */
public interface AccessDAO {

    int insertAccess(Access acs);

    Access getAccess(int idaccess);

    Access getAccess(String username);

    List<Access> getAllLoggins();
}
