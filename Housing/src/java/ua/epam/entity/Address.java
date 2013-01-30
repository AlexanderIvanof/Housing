package ua.epam.entity;

/**
 * Entity for Address
 *
 * @author Ivanov Alexander
 */
public class Address {

    private int idAddress;
    private String street;
    private String building;
    private String flat;

    /**
     * Construct empty Address
     */
    public Address() {
    }

    /**
     * Construct Address with parameters
     *
     * @param street - Street name
     * @param building - House number
     * @param flat - Flat number
     */
    public Address(String street, String building, String flat) {
        this.street = street;
        this.building = building;
        this.flat = flat;
        idAddress = -1;
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
    public String toString() {
        return "ул. " + street + " / д." + building + " / кв." + flat;
    }

    /**
     * @return the idAddress
     */
    public int getIdAddress() {
        return idAddress;
    }

    /**
     * @param idAddress the idAddress to set
     */
    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
}
