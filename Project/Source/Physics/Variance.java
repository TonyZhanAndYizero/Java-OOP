/*
 * Created by JFormDesigner on Tue Dec 12 10:46:37 CST 2023
 */

package Source.Physics;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author tonyzhan0514
 */
public class Variance extends JPanel {
    public Variance() {
        initComponents();
    }

    protected ArrayList<BigDecimal> Nums = new ArrayList<>();

    private void compute() {
        Nums.clear();
        String[] in = textField1.getText().strip().split("\\s+");
        if (in.length <= 1) {
            JOptionPane.showMessageDialog(null, "Input Wrong");
        } else {
            BigDecimal temp;
            for (String str : in) {
                try {
                    if (!str.isEmpty()) {
                        temp = new BigDecimal(str);
                        Nums.add(temp);
                    }
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Input Wrong");
                    return;
                }
            }
            BigDecimal ave = BigDecimal.ZERO;
            BigDecimal n = new BigDecimal(Nums.size());
            for (BigDecimal bd : Nums) {
                ave = ave.add(bd);
            }
            ave = ave.divide(n, 4, RoundingMode.HALF_UP);
            label5.setText(ave.toPlainString());

            BigDecimal var=BigDecimal.ZERO;
            for (BigDecimal bd:Nums) {
                var=var.add(bd.subtract(ave).pow(2));
            }
            var = var.divide(n.subtract(BigDecimal.ONE),4,RoundingMode.HALF_UP);
            label6.setText(var.toPlainString());

            BigDecimal sqrtVar=var.sqrt(MathContext.DECIMAL64);
            label7.setText(sqrtVar.toPlainString());

            BigDecimal ua=var.divide(n,4,RoundingMode.HALF_UP).sqrt(MathContext.DECIMAL64);
            label9.setText(ua.toPlainString());

            BigDecimal deltaB=new BigDecimal(textField2.getText());
            BigDecimal ub=deltaB.divide(new BigDecimal(3).sqrt(MathContext.DECIMAL64),4,RoundingMode.HALF_UP);
            label12.setText(ub.toPlainString());

            BigDecimal u=(ua.pow(2).add(ub.pow(2))).sqrt(MathContext.DECIMAL64);
            label14.setText(u.toPlainString());
        }
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            compute();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button1 = new JButton();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textField2 = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //---- textField1 ----
        textField1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(textField1);
        textField1.setBounds(95, 85, 450, 45);

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u5f85\u8ba1\u7b97\u6837\u672c\u6570\u7684\u5e8f\u5217(\u7528\u7a7a\u683c\u5206\u5f00):");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 4f));
        add(label1);
        label1.setBounds(165, 45, 320, 30);

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/Resources/img/ave.png")));
        add(label2);
        label2.setBounds(95, 130, 140, 110);

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/Resources/img/var.png")));
        add(label3);
        label3.setBounds(95, 240, 225, 105);

        //---- label4 ----
        label4.setIcon(new ImageIcon(getClass().getResource("/Resources/img/sqrtVar.png")));
        add(label4);
        label4.setBounds(95, 345, 225, 120);

        //---- label5 ----
        label5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label5);
        label5.setBounds(230, 185, 400, 45);

        //---- label6 ----
        label6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label6);
        label6.setBounds(310, 290, 320, 45);

        //---- label7 ----
        label7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label7);
        label7.setBounds(320, 405, 310, 45);

        //---- button1 ----
        button1.setText("\u8ba1\u7b97");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 4f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(560, 90, 70, 35);

        //---- label8 ----
        label8.setIcon(new ImageIcon(getClass().getResource("/Resources/img/ua.png")));
        add(label8);
        label8.setBounds(95, 465, 325, 120);

        //---- label9 ----
        label9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label9);
        label9.setBounds(420, 525, 210, 45);

        //---- label10 ----
        label10.setIcon(new ImageIcon(getClass().getResource("/Resources/img/ub.png")));
        add(label10);
        label10.setBounds(95, 585, 125, 80);

        //---- label11 ----
        label11.setIcon(new ImageIcon(getClass().getResource("/Resources/img/divSqrt3.png")));
        add(label11);
        label11.setBounds(220, 585, label11.getPreferredSize().width, 80);

        //---- textField2 ----
        textField2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(textField2);
        textField2.setBounds(225, 590, 40, 30);

        //---- label12 ----
        label12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label12);
        label12.setBounds(290, 600, 340, 45);

        //---- label13 ----
        label13.setIcon(new ImageIcon(getClass().getResource("/Resources/img/u.png")));
        add(label13);
        label13.setBounds(95, 665, 180, 80);

        //---- label14 ----
        label14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label14);
        label14.setBounds(275, 685, 355, 45);

        setPreferredSize(new Dimension(755, 765));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField2;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
