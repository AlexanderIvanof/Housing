/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.entity;

import java.util.GregorianCalendar;

/**
 * Entity for Works Plan
 *
 * @author Ivanov Alexander
 */
public class WorkPlan {

    private int idPlan;
    private Worker foreman;
    private Worker worker;
    private Address address;
    private GregorianCalendar planDate;

    /**
     * Construct an empty works plan
     */
    public WorkPlan() {
        idPlan = 0;
    }

    /**
     * Construct plan with parameter
     *
     * @param idPlan - Id
     * @param foreman - Responsible for executing
     * @param worker - Who perform work
     * @param address - Address
     * @param planDate - Execution date
     */
    public WorkPlan(int idPlan, Worker foreman, Worker worker, Address address, GregorianCalendar planDate) {
        this.idPlan = idPlan;
        this.foreman = foreman;
        this.worker = worker;
        this.address = address;
        this.planDate = planDate;
    }

    /**
     * @return the idPlan
     */
    public int getIdPlan() {
        return idPlan;
    }

    /**
     * @param idPlan the idPlan to set
     */
    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    /**
     * @return the foreman
     */
    public Worker getForeman() {
        return foreman;
    }

    /**
     * @param foreman the foreman to set
     */
    public void setForeman(Worker foreman) {
        this.foreman = foreman;
    }

    /**
     * @return the worker
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * @param worker the worker to set
     */
    public void setWorker(Worker worker) {
        this.worker = worker;
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
     * @return the planDate
     */
    public GregorianCalendar getPlanDate() {
        return planDate;
    }

    /**
     * @param planDate the planDate to set
     */
    public void setPlanDate(GregorianCalendar planDate) {
        this.planDate = planDate;
    }
}
