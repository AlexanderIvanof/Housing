package ua.epam.entitydao;

import ua.epam.entity.Address;

/**
 * DAO Address
 *
 * @author Alexandr Ivanov
 */
public interface AddressDAO {

    int insertAddress(Address myadd);

    Address getAddress(int idaddress);
}
