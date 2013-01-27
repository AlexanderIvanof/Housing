/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.entitydao;

import java.util.List;

/**
 *
 * @author Alexandr Ivanov
 */
public interface WorkerRequestDAO {
    
    List<Integer> getListRequest(int idworker);
    
    int setRow(int idworker, int idrequest);

}
