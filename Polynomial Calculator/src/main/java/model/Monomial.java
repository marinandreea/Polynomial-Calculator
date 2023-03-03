package model;

/**
 * Class for objects of type Monomial
 */
public class Monomial {
    private double coefficient;
    private int power;

    /**
     * Constructor for monomial
     *
     * @param coefficient
     * @param power
     */
    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    /**
     * default constructor
     */
    public Monomial() {
    }

    /**
     * Getter for coefficient
     *
     * @return coefficient
     */
    public double getCoefficient() {
        return this.coefficient;
    }

    /**
     * Setter for coefficient
     *
     * @param coefficient that we want to set
     */
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Getter for power
     *
     * @return power
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Setter for power
     *
     * @param power we want to set
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * method for getting the monomial as a string
     *
     * @return monomial as a string
     */
    public String getMonomString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.coefficient > 0.0 && this.power != 0) {
            return stringBuilder.append("+").append(this.coefficient).append("x^").append(this.power).toString();
        } else if (this.coefficient > 0.0 && this.power == 0) {
            return stringBuilder.append("+").append(this.coefficient).toString();
        } else if (this.coefficient < 0.0 && this.power != 0) {
            return stringBuilder.append(this.coefficient).append("x^").append(this.power).toString();
        } else if(this.coefficient< 0.0 && this.power == 0){
                return stringBuilder.append(this.coefficient).toString();
            }
          return "+0.0";
        }
    }
