package ua.epam.entity;

/**
 * Entity for log in.
 *
 * @author Ivanov Alexander
 */
public class Access {

    private int idAccess;
    private String username;
    private String password;
    private UserType userType;

    /**
     *
     * Construct empty access
     */
    public Access() {
    }

    /**
     * Construct new access with parameters
     *
     * @param username
     * @param password
     * @param userType - Mean USER or ADMINISTRATOR
     */
    public Access(String username, String password, UserType userType) {
        this.idAccess = 0;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * @return the idAccess
     */
    public int getIdAccess() {
        return idAccess;
    }

    /**
     * @param idAccess the idAccess to set
     */
    public void setIdAccess(int idAccess) {
        this.idAccess = idAccess;
    }

    @Override
    public String toString() {
        return "id = " + idAccess + ":[ " + username + ", " + password + " ]";
    }
}
