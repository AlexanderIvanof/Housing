/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.entitydao;

import ua.epam.entity.*;
/**
 *
 * @author Alexandr Ivanov
 */
public interface ProfessionDAO {

    int insertProfession(Profession prof);
    Profession getProfession(int idprofession);
}
