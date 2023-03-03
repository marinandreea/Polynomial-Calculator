package view;

import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Class that implements the graphical user interface
 */
public class CalculatorView extends JFrame {

    private JButton addBtn;
    private JButton subBtn;
    private JButton multBtn;
    private JLabel labelInp1;
    private JLabel labelInp2;
    private JTextField txtFieldInp1;
    private JTextField txtFieldInp2;
    private JButton divBtn;
    private JButton derivBtn;
    private JButton integrBtn;
    private JButton clearBtn;
    private JLabel labelResult;
    private JTextField txtFieldResult;
    private JLabel instrLabel;

    /**
     * Constructor that sets the title of the application, its size and the default close operation
     * It also initializes the buttons, adds them to the frame and sets their bounds
     */
    public CalculatorView() {

        this.setTitle("Polynomial Calculator");
        this.setSize(900, 900);
        this.setLayout((LayoutManager)null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addBtn = new JButton("+");
        this.subBtn = new JButton("-");
        this.multBtn = new JButton("*");
        this.labelInp1 = new JLabel("Insert polynomial 1:");
        this.labelInp2 = new JLabel("Insert polynomial 2:");
        this.txtFieldInp1 = new JTextField(5);
        this.txtFieldInp2 = new JTextField(5);
        this.divBtn = new JButton("/");
        this.derivBtn = new JButton("( )'");
        this.integrBtn = new JButton("∫ f(x)dx");
        this.clearBtn = new JButton("Clear");
        this.labelResult = new JLabel("Result:");
        this.txtFieldResult = new JTextField(5);
        this.instrLabel = new JLabel("ATTENTION: Please enter the input like this: c1^p1+c2^p2...., (where c1,c2,...,cn are doubles and p1,p2,...,pn are integeres).");

        this.add(this.addBtn);
        this.add(this.subBtn);
        this.add(this.multBtn);
        this.add(this.labelInp1);
        this.add(this.labelInp2);
        this.add(this.txtFieldInp1);
        this.add(this.txtFieldInp2);
        this.add(this.divBtn);
        this.add(this.derivBtn);
        this.add(this.integrBtn);
        this.add(this.clearBtn);
        this.add(this.labelResult);
        this.add(this.txtFieldResult);
        this.add(this.instrLabel);

        this.addBtn.setBounds(100, 255, 100, 35);
        this.subBtn.setBounds(330, 255, 100, 35);
        this.multBtn.setBounds(560, 255, 100, 35);
        this.labelInp1.setBounds(85, 60, 115, 35);
        this.labelInp2.setBounds(85, 115, 115, 35);
        this.txtFieldInp1.setBounds(205, 65, 345, 35);
        this.txtFieldInp2.setBounds(205, 115, 345, 35);
        this.divBtn.setBounds(100, 340, 100, 35);
        this.derivBtn.setBounds(330, 340, 100, 35);
        this.integrBtn.setBounds(560, 345, 100, 35);
        this.clearBtn.setBounds(610, 115, 100, 35);
        this.labelResult.setBounds(85, 165, 80, 35);
        this.txtFieldResult.setBounds(205, 165, 345, 35);
        this.instrLabel.setBounds(5, 400, 800, 95);
    }

    /**
     * Getter for text field of input 1
     *
     * @return text field of input 1
     */
    public JTextField getTxtFieldInp1() {
        return this.txtFieldInp1;
    }

    /**
     * Getter for text field of input 2
     *
     * @return text field of input 2
     */
    public JTextField getTxtFieldInp2() {
        return this.txtFieldInp2;
    }

    /**
     * Getter for text field of result
     *
     * @return text field of result
     */
    public JTextField getTxtFieldResult() {
        return this.txtFieldResult;
    }

    /**
     * Setter for text field of result
     *
     * @param res the string we want to display as result
     */
    public void setTxtFieldResult(String res) {
        this.txtFieldResult.setText(res);
    }

    /**
     * method for adding the listener for addition button
     *
     * @param e
     */
    public void addListenerAddBtn(ActionListener e) {
        this.addBtn.addActionListener(e);
    }

    /**
     * method for adding the listener for subtraction button
     *
     * @param e
     */
    public void addListenerSubBtn(ActionListener e) {
        this.subBtn.addActionListener(e);
    }

    /**
     * method for adding the listener for multiplication button
     *
     * @param e
     */
    public void addListenerMulBtn(ActionListener e) {
        this.multBtn.addActionListener(e);
    }

    /**
     * method for adding the listener for differentiation button
     *
     * @param e
     */
    public void addListenerDerivBtn(ActionListener e) {
        this.derivBtn.addActionListener(e);
    }

    /**
     * method for adding the listener for division button
     *
     * @param e
     */
    public void addListenerDivBtn(ActionListener e) {
        this.divBtn.addActionListener(e);
    }

    /**
     * method for adding the listener for integration button
     *
     * @param e
     */
    public void addListenerIntegrBtn(ActionListener e) {
        this.integrBtn.addActionListener(e);
    }

    /**
     * method for adding the listener for clear button
     *
     * @param e
     */
    public void addListenerClearBtn(ActionListener e) {
        this.clearBtn.addActionListener(e);
    }
}