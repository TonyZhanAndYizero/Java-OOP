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
    private void exchange(JTextField textField1, JTextField textField2)
    {
        int p1 = comboBox1.getSelectedIndex();
        int p2 = comboBox2.getSelectedIndex();
        System.out.println(p1 + " " + p2);
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
                        str1 = str1.replaceAll(str, "");
                        textField1.setText(str1);
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
                        str1 = str1.replaceAll(str, "");
                        textField2.setText(str1);
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
        exchange(textField1, textField2);
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if(whichFocus)
            exchange(textField1, textField2);
        else
            exchange(textField2, textField1);
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if(whichFocus)
            exchange(textField1, textField2);
        else
            exchange(textField2, textField1);
    }

    private void textField2KeyReleased(KeyEvent e) {
        // TODO add your code here
        exchange(textField2, textField1);
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
        setMinimumSize(new Dimension(398, 564));
        setLayout(null);

        //---- 角度 ----
        角度.setText("\u89d2\u5ea6");
        角度.setFont(角度.getFont().deriveFont(角度.getFont().getStyle() | Font.BOLD, 角度.getFont().getSize() + 10f));
        add(角度);
        角度.setBounds(new Rectangle(new Point(15, 25), 角度.getPreferredSize()));

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
        textField1.setBounds(5, 70, 380, 50);

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
            public void keyReleased(KeyEvent e) {
                textField2KeyReleased(e);
            }
        });
        add(textField2);
        textField2.setBounds(5, 175, 380, 50);

        //---- button1 ----
        button1.setText("CE");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 6f));
        add(button1);
        button1.setBounds(133, 290, 132, 55);

        //---- button6 ----
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
        add(button6);
        button6.setBounds(266, 290, 132, 55);

        //---- button3 ----
        button3.setText("7");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 6f));
        add(button3);
        button3.setBounds(0, 345, 132, 55);

        //---- button4 ----
        button4.setText("8");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getStyle() | Font.BOLD, button4.getFont().getSize() + 6f));
        add(button4);
        button4.setBounds(133, 345, 132, 55);

        //---- button7 ----
        button7.setText("9");
        button7.setFont(button7.getFont().deriveFont(button7.getFont().getStyle() | Font.BOLD, button7.getFont().getSize() + 6f));
        add(button7);
        button7.setBounds(266, 345, 132, 55);

        //---- button5 ----
        button5.setText("4");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getStyle() | Font.BOLD, button5.getFont().getSize() + 6f));
        add(button5);
        button5.setBounds(0, 400, 132, 55);

        //---- button8 ----
        button8.setText("5");
        button8.setFont(button8.getFont().deriveFont(button8.getFont().getStyle() | Font.BOLD, button8.getFont().getSize() + 6f));
        add(button8);
        button8.setBounds(133, 400, 132, 55);

        //---- button9 ----
        button9.setText("6");
        button9.setFont(button9.getFont().deriveFont(button9.getFont().getStyle() | Font.BOLD, button9.getFont().getSize() + 6f));
        add(button9);
        button9.setBounds(266, 400, 132, 55);

        //---- button10 ----
        button10.setText("1");
        button10.setFont(button10.getFont().deriveFont(button10.getFont().getStyle() | Font.BOLD, button10.getFont().getSize() + 6f));
        add(button10);
        button10.setBounds(0, 455, 132, 55);

        //---- button11 ----
        button11.setText("2");
        button11.setFont(button11.getFont().deriveFont(button11.getFont().getStyle() | Font.BOLD, button11.getFont().getSize() + 6f));
        add(button11);
        button11.setBounds(133, 455, 132, 55);

        //---- button12 ----
        button12.setText("3");
        button12.setFont(button12.getFont().deriveFont(button12.getFont().getStyle() | Font.BOLD, button12.getFont().getSize() + 6f));
        add(button12);
        button12.setBounds(266, 455, 132, 55);

        //---- button13 ----
        button13.setText("+/_");
        button13.setFont(button13.getFont().deriveFont(button13.getFont().getStyle() | Font.BOLD, button13.getFont().getSize() + 6f));
        add(button13);
        button13.setBounds(0, 510, 132, 55);

        //---- button14 ----
        button14.setText("0");
        button14.setFont(button14.getFont().deriveFont(button14.getFont().getStyle() | Font.BOLD, button14.getFont().getSize() + 6f));
        add(button14);
        button14.setBounds(133, 510, 132, 55);

        //---- button15 ----
        button15.setText(".");
        button15.setFont(button15.getFont().deriveFont(button15.getFont().getStyle() | Font.BOLD, button15.getFont().getSize() + 6f));
        add(button15);
        button15.setBounds(266, 510, 132, 55);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "    \u5ea6",
            "  \u5f27\u5ea6",
            "\u767e\u5206\u5ea6"
        }));
        comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getStyle() | Font.BOLD, comboBox1.getFont().getSize() + 4f));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        add(comboBox1);
        comboBox1.setBounds(5, 130, 80, 40);

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "    \u5ea6",
            "  \u5f27\u5ea6",
            "\u767e\u5206\u5ea6"
        }));
        comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getStyle() | Font.BOLD, comboBox2.getFont().getSize() + 4f));
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
        add(comboBox2);
        comboBox2.setBounds(5, 235, 80, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
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
