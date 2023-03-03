package model;

import controller.CalculatorController;
import view.CalculatorView;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        Model model = new Model();
        new CalculatorController(calculatorView, model);
        calculatorView.setVisible(true);
    }
}