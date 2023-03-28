package ro.tuc.frontend;

import ro.tuc.model.Monom;
import ro.tuc.model.Polynom;
import ro.tuc.operations.Conversion;
import ro.tuc.operations.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private final JLabel polynomTitle1;
    private final JLabel polynomTitle2;
    private final JLabel titleResult;

    private final JTextField polynomForm1;
    private final JTextField polynomForm2;
    private final JTextField resultForm;

    private final JButton buttonAdd;
    private final JButton buttonSub;
    private final JButton buttonMul;
    private final JButton buttonDiv;
    private final JButton buttonDeriv;
    private final JButton buttonInteg;

    public Window() {
        setTitle("Polynom Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        inputPanel.setBackground(new Color(238, 238, 238));

        polynomTitle1 = new JLabel("Polynomial 1:", SwingConstants.RIGHT);
        inputPanel.add(polynomTitle1);
        polynomForm1 = new JTextField(20);
        inputPanel.add(polynomForm1);
        polynomTitle2 = new JLabel("Polynomial 2:", SwingConstants.RIGHT);
        inputPanel.add(polynomTitle2);
        polynomForm2 = new JTextField(20);
        inputPanel.add(polynomForm2);
        titleResult = new JLabel("Result:", SwingConstants.RIGHT);
        inputPanel.add(titleResult);
        resultForm = new JTextField(20);
        resultForm.setEditable(false);
        inputPanel.add(resultForm);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        buttonPanel.setBackground(new Color(238, 238, 238));
        buttonAdd = new JButton("Add (+)");
        buttonAdd.setBackground(Color.GRAY);
        buttonAdd.setForeground(Color.BLACK);
        buttonPanel.add(buttonAdd);

        buttonSub = new JButton("Subtract (-)");
        buttonSub.setBackground(Color.GRAY);
        buttonSub.setForeground(Color.BLACK);
        buttonPanel.add(buttonSub);

        buttonMul = new JButton("Multiply (*)");
        buttonMul.setBackground(Color.GRAY);
        buttonMul.setForeground(Color.BLACK);
        buttonPanel.add(buttonMul);

        buttonDiv = new JButton("Divide (/)");
        buttonDiv.setBackground(Color.GRAY);
        buttonDiv.setForeground(Color.BLACK);
        buttonPanel.add(buttonDiv);

        buttonDeriv = new JButton("Differentiate (dx)");
        buttonDeriv.setBackground(Color.GRAY);
        buttonDeriv.setForeground(Color.BLACK);
        buttonPanel.add(buttonDeriv);

        buttonInteg = new JButton("Integrate ($dx)");
        buttonInteg.setBackground(Color.GRAY);
        buttonInteg.setForeground(Color.BLACK);
        buttonPanel.add(buttonInteg);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(238, 238, 238));

        panel.add(inputPanel, BorderLayout.PAGE_START);
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);

        buttonAdd.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonDeriv.addActionListener(this);
        buttonInteg.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input1 = polynomForm1.getText().trim();
        String input2 = polynomForm2.getText().trim();

        Polynom polynom1;
        Polynom polynom2;

        Object source = e.getSource();
        if (buttonAdd.equals(source)) {
            polynom1 = Conversion.convertFromString(input1);
            polynom2 = Conversion.convertFromString(input2);

            resultForm.setText(Operations.add(polynom1, polynom2).toString());
        }
        else if (buttonSub.equals(source)) {
            polynom1 = Conversion.convertFromString(input1);
            polynom2 = Conversion.convertFromString(input2);

            resultForm.setText(Operations.sub(polynom1, polynom2).toString());
        }
        else if (buttonMul.equals(source)) {
            polynom1 = Conversion.convertFromString(input1);
            polynom2 = Conversion.convertFromString(input2);

            resultForm.setText(Operations.mul(polynom1, polynom2).toString());
        }
        else if (buttonDiv.equals(source)) {
            polynom1 = Conversion.convertFromString(input1);
            polynom2 = Conversion.convertFromString(input2);
            //TODO division operation
        }
        else if (buttonDeriv.equals(source)) {
            polynom1 = Conversion.convertFromString(input1);
            polynom2 = Conversion.convertFromString(input2);

            resultForm.setText(Operations.derivative(polynom1).toString());
        }
        else if (buttonInteg.equals(source)) {
            polynom1 = Conversion.convertFromString(input1);
            polynom2 = Conversion.convertFromString(input2);

            resultForm.setText(Operations.integral(polynom1).toString());
        }
    }
}