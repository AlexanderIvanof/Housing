package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.*;

/**
 * DAO for worker
 *
 * @author Alexandr Ivanov
 */
public interface WorkerDAO {

    int insertWorker(Worker wrk);

    Worker getWorker(int idworker);

    Worker getWorker(String firstName, String lastName);

    List<Worker> getAllWorkers();

    List<Worker> getWorkerByProfession(Profession prof);

    void setWorkerBusy(int idworker, boolean busy);
}
