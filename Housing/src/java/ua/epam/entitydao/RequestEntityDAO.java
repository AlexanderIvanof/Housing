package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.*;

/**
 *
 * @author Alexandr Ivanov
 */
public interface RequestEntityDAO {

    int insertRequest(RequestEntity set);
    
    List<RequestEntity> getAllRequests();
}
