package ua.epam.entitydao;

import java.util.List;

/**
 * DAO for worker-request
 *
 * @author Alexandr Ivanov
 */
public interface WorkerRequestDAO {

    List<Integer> getListRequest(int idworker);

    int setRow(int idworker, int idrequest);
}
