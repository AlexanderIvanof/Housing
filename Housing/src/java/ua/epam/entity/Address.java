package ua.epam.entity;

/**
 *
 * @author Ivanov Alexander
 */
public class Address {

    private String street;
    private String building;
    private String flat;
    
    public Address(){
    }

    public Address(String street, String building, String flat) {
        this.street = street;
        this.building = building;
        this.flat = flat;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * @param building the building to set
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * @return the flat
     */
    public String getFlat() {
        return flat;
    }

    /**
     * @param flat the flat to set
     */
    public void setFlat(String flat) {
        this.flat = flat;
    }
    
    @Override
    public String toString(){
        return "Address [ " + street + ", " + building + ", " + flat + " ]";
    }
}
