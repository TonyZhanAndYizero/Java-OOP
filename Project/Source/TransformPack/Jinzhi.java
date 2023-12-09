package Source.TransformPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

public class Jinzhi extends JPanel{
    public Jinzhi() {
        try {
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        }catch (Exception ignored){
        }
        initComponents();
    }

    private void textField1CaretUpdate(CaretEvent e) {
        // TODO add your code here
    }

    private void textField1FocusGained(FocusEvent e) {
        // TODO add your code here
    }

    private void textField1KeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void textField2CaretUpdate(CaretEvent e) {
        // TODO add your code here
    }

    private void textField2FocusGained(FocusEvent e) {
        // TODO add your code here
    }

    private void textField2KeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        this2 = new JPanel();
        进制 = new JLabel();
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

            //---- 进制 ----
            进制.setText("\u8fdb\u5236");
            进制.setFont(进制.getFont().deriveFont(进制.getFont().getStyle() | Font.BOLD, 进制.getFont().getSize() + 10f));
            this2.add(进制);
            进制.setBounds(new Rectangle(new Point(15, 25), 进制.getPreferredSize()));

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
                "    \u5ea6",
                "  \u5f27\u5ea6",
                "\u767e\u5206\u5ea6"
            }));
            comboBox1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            comboBox1.setFocusable(false);
            comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
            this2.add(comboBox1);
            comboBox1.setBounds(15, 130, 105, 40);

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "    \u5ea6",
                "  \u5f27\u5ea6",
                "\u767e\u5206\u5ea6"
            }));
            comboBox2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
            this2.add(comboBox2);
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
    private JLabel 进制;
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
