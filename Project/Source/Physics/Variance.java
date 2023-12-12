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

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //---- textField1 ----
        textField1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField1.setFont(new Font("Consolas", Font.PLAIN, 14));
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
        label2.setBounds(95, 140, 140, 120);

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/Resources/img/var.png")));
        add(label3);
        label3.setBounds(95, 265, 225, 120);

        //---- label4 ----
        label4.setIcon(new ImageIcon(getClass().getResource("/Resources/img/sqrtVar.png")));
        add(label4);
        label4.setBounds(95, 390, 225, 120);

        //---- label5 ----
        label5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label5);
        label5.setBounds(230, 195, 315, 45);

        //---- label6 ----
        label6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label6);
        label6.setBounds(310, 320, 235, 45);

        //---- label7 ----
        label7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        add(label7);
        label7.setBounds(320, 450, 225, 45);

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

        setPreferredSize(new Dimension(655, 595));
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
