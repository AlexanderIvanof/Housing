package ua.epam.entity;

/**
 * Entity for proffesion of worker
 *
 * @author Ivanov Alexander
 */
public class Profession {

    private String nameprof;

    /**
     * Construct empty profession
     */
    public Profession() {
    }

    /**
     * Construct profession with name
     *
     * @param nameprof - name of profession
     */
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
    public String toString() {
        return nameprof;
    }
}
