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

/*
 * Created by JFormDesigner on Sat Nov 25 15:58:14 CST 2023
 */


/**
 * @author HeMercy
 */
public class Angle extends JPanel {
    Boolean whichFocus = true;

    public Angle() {
        try {
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ignored) {
        }
        initComponents();
    }

    private boolean illegal = false;

    /**
     * Description: To realize the conversion of Angle, radian and percentile
     * @param textField1 The first text-field
     * @param textField2 The second text-field
     * @author HeMercy
     */
    private void exchange(JTextField textField1, JTextField textField2) {
        if (illegal) {
            illegal = false;
            textField1.setText("0");
            textField2.setText("0");
            return;
        }
        int p1 = comboBox1.getSelectedIndex();
        int p2 = comboBox2.getSelectedIndex();
        if (textField1.getText().isEmpty()) {
            textField1.setText("0");
            textField2.setText("0");
            return;
        }
        BigDecimal bg1;
        try {
            bg1 = new BigDecimal(textField1.getText());
        } catch (NumberFormatException nfe) {
            textField2.setText("illegal!");
            illegal = true;
            return;
        }
        BigDecimal res = null;
        switch (p1) {
            case 0:
                switch (p2) {
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
                switch (p2) {
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
                switch (p2) {
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

    /**
     * Description: Monitor the input of the first text-field
     * @param e CaretEvent
     * @author HeMercy
     */
    private void textField1CaretUpdate(CaretEvent e) {
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new RestrictedDocumentFilter());
    }
    /**
     * Description: Monitor the input of the second text-field
     * @param e CaretEvent
     * @author HeMercy
     */
    private void textField2CaretUpdate(CaretEvent e) {
        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new RestrictedDocumentFilter());
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
                        if (str1.length()>1&&str1.charAt(1) == '.') return;
                        try {
                            if (textField1.getText().charAt(0) == '0')
                                textField1.setText(str1.substring(1));
                        }// 清空原始文本
                        catch (Exception e) {
                            textField1.setText("0");
                        }
                    });
                    firstInput = false;
                }
                // 可以在这里处理用户输入后的逻辑
                if (textField1.getText().length() == 1 && textField1.getText().equals("0")) {
                    firstInput = true;
                }
            }
        });
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
                        if (str1.length()>1&&str1.charAt(1) == '.') return;
                        try {
                            if (textField2.getText().charAt(0) == '0')
                                textField2.setText(str1.substring(1));
                        }// 清空原始文本
                        catch (Exception e) {
                            textField2.setText("0");
                        }
                    });
                    firstInput = false;
                }
                if (textField2.getText().length() == 1 && textField2.getText().equals("0")) {
                    firstInput = true;
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
        exchange(textField1, textField2);
    }
    /**
     * Description: Monitor the changes of the item state of the first combo Box.
     * If it happens, update the contents of the other text-field in real time.
     * @param e ItemEvent
     * @author HeMercy
     */
    private void comboBox1ItemStateChanged(ItemEvent e) {
        if (whichFocus)
            exchange(textField1, textField2);
        else
            exchange(textField2, textField1);
    }
    /**
     * Description: Monitor the changes of the item state of the second combo Box.
     * If it happens, update the contents of the other text-field in real time.
     * @param e ItemEvent
     * @author HeMercy
     */
    private void comboBox2ItemStateChanged(ItemEvent e) {
        if (whichFocus)
            exchange(textField1, textField2);
        else
            exchange(textField2, textField1);
    }
    /**
     * Description: Monitor the keyboard input of the second text-field.
     * If it happens, update the contents of the other text-field in real time.
     * @param e KeyEvent
     * @author HeMercy
     */
    private void textField2KeyReleased(KeyEvent e) {
        exchange(textField2, textField1);
    }
    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: Monitor the button "1".
     * If it is pressed, enter "1" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button1MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
        }
    }
    /**
     * Description: Monitor the button "2".
     * If it is pressed, enter "2" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button2MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);
        }
    }
    /**
     * Description: Monitor the button "3".
     * If it is pressed, enter "3" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button3MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);
        }
    }
    /**
     * Description: Monitor the button "4".
     * If it is pressed, enter "4" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button4MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_4);
        }
    }
    /**
     * Description: Monitor the button "5".
     * If it is pressed, enter "5" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button5MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_5);
            robot.keyRelease(KeyEvent.VK_5);
        }
    }
    /**
     * Description: Monitor the button "6".
     * If it is pressed, enter "6" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button6MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_6);
        }
    }
    /**
     * Description: Monitor the button "7".
     * If it is pressed, enter "7" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button7MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_7);
            robot.keyRelease(KeyEvent.VK_7);
        }
    }
    /**
     * Description: Monitor the button "8".
     * If it is pressed, enter "8" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button8MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_8);
            robot.keyRelease(KeyEvent.VK_8);
        }
    }
    /**
     * Description: Monitor the button "9".
     * If it is pressed, enter "9" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button9MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_9);
        }
    }
    /**
     * Description: Monitor the button "0".
     * If it is pressed, enter "0" in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void button0MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_0);
        }
    }
    /**
     * Description: Monitor the button ".".
     * If it is pressed, enter "." in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void buttonDotMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);
        }
    }
    /**
     * Description: Monitor the button "backspace".
     * If it is pressed, delete the last character in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void buttonBackspaceMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }
    /**
     * Description: Monitor the button "CE".
     * If it is pressed, delete all the characters in the current text-field.
     * @param e MouseEvent
     * @author TonyZhanAndYizero
     */
    private void buttonClearMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

    /**
     * Description: Limit the content entered the text-field.
     * It can only be number or point.
     * And it can only have one point in the middle of the contents.
     * @author HeMercy
     */
    static class RestrictedDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            super.replace(fb, offset, length, text, attrs);
        }

        private String filter(String input) {
            // 此处可以根据需要定义文本框的输入限制
            // 这个例子中只允许输入数字
            input.replaceAll("..", ".");
            if (input.charAt(0) == '.')
                input.replaceFirst(".", "");
            return input.replaceAll("[^0-9.]", "");
        }
    }

    /**
     * Description: Initialize the Angle-class.
     * @author HeMercy
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        Angle = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        buttonClear = new JButton();
        buttonBackspace = new JButton();
        button0 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        buttonDot = new JButton();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
        setMinimumSize(new Dimension(450, 564));
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setLayout(null);

        //---- Angle ----
        Angle.setText("\u89d2\u5ea6");
        Angle.setFont(Angle.getFont().deriveFont(Angle.getFont().getStyle() | Font.BOLD, Angle.getFont().getSize() + 10f));
        add(Angle);
        Angle.setBounds(new Rectangle(new Point(15, 25), Angle.getPreferredSize()));

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

        //---- buttonClear ----
        buttonClear.setText("C");
        buttonClear.setFont(new Font("Consolas", Font.PLAIN, 18));
        buttonClear.setFocusable(false);
        buttonClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonClearMousePressed(e);
            }
        });
        add(buttonClear);
        buttonClear.setBounds(140, 285, 120, 50);

        //---- buttonBackspace ----
        buttonBackspace.setFont(buttonBackspace.getFont().deriveFont(buttonBackspace.getFont().getStyle() | Font.BOLD, buttonBackspace.getFont().getSize() + 6f));
        buttonBackspace.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        buttonBackspace.setFocusable(false);
        buttonBackspace.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonBackspaceMousePressed(e);
            }
        });
        add(buttonBackspace);
        buttonBackspace.setBounds(270, 285, 120, 50);

        //---- button0 ----
        button0.setText("0");
        button0.setFont(new Font("Consolas", Font.PLAIN, 18));
        button0.setFocusable(false);
        button0.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button0MousePressed(e);
            }
        });
        add(button0);
        button0.setBounds(140, 505, 120, 50);

        //---- button1 ----
        button1.setText("1");
        button1.setFont(new Font("Consolas", Font.PLAIN, 18));
        button1.setFocusable(false);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(10, 450, 120, 50);

        //---- button2 ----
        button2.setText("2");
        button2.setFont(new Font("Consolas", Font.PLAIN, 18));
        button2.setFocusable(false);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2);
        button2.setBounds(140, 450, 120, 50);

        //---- button3 ----
        button3.setText("3");
        button3.setFont(new Font("Consolas", Font.PLAIN, 18));
        button3.setFocusable(false);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        add(button3);
        button3.setBounds(270, 450, 120, 50);

        //---- button4 ----
        button4.setText("4");
        button4.setFont(new Font("Consolas", Font.PLAIN, 18));
        button4.setFocusable(false);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        add(button4);
        button4.setBounds(10, 395, 120, 50);

        //---- button5 ----
        button5.setText("5");
        button5.setFont(new Font("Consolas", Font.PLAIN, 18));
        button5.setFocusable(false);
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button5MousePressed(e);
            }
        });
        add(button5);
        button5.setBounds(140, 395, 120, 50);

        //---- button6 ----
        button6.setText("6");
        button6.setFont(new Font("Consolas", Font.PLAIN, 18));
        button6.setFocusable(false);
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button6MousePressed(e);
            }
        });
        add(button6);
        button6.setBounds(270, 395, 120, 50);

        //---- button7 ----
        button7.setText("7");
        button7.setFont(new Font("Consolas", Font.PLAIN, 18));
        button7.setFocusable(false);
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button7MousePressed(e);
            }
        });
        add(button7);
        button7.setBounds(10, 340, 120, 50);

        //---- button8 ----
        button8.setText("8");
        button8.setFont(new Font("Consolas", Font.PLAIN, 18));
        button8.setFocusable(false);
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button8MousePressed(e);
            }
        });
        add(button8);
        button8.setBounds(140, 340, 120, 50);

        //---- button9 ----
        button9.setText("9");
        button9.setFont(new Font("Consolas", Font.PLAIN, 18));
        button9.setFocusable(false);
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button9MousePressed(e);
            }
        });
        add(button9);
        button9.setBounds(270, 340, 120, 50);

        //---- buttonDot ----
        buttonDot.setText(".");
        buttonDot.setFont(new Font("Consolas", Font.PLAIN, 18));
        buttonDot.setFocusable(false);
        buttonDot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDotMousePressed(e);
            }
        });
        add(buttonDot);
        buttonDot.setBounds(270, 505, 120, 50);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "    \u5ea6",
            "  \u5f27\u5ea6",
            "\u767e\u5206\u5ea6"
        }));
        comboBox1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        comboBox1.setBorder(null);
        comboBox1.setFocusable(false);
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        add(comboBox1);
        comboBox1.setBounds(15, 130, 115, 40);

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "    \u5ea6",
            "  \u5f27\u5ea6",
            "\u767e\u5206\u5ea6"
        }));
        comboBox2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
        add(comboBox2);
        comboBox2.setBounds(15, 240, 115, 40);
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(260, 180), scrollPane1.getPreferredSize()));

        setPreferredSize(new Dimension(400, 570));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel Angle;
    private JTextField textField1;
    private JTextField textField2;
    private JButton buttonClear;
    private JButton buttonBackspace;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonDot;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
