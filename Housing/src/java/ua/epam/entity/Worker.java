/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.entity;

/**
 *
 * @author Ivanov Alexander
 */
public class Worker {

    private int idworker;
    private String firstName;
    private String lastName;
    private Profession prof;
    private boolean busy;

    public Worker() {
    }

    public Worker(int idworker, String firstName, String lastName, Profession prof) {
        this.idworker = idworker;
        this.firstName = firstName;
        this.lastName = lastName;
        this.prof = prof;
        busy = false;
    }

    /**
     * @return the idworker
     */
    public int getIdworker() {
        return idworker;
    }

    /**
     * @param idworker the idworker to set
     */
    public void setIdworker(int idworker) {
        this.idworker = idworker;
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
     * @return the prof
     */
    public Profession getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(Profession prof) {
        this.prof = prof;
    }

    /**
     * @return the busy
     */
    public boolean isBusy() {
        return busy;
    }

    /**
     * @param busy the busy to set
     */
    public void setBusy(boolean busy) {
        this.busy = busy;
    }
    
    @Override
    public String toString(){
        return "Worker id = " +idworker + ": " +firstName + " " +lastName +
                " PROF: " + prof + "|" + busy + "|";
    }
}
