package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Class for objects of type Polynomial
 */
public class Polynomial {
    private ArrayList<Monomial> polynom = new ArrayList();

    /**
     * default constructor
     */
    public Polynomial() {
    }

    /**
     * Getter for polynomial
     *
     * @return the polynomial
     */
    public ArrayList<Monomial> getPolynom() {
        return this.polynom;
    }

    /**
     * method which sorts the polynomial in an increasing way according to the powers of its monomial
     */
    public void sortByDegree() {

        Collections.sort(polynom, new Comparator<Monomial>() {

            @Override
            public int compare(Monomial o1, Monomial o2) {
                if (o1.getPower() > o2.getPower())
                    return -1;
                else if (o1.getPower() == o2.getPower())
                    return 0;
                else
                    return 1;
            }
        });
    }

    /**
     * method that gets the polynomial as a string
     *
     * @return polynomial as a string
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.getPolynom().forEach((m) -> {
            stringBuilder.append(m.getMonomString());
        });
        return stringBuilder.toString();
    }

    /**
     * method that finds the monomial with a given power
     *
     * @param power that the monomial should have
     *
     * @return the monomial with the desired power
     */
    public Monomial findMonomByPower(int power) {
        Monomial resultMonom = null;
        Iterator myIterator = this.getPolynom().iterator();

        while(myIterator.hasNext()) {
            Monomial currentMonom = (Monomial)myIterator.next();
            if (currentMonom.getPower() == power) {
                resultMonom = currentMonom;
            }
        }
        return resultMonom;
    }

    /**
     * method that adds two polynomials
     * @param polynom1
     * @param polynom2
     *
     * @return result of adding two polynomials
     */
    public static Polynomial add(Polynomial polynom1, Polynomial polynom2) {
        Polynomial sumP = new Polynomial();
        sumP.getPolynom().addAll(polynom1.getPolynom());
        polynom2.getPolynom().forEach((m) -> {
            Monomial findM = sumP.findMonomByPower(m.getPower());
            if (findM != null) {
                findM.setCoefficient(findM.getCoefficient() + m.getCoefficient());
            } else {
                sumP.getPolynom().add(m);
            }

        });
        sumP.sortByDegree();
        return sumP;
    }

    /**
     * method that subtracts two polynomials
     * @param polynom1
     * @param polynom2
     *
     * @return result of subtracting two polynomials
     */
    public static Polynomial subtract(Polynomial polynom1, Polynomial polynom2) {
        Polynomial diffP = new Polynomial();
        diffP.getPolynom().addAll(polynom1.getPolynom());
        polynom2.getPolynom().forEach((m) -> {
            Monomial findM = diffP.findMonomByPower(m.getPower());
            if (findM != null) {
                findM.setCoefficient(findM.getCoefficient() - m.getCoefficient());
            } else {
                m.setCoefficient(-m.getCoefficient());
                diffP.getPolynom().add(m);
            }

        });
        diffP.sortByDegree();
        return diffP;
    }

    /**
     * method that multiplies two polynomials
     *
     * @param polynom1
     * @param polynom2
     *
     * @return result of multiplying two polynomials
     */
    public static Polynomial multiply(Polynomial polynom1, Polynomial polynom2) {
        Polynomial multiplyP = new Polynomial();
        Polynomial copyP1 = new Polynomial();
        copyP1.getPolynom().addAll(polynom1.getPolynom());
        Polynomial copyP2 = new Polynomial();
        copyP2.getPolynom().addAll(polynom2.getPolynom());
        copyP1.getPolynom().forEach((m) -> {
            int power1 = m.getPower();
            double coeff1 = m.getCoefficient();
            copyP2.getPolynom().forEach((m2) -> {
                int power2 = m2.getPower();
                double coeff2 = m2.getCoefficient();
                int resultPower = power1 + power2;
                double resultCoeff = coeff1 * coeff2;
                Monomial findM = multiplyP.findMonomByPower(resultPower);
                if (findM != null) {
                    findM.setCoefficient(findM.getCoefficient() + resultCoeff);
                } else {
                    Monomial o = new Monomial(resultCoeff, resultPower);
                    multiplyP.getPolynom().add(o);
                }

            });
        });
        multiplyP.sortByDegree();
        return multiplyP;
    }

    /**
     * method that copies a polynomial
     *
     * @param polynom
     *
     * @return result of copying a polynomial
     */
    public Polynomial copyPolinom(Polynomial polynom) {
        Polynomial copyPolinom = new Polynomial();

        Iterator<Monomial> myIterator = polynom.getPolynom().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonom = myIterator.next();

            int power = currentMonom.getPower();
            double coeff = currentMonom.getCoefficient();

            Monomial copyMonom = new Monomial(coeff, power);
            copyPolinom.getPolynom().add(copyMonom);
        }
        return copyPolinom;
    }

    /**
     * method that divides a polynomial
     *
     * @param polynom1
     * @param polynom2
     *
     * @return result of division
     */
    public static Polynomial[] divide(Polynomial polynom1, Polynomial polynom2) {
        Polynomial quotient = new Polynomial(), remainder = new Polynomial(), copyP = polynom2.copyPolinom(polynom2);
        remainder = polynom1.copyPolinom(polynom1);

        Monomial dividerFirstMonom = copyP.getPolynom().get(0);
        Monomial remainderMonom = remainder.getFirstMonom(remainder);

        double qCoeff, dividerCoef = dividerFirstMonom.getCoefficient(),
                remainderCoeff = remainderMonom.getCoefficient();
        int dividerPower = dividerFirstMonom.getPower(), remainderPower = remainderMonom.getPower(), qPower;

        if (remainderPower < dividerPower) {
            JOptionPane.showMessageDialog(null, "ERROR : DIVISION NOT POSSIBLE, divident power < divider power!");
            return null;
        }

        while (remainderPower >= dividerPower) {
            qPower = remainderPower - dividerPower;
            qCoeff = remainderCoeff / dividerCoef;

            Monomial myMonom = new Monomial(qCoeff, qPower);
            quotient.getPolynom().add(myMonom);

            Polynomial helper = new Polynomial();
            helper.getPolynom().add(myMonom);

            remainder = remainder.subtract(remainder, (helper.multiply(helper, copyP)));

            remainderMonom = remainder.getFirstMonom(remainder);
            remainderPower = remainderMonom.getPower();
            remainderCoeff = remainderMonom.getCoefficient();
        }
        Polynomial[] returnedPolinom = new Polynomial[2];
        returnedPolinom[0] = quotient;
        returnedPolinom[1] = remainder;
        return returnedPolinom;
    }

    public Monomial getFirstMonom(Polynomial p) {
        Monomial firstMonom = new Monomial();

        Iterator<Monomial> myIterator = p.getPolynom().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonom = myIterator.next();
            if (currentMonom.getCoefficient() != 0) {
                firstMonom = currentMonom;
                break;
            }
        }
        return firstMonom;
    }

    /**
     * method that differentiates a polynomial
     *
     * @param polynom
     *
     * @return result of differentiation
     */
    public static Polynomial differentiation(Polynomial polynom) {
        Polynomial result = new Polynomial();
        polynom.getPolynom().forEach((m) -> {
            if (m.getPower() >= 1) {
                m.setCoefficient(m.getCoefficient() * m.getPower());
                m.setPower(m.getPower() - 1);
            } else if (m.getPower() == 0) {
                m.setPower(0);
                m.setCoefficient(0.0);
            }

        });
        polynom.sortByDegree();
        result.getPolynom().addAll(polynom.getPolynom());
        return result;
    }

    /**
     * method that integrates a polynomial
     *
     * @param polynom
     *
     * @return reslut of integration
     */
    public static Polynomial integrate(Polynomial polynom) {
        Polynomial result = new Polynomial();
        polynom.getPolynom().forEach((m) -> {
            if (m.getPower() >= 1) {
                m.setCoefficient(m.getCoefficient() / (m.getPower() + 1));
                m.setPower(m.getPower() + 1);
            } else if (m.getPower() == 0) {
                m.setPower(1);
            }

        });
        polynom.sortByDegree();
        result.getPolynom().addAll(polynom.getPolynom());
        return result;
    }
}