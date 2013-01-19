/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.entitydao;

import java.util.List;
import ua.epam.entity.WorkType;
/**
 *
 * @author Alexandr Ivanov
 */
public interface WorkTypeDAO {

    WorkType getWorkType(int idWorkType);
    
    List<WorkType> getAllWorkType();
}
