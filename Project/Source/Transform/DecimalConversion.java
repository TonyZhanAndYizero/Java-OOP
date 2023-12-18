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
    private String JinzhiSwitch(String nums, int op1, int op2) {
        try {
            if(!nums.isEmpty())
            {
                if(nums.charAt(0) == '-' && op2 != 10)
                {
                    String newNums = new BigInteger(nums.substring(1), op1).toString(2);
                    StringBuilder res = new StringBuilder("1");
                    for(char i : newNums.toCharArray())
                    {
                        if(i == '1')
                            res.append('0');
                        else
                            res.append('1');
                    }
                    return new BigInteger(res.toString(), 2).add(BigInteger.ONE).toString(op2);
                }
                else
                    return new BigInteger(nums, op1).toString(op2);
            }
            return null;
        }catch (Exception e)
        {
            return null;
        }
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
                        res = JinzhiSwitch(inputString, 2, 2);
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
                        res = JinzhiSwitch(inputString, 8, 8);
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
                        res = JinzhiSwitch(inputString, 10, 10);
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
                        res = JinzhiSwitch(inputString, 16, 16);
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
            if(input == null || input.isEmpty())
                return null;
            switch (op)
            {
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
    private void textField1CaretUpdate(CaretEvent e) {
        // TODO add your code here
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new RestrictedDocumentFilter(comboBox1.getSelectedIndex()));
    }

    private void textField1FocusGained(FocusEvent e) {
        // TODO add your code here
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
                        }catch (Exception ignored)
                        {
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
                        }catch (Exception ignored)
                        {
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

    private void buttonCE(ActionEvent e) {
        // TODO add your code here
        textField1.setText("");
        textField2.setText("");
    }

    private void buttonBack(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            String text = textField1.getText();
            if(!text.isEmpty())
            {
                textField1.setText(text.substring(0, text.length() - 1));
                solve(textField1, textField2, comboBox1, comboBox2);
            }
        }
        else
        {
            String text = textField2.getText();
            if(!text.isEmpty())
            {
                textField2.setText(text.substring(0, text.length() - 1));
                solve(textField2, textField1, comboBox2, comboBox1);
            }
        }
    }

    private void button0(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "0");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "0");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "1");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "1");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "2");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "2");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "3");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "3");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "4");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "4");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "5");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "5");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "6");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "6");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "7");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "7");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "8");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "8");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void button9(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "9");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "9");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void buttonA(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "a");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "a");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void buttonB(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "b");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "b");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void buttonC(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "c");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "c");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void buttonD(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "d");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "d");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void buttonE(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            textField1.setText(textField1.getText() + "e");
            solve(textField1, textField2, comboBox1, comboBox2);
        }
        else {
            textField2.setText(textField2.getText() + "e");
            solve(textField2, textField1, comboBox2, comboBox1);
        }
    }

    private void buttonAnti(ActionEvent e) {
        // TODO add your code here
        if(whichFocus)
        {
            if(!textField1.getText().isEmpty() && textField1.getText().charAt(0) != '-')
            {
                textField1.setText("-" + textField1.getText());
                solve(textField1, textField2, comboBox1, comboBox2);
            }
            else if(!textField1.getText().isEmpty())
            {
                textField1.setText(textField1.getText().substring(1));
                solve(textField1, textField2, comboBox1, comboBox2);
            }
        }
        else {
            if(!textField2.getText().isEmpty() && textField2.getText().charAt(0) != '-')
            {
                textField2.setText("-" + textField2.getText());
                solve(textField2, textField1, comboBox2, comboBox1);
            }
            else if(!textField2.getText().isEmpty())
            {
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
        button15 = new JButton();
        button2 = new JButton();
        button16 = new JButton();
        button17 = new JButton();
        button18 = new JButton();
        button19 = new JButton();

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
        button1.setFont(new Font("Consolas", Font.PLAIN, 18));
        button1.setFocusable(false);
        button1.addActionListener(e -> buttonCE(e));
        add(button1);
        button1.setBounds(190, 285, 90, 50);

        //---- button6 ----
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
        button6.setSelectedIcon(new ImageIcon(getClass().getResource("/Resources/img/Backspace(1)(1).png")));
        button6.setIcon(new ImageIcon(getClass().getResource("/Resources/img/Backspace(1)(1).png")));
        button6.setFocusable(false);
        button6.addActionListener(e -> buttonBack(e));
        add(button6);
        button6.setBounds(280, 285, 90, 50);

        //---- button3 ----
        button3.setText("7");
        button3.setFont(new Font("Consolas", Font.PLAIN, 18));
        button3.setFocusable(false);
        button3.addActionListener(e -> button7(e));
        add(button3);
        button3.setBounds(100, 340, 90, 50);

        //---- button4 ----
        button4.setText("8");
        button4.setFont(new Font("Consolas", Font.PLAIN, 18));
        button4.setFocusable(false);
        button4.addActionListener(e -> button8(e));
        add(button4);
        button4.setBounds(190, 340, 90, 50);

        //---- button7 ----
        button7.setText("9");
        button7.setFont(new Font("Consolas", Font.PLAIN, 18));
        button7.setFocusable(false);
        button7.addActionListener(e -> button9(e));
        add(button7);
        button7.setBounds(280, 340, 90, 50);

        //---- button5 ----
        button5.setText("4");
        button5.setFont(new Font("Consolas", Font.PLAIN, 18));
        button5.setFocusable(false);
        button5.addActionListener(e -> button4(e));
        add(button5);
        button5.setBounds(100, 395, 90, 50);

        //---- button8 ----
        button8.setText("5");
        button8.setFont(new Font("Consolas", Font.PLAIN, 18));
        button8.setFocusable(false);
        button8.addActionListener(e -> button5(e));
        add(button8);
        button8.setBounds(190, 395, 90, 50);

        //---- button9 ----
        button9.setText("6");
        button9.setFont(new Font("Consolas", Font.PLAIN, 18));
        button9.setFocusable(false);
        button9.addActionListener(e -> button6(e));
        add(button9);
        button9.setBounds(280, 395, 90, 50);

        //---- button10 ----
        button10.setText("1");
        button10.setFont(new Font("Consolas", Font.PLAIN, 18));
        button10.setFocusable(false);
        button10.addActionListener(e -> button1(e));
        add(button10);
        button10.setBounds(100, 450, 90, 50);

        //---- button11 ----
        button11.setText("2");
        button11.setFont(new Font("Consolas", Font.PLAIN, 18));
        button11.setFocusable(false);
        button11.addActionListener(e -> button2(e));
        add(button11);
        button11.setBounds(190, 450, 90, 50);

        //---- button12 ----
        button12.setText("3");
        button12.setFont(new Font("Consolas", Font.PLAIN, 18));
        button12.setFocusable(false);
        button12.addActionListener(e -> button3(e));
        add(button12);
        button12.setBounds(280, 450, 90, 50);

        //---- button13 ----
        button13.setText("+/-");
        button13.setFont(new Font("Consolas", Font.PLAIN, 18));
        button13.setFocusable(false);
        button13.addActionListener(e -> buttonAnti(e));
        add(button13);
        button13.setBounds(100, 505, 90, 50);

        //---- button14 ----
        button14.setText("0");
        button14.setFont(new Font("Consolas", Font.PLAIN, 18));
        button14.setFocusable(false);
        button14.addActionListener(e -> button0(e));
        add(button14);
        button14.setBounds(190, 505, 90, 50);

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

        //---- button15 ----
        button15.setText(".");
        button15.setFont(new Font("Consolas", Font.PLAIN, 18));
        button15.setBackground(new Color(0x999999));
        button15.setFocusable(false);
        add(button15);
        button15.setBounds(280, 505, 90, 50);

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

        setPreferredSize(new Dimension(380, 570));
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
    private JButton button15;
    private JButton button2;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
