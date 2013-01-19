/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.entity;

/**
 *
 * @author Ivanov Alexander
 */
public class Profession {

    private String nameprof;

    public Profession() {
    }

    
    public Profession(String nameprof) {
        this.nameprof = nameprof;
    }

    /**
     * @return the nameprof
     */
    public String getNameprof() {
        return nameprof;
    }

    /**
     * @param nameprof the nameprof to set
     */
    public void setNameprof(String nameprof) {
        this.nameprof = nameprof;
    }
    
    @Override
    public String toString(){
      return nameprof;  
    }
    
}
