/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.entitydao;

import java.util.GregorianCalendar;

/**
 *
 * @author Alexandr Ivanov
 */
public interface WorkPlanDAO {

    int insertRow(int foreman, int address, GregorianCalendar planDate, int worker);
}
