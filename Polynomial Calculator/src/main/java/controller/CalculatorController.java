package controller;

import model.Model;
import model.Monomial;
import model.Polynomial;
import view.CalculatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class controls the data flow into a model object and updates the view whenever data changes
 */
public class CalculatorController {
    private CalculatorView calculatorView;
    private Model model;

    /**
     * Constructor for CalculatorController Class
     * It initializes the buttons
     * @param calculatorView
     * @param model
     */
    public CalculatorController(CalculatorView calculatorView, Model model) {
        this.calculatorView = calculatorView;
        this.model = model;
        this.initializeButtons();
    }

    /**
     * method to get text from text field and converts it into a polynomial
     * @param s is the text from the text field
     * @return polynomial
     * @throws Exception that occurs when the coefficient of a monomial is 0
     */
    public static Polynomial strToPolynomial(String s) throws Exception {
        Pattern pattern = Pattern.compile("([+-]?\\d+\\.0)[x]\\^([+-]?\\d+)");
        Matcher matcher = pattern.matcher(s);
        Polynomial polynomial = new Polynomial();

        while(matcher.find()) {
            Monomial momo1 = new Monomial();
            if (Double.parseDouble(matcher.group(1)) != 0.0) {

                momo1.setCoefficient(Double.parseDouble(matcher.group(1)));
                momo1.setPower(Integer.parseInt(matcher.group(2)));
                polynomial.getPolynom().add(momo1);
            }else{
                throw new Exception("Bad input!");
            }
        }

        return polynomial;
    }

    /**
     * method to initialize the buttons
     */
    public void initializeButtons() {
        this.calculatorView.addListenerAddBtn(new ActionListener() {
            /**
             * the method gets the text from the text fields of the two polynomials,
             * gets the polynomials by calling the method strToPolynomial
             * performs the addition and sets the text field of result with the result of the operation
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String first = "";
                String second = "";

                try {
                    first = CalculatorController.this.calculatorView.getTxtFieldInp1().getText();
                    second = CalculatorController.this.calculatorView.getTxtFieldInp2().getText();
                    CalculatorController.this.model.setResult(Polynomial.add(CalculatorController.strToPolynomial(first), CalculatorController.strToPolynomial(second)));
                    CalculatorController.this.calculatorView.getTxtFieldResult().setText(CalculatorController.this.model.getResult().toString());
                } catch (Exception exception) {
                    CalculatorController.this.calculatorView.setTxtFieldResult("Bad input!");
                }

            }
        });
        this.calculatorView.addListenerSubBtn(new ActionListener() {
            /**
             * the method gets the text from the text fields of the two polynomials,
             * gets the polynomials by calling the method strToPolynomial
             * performs the subtraction and sets the text field of result with the result of the operation
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String first = "";
                String second = "";

                try {
                    first = CalculatorController.this.calculatorView.getTxtFieldInp1().getText();
                    second = CalculatorController.this.calculatorView.getTxtFieldInp2().getText();
                    CalculatorController.this.model.setResult(Polynomial.subtract(CalculatorController.strToPolynomial(first), CalculatorController.strToPolynomial(second)));
                    CalculatorController.this.calculatorView.getTxtFieldResult().setText(CalculatorController.this.model.getResult().toString());
                } catch (Exception exception) {
                    CalculatorController.this.calculatorView.setTxtFieldResult("Bad input!");
                }

            }
        });
        this.calculatorView.addListenerMulBtn(new ActionListener() {
            /**
             * the method gets the text from the text fields of the two polynomials,
             * gets the polynomials by calling the method strToPolynomial
             * performs the multiplication and sets the text field of result with the result of the operation
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String first = "";
                String second = "";

                try {
                    first = CalculatorController.this.calculatorView.getTxtFieldInp1().getText();
                    second = CalculatorController.this.calculatorView.getTxtFieldInp2().getText();
                    CalculatorController.this.model.setResult(Polynomial.multiply(CalculatorController.strToPolynomial(first), CalculatorController.strToPolynomial(second)));
                    CalculatorController.this.calculatorView.getTxtFieldResult().setText(CalculatorController.this.model.getResult().toString());
                } catch (Exception exception) {
                    CalculatorController.this.calculatorView.setTxtFieldResult("Bad input!");
                }

            }
        });
        this.calculatorView.addListenerDerivBtn(new ActionListener() {
            /**
             * the method gets the text from the text fields of the two polynomials,
             * gets the polynomials by calling the method strToPolynomial
             * performs the differentiation and sets the text field of result with the result of the operation
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String first = "";

                try {
                    first = CalculatorController.this.calculatorView.getTxtFieldInp1().getText();
                    CalculatorController.this.model.setResult(Polynomial.differentiation(CalculatorController.strToPolynomial(first)));
                    CalculatorController.this.calculatorView.getTxtFieldResult().setText(CalculatorController.this.model.getResult().toString());
                } catch (Exception exception) {
                    CalculatorController.this.calculatorView.setTxtFieldResult("Bad input!");
                }

            }
        });
        this.calculatorView.addListenerIntegrBtn(new ActionListener() {
            /**
             * the method gets the text from the text fields of the two polynomials,
             * gets the polynomials by calling the method strToPolynomial
             * performs the integration and sets the text field of result with the result of the operation
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String first = "";

                try {
                    first = CalculatorController.this.calculatorView.getTxtFieldInp1().getText();
                    CalculatorController.this.model.setResult(Polynomial.integrate(CalculatorController.strToPolynomial(first)));
                    CalculatorController.this.calculatorView.getTxtFieldResult().setText(CalculatorController.this.model.getResult().toString());
                } catch (Exception exception) {
                    CalculatorController.this.calculatorView.setTxtFieldResult("Bad input!");
                }

            }
        });
        this.calculatorView.addListenerClearBtn(new ActionListener() {
            /**
             * the method clears the text fields of input 1, input 2 and result
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                CalculatorController.this.calculatorView.getTxtFieldInp1().setText("");
                CalculatorController.this.calculatorView.getTxtFieldInp2().setText("");
                CalculatorController.this.calculatorView.getTxtFieldResult().setText("");
            }
        });
        this.calculatorView.addListenerDivBtn(new ActionListener() {
            /**
             * the method gets the text from the text fields of the two polynomials,
             * gets the polynomials by calling the method strToPolynomial
             * performs the division and sets the text field of result with the result of the operation
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String first = "";
                String second = "";

                try {
                    first = CalculatorController.this.calculatorView.getTxtFieldInp1().getText();
                    second = CalculatorController.this.calculatorView.getTxtFieldInp2().getText();
                    Polynomial quotient = (Polynomial.divide(CalculatorController.strToPolynomial(first), CalculatorController.strToPolynomial(second)))[0];
                    Polynomial remainder = (Polynomial.divide(CalculatorController.strToPolynomial(first), CalculatorController.strToPolynomial(second)))[1];
                    CalculatorController.this.calculatorView.getTxtFieldResult().setText("Q: " + quotient.toString() + ";   Rem: " + remainder.toString());
                } catch (Exception exception) {
                    CalculatorController.this.calculatorView.setTxtFieldResult("Bad input!");
                }

            }
        });
    }
}