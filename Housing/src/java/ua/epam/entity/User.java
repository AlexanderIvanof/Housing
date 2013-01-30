package ua.epam.entity;

/**
 * This entity for tenant
 * 
 * @author Ivanov Alexander
 */
public class User {

    private int idUser;
    private String firstName;
    private String lastName;
    private Address address;
    private Access loggin;
    
    /**
     * Construct empty tenant
     */
    public User(){ 
    }

    /**
     * Construct tenant with parameters
     * 
     * @param idUser - id in DB
     * @param firstName - first name
     * @param lastName - last name
     * @param address - address
     * @param loggin - login for access
     */
    public User(int idUser, String firstName, String lastName, Address address, Access loggin) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.loggin = loggin;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the loggin
     */
    public Access getLoggin() {
        return loggin;
    }

    /**
     * @param loggin the loggin to set
     */
    public void setLoggin(Access loggin) {
        this.loggin = loggin;
    }
    
    @Override
    public String toString(){
        return "user id = " + idUser + ": " + firstName + " " + lastName + " " + address + "; " + loggin; 
    }
    
}
