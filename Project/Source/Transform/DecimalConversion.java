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

    public DecimalConversion() {
        initComponents();
    }

    private String JinzhiSwitch(String nums, int op1, int op2) {
        return new BigInteger(nums, op1).toString(op2);
    }

    private void solve(JTextField textField1, JTextField textField2, JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String inputString = textField1.getText();
        int p1 = comboBox1.getSelectedIndex();
        int p2 = comboBox2.getSelectedIndex();

        String res = null;
        switch (p1) {
            case 0:
                switch (p2) {
                    case 0 -> {
                        res = inputString;
                    }
                    case 1 -> {
                        res = JinzhiSwitch(inputString, 2, 8);
                    }
                    case 2 -> {
                        res = JinzhiSwitch(inputString, 2, 10);
                    }
                    case 3 -> {
                        res = JinzhiSwitch(inputString, 2, 16);
                    }
                }
                break;
            case 1:
                switch (p2) {
                    case 0 -> {
                        res = JinzhiSwitch(inputString, 8, 2);
                    }
                    case 1 -> {
                        res = inputString;
                    }
                    case 2 -> {
                        res = JinzhiSwitch(inputString, 8, 10);
                    }
                    case 3 -> {
                        res = JinzhiSwitch(inputString, 8, 16);
                    }
                }
                break;
            case 2:
                switch (p2) {
                    case 0 -> {
                        res = JinzhiSwitch(inputString, 10, 2);
                    }
                    case 1 -> {
                        res = JinzhiSwitch(inputString, 10, 8);
                    }
                    case 2 -> {
                        res = inputString;
                    }
                    case 3 -> {
                        res = JinzhiSwitch(inputString, 10, 16);
                    }
                }
                break;
            case 3:
                switch (p2) {
                    case 0 -> {
                        res = JinzhiSwitch(inputString, 16, 2);
                    }
                    case 1 -> {
                        res = JinzhiSwitch(inputString, 16, 8);
                    }
                    case 2 -> {
                        res = JinzhiSwitch(inputString, 16, 10);
                    }
                    case 3 -> {
                        res = inputString;
                    }
                }
                break;
        }
        textField2.setText(res);
    }

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
            // 此处可以根据需要定义文本框的输入限制
            // 这个例子中只允许输入数字
            input.replaceAll("\\.\\.", ".");
            if (!input.isEmpty() && input.charAt(0) == '.')
                input.replaceFirst("\\.", "");
            switch (op) {
                case 0 -> {
                    return input.replaceAll("[^\\-0-1.]", "");
                }
                case 1 -> {
                    return input.replaceAll("[^\\-0-7.]", "");
                }
                case 2 -> {
                    return input.replaceAll("[^\\-0-9.]", "");
                }
                case 3 -> {
                    return input.replaceAll("[^\\-0-9a-fA-F.]", "");
                }
                default -> {
                    return input;
                }
            }
        }
    }

    private void textField1CaretUpdate(CaretEvent e) {
        // TODO add your code here
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox1.getSelectedIndex()));
    }

    private void textField1FocusGained(FocusEvent e) {
        // TODO add your code here
        String str = textField1.getText();
        whichFocus = true;
        textField1.setFont(new Font("Inter", Font.BOLD, 28));
        textField2.setFont(new Font("Inter", Font.PLAIN, 28));
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            private boolean firstInput = true;

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

    private void textField1KeyReleased(KeyEvent e) {
        // TODO add your code here
//        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox1.getSelectedIndex()));
        solve(textField1, textField2, comboBox1, comboBox2);
    }

    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void textField2CaretUpdate(CaretEvent e) {

        // TODO add your code here
        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox2.getSelectedIndex()));
    }

    private void textField2FocusGained(FocusEvent e) {
        // TODO add your code here
        String str = textField2.getText();
        whichFocus = false;
        textField1.setFont(new Font("Inter", Font.PLAIN, 28));
        textField2.setFont(new Font("Inter", Font.BOLD, 28));
        textField2.getDocument().addDocumentListener(new DocumentListener() {
            private boolean firstInput = true;

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

    private void textField2KeyReleased(KeyEvent e) {
        // TODO add your code here
//        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox2.getSelectedIndex()));
        solve(textField2, textField1, comboBox2, comboBox1);
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        whichFocus = false;
        textField1.setFont(new Font("Inter", Font.PLAIN, 28));
        textField2.setFont(new Font("Inter", Font.BOLD, 28));
        solve(textField2, textField1, comboBox2, comboBox1);
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        whichFocus = true;
        textField1.setFont(new Font("Inter", Font.BOLD, 28));
        textField2.setFont(new Font("Inter", Font.PLAIN, 28));
        solve(textField1, textField2, comboBox1, comboBox2);
    }

    private void textField2KeyPressed(KeyEvent e) {
        // TODO add your code here
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
        button15 = new JButton();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();

        //======== this ========
        setFont(new Font("Inter", Font.BOLD, 16));
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
        textField1.setBorder(null);
        textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getStyle() | Font.BOLD, textField1.getFont().getSize() + 15f));
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
            public void keyPressed(KeyEvent e) {
                textField1KeyPressed(e);
            }
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
        textField2.setBorder(null);
        textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getStyle() & ~Font.BOLD, textField2.getFont().getSize() + 15f));
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
            public void keyPressed(KeyEvent e) {
                textField2KeyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                textField2KeyReleased(e);
            }
        });
        add(textField2);
        textField2.setBounds(10, 180, 380, 50);

        //---- button1 ----
        button1.setText("CE");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 6f));
        add(button1);
        button1.setBounds(140, 285, 120, 50);

        //---- button6 ----
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
        button6.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        add(button6);
        button6.setBounds(270, 285, 120, 50);

        //---- button3 ----
        button3.setText("7");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 6f));
        add(button3);
        button3.setBounds(10, 340, 120, 50);

        //---- button4 ----
        button4.setText("8");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getStyle() | Font.BOLD, button4.getFont().getSize() + 6f));
        add(button4);
        button4.setBounds(140, 340, 120, 50);

        //---- button7 ----
        button7.setText("9");
        button7.setFont(button7.getFont().deriveFont(button7.getFont().getStyle() | Font.BOLD, button7.getFont().getSize() + 6f));
        add(button7);
        button7.setBounds(270, 340, 120, 50);

        //---- button5 ----
        button5.setText("4");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getStyle() | Font.BOLD, button5.getFont().getSize() + 6f));
        add(button5);
        button5.setBounds(10, 395, 120, 50);

        //---- button8 ----
        button8.setText("5");
        button8.setFont(button8.getFont().deriveFont(button8.getFont().getStyle() | Font.BOLD, button8.getFont().getSize() + 6f));
        add(button8);
        button8.setBounds(140, 395, 120, 50);

        //---- button9 ----
        button9.setText("6");
        button9.setFont(button9.getFont().deriveFont(button9.getFont().getStyle() | Font.BOLD, button9.getFont().getSize() + 6f));
        add(button9);
        button9.setBounds(270, 395, 120, 50);

        //---- button10 ----
        button10.setText("1");
        button10.setFont(button10.getFont().deriveFont(button10.getFont().getStyle() | Font.BOLD, button10.getFont().getSize() + 6f));
        add(button10);
        button10.setBounds(10, 450, 120, 50);

        //---- button11 ----
        button11.setText("2");
        button11.setFont(button11.getFont().deriveFont(button11.getFont().getStyle() | Font.BOLD, button11.getFont().getSize() + 6f));
        add(button11);
        button11.setBounds(140, 450, 120, 50);

        //---- button12 ----
        button12.setText("3");
        button12.setFont(button12.getFont().deriveFont(button12.getFont().getStyle() | Font.BOLD, button12.getFont().getSize() + 6f));
        add(button12);
        button12.setBounds(270, 450, 120, 50);

        //---- button13 ----
        button13.setText("+/-");
        button13.setFont(button13.getFont().deriveFont(button13.getFont().getStyle() | Font.BOLD, button13.getFont().getSize() + 6f));
        add(button13);
        button13.setBounds(10, 505, 120, 50);

        //---- button14 ----
        button14.setText("0");
        button14.setFont(button14.getFont().deriveFont(button14.getFont().getStyle() | Font.BOLD, button14.getFont().getSize() + 6f));
        add(button14);
        button14.setBounds(140, 505, 120, 50);

        //---- button15 ----
        button15.setText(".");
        button15.setFont(button15.getFont().deriveFont(button15.getFont().getStyle() | Font.BOLD, button15.getFont().getSize() + 6f));
        add(button15);
        button15.setBounds(270, 505, 120, 50);

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
        comboBox1.setBounds(15, 130, 105, 40);

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
        comboBox2.setBounds(15, 240, 105, 40);

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
    private JButton button15;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
