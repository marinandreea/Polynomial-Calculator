package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperationTest  {


    @Test
    public void addOperationTest() {
        Polynomial expectedP = new Polynomial();
        Polynomial polynom1 = new Polynomial();
        Polynomial polynom2 = new Polynomial();
        Monomial m1 = new Monomial(3.0, 2);
        Monomial m2 = new Monomial(2.0, 1);
        Monomial m3 = new Monomial(-1.0, 0);
        Monomial m4 = new Monomial(4.0, 3);
        Monomial m5 = new Monomial(-3.0, 1);
        Monomial m6 = new Monomial(2.0, 0);
        Monomial m7 = new Monomial(4.0, 3);
        Monomial m8 = new Monomial(3.0, 2);
        Monomial m9 = new Monomial(-1.0, 1);
        Monomial m10 = new Monomial(1.0, 0);
        polynom1.getPolynom().add(m1);
        polynom1.getPolynom().add(m2);
        polynom1.getPolynom().add(m3);
        polynom2.getPolynom().add(m4);
        polynom2.getPolynom().add(m5);
        polynom2.getPolynom().add(m6);
        expectedP.getPolynom().add(m7);
        expectedP.getPolynom().add(m8);
        expectedP.getPolynom().add(m9);
        expectedP.getPolynom().add(m10);
        Polynomial sum = new Polynomial();
        sum.getPolynom().addAll(Polynomial.add(polynom1, polynom2).getPolynom());
        assertEquals(expectedP.toString(), sum.toString());
    }

    @Test
    public void subtractOperationTest() {
        Polynomial expectedP = new Polynomial();
        Polynomial polynom1 = new Polynomial();
        Polynomial polynom2 = new Polynomial();
        Monomial m1 = new Monomial(3.0, 2);
        Monomial m2 = new Monomial(2.0, 1);
        Monomial m3 = new Monomial(-1.0, 0);
        Monomial m4 = new Monomial(4.0, 3);
        Monomial m5 = new Monomial(-3.0, 1);
        Monomial m6 = new Monomial(2.0, 0);
        Monomial m7 = new Monomial(-4.0, 3);
        Monomial m8 = new Monomial(3.0, 2);
        Monomial m9 = new Monomial(5.0, 1);
        Monomial m10 = new Monomial(-3.0, 0);
        polynom1.getPolynom().add(m1);
        polynom1.getPolynom().add(m2);
        polynom1.getPolynom().add(m3);
        polynom2.getPolynom().add(m4);
        polynom2.getPolynom().add(m5);
        polynom2.getPolynom().add(m6);
        expectedP.getPolynom().add(m7);
        expectedP.getPolynom().add(m8);
        expectedP.getPolynom().add(m9);
        expectedP.getPolynom().add(m10);
        Polynomial diff = new Polynomial();
        diff.getPolynom().addAll(Polynomial.subtract(polynom1, polynom2).getPolynom());
        assertEquals(expectedP.toString(), diff.toString());
    }

    @Test
    public void multiplyOperationTest() {
        Polynomial expectedP = new Polynomial();
        Polynomial polynom1 = new Polynomial();
        Polynomial polynom2 = new Polynomial();
        Monomial m1 = new Monomial(3.0, 2);
        Monomial m2 = new Monomial(2.0, 1);
        Monomial m4 = new Monomial(4.0, 3);
        Monomial m5 = new Monomial(2.0, 0);
        Monomial m7 = new Monomial(12.0, 5);
        Monomial m8 = new Monomial(8.0, 4);
        Monomial m9 = new Monomial(6.0, 2);
        Monomial m10 = new Monomial(4.0, 1);
        polynom1.getPolynom().add(m1);
        polynom1.getPolynom().add(m2);
        polynom2.getPolynom().add(m4);
        polynom2.getPolynom().add(m5);
        expectedP.getPolynom().add(m7);
        expectedP.getPolynom().add(m8);
        expectedP.getPolynom().add(m9);
        expectedP.getPolynom().add(m10);
        Polynomial multiply = new Polynomial();
        multiply.getPolynom().addAll(Polynomial.multiply(polynom1, polynom2).getPolynom());
        assertEquals(expectedP.toString(), multiply.toString());
    }

    @Test
    public void deriveOperationTest() {
        Polynomial expectedP = new Polynomial();
        Polynomial polynom1 = new Polynomial();
        Monomial m2 = new Monomial(3.0, 2);
        Monomial m3 = new Monomial(2.0, 1);
        Monomial m4 = new Monomial(-1.0, 0);
        Monomial m1 = new Monomial(4.0, 3);
        Monomial m5 = new Monomial(12.0, 2);
        Monomial m6 = new Monomial(6.0, 1);
        Monomial m7 = new Monomial(2.0, 0);
        Monomial m8 = new Monomial(0.0, 0);
        polynom1.getPolynom().add(m1);
        polynom1.getPolynom().add(m2);
        polynom1.getPolynom().add(m3);
        polynom1.getPolynom().add(m4);
        expectedP.getPolynom().add(m5);
        expectedP.getPolynom().add(m6);
        expectedP.getPolynom().add(m7);
        expectedP.getPolynom().add(m8);
        Polynomial derivate = new Polynomial();
        derivate.getPolynom().addAll(Polynomial.differentiation(polynom1).getPolynom());
        assertEquals(expectedP.toString(), derivate.toString());
    }

    @Test
    public void integrateOperationTest() {
        Polynomial expectedP = new Polynomial();
        Polynomial polynom1 = new Polynomial();
        Monomial m2 = new Monomial(3.0, 2);
        Monomial m3 = new Monomial(2.0, 1);
        Monomial m4 = new Monomial(-1.0, 0);
        Monomial m1 = new Monomial(4.0, 3);
        Monomial m5 = new Monomial(1.0, 4);
        Monomial m6 = new Monomial(1.0, 3);
        Monomial m7 = new Monomial(1.0, 2);
        Monomial m8 = new Monomial(-1.0, 1);
        polynom1.getPolynom().add(m1);
        polynom1.getPolynom().add(m2);
        polynom1.getPolynom().add(m3);
        polynom1.getPolynom().add(m4);
        expectedP.getPolynom().add(m5);
        expectedP.getPolynom().add(m6);
        expectedP.getPolynom().add(m7);
        expectedP.getPolynom().add(m8);
        Polynomial integrate = new Polynomial();
        integrate.getPolynom().addAll(Polynomial.integrate(polynom1).getPolynom());
        assertEquals(expectedP.toString(), integrate.toString());
    }
}