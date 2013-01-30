package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.WorkType;

/**
 * DAO for Work type
 *
 * @author Alexandr Ivanov
 */
public interface WorkTypeDAO {

    WorkType getWorkType(int idWorkType);

    List<WorkType> getAllWorkType();
}
