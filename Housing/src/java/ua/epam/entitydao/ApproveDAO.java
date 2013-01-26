/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.entitydao;

import ua.epam.entity.Approve;

/**
 *
 * @author Ivanov Alexander
 */
public interface ApproveDAO {

    Approve getApprove(int idrequest);

    void setApprove(int idrequest, Approve current);
}
