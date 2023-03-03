package model;

/**
 * Class that makes the connection between view and controller
 */
public class Model {
    Polynomial polynom1;
    Polynomial polynom2;
    Polynomial result;

    /**
     * Constructor
     */
    public Model() {
        this.polynom1 = polynom1;
        this.polynom2 = polynom2;
        this.result = result;

    }

    /**
     * Getter for result
     *
     * @return result
     */
    public Polynomial getResult() {
        return this.result;
    }


    /**
     * Setter for result
     *
     * @param result that we want to set
     */
    public void setResult(Polynomial result) {
        this.result = result;
    }


}