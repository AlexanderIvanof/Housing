package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.*;

/**
 *
 * @author Alexandr Ivanov
 */
public interface WorkerDAO {

    int insertWorker(Worker wrk);

    Worker getWorker(int idworker);

    Worker getWorker(String firstName, String lastName);

    List<Worker> getAllWorkers();

    List<Worker> getWorkerByProfession(Profession prof);
    
    List<Worker> getWorkerByTeam(int team);
    
    void setWorkerBusy(int idworker, boolean busy);
    
    void setWorkTeam(int idworker, int teamNumber);
}
