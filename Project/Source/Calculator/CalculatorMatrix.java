/*
 * Created by JFormDesigner on Sat Dec 16 23:24:35 CST 2023
 */

package Source.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author tonyzhan0514
 */
public class CalculatorMatrix extends JPanel {
    public CalculatorMatrix() {
        initComponents();
    }

    boolean canCal = false;
    int n;
    double[][] coefficients;
    double[] constants;
    double[] answer;

    private void init(int n) {
        coefficients = new double[n][n];
        constants = new double[n];
        answer = new double[n];
    }

    /**
     * to calculate the matrix via Cramer's Rule
     *
     * @author TonyZhan
     */
    private void calculate() {
        if (canCal) {
            String[] rows = textPane1.getText().split("\n");

            for (int i = 0; i < n; i++) {
                String[] cols = rows[i].split("\\s+");
                for (int j = 0; j < n; j++) {
                    try {
                        coefficients[i][j] = Integer.parseInt(cols[j].strip());
                    } catch (NumberFormatException nfe) {
                        setWrong();
                        return;
                    }
                }
            }

            rows = textPane2.getText().split("\n");
            for (int i = 0; i < n; i++) {
                try {
                    constants[i] = Integer.parseInt(rows[i].strip());
                } catch (NumberFormatException nfe) {
                    setWrong();
                    return;
                }
            }

            double det = determinant(coefficients, n);
            label6.setText(String.format("%.3f",det));
            if (det != 0) {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    answer[i] = determinant(replaceColumn(coefficients, constants, i), n) / det;
                    ans.append(String.format("%.3f", answer[i])).append(" ");
                }
                label5.setText(ans.toString());
                setCorrect();
            } else {
                label5.setText("The system has no solution or infinitely many solutions.");
            }
        }
    }


    /**
     * to calculate the determinant of a matrix
     *
     * @return a double matrix
     * @author TonyZhan
     */
    public static double determinant(double[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        //Laplace
        double sum = 0;
        for (int i = 0; i < n; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            double subDet = determinant(subMatrix(matrix, n, i), n - 1);
            sum += sign * matrix[0][i] * subDet;
        }
        return sum;
    }

    /**
     * to calculate the smaller matrix
     *
     * @return a double matrix
     * @author TonyZhan
     */
    public static double[][] subMatrix(double[][] matrix, int n, int j) {
        double[][] sub = new double[n - 1][n - 1];
        //遍历原矩阵，跳过第一行和第j列，将元素复制到子矩阵中
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (k == j) {
                    continue; //跳过第j列
                }
                int sub_i = i - 1;
                int sub_j = (k < j) ? k : k - 1;
                sub[sub_i][sub_j] = matrix[i][k];
            }
        }
        return sub;
    }

    /**
     * to calculate the line-changed matrix
     *
     * @return a double matrix
     * @author TonyZhan
     */
    public static double[][] replaceColumn(double[][] matrix, double[] constants, int j) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[0].length);
        }
        for (int i = 0; i < constants.length; i++) {
            newMatrix[i][j] = constants[i];
        }
        return newMatrix;
    }

    /**
     * set state wrong
     *
     * @author TonyZhan
     */
    private void setWrong() {
        label4.setText("Wrong");
        label4.setForeground(Color.red);
        label4.setFont(new Font("Consolas", Font.BOLD, 16));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        canCal = false;
    }

    /**
     * set state correct
     *
     * @author TonyZhan
     */
    private void setCorrect() {
        label4.setText("Correct");
        label4.setForeground(new Color(0, 128, 0));
        label4.setFont(new Font("Consolas", Font.BOLD, 16));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        canCal = true;
    }

    private void button1MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            try {
                n = Integer.parseInt(textField1.getText().strip());
            } catch (NumberFormatException nfe) {
                setWrong();
                return;
            }
            setCorrect();
            init(n);
        }
    }

    private void button2MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            calculate();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        scrollPane2 = new JScrollPane();
        textPane2 = new JTextPane();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label4 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane3 = new JScrollPane();
        label5 = new JLabel();
        label3 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            scrollPane1.setViewportView(textPane1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(125, 135, 240, 240);

        //======== scrollPane2 ========
        {

            //---- textPane2 ----
            textPane2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            scrollPane2.setViewportView(textPane2);
        }
        add(scrollPane2);
        scrollPane2.setBounds(430, 135, 40, 240);

        //---- label1 ----
        label1.setText("=");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(label1);
        label1.setBounds(390, 245, 20, 20);

        //---- textField1 ----
        textField1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(textField1);
        textField1.setBounds(225, 70, 40, 40);

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u9636\u6570:");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 4f));
        add(label2);
        label2.setBounds(125, 75, 100, 25);

        //---- label4 ----
        label4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "Status", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
            new Font("Consolas", Font.BOLD | Font.ITALIC, 12)));
        label4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        add(label4);
        label4.setBounds(375, 60, 100, 55);

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(295, 70, 65, 35);

        //---- button2 ----
        button2.setText("\u8ba1\u7b97");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2);
        button2.setBounds(490, 240, 65, 35);

        //======== scrollPane3 ========
        {

            //---- label5 ----
            label5.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "Answer", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Consolas", Font.BOLD | Font.ITALIC, 12)));
            label5.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            scrollPane3.setViewportView(label5);
        }
        add(scrollPane3);
        scrollPane3.setBounds(125, 435, 350, 65);

        //---- label3 ----
        label3.setText("det = | A | =");
        label3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
        add(label3);
        label3.setBounds(125, 390, 135, 35);

        //---- label6 ----
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(label6);
        label6.setBounds(260, 390, 210, 35);

        setPreferredSize(new Dimension(675, 555));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JScrollPane scrollPane2;
    private JTextPane textPane2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label4;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane3;
    private JLabel label5;
    private JLabel label3;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
