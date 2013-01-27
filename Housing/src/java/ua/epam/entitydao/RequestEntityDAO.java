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
    
    List<RequestEntity> getRequestsByUser(int userId);
    
    RequestEntity getRequest(int idrequest);
    
     Approve getApprove(int idrequest);

    void setApprove(int idrequest, Approve current);
}
