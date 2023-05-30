package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalcView extends JFrame{

    //components:
    private JTextField firstPolyJTextField = new JTextField();
    private JTextField secondPolyJTextField = new JTextField();
    private JTextField resultJTextfield = new JTextField();

    private JButton nr1Button = new JButton("1");
    private JButton nr2Button = new JButton("2");
    private JButton nr3Button = new JButton("3");
    private JButton nr4Button = new JButton("4");
    private JButton nr5Button = new JButton("5");
    private JButton nr6Button = new JButton("6");
    private JButton nr7Button = new JButton("7");
    private JButton nr8Button = new JButton("8");
    private JButton nr9Button = new JButton("9");

    private JButton nr0Button = new JButton("0");
    private JButton plusButton = new JButton("+");
    private JButton minusButton = new JButton("-");
    private JButton resetButton = new JButton("reset");
    private JButton powButton = new JButton("^");
    private JButton clear = new JButton("clear");
    private JButton asteriskButton = new JButton("*");
    private JButton deleteButton = new JButton("delete");
    private JButton xButton = new JButton("x");

    private JLabel l1 = new JLabel(": Polynomial 1");
    private JLabel l2 = new JLabel(": Polynomial 2");
    private JLabel l3 = new JLabel(": Result");


    private JButton addButton = new JButton("ADD");
    private JButton diffButton = new JButton("SUB");
    private JButton mulButton = new JButton("MULTIPLY");
    private JButton divButton = new JButton("DIVIDE");
    private JButton derivButton = new JButton("DERIVE");
    private JButton integButton = new JButton("INTEGRATE");


    public CalcView(){
        setSize(800, 800);

        JPanel mainPanel = new JPanel();
        //JSplitPane mainPanel = new JSplitPane();

        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        southPanel.setLayout(new GridLayout(1, 2));

        // panel 1 - cu numerele
        panel1.setLayout(new GridLayout(3, 3));
        addButtonsToPanel1(panel1);

        southPanel.setPreferredSize(new Dimension(800, 300));
        southPanel.add(panel1);

        // panel 2 - cu 0, x, +, -, ^
        panel2.setLayout(new GridLayout(3, 3));
        addButtonToPanel2(panel2);

        southPanel.add(panel2);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        //north panel
        northPanel.setLayout(new GridLayout(3, 2));
        addToNorthPanel(northPanel);
        northPanel.setPreferredSize(new Dimension(800, 200));

        mainPanel.add(northPanel, BorderLayout.NORTH);


        //center panel
        centerPanel.setLayout(new GridLayout(3, 2));
        addToCenterPanel(centerPanel);
        centerPanel.setPreferredSize(new Dimension(1000, 200));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setFontToAllComponents();
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButtonListeners();
    }


    private void addButtonsToPanel1(JPanel panel){
        nr1Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr1Button);
        nr2Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr2Button);
        nr3Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr3Button);
        nr4Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr4Button);
        nr5Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr5Button);
        nr6Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr6Button);
        nr7Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr7Button);
        nr8Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr8Button);
        nr9Button.setPreferredSize(new Dimension(25, 25));
        panel.add(nr9Button);
    }

    private void addButtonToPanel2(JPanel panel){
        panel.add(nr0Button);
        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(asteriskButton);
        panel.add(clear);
        panel.add(powButton);
        panel.add(xButton);
        panel.add(deleteButton);
        panel.add(resetButton);
    }

    private void addToNorthPanel(JPanel panel){
        panel.add(firstPolyJTextField);
        panel.add(l1);
        panel.add(secondPolyJTextField);
        panel.add(l2);
        panel.add(resultJTextfield);
        panel.add(l3);
    }

    private void addToCenterPanel(JPanel panel){
        panel.add(addButton);
        panel.add(diffButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(derivButton);
        panel.add(integButton);
    }

    private void setFontToAllComponents(){
        setFontJTextFields();
        setFontLabels();
    }

    private void setFontJTextFields(){
        Font font = new Font("Arial", Font.PLAIN, 25);
        firstPolyJTextField.setFont(font);
        secondPolyJTextField.setFont(font);
        resultJTextfield.setFont(font);
    }

    private void setFontLabels(){
        Font font = new Font("Arial", Font.PLAIN, 30);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
    }

    public void open(){
        this.setTitle("Polynomial Calculator");
        this.setVisible(true);
    }

    public String getFirstPolynomial(){
        return firstPolyJTextField.getText();
    }

    public String getSecondPolynomial(){
        return  secondPolyJTextField.getText();
    }

    public void setResult(String result){
        if(result.equals(""))
            resultJTextfield.setText("0");
        else
            resultJTextfield.setText(result);
    }

    public void showError(String s){
        System.out.println(s);
    }

    /** --------- ADD LISTENERS --------**/
    public void addAddListener(ActionListener addListener){
        addButton.addActionListener(addListener);
    }
    public void addSubstactListener(ActionListener subListener){
        diffButton.addActionListener(subListener);
    }
    public void addMultiplyListener(ActionListener multiplyListener){
        mulButton.addActionListener(multiplyListener);
    }
    public void addDivideListener(ActionListener divideListener){
        divButton.addActionListener(divideListener);
    }
    public void addDeriveListener(ActionListener deriveListener){
        derivButton.addActionListener(deriveListener);
    }
    public void addIntegrateListener(ActionListener integrateListener){
        integButton.addActionListener(integrateListener);
    }

    /*** LOCAL BUTTONS LISTENERS ***/
    private void addButtonListeners(){
        ButtonHandler handler = new ButtonHandler();
        ResetButtonListener resetButtonListener = new ResetButtonListener();
        nr0Button.addActionListener(handler);
        nr1Button.addActionListener(handler);
        nr2Button.addActionListener(handler);
        nr3Button.addActionListener(handler);
        nr4Button.addActionListener(handler);
        nr5Button.addActionListener(handler);
        nr6Button.addActionListener(handler);
        nr7Button.addActionListener(handler);
        nr8Button.addActionListener(handler);
        nr9Button.addActionListener(handler);

        plusButton.addActionListener(handler);
        minusButton.addActionListener(handler);
        resetButton.addActionListener(resetButtonListener);
        powButton.addActionListener(handler);
        clear.addActionListener(resetButtonListener);
        asteriskButton.addActionListener(handler);
        deleteButton.addActionListener(resetButtonListener);
        xButton.addActionListener(handler);

        nr0Button.setFocusable(false);
        nr1Button.setFocusable(false);
        nr2Button.setFocusable(false);
        nr3Button.setFocusable(false);
        nr4Button.setFocusable(false);
        nr5Button.setFocusable(false);
        nr6Button.setFocusable(false);
        nr7Button.setFocusable(false);
        nr8Button.setFocusable(false);
        nr9Button.setFocusable(false);

        plusButton.setFocusable(false);
        minusButton.setFocusable(false);
        resetButton.setFocusable(false);
        powButton.setFocusable(false);
        clear.setFocusable(false);
        asteriskButton.setFocusable(false);
        deleteButton.setFocusable(false);
        xButton.setFocusable(false);

    }
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source instanceof JButton){
                JButton btn = (JButton) source;
                try {
                    Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                    if(comp instanceof JTextField){
                        JTextField tf = (JTextField) comp;
                        tf.setText(tf.getText() + btn.getText());
                    }
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }
    }
    private class ResetButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source instanceof JButton){
                JButton btn = (JButton) source;
                if(btn.getText().equals("reset")) {
                    firstPolyJTextField.setText("");
                    secondPolyJTextField.setText("");
                    resultJTextfield.setText("");
                }
                else {
                    try {
                        Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                        if(comp instanceof JTextField){
                            JTextField tf = (JTextField) comp;
                            if(btn.getText().equals("delete") && tf.getText().length() > 0)
                                tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
                            else if(btn.getText().equals("clear"))
                                tf.setText("");
                        }
                    }
                    catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}
