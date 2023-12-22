package Source.Transform;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/*
 * Created by JFormDesigner on Sun Dec 10 16:05:11 CST 2023
 */


/**
 * @author HeMercy
 */
public class DecimalConversion extends JPanel {
    Boolean whichFocus = true;
    Boolean firstInput = true;

    public DecimalConversion() {
        initComponents();
    }

    /**
     * Description: Converts between binary, octal, decimal, and hexadecimal.
     * @param nums The number that needs to be converted.
     * @param op1 The decimal of the number.
     * @param op2 The decimal to be converted to.
     * @return The number that has been converted.
     * @author HeMercy
     */
    private String decimalConversion(String nums, int op1, int op2) {
        try {
            if (!nums.isEmpty()) {
                if (nums.charAt(0) == '-' && op2 != 10) {
                    String newNums = new BigInteger(nums.substring(1), op1).toString(2);
                    StringBuilder res = new StringBuilder("1");
                    for (char i : newNums.toCharArray()) {
                        if (i == '1')
                            res.append('0');
                        else
                            res.append('1');
                    }
                    return new BigInteger(res.toString(), 2).add(BigInteger.ONE).toString(op2);
                } else
                    return new BigInteger(nums, op1).toString(op2);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Description: Execute the method decimalConversion.
     * @param textField1 The currently focused text-field.
     * @param textField2 The other text-field.
     * @param comboBox1 The combo box of the currently focused text-field.
     * @param comboBox2 The combo box of the other text-field.
     * @author HeMercy
     */
    private void solve(JTextField textField1, JTextField textField2, JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String inputString = textField1.getText();
        int p1 = comboBox1.getSelectedIndex();
        int p2 = comboBox2.getSelectedIndex();

        String res = null;
        switch (p1) {
            case 0:
                switch (p2) {
                    case 0 -> {
                        res = decimalConversion(inputString, 2, 2);
                    }
                    case 1 -> {
                        res = decimalConversion(inputString, 2, 8);
                    }
                    case 2 -> {
                        res = decimalConversion(inputString, 2, 10);
                    }
                    case 3 -> {
                        res = decimalConversion(inputString, 2, 16);
                    }
                }
                break;
            case 1:
                switch (p2) {
                    case 0 -> {
                        res = decimalConversion(inputString, 8, 2);
                    }
                    case 1 -> {
                        res = decimalConversion(inputString, 8, 8);
                    }
                    case 2 -> {
                        res = decimalConversion(inputString, 8, 10);
                    }
                    case 3 -> {
                        res = decimalConversion(inputString, 8, 16);
                    }
                }
                break;
            case 2:
                switch (p2) {
                    case 0 -> {
                        res = decimalConversion(inputString, 10, 2);
                    }
                    case 1 -> {
                        res = decimalConversion(inputString, 10, 8);
                    }
                    case 2 -> {
                        res = decimalConversion(inputString, 10, 10);
                    }
                    case 3 -> {
                        res = decimalConversion(inputString, 10, 16);
                    }
                }
                break;
            case 3:
                switch (p2) {
                    case 0 -> {
                        res = decimalConversion(inputString, 16, 2);
                    }
                    case 1 -> {
                        res = decimalConversion(inputString, 16, 8);
                    }
                    case 2 -> {
                        res = decimalConversion(inputString, 16, 10);
                    }
                    case 3 -> {
                        res = decimalConversion(inputString, 16, 16);
                    }
                }
                break;
        }
        textField2.setText(res);
    }

    /**
     * Description: Limit the content entered the text-field.
     * It can only be number or letter or minus sign.
     * @author HeMercy
     */
    static class RestrictedDocumentFilter extends DocumentFilter {
        int op;

        public RestrictedDocumentFilter(int op) {
            this.op = op;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            super.insertString(fb, offset, filter(string), attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            super.replace(fb, offset, length, filter(text), attrs);
        }

        private String filter(String input) {
            if (input == null || input.isEmpty())
                return null;
            switch (op) {
                case 0 -> {
                    return input.replaceAll("[^-0-1]", "");
                }
                case 1 -> {
                    return input.replaceAll("[^-0-7]", "");
                }
                case 2 -> {
                    return input.replaceAll("[^-0-9]", "");
                }
                case 3 -> {
                    return input.replaceAll("[^-0-9a-fA-F]", "");
                }
                default -> {
                    return null;
                }
            }
        }
    }
    /**
     * Description: Monitor the input of the first text-field
     * @param e CaretEvent
     * @author HeMercy
     */
    private void textField1CaretUpdate(CaretEvent e) {
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox1.getSelectedIndex()));
    }
    /**
     * Description: Monitor the focus of the first text-field.
     * If it's the first input, replace the original contents with new input.
     * @param e FocusEvent
     * @author HeMercy
     */
    private void textField1FocusGained(FocusEvent e) {
        String str = textField1.getText();
        whichFocus = true;
        firstInput = true;
        textField1.setFont(new Font("Inter", Font.BOLD, 28));
        textField2.setFont(new Font("Inter", Font.PLAIN, 28));
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleInput();
            }

            private void handleInput() {
                if (firstInput) {
                    SwingUtilities.invokeLater(() -> {
                        String str1 = textField1.getText();
                        try {
                            textField1.setText(str1.substring(str.length()));
                            solve(textField1, textField2, comboBox1, comboBox2);
                        } catch (Exception ignored) {
                        }
                        // 清空原始文本
                    });
                    firstInput = false;
                }
                // 可以在这里处理用户输入后的逻辑
            }
        });
    }
    /**
     * Description: Monitor the keyboard input of the first text-field.
     * If it happens, update the contents of the other text-field in real time.
     * @param e KeyEvent
     * @author HeMercy
     */
    private void textField1KeyReleased(KeyEvent e) {
        solve(textField1, textField2, comboBox1, comboBox2);
    }
    /**
     * Description: Monitor the input of the second text-field
     * @param e CaretEvent
     * @author HeMercy
     */
    private void textField2CaretUpdate(CaretEvent e) {

        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox2.getSelectedIndex()));
    }
    /**
     * Description: Monitor the focus of the second text-field.
     * If it's the first input, replace the original contents with new input.
     * @param e FocusEvent
     * @author HeMercy
     */
    private void textField2FocusGained(FocusEvent e) {

        String str = textField2.getText();
        whichFocus = false;
        firstInput = true;
        textField1.setFont(new Font("Inter", Font.PLAIN, 28));
        textField2.setFont(new Font("Inter", Font.BOLD, 28));
        textField2.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleInput();
            }

            private void handleInput() {
                if (firstInput) {
                    SwingUtilities.invokeLater(() -> {
                        String str1 = textField2.getText();
                        try {
                            textField2.setText(str1.substring(str.length()));
                            solve(textField2, textField1, comboBox2, comboBox1);
                        } catch (Exception ignored) {
                        }
                        // 清空原始文本
                    });
                    firstInput = false;
                }
                // 可以在这里处理用户输入后的逻辑
            }
        });
    }
    /**
     * Description: Monitor the keyboard input of the second text-field.
     * If it happens, update the contents of the other text-field in real time.
     * @param e KeyEvent
     * @author HeMercy
     */
    private void textField2KeyReleased(KeyEvent e) {
        solve(textField2, textField1, comboBox2, comboBox1);
    }
    /**
     * Description: Monitor the changes of the item state of the first combo Box.
     * If it happens, update the contents of the first text-field
     * depending on the contents of the second text-field in real time.
     * @param e ItemEvent
     * @author HeMercy
     */
    private void comboBox1ItemStateChanged(ItemEvent e) {
        whichFocus = false;
        textField1.setFont(new Font("Inter", Font.PLAIN, 28));
        textField2.setFont(new Font("Inter", Font.BOLD, 28));
        solve(textField2, textField1, comboBox2, comboBox1);
    }
    /**
     * Description: Monitor the changes of the item state of the second combo Box.
     * If it happens, update the contents of the second text-field
     * depending on the contents of the first text-field in real time.
     * @param e ItemEvent
     * @author HeMercy
     */
    private void comboBox2ItemStateChanged(ItemEvent e) {
        whichFocus = true;
        textField1.setFont(new Font("Inter", Font.BOLD, 28));
        textField2.setFont(new Font("Inter", Font.PLAIN, 28));
        solve(textField1, textField2, comboBox1, comboBox2);
    }

    /**
     * Description: Monitor the button "CE".
     * If it is pressed, delete all the characters in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonClear(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
    }
    /**
     * Description: Monitor the button "backspace".
     * If it is pressed, delete the last character in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonBack(ActionEvent e) {
        if (whichFocus) {
            String text = textField1.getText();
            if (!text.isEmpty()) {
                textField1.setText(text.substring(0, text.length() - 1));
                solve(textField1, textField2, comboBox1, comboBox2);
            }
        } else {
            String text = textField2.getText();
            if (!text.isEmpty()) {
                textField2.setText(text.substring(0, text.length() - 1));
                solve(textField2, textField1, comboBox2, comboBox1);
            }
        }
    }
    /**
     * Description: Monitor the button "0".
     * If it is pressed, enter "0" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button0(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "0");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "0");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "1".
     * If it is pressed, enter "1" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button1(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "1");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "1");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "2".
     * If it is pressed, enter "2" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button2(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "2");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "2");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "3".
     * If it is pressed, enter "3" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button3(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "3");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "3");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "4".
     * If it is pressed, enter "4" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button4(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "4");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "4");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "5".
     * If it is pressed, enter "5" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button5(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "5");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "5");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "6".
     * If it is pressed, enter "6" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button6(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "6");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "6");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "7".
     * If it is pressed, enter "7" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button7(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "7");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "7");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "8".
     * If it is pressed, enter "8" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button8(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "8");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "8");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "9".
     * If it is pressed, enter "9" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void button9(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "9");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "9");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "a".
     * If it is pressed, enter "a" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonA(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "a");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "a");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "b".
     * If it is pressed, enter "b" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonB(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "b");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "b");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "c".
     * If it is pressed, enter "c" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonC(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "c");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "c");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "d".
     * If it is pressed, enter "d" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonD(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "d");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "d");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "e".
     * If it is pressed, enter "e" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonE(ActionEvent e) {
        if (whichFocus) {
            textField1.setText(textField1.getText() + "e");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "e");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "f".
     * If it is pressed, enter "f" in the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonF(ActionEvent e) {
        // TODO add your code here
        if (whichFocus) {
            textField1.setText(textField1.getText() + "f");
            solve(textField1, textField2, comboBox1, comboBox2);
        } else {
            textField2.setText(textField2.getText() + "f");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }
    /**
     * Description: Monitor the button "+/-".
     * If it is pressed, add or remove a minus sign at the top of the current text-field.
     * @param e ActionEvent
     * @author HeMercy
     */
    private void buttonAnti(ActionEvent e) {
        firstInput = false;
        if (whichFocus) {
            if (!textField1.getText().isEmpty() && textField1.getText().charAt(0) != '-') {
                String now = textField1.getText();
                System.out.println(now);
                textField1.setText("-" + now);
                solve(textField1, textField2, comboBox1, comboBox2);
            } else if (!textField1.getText().isEmpty()) {
                textField1.setText(textField1.getText().substring(1));
                solve(textField1, textField2, comboBox1, comboBox2);
            }
        } else {
            if (!textField2.getText().isEmpty() && textField2.getText().charAt(0) != '-') {
                textField2.setText("-" + textField2.getText());
                solve(textField2, textField1, comboBox2, comboBox1);
            } else if (!textField2.getText().isEmpty()) {
                textField2.setText(textField2.getText().substring(1));
                solve(textField2, textField1, comboBox2, comboBox1);
            }
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        decimalConversion = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button6 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button7 = new JButton();
        button5 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button14 = new JButton();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        button2 = new JButton();
        button16 = new JButton();
        button17 = new JButton();
        button18 = new JButton();
        button19 = new JButton();
        button20 = new JButton();

        //======== this ========
        setFont(new Font("Consolas", Font.PLAIN, 18));
        setMinimumSize(new Dimension(450, 564));
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setLayout(null);

        //---- decimalConversion ----
        decimalConversion.setText("\u8fdb\u5236\u8f6c\u6362");
        decimalConversion.setFont(decimalConversion.getFont().deriveFont(decimalConversion.getFont().getStyle() | Font.BOLD, decimalConversion.getFont().getSize() + 10f));
        add(decimalConversion);
        decimalConversion.setBounds(new Rectangle(new Point(15, 25), decimalConversion.getPreferredSize()));

        //---- textField1 ----
        textField1.setColumns(10);
        textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        textField1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        textField1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 26));
        textField1.setText("0");
        textField1.setMargin(new Insets(4, 8, 4, 8));
        textField1.setCaretPosition(1);
        textField1.setHorizontalAlignment(SwingConstants.LEFT);
        textField1.addCaretListener(e -> textField1CaretUpdate(e));
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField1FocusGained(e);
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                textField1KeyReleased(e);
            }
        });
        add(textField1);
        textField1.setBounds(10, 70, 380, 50);

        //---- textField2 ----
        textField2.setColumns(10);
        textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        textField2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        textField2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 26));
        textField2.setText("0");
        textField2.setMargin(new Insets(4, 8, 4, 8));
        textField2.setCaretPosition(1);
        textField2.setHorizontalAlignment(SwingConstants.LEFT);
        textField2.addCaretListener(e -> textField2CaretUpdate(e));
        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField2FocusGained(e);
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                textField2KeyReleased(e);
            }
        });
        add(textField2);
        textField2.setBounds(10, 180, 380, 50);

        //---- button1 ----
        button1.setText("C");
        button1.setFont(new Font("Consolas", Font.PLAIN, 18));
        button1.setFocusable(false);
        button1.addActionListener(e -> buttonClear(e));
        add(button1);
        button1.setBounds(200, 285, 90, 50);

        //---- button6 ----
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
        button6.setSelectedIcon(new ImageIcon(getClass().getResource("/Resources/img/Backspace(1)(1).png")));
        button6.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        button6.setFocusable(false);
        button6.addActionListener(e -> buttonBack(e));
        add(button6);
        button6.setBounds(295, 285, 90, 50);

        //---- button3 ----
        button3.setText("7");
        button3.setFont(new Font("Consolas", Font.PLAIN, 18));
        button3.setFocusable(false);
        button3.addActionListener(e -> button7(e));
        add(button3);
        button3.setBounds(105, 340, 90, 50);

        //---- button4 ----
        button4.setText("8");
        button4.setFont(new Font("Consolas", Font.PLAIN, 18));
        button4.setFocusable(false);
        button4.addActionListener(e -> button8(e));
        add(button4);
        button4.setBounds(200, 340, 90, 50);

        //---- button7 ----
        button7.setText("9");
        button7.setFont(new Font("Consolas", Font.PLAIN, 18));
        button7.setFocusable(false);
        button7.addActionListener(e -> button9(e));
        add(button7);
        button7.setBounds(295, 340, 90, 50);

        //---- button5 ----
        button5.setText("4");
        button5.setFont(new Font("Consolas", Font.PLAIN, 18));
        button5.setFocusable(false);
        button5.addActionListener(e -> button4(e));
        add(button5);
        button5.setBounds(105, 395, 90, 50);

        //---- button8 ----
        button8.setText("5");
        button8.setFont(new Font("Consolas", Font.PLAIN, 18));
        button8.setFocusable(false);
        button8.addActionListener(e -> button5(e));
        add(button8);
        button8.setBounds(200, 395, 90, 50);

        //---- button9 ----
        button9.setText("6");
        button9.setFont(new Font("Consolas", Font.PLAIN, 18));
        button9.setFocusable(false);
        button9.addActionListener(e -> button6(e));
        add(button9);
        button9.setBounds(295, 395, 90, 50);

        //---- button10 ----
        button10.setText("1");
        button10.setFont(new Font("Consolas", Font.PLAIN, 18));
        button10.setFocusable(false);
        button10.addActionListener(e -> button1(e));
        add(button10);
        button10.setBounds(105, 450, 90, 50);

        //---- button11 ----
        button11.setText("2");
        button11.setFont(new Font("Consolas", Font.PLAIN, 18));
        button11.setFocusable(false);
        button11.addActionListener(e -> button2(e));
        add(button11);
        button11.setBounds(200, 450, 90, 50);

        //---- button12 ----
        button12.setText("3");
        button12.setFont(new Font("Consolas", Font.PLAIN, 18));
        button12.setFocusable(false);
        button12.addActionListener(e -> button3(e));
        add(button12);
        button12.setBounds(295, 450, 90, 50);

        //---- button13 ----
        button13.setText("+/-");
        button13.setFont(new Font("Consolas", Font.PLAIN, 18));
        button13.setFocusable(false);
        button13.addActionListener(e -> buttonAnti(e));
        add(button13);
        button13.setBounds(295, 505, 90, 50);

        //---- button14 ----
        button14.setText("0");
        button14.setFont(new Font("Consolas", Font.PLAIN, 18));
        button14.setFocusable(false);
        button14.addActionListener(e -> button0(e));
        add(button14);
        button14.setBounds(200, 505, 90, 50);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u4e8c\u8fdb\u5236",
            "\u516b\u8fdb\u5236",
            "\u5341\u8fdb\u5236",
            "\u5341\u516d\u8fdb\u5236"
        }));
        comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getStyle() | Font.BOLD, comboBox1.getFont().getSize() + 4f));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        add(comboBox1);
        comboBox1.setBounds(15, 130, 120, 40);

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u4e8c\u8fdb\u5236",
            "\u516b\u8fdb\u5236",
            "\u5341\u8fdb\u5236",
            "\u5341\u516d\u8fdb\u5236"
        }));
        comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getStyle() | Font.BOLD, comboBox2.getFont().getSize() + 4f));
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
        add(comboBox2);
        comboBox2.setBounds(15, 240, 120, 40);

        //---- button2 ----
        button2.setText("a");
        button2.setFont(new Font("Consolas", Font.PLAIN, 18));
        button2.setFocusable(false);
        button2.addActionListener(e -> buttonA(e));
        add(button2);
        button2.setBounds(10, 285, 90, 50);

        //---- button16 ----
        button16.setText("b");
        button16.setFont(new Font("Consolas", Font.PLAIN, 18));
        button16.setFocusable(false);
        button16.addActionListener(e -> buttonB(e));
        add(button16);
        button16.setBounds(10, 340, 90, 50);

        //---- button17 ----
        button17.setText("c");
        button17.setFont(new Font("Consolas", Font.PLAIN, 18));
        button17.setFocusable(false);
        button17.addActionListener(e -> buttonC(e));
        add(button17);
        button17.setBounds(10, 395, 90, 50);

        //---- button18 ----
        button18.setText("d");
        button18.setFont(new Font("Consolas", Font.PLAIN, 18));
        button18.setFocusable(false);
        button18.addActionListener(e -> buttonD(e));
        add(button18);
        button18.setBounds(10, 450, 90, 50);

        //---- button19 ----
        button19.setText("e");
        button19.setFont(new Font("Consolas", Font.PLAIN, 18));
        button19.setFocusable(false);
        button19.addActionListener(e -> buttonE(e));
        add(button19);
        button19.setBounds(10, 505, 90, 50);

        //---- button20 ----
        button20.setText("f");
        button20.setFont(new Font("Consolas", Font.PLAIN, 18));
        button20.setFocusable(false);
        button20.addActionListener(e -> buttonF(e));
        add(button20);
        button20.setBounds(105, 505, 90, 50);

        setPreferredSize(new Dimension(400, 570));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel decimalConversion;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button6;
    private JButton button3;
    private JButton button4;
    private JButton button7;
    private JButton button5;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JButton button2;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
