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
            System.out.println(det);
            if (det != 0) {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    answer[i] = determinant(replaceColumn(coefficients, constants, i), n) / det;
                    System.out.println(answer[i]);

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
        //如果n为1，直接返回矩阵元素
        if (n == 1) {
            return matrix[0][0];
        }
        //如果n为2，返回二阶行列式的值
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        //如果n大于2，用拉普拉斯展开定理计算
        double sum = 0; //用于累加各项的值
        for (int i = 0; i < n; i++) {
            //计算代数余子式的符号
            int sign = (i % 2 == 0) ? 1 : -1;
            //计算代数余子式的值，即去掉第一行和第i+1列的n-1阶行列式的值
            double subDet = determinant(subMatrix(matrix, n, i), n - 1);
            System.out.println("good:" + subDet);
            //累加
            sum += sign * matrix[0][i] * subDet;
        }
        //返回结果
        return sum;
    }

    /**
     * to calculate the smaller matrix
     *
     * @return a double matrix
     * @author TonyZhan
     */
    public static double[][] subMatrix(double[][] matrix, int n, int j) {
        //创建一个n-1阶的二维数组
        double[][] sub = new double[n - 1][n - 1];
        //遍历原矩阵，跳过第一行和第j列，将元素复制到子矩阵中
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (k == j) {
                    continue; //跳过第j列
                }
                //计算子矩阵的行列下标
                int sub_i = i - 1;
                int sub_j = (k < j) ? k : k - 1;
                //复制元素
                sub[sub_i][sub_j] = matrix[i][k];
            }
        }
        System.out.println(Arrays.deepToString(sub));
        //返回子矩阵
        return sub;
    }

    /**
     * to calculate the line-changed matrix
     *
     * @return a double matrix
     * @author TonyZhan
     */
    public static double[][] replaceColumn(double[][] matrix, double[] constants, int j) {
        //创建一个新的矩阵，复制原矩阵的元素
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[0].length);
        }
        //将新矩阵的第j列替换为常数项向量
        for (int i = 0; i < constants.length; i++) {
            newMatrix[i][j] = constants[i];
        }
        //返回新矩阵
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
        // TODO add your code here
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
        // TODO add your code here
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

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            scrollPane1.setViewportView(textPane1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(85, 115, 200, 200);

        //======== scrollPane2 ========
        {

            //---- textPane2 ----
            textPane2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            scrollPane2.setViewportView(textPane2);
        }
        add(scrollPane2);
        scrollPane2.setBounds(340, 115, 50, 200);

        //---- label1 ----
        label1.setText("=");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(label1);
        label1.setBounds(305, 210, 20, 20);
        add(textField1);
        textField1.setBounds(185, 50, 40, 40);

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u9636\u6570:");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 4f));
        add(label2);
        label2.setBounds(85, 55, 100, 25);

        //---- label4 ----
        label4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "Status", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
            new Font("Consolas", Font.BOLD | Font.ITALIC, 12)));
        label4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        add(label4);
        label4.setBounds(335, 40, 100, 55);

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
        button1.setBounds(255, 50, 65, 35);

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
        button2.setBounds(415, 200, 65, 35);

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
        scrollPane3.setBounds(85, 330, 305, 65);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
