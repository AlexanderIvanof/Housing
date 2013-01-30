package ua.epam.entitydao;

import ua.epam.entity.*;

/**
 * Take access to profession
 *
 * @author Alexandr Ivanov
 */
public interface ProfessionDAO {

    int insertProfession(Profession prof);

    Profession getProfession(int idprofession);
}
