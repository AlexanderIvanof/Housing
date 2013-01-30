package ua.epam.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Entity for request from tenant to Housing
 *
 * @author Ivanov Alexander
 */
public class RequestEntity {

    private int idRequest;
    private GregorianCalendar requestDate;
    private WorkType typeWork;
    private GregorianCalendar orderFullfillment;
    private User user;
    private Approve approve;

    /**
     * Construct empty request
     */
    public RequestEntity() {
    }

    /**
     * Construct new request with parameters
     *
     * @param requestDate - date of request
     * @param typeWork - type work that do
     * @param orderFullfillment - day of the work performance
     * @param user - from what tenant
     */
    public RequestEntity(GregorianCalendar requestDate, WorkType typeWork, GregorianCalendar orderFullfillment, User user) {
        this.idRequest = 0;
        this.requestDate = requestDate;
        this.typeWork = typeWork;
        this.orderFullfillment = orderFullfillment;
        this.user = user;
        this.approve = Approve.WAIT_APPROVE;
    }

    /**
     * @return the idRequest
     */
    public int getIdRequest() {
        return idRequest;
    }

    /**
     * @param idRequest the idRequest to set
     */
    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    /**
     * @return the requestDate
     */
    public GregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(GregorianCalendar requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the typeWork
     */
    public WorkType getTypeWork() {
        return typeWork;
    }

    /**
     * @param typeWork the typeWork to set
     */
    public void setTypeWork(WorkType typeWork) {
        this.typeWork = typeWork;
    }

    /**
     * @return the orderFullfillment
     */
    public GregorianCalendar getOrderFullfillment() {
        return orderFullfillment;
    }

    /**
     * @param orderFullfillment the orderFullfillment to set
     */
    public void setOrderFullfillment(GregorianCalendar orderFullfillment) {
        this.orderFullfillment = orderFullfillment;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Static method that return date in YYYY-MM-DD
     *
     * @param gcal - calendar date
     * @return date in YYYY-MM-DD
     */
    public static String showDate(GregorianCalendar gcal) {
        return " [" + gcal.get(Calendar.YEAR) + "/" + (gcal.get(Calendar.MONTH) + 1)
                + "/" + gcal.get(Calendar.DAY_OF_MONTH) + "] ";
    }

    /**
     * @return the approve
     */
    public Approve getApprove() {
        return approve;
    }

    /**
     * @param approve the approve to set
     */
    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "Request id = " + idRequest + " request date:" + showDate(requestDate)
                + "<br> --> " + user + "<br> --> |" + typeWork + "| -- |"
                + showDate(orderFullfillment) + "|; ";
    }
}
