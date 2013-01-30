package ua.epam.entity;

/**
 * Entity for Type of work
 *
 * @author Ivanov Alexander
 */
public class WorkType {

    private int idWorkType;
    private String name;
    private Profession whoDo;

    /**
     * Construct an empty work type
     */
    public WorkType() {
    }

    /**
     * Construct work type with parameters
     *
     * @param idWorkType - id in DB
     * @param name
     * @param whoDo - What worker can do it
     */
    public WorkType(int idWorkType, String name, Profession whoDo) {
        this.idWorkType = idWorkType;
        this.name = name;
        this.whoDo = whoDo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the whoDo
     */
    public Profession getWhoDo() {
        return whoDo;
    }

    /**
     * @param whoDo the whoDo to set
     */
    public void setWhoDo(Profession whoDo) {
        this.whoDo = whoDo;
    }

    /**
     * @return the idWorkType
     */
    public int getIdWorkType() {
        return idWorkType;
    }

    /**
     * @param idWorkType the idWorkType to set
     */
    public void setIdWorkType(int idWorkType) {
        this.idWorkType = idWorkType;
    }

    @Override
    public String toString() {
        return "work id = " + idWorkType + " [" + name + ", " + whoDo.toString() + "] ";
    }
}
