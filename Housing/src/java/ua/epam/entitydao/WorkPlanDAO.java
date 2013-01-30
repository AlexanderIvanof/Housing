package ua.epam.entitydao;

import java.util.GregorianCalendar;
import java.util.List;
import ua.epam.entity.*;

/**
 * DAO for work plan
 *
 * @author Alexandr Ivanov
 */
public interface WorkPlanDAO {

    int insertRow(int foreman, int address, GregorianCalendar planDate, int worker);

    List<WorkPlan> getWorkPlans();
}
