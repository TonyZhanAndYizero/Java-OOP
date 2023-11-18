import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Sat Nov 18 15:30:39 CST 2023
 */


/**
 * @author tonyzhan0514
 */
public class Calculator extends JFrame {
    public Calculator() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button0 = new JButton();
        button_dot = new JButton();
        button_polar = new JButton();
        button_upsidedown = new JButton();
        button_pow2 = new JButton();
        button_sqrt = new JButton();
        button_equal = new JButton();
        button_plus = new JButton();
        button_minus = new JButton();
        button_mul = new JButton();
        button_div = new JButton();
        button_percent = new JButton();
        button_cleanEntry = new JButton();
        button_clear = new JButton();
        button_smoke = new JButton();
        button_David = new JButton();
        button_backspace = new JButton();

        //======== this ========
        setTitle("Calculator");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.setAlignmentY(0.4736842F);
            menuBar1.setBorderPainted(false);
            menuBar1.setAutoscrolls(true);

            //======== menu2 ========
            {
                menu2.setText("\u7c7b\u578b");
                menu2.setFont(new Font("\u5b8b\u4f53", menu2.getFont().getStyle() | Font.BOLD, 12));
                menu2.setBorderPainted(false);
                menu2.setAutoscrolls(true);
                menu2.setComponentPopupMenu(null);

                //---- menuItem3 ----
                menuItem3.setText("\u6807\u51c6");
                menuItem3.setFont(new Font("\u5b8b\u4f53", menuItem3.getFont().getStyle() | Font.BOLD, menuItem3.getFont().getSize()));
                menuItem3.setPreferredSize(new Dimension(73, 22));
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u79d1\u5b66");
                menuItem4.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");
                menu1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));

                //---- menuItem1 ----
                menuItem1.setText("\u6253\u5f00\u6587\u4ef6");
                menuItem1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u4fdd\u5b58\u6587\u4ef6");
                menuItem2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- textField1 ----
        textField1.setBorder(null);
        textField1.setHorizontalAlignment(SwingConstants.TRAILING);
        textField1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 28));
        contentPane.add(textField1);
        textField1.setBounds(40, 30, 460, 65);

        //---- button1 ----
        button1.setText("1");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.setFocusable(false);
        contentPane.add(button1);
        button1.setBounds(40, 280, 85, 40);

        //---- button2 ----
        button2.setText("2");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.setFocusable(false);
        contentPane.add(button2);
        button2.setBounds(130, 280, 85, 40);

        //---- button3 ----
        button3.setText("3");
        button3.setFont(new Font("Consolas", Font.PLAIN, 16));
        button3.setFocusable(false);
        contentPane.add(button3);
        button3.setBounds(220, 280, 85, 40);

        //---- button4 ----
        button4.setText("4");
        button4.setFont(new Font("Consolas", Font.PLAIN, 16));
        button4.setFocusable(false);
        contentPane.add(button4);
        button4.setBounds(40, 235, 85, 40);

        //---- button5 ----
        button5.setText("5");
        button5.setFont(new Font("Consolas", Font.PLAIN, 16));
        button5.setFocusable(false);
        contentPane.add(button5);
        button5.setBounds(130, 235, 85, 40);

        //---- button6 ----
        button6.setText("6");
        button6.setFont(new Font("Consolas", Font.PLAIN, 16));
        button6.setFocusable(false);
        contentPane.add(button6);
        button6.setBounds(220, 235, 85, 40);

        //---- button7 ----
        button7.setText("7");
        button7.setFont(new Font("Consolas", Font.PLAIN, 16));
        button7.setFocusable(false);
        contentPane.add(button7);
        button7.setBounds(40, 190, 85, 40);

        //---- button8 ----
        button8.setText("8");
        button8.setFont(new Font("Consolas", Font.PLAIN, 16));
        button8.setFocusable(false);
        contentPane.add(button8);
        button8.setBounds(130, 190, 85, 40);

        //---- button9 ----
        button9.setText("9");
        button9.setFont(new Font("Consolas", Font.PLAIN, 16));
        button9.setFocusable(false);
        contentPane.add(button9);
        button9.setBounds(220, 190, 85, 40);

        //---- button0 ----
        button0.setText("0");
        button0.setFont(new Font("Consolas", Font.PLAIN, 16));
        button0.setFocusable(false);
        contentPane.add(button0);
        button0.setBounds(130, 325, 85, 40);

        //---- button_dot ----
        button_dot.setText(".");
        button_dot.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_dot.setFocusable(false);
        contentPane.add(button_dot);
        button_dot.setBounds(220, 325, 85, 40);

        //---- button_polar ----
        button_polar.setText("+/-");
        button_polar.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_polar.setFocusable(false);
        contentPane.add(button_polar);
        button_polar.setBounds(40, 325, 85, 40);

        //---- button_upsidedown ----
        button_upsidedown.setText("1/x");
        button_upsidedown.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_upsidedown.setFocusable(false);
        contentPane.add(button_upsidedown);
        button_upsidedown.setBounds(40, 145, 85, 40);

        //---- button_pow2 ----
        button_pow2.setText("x^2");
        button_pow2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_pow2.setFocusable(false);
        contentPane.add(button_pow2);
        button_pow2.setBounds(130, 145, 85, 40);

        //---- button_sqrt ----
        button_sqrt.setText("\u221ax");
        button_sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_sqrt.setFocusable(false);
        contentPane.add(button_sqrt);
        button_sqrt.setBounds(220, 145, 85, 40);

        //---- button_equal ----
        button_equal.setText("=");
        button_equal.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_equal.setFocusable(false);
        contentPane.add(button_equal);
        button_equal.setBounds(310, 325, 85, 40);

        //---- button_plus ----
        button_plus.setText("+");
        button_plus.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_plus.setFocusable(false);
        contentPane.add(button_plus);
        button_plus.setBounds(310, 280, 85, 40);

        //---- button_minus ----
        button_minus.setText("-");
        button_minus.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_minus.setFocusable(false);
        contentPane.add(button_minus);
        button_minus.setBounds(310, 235, 85, 40);

        //---- button_mul ----
        button_mul.setText("\u00d7");
        button_mul.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_mul.setFocusable(false);
        contentPane.add(button_mul);
        button_mul.setBounds(310, 190, 85, 40);

        //---- button_div ----
        button_div.setText("\u00f7");
        button_div.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_div.setFocusable(false);
        contentPane.add(button_div);
        button_div.setBounds(310, 145, 85, 40);

        //---- button_percent ----
        button_percent.setText("%");
        button_percent.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_percent.setFocusable(false);
        contentPane.add(button_percent);
        button_percent.setBounds(40, 100, 85, 40);

        //---- button_cleanEntry ----
        button_cleanEntry.setText("CE");
        button_cleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_cleanEntry.setFocusable(false);
        contentPane.add(button_cleanEntry);
        button_cleanEntry.setBounds(130, 100, 85, 40);

        //---- button_clear ----
        button_clear.setText("C");
        button_clear.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_clear.setFocusable(false);
        button_clear.setAlignmentY(0.0F);
        contentPane.add(button_clear);
        button_clear.setBounds(220, 100, 85, 40);

        //---- button_smoke ----
        button_smoke.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_smoke.setIcon(new ImageIcon(getClass().getResource("/smoke.png")));
        button_smoke.setFocusable(false);
        contentPane.add(button_smoke);
        button_smoke.setBounds(400, 235, 100, 130);

        //---- button_David ----
        button_David.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_David.setIcon(new ImageIcon(getClass().getResource("/David.png")));
        button_David.setFocusable(false);
        contentPane.add(button_David);
        button_David.setBounds(400, 100, 100, 130);

        //---- button_backspace ----
        button_backspace.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_backspace.setIcon(new ImageIcon(getClass().getResource("/Backspace(1)(1).png")));
        button_backspace.setFocusable(false);
        contentPane.add(button_backspace);
        button_backspace.setBounds(310, 100, 85, 40);

        contentPane.setPreferredSize(new Dimension(545, 440));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton button_dot;
    private JButton button_polar;
    private JButton button_upsidedown;
    private JButton button_pow2;
    private JButton button_sqrt;
    private JButton button_equal;
    private JButton button_plus;
    private JButton button_minus;
    private JButton button_mul;
    private JButton button_div;
    private JButton button_percent;
    private JButton button_cleanEntry;
    private JButton button_clear;
    private JButton button_smoke;
    private JButton button_David;
    private JButton button_backspace;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
}
