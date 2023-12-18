package Source.Transform;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import ch.obermuhlner.math.big.BigDecimalMath;
import com.intellij.uiDesigner.core.*;

/*
 * Created by JFormDesigner on Sat Nov 25 15:58:14 CST 2023
 */



/**
 * @author HeMercy
 */
public class Angle extends JPanel {
    Boolean whichFocus = true;
    public Angle() {
        initComponents();
    }
    private void exchange(JTextField textField1, JTextField textField2, JComboBox<String> comboBox1, JComboBox<String> comboBox2)
    {
        int p1 = comboBox1.getSelectedIndex();
        int p2 = comboBox2.getSelectedIndex();
        String text;
        BigDecimal bg1 = new BigDecimal(textField1.getText());
        BigDecimal res = null;
        switch (p1)
        {
            case 0:
                switch (p2){
                    case 0 -> {
                        res = bg1;
                    }
                    case 1 -> {
                        res = bg1.multiply(new BigDecimal(Math.PI)).divide(new BigDecimal(180), 7, RoundingMode.HALF_UP);
                    }
                    case 2 -> {
                        res = bg1.divide(new BigDecimal(0.9), 7, RoundingMode.HALF_UP);
                    }
                }
                break;
            case 1:
                switch (p2){
                    case 0 -> {
                        res = bg1.multiply(new BigDecimal(180)).divide(new BigDecimal(Math.PI), 7, RoundingMode.HALF_UP);
                    }
                    case 1 -> {
                        res = bg1;
                    }
                    case 2 -> {
                        res = bg1.multiply(new BigDecimal(200)).divide(new BigDecimal(Math.PI), 7, RoundingMode.HALF_UP);
                    }
                }
                break;
            case 2:
                switch (p2){
                    case 0 -> {
                        res = bg1.multiply(new BigDecimal(0.9), new MathContext(7, RoundingMode.HALF_UP));
                    }
                    case 1 -> {
                        res = bg1.multiply(new BigDecimal(Math.PI)).divide(new BigDecimal(200), 7, RoundingMode.HALF_UP);
                    }
                    case 2 -> {
                        res = bg1;
                    }
                }
                break;
        }
        textField2.setText(res.stripTrailingZeros().toPlainString());
    }
    private void textField1CaretUpdate(CaretEvent e) {
        // TODO add your code here
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new RestrictedDocumentFilter());
    }

    private void textField2CaretUpdate(CaretEvent e) {
        // TODO add your code here
        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new RestrictedDocumentFilter());
    }

    private void textField1FocusGained(FocusEvent e) {
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
                        textField1.setText(str1.substring(str.length()));
                        // 清空原始文本
                    });
                    firstInput = false;
                }
                // 可以在这里处理用户输入后的逻辑
            }
        });
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
                        textField2.setText(str1.substring(str.length()));
                        // 清空原始文本
                    });
                    firstInput = false;
                }
                // 可以在这里处理用户输入后的逻辑
            }
        });
    }

    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
//        exchange(textField1, textField2);
    }

    private void textField1KeyReleased(KeyEvent e) {
        // TODO add your code here
        exchange(textField1, textField2, comboBox1, comboBox2);
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if(whichFocus)
            exchange(textField1, textField2, comboBox1, comboBox2);
        else
            exchange(textField2, textField1, comboBox2, comboBox1);
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if(whichFocus)
            exchange(textField1, textField2, comboBox1, comboBox2);
        else
            exchange(textField2, textField1, comboBox2, comboBox1);
    }

    private void textField2KeyReleased(KeyEvent e) {
        // TODO add your code here
        exchange(textField2, textField1, comboBox2, comboBox1);
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
    }


    static class RestrictedDocumentFilter extends DocumentFilter {
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
            input.replaceAll("..", ".");
            if(input.charAt(0) == '.')
                input.replaceFirst(".", "");
            return input.replaceAll("[^0-9.]", "");
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        角度 = new JLabel();
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
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        button17 = new JButton();
        button18 = new JButton();
        button19 = new JButton();
        button20 = new JButton();
        button13 = new JButton();
        button21 = new JButton();

        //======== this ========
        setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
        setMinimumSize(new Dimension(450, 564));
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setLayout(null);

        //---- 角度 ----
        角度.setText("\u89d2\u5ea6");
        角度.setFont(角度.getFont().deriveFont(角度.getFont().getStyle() | Font.BOLD, 角度.getFont().getSize() + 10f));
        add(角度);
        角度.setBounds(new Rectangle(new Point(15, 25), 角度.getPreferredSize()));

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
        button1.setText("CE");
        button1.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button1);
        button1.setBounds(140, 285, 120, 50);

        //---- button6 ----
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
        button6.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        add(button6);
        button6.setBounds(270, 285, 120, 50);

        //---- button3 ----
        button3.setText("7");
        button3.setFont(new Font("Consolas", Font.PLAIN, 18));
        button3.addActionListener(e -> button7(e));
        add(button3);
        button3.setBounds(10, 340, 120, 50);

        //---- button4 ----
        button4.setText("8");
        button4.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button4);
        button4.setBounds(140, 340, 120, 50);

        //---- button7 ----
        button7.setText("9");
        button7.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button7);
        button7.setBounds(270, 340, 120, 50);

        //---- button5 ----
        button5.setText("4");
        button5.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button5);
        button5.setBounds(10, 395, 120, 50);

        //---- button8 ----
        button8.setText("5");
        button8.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button8);
        button8.setBounds(140, 395, 120, 50);

        //---- button9 ----
        button9.setText("6");
        button9.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button9);
        button9.setBounds(270, 395, 120, 50);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "    \u5ea6",
            "  \u5f27\u5ea6",
            "\u767e\u5206\u5ea6"
        }));
        comboBox1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        comboBox1.setFocusable(false);
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        add(comboBox1);
        comboBox1.setBounds(15, 130, 105, 40);

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "    \u5ea6",
            "  \u5f27\u5ea6",
            "\u767e\u5206\u5ea6"
        }));
        comboBox2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
        add(comboBox2);
        comboBox2.setBounds(15, 240, 105, 40);
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(260, 180), scrollPane1.getPreferredSize()));

        //---- button17 ----
        button17.setText("1");
        button17.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button17);
        button17.setBounds(10, 450, 120, 50);

        //---- button18 ----
        button18.setText("2");
        button18.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button18);
        button18.setBounds(140, 450, 120, 50);

        //---- button19 ----
        button19.setText("3");
        button19.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button19);
        button19.setBounds(270, 450, 120, 50);

        //---- button20 ----
        button20.setText(".");
        button20.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button20);
        button20.setBounds(270, 505, 120, 50);

        //---- button13 ----
        button13.setText("+/-");
        button13.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button13);
        button13.setBounds(10, 505, 120, 50);

        //---- button21 ----
        button21.setText("0");
        button21.setFont(new Font("Consolas", Font.PLAIN, 18));
        add(button21);
        button21.setBounds(140, 505, 120, 50);

        setPreferredSize(new Dimension(400, 570));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel 角度;
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
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JScrollPane scrollPane1;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JButton button13;
    private JButton button21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
