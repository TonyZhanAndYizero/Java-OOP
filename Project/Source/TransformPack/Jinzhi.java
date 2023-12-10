package Source.TransformPack;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.AbstractDocument;

import net.miginfocom.swing.*;

public class Jinzhi extends JPanel{
    private String inputString = "0";
    private String outputString = "0";
    public Jinzhi() {
        try {
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        }catch (Exception ignored){
        }
        initComponents();
    }

    private String JinzhiSwitch(String nums, int op1, int op2){
        String stringInop2 = "";
        BigDecimal numIn10 = new BigDecimal(0);
        BigDecimal op1BigDecimal = new BigDecimal(op1);
        BigDecimal op2BigDecimal = new BigDecimal(op2);
        for (int i = 0; i < nums.length(); i++) {
            char c = nums.charAt(i);
            numIn10 = numIn10.multiply(op1BigDecimal).add(new BigDecimal(c - '0'));
        }

        while(numIn10.compareTo(BigDecimal.ZERO) > 0){
            stringInop2 += (char)('0' + numIn10.remainder(op2BigDecimal).intValue());
            numIn10 = numIn10.divide(op2BigDecimal);
        }
        StringBuilder stringBuilder = new StringBuilder(stringInop2);
        stringBuilder.reverse();
        String reversedString = stringBuilder.toString();
        return reversedString;
    }

    private void solve(){
        //inputString = textField1.getText();

        int p1 = comboBox1.getSelectedIndex();
        int p2 = comboBox2.getSelectedIndex();

        String res = null;
        switch (p1)
        {
            case 0:
                switch (p2){
                    case 0 -> {
                        res = inputString;
                    }
                    case 1 -> {
                        res = JinzhiSwitch(inputString, 10, 8);
                    }
                    case 2 -> {
                        res = JinzhiSwitch(inputString, 10, 16);
                    }
                }
                break;
            case 1:
                switch (p2){
                    case 0 -> {
                        res = JinzhiSwitch(inputString, 8, 10);
                    }
                    case 1 -> {
                        res = inputString;
                    }
                    case 2 -> {
                        res = JinzhiSwitch(inputString, 8, 16);
                    }
                }
                break;
            case 2:
                switch (p2){
                    case 0 -> {
                        res = JinzhiSwitch(inputString, 16, 10);
                    }
                    case 1 -> {
                        res = JinzhiSwitch(inputString, 16, 8);
                    }
                    case 2 -> {
                        res = inputString;
                    }
                }
                break;
        }
        textField2.setText(res);
    }

    private void textField1CaretUpdate(CaretEvent e) {
        // TODO add your code here
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(new Angle.RestrictedDocumentFilter());
    }

    private void textField1FocusGained(FocusEvent e) {
        // TODO add your code here
        //solve();
        inputString = textField1.getText();
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
                        str1 = str1.replaceAll(inputString, "");
                        textField1.setText(str1);
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
        solve();
    }

    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
        //solve();
    }

    private void textField2CaretUpdate(CaretEvent e) {
        // TODO add your code here
        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new Angle.RestrictedDocumentFilter());
    }

    private void textField2FocusGained(FocusEvent e) {
        // TODO add your code here
        //solve();
        String str = textField2.getText();
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

    private void textField2KeyReleased(KeyEvent e) {
        // TODO add your code here
        solve();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        solve();
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        solve();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        this2 = new JPanel();
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
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== this2 ========
        {
            this2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            this2.setMinimumSize(new Dimension(398, 564));
            this2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            this2.setLayout(null);

            //---- 角度 ----
            角度.setText("\u8fdb\u5236");
            角度.setFont(角度.getFont().deriveFont(角度.getFont().getStyle() | Font.BOLD, 角度.getFont().getSize() + 10f));
            this2.add(角度);
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
            this2.add(textField1);
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
            this2.add(textField2);
            textField2.setBounds(10, 180, 380, 50);

            //---- button1 ----
            button1.setText("CE");
            button1.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button1);
            button1.setBounds(140, 285, 120, 50);

            //---- button6 ----
            button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
            button6.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
            this2.add(button6);
            button6.setBounds(270, 285, 120, 50);

            //---- button3 ----
            button3.setText("7");
            button3.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button3);
            button3.setBounds(10, 340, 120, 50);

            //---- button4 ----
            button4.setText("8");
            button4.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button4);
            button4.setBounds(140, 340, 120, 50);

            //---- button7 ----
            button7.setText("9");
            button7.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button7);
            button7.setBounds(270, 340, 120, 50);

            //---- button5 ----
            button5.setText("4");
            button5.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button5);
            button5.setBounds(10, 395, 120, 50);

            //---- button8 ----
            button8.setText("5");
            button8.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button8);
            button8.setBounds(140, 395, 120, 50);

            //---- button9 ----
            button9.setText("6");
            button9.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button9);
            button9.setBounds(270, 395, 120, 50);

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5341\u8fdb\u5236",
                "\u516b\u8fdb\u5236",
                "\u5341\u516d\u8fdb\u5236"
            }));
            comboBox1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            comboBox1.setFocusable(false);
            comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
            add(comboBox1);
            comboBox1.setBounds(15, 130, 105, 40);

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5341\u8fdb\u5236",
                "\u516b\u8fdb\u5236",
                "\u5341\u516d\u8fdb\u5236"
            }));
            comboBox2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
            add(comboBox2);
            comboBox2.setBounds(15, 240, 105, 40);
            this2.add(scrollPane1);
            scrollPane1.setBounds(new Rectangle(new Point(260, 180), scrollPane1.getPreferredSize()));

            //---- button17 ----
            button17.setText("1");
            button17.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button17);
            button17.setBounds(10, 450, 120, 50);

            //---- button18 ----
            button18.setText("2");
            button18.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button18);
            button18.setBounds(140, 450, 120, 50);

            //---- button19 ----
            button19.setText("3");
            button19.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button19);
            button19.setBounds(270, 450, 120, 50);

            //---- button20 ----
            button20.setText(".");
            button20.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button20);
            button20.setBounds(270, 505, 120, 50);

            //---- button13 ----
            button13.setText("+/-");
            button13.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button13);
            button13.setBounds(10, 505, 120, 50);

            //---- button21 ----
            button21.setText("0");
            button21.setFont(new Font("Consolas", Font.PLAIN, 18));
            this2.add(button21);
            button21.setBounds(140, 505, 120, 50);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < this2.getComponentCount(); i++) {
                    Rectangle bounds = this2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2.setMinimumSize(preferredSize);
                this2.setPreferredSize(preferredSize);
            }
        }
        add(this2, "cell 0 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel this2;
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
