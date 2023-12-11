/*
 * Created by JFormDesigner on Tue Dec 05 16:17:30 CST 2023
 */

package Source.Physics;

import org.matheclipse.core.builtin.functions.ZetaJS;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * a Linear Regression function
 *
 * @author TonyZhan
 */
public class LinearRegression extends JPanel {
    public LinearRegression() {
        try {
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ignored) {
        }
        initComponents();
    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            textField1.setText("");
        }
    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            textField2.setText("");
        }
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            textField3.setText("");
        }
    }

    private void button5MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        }
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            compute();
        }
    }

    protected ArrayList<BigDecimal> XNums = new ArrayList<>();
    protected ArrayList<BigDecimal> YNums = new ArrayList<>();
    protected int state = 1;

    /**
     * set state wrong
     *
     * @author TonyZhan
     */
    private void setWrong() {
        state = -1;
        label4.setText("Wrong");
        label4.setForeground(Color.red);
        label4.setFont(new Font("Consolas", Font.BOLD, 16));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setText("");
        label8.setText("");
        label10.setText("");
        label11.setText("");
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                        {"sum", null, null, null, null, null},
                        {"ave", null, null, null, null, null},
                },
                new String[]{
                        "index=i", "Xi=xi", "Xi^2=xi^2", "Yi=yi", "Yi^2=yi^2", "XiYi=xiyi"
                }
        ));
        data = null;
    }

    /**
     * set state warning(not the correct k or etc. but can still be computed)
     *
     * @author TonyZhan
     */
    private void setWarning() {
        state = 0;
        label4.setText("Warning");
        label4.setForeground(Color.yellow);
        label4.setFont(new Font("Consolas", Font.BOLD, 16));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * set state correct
     *
     * @author TonyZhan
     */
    private void setCorrect() {
        state = 1;
        label4.setText("Correct");
        label4.setForeground(new Color(0, 128, 0));
        label4.setFont(new Font("Consolas", Font.BOLD, 16));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
    }

    Object[][] data = null;
    String[] columnNames = {"index=i", "Xi=xi", "Xi^2=xi^2", "Yi=yi", "Yi^2=yi^2", "XiYi=xiyi"};

    BigDecimal b, a, r;

    /**
     * the compute process
     *
     * @author TonyZhan
     */
    private void compute() {
        XNums.clear();
        YNums.clear();

        state = 1;
        String[] K = textField1.getText().strip().split("\\s+");
        String[] X = textField2.getText().strip().split("\\s+");
        String[] Y = textField3.getText().strip().split("\\s+");

        if (K.length != 1) {
            setWarning();
        }

        BigDecimal temp;
        for (String str : X) {
            try {
                if (!str.isEmpty()) {
                    temp = new BigDecimal(str);
                    XNums.add(temp);
                }
            } catch (Exception exp) {
                setWrong();
            }
        }
        for (String str : Y) {
            try {
                if (!str.isEmpty()) {
                    temp = new BigDecimal(str);
                    YNums.add(temp);
                }
            } catch (Exception exp) {
                setWrong();
            }
        }

        int k = XNums.size();
        if (K[0].isEmpty() || Integer.parseInt(K[0]) != k) {
            setWarning();
        }

        if (XNums.size() != YNums.size() || XNums.size() < 2) {
            setWrong();
        }

        if (state != -1) {
            if (state == 1) {
                setCorrect();
            }
            data = new Object[k + 2][6];
            BigDecimal sumX = BigDecimal.ZERO,
                    sumY = BigDecimal.ZERO,
                    sumX2 = BigDecimal.ZERO,
                    sumY2 = BigDecimal.ZERO,
                    sumXY = BigDecimal.ZERO;
            label11.setText("k = " + k);
            for (int i = 0; i < k; i++) {
                data[i][0] = i + 1;
                data[i][1] = XNums.get(i);
                data[i][2] = XNums.get(i).pow(2);
                data[i][3] = YNums.get(i);
                data[i][4] = YNums.get(i).pow(2);
                data[i][5] = XNums.get(i).multiply(YNums.get(i));
                sumX = sumX.add((BigDecimal) data[i][1]);
                sumY = sumY.add((BigDecimal) data[i][3]);
                sumX2 = sumX2.add((BigDecimal) data[i][2]);
                sumY2 = sumY2.add((BigDecimal) data[i][4]);
                sumXY = sumXY.add((BigDecimal) data[i][5]);
            }
            data[k][0] = "sum";
            data[k + 1][0] = "ave";
            if (k > 0) {
                BigDecimal aveX = sumX.divide(new BigDecimal(k), 6, RoundingMode.HALF_UP);
                BigDecimal aveX2 = sumX2.divide(new BigDecimal(k), 6, RoundingMode.HALF_UP);
                BigDecimal aveY = sumY.divide(new BigDecimal(k), 6, RoundingMode.HALF_UP);
                BigDecimal aveY2 = sumY2.divide(new BigDecimal(k), 6, RoundingMode.HALF_UP);
                BigDecimal aveXY = sumXY.divide(new BigDecimal(k), 6, RoundingMode.HALF_UP);
                data[k][1] = sumX;
                data[k][2] = sumX2;
                data[k][3] = sumY;
                data[k][4] = sumY2;
                data[k][5] = sumXY;
                data[k + 1][1] = aveX;
                data[k + 1][2] = aveX2;
                data[k + 1][3] = aveY;
                data[k + 1][4] = aveY2;
                data[k + 1][5] = aveXY;

                try {
                    BigDecimal up = aveXY.subtract(aveX.multiply(aveY));
                    BigDecimal section1 = aveX2.subtract(aveX.pow(2));
                    BigDecimal section2 = aveY2.subtract(aveY.pow(2));
                    BigDecimal low = section1.multiply(section2).sqrt(new MathContext(514));

                    r = up.divide(low, 6, RoundingMode.HALF_UP);
                    b = (aveX.multiply(aveY).subtract(aveXY)).divide(aveX.pow(2).subtract(aveX2), 6, RoundingMode.HALF_UP);
                    a = aveY.subtract(b.multiply(aveX));

                    label6.setText(b.toPlainString());
                    label8.setText(a.setScale(6, RoundingMode.HALF_UP).toPlainString());

                    if (up.equals(BigDecimal.ZERO) && (low.equals(BigDecimal.ZERO)))
                        label10.setText("1");
                    else
                        label10.setText(r.toPlainString());
                } catch (Exception exp) {
                    setWrong();
                }
            }


            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table1.setModel(model);
            table1.setFocusable(false);
            scrollPane1.setViewportView(table1);
        }
    }

    private String readTxt(File file) {
        StringBuilder ans = new StringBuilder(new StringBuilder());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ans.append(line);
                ans.append('\n');
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans.toString().strip();
    }

    private void button6MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String userDir = System.getProperty("user.home");
            JFileChooser fileChooser = new JFileChooser(userDir + "/Desktop");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("文本文档(*.txt)", "txt"));//文件过滤器
            int state = fileChooser.showOpenDialog(null);//显示文件选择框
            if (state == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                StringBuilder input = new StringBuilder(readTxt(file));
                int kStart = input.indexOf("k:");
                int xStart = input.indexOf("x:");
                int yStart = input.indexOf("y:");
                if (kStart == -1 || xStart == -1 && yStart == -1) {
                    JOptionPane.showMessageDialog(null, "Input Wrong");
                } else {
                    String k = input.substring(kStart + 2, xStart).replaceAll("\n", " ");
                    String x = input.substring(xStart + 2, yStart).replaceAll("\n", " ");
                    String y = input.substring(yStart + 2).replaceAll("\n", " ");
                    textField1.setText(k);
                    textField2.setText(x);
                    textField3.setText(y);
                }
            }
        }
    }

    private void WriteTxt(File file) {
        try {
            if (data == null) {
                JOptionPane.showMessageDialog(null, "Data Wrong");
            } else {
                FileWriter fw = new FileWriter(file);
                fw.write("k=" + XNums.size() + "\n");
                for (String name : columnNames) {
                    fw.write(String.format("%-30s", name));
                }
                fw.write('\n');
                for (Object[] oo : data) {
                    for (Object o : oo) {
                        fw.write(String.format("%-30s", o));
                    }
                    fw.write('\n');
                }
                fw.write(String.format("\nb=%-28sa=%-28sr=%-28s\n",
                        b.toPlainString(),
                        a.setScale(6, RoundingMode.HALF_UP).toPlainString(),
                        r.toPlainString()));
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void button7MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String userDir = System.getProperty("user.home");
            JFileChooser fileChooser = new JFileChooser(userDir + "/Desktop");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("文本文档(*.txt)", "txt"));//文件过滤器
            int state = fileChooser.showSaveDialog(null);
            if (state == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filepath = file.getPath();
                if (!filepath.endsWith(".txt")) {
                    filepath = filepath + ".txt";
                    file = new File(filepath);
                }
                WriteTxt(file);
            }
        }
    }

    private void button8MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1 && data != null) {
            new LinearRegressionDemo(this);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane3 = new JScrollPane();
        textField2 = new JTextField();
        label3 = new JLabel();
        scrollPane4 = new JScrollPane();
        textField3 = new JTextField();
        scrollPane2 = new JScrollPane();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        label9 = new JLabel();
        label11 = new JLabel();
        button6 = new JButton();
        button7 = new JButton();
        scrollPane5 = new JScrollPane();
        label8 = new JLabel();
        scrollPane6 = new JScrollPane();
        label6 = new JLabel();
        scrollPane7 = new JScrollPane();
        label10 = new JLabel();
        button8 = new JButton();

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"sum", null, null, null, null, null},
                    {"ave", null, null, null, null, null},
                },
                new String[] {
                    "index=i", "Xi=xi", "Xi^2=xi^2", "Yi=yi", "Yi^2=yi^2", "XiYi=xiyi"
                }
            ));
            table1.setFocusable(false);
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(175, 250, scrollPane1.getPreferredSize().width, 290);

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u5904\u7406\u6570\u636e\u70b9\u4e2a\u6570(\u53ef\u9009)\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 4f));
        add(label1);
        label1.setBounds(110, 25, 245, 40);

        //---- label2 ----
        label2.setText("\u8bf7\u4f9d\u6b21\u8f93\u5165x\u7684\u5404\u4e2a\u6570\u636e\u70b9(\u7528\u7a7a\u683c\u5206\u5f00)\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 4f));
        add(label2);
        label2.setBounds(40, 85, 325, 40);

        //======== scrollPane3 ========
        {
            scrollPane3.setAutoscrolls(true);

            //---- textField2 ----
            textField2.setFont(new Font("Consolas", Font.PLAIN, 14));
            scrollPane3.setViewportView(textField2);
        }
        add(scrollPane3);
        scrollPane3.setBounds(350, 80, 355, 45);

        //---- label3 ----
        label3.setText("\u8bf7\u4f9d\u6b21\u8f93\u5165y\u7684\u5404\u4e2a\u6570\u636e\u70b9(\u7528\u7a7a\u683c\u5206\u5f00)\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 4f));
        add(label3);
        label3.setBounds(40, 145, 320, 40);

        //======== scrollPane4 ========
        {
            scrollPane4.setAutoscrolls(true);

            //---- textField3 ----
            textField3.setFont(new Font("Consolas", Font.PLAIN, 14));
            textField3.setDragEnabled(true);
            scrollPane4.setViewportView(textField3);
        }
        add(scrollPane4);
        scrollPane4.setBounds(350, 140, 355, 45);

        //======== scrollPane2 ========
        {
            scrollPane2.setAutoscrolls(true);

            //---- textField1 ----
            textField1.setFont(new Font("Consolas", Font.PLAIN, 14));
            scrollPane2.setViewportView(textField1);
        }
        add(scrollPane2);
        scrollPane2.setBounds(350, 20, 355, 45);

        //---- button1 ----
        button1.setText("\u8ba1\u7b97");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 4f));
        button1.setFocusable(false);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(565, 195, 75, 40);

        //---- button2 ----
        button2.setText("CE");
        button2.setFont(new Font("Consolas", Font.PLAIN, 14));
        button2.setFocusable(false);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2);
        button2.setBounds(720, 30, 49, 30);

        //---- button3 ----
        button3.setText("CE");
        button3.setFont(new Font("Consolas", Font.PLAIN, 14));
        button3.setFocusable(false);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        add(button3);
        button3.setBounds(720, 90, 49, 30);

        //---- button4 ----
        button4.setText("CE");
        button4.setFont(new Font("Consolas", Font.PLAIN, 14));
        button4.setFocusable(false);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        add(button4);
        button4.setBounds(720, 150, 49, 30);

        //---- button5 ----
        button5.setText("Clear");
        button5.setFont(new Font("Consolas", Font.PLAIN, 14));
        button5.setFocusable(false);
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button5MousePressed(e);
            }
        });
        add(button5);
        button5.setBounds(415, 195, 75, 40);

        //---- label4 ----
        label4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "Status", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
            new Font("Consolas", Font.BOLD | Font.ITALIC, 12)));
        label4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        add(label4);
        label4.setBounds(105, 185, 100, 55);

        //---- label5 ----
        label5.setIcon(new ImageIcon(getClass().getResource("/Resources/img/b.png")));
        label5.setMaximumSize(new Dimension(200, 200));
        label5.setMinimumSize(new Dimension(200, 200));
        label5.setPreferredSize(new Dimension(200, 200));
        add(label5);
        label5.setBounds(10, 555, 185, 85);

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/Resources/img/a.png")));
        label7.setMaximumSize(new Dimension(200, 200));
        label7.setMinimumSize(new Dimension(200, 200));
        label7.setPreferredSize(new Dimension(200, 200));
        add(label7);
        label7.setBounds(30, 655, 160, 60);

        //---- label9 ----
        label9.setIcon(new ImageIcon(getClass().getResource("/Resources/img/r.png")));
        label9.setMaximumSize(new Dimension(200, 200));
        label9.setMinimumSize(new Dimension(200, 200));
        label9.setPreferredSize(new Dimension(200, 200));
        add(label9);
        label9.setBounds(320, 590, 325, 115);

        //---- label11 ----
        label11.setText("k =");
        label11.setFont(new Font("Times New Roman", Font.ITALIC, 28));
        add(label11);
        label11.setBounds(30, 500, 90, 35);

        //---- button6 ----
        button6.setText("\u5bfc\u5165");
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 4f));
        button6.setFocusable(false);
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button6MousePressed(e);
            }
        });
        add(button6);
        button6.setBounds(675, 405, 75, 40);

        //---- button7 ----
        button7.setText("\u5bfc\u51fa");
        button7.setFont(button7.getFont().deriveFont(button7.getFont().getStyle() | Font.BOLD, button7.getFont().getSize() + 4f));
        button7.setFocusable(false);
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button7MousePressed(e);
            }
        });
        add(button7);
        button7.setBounds(675, 465, 75, 40);

        //======== scrollPane5 ========
        {

            //---- label8 ----
            label8.setFont(new Font("Times New Roman", Font.BOLD, 18));
            scrollPane5.setViewportView(label8);
        }
        add(scrollPane5);
        scrollPane5.setBounds(195, 665, 125, 50);

        //======== scrollPane6 ========
        {

            //---- label6 ----
            label6.setFont(new Font("Times New Roman", Font.BOLD, 18));
            scrollPane6.setViewportView(label6);
        }
        add(scrollPane6);
        scrollPane6.setBounds(195, 570, 125, 50);

        //======== scrollPane7 ========
        {

            //---- label10 ----
            label10.setFont(new Font("Times New Roman", Font.BOLD, 18));
            scrollPane7.setViewportView(label10);
        }
        add(scrollPane7);
        scrollPane7.setBounds(650, 615, 125, 50);

        //---- button8 ----
        button8.setText("\u56fe\u50cf");
        button8.setFont(button8.getFont().deriveFont(button8.getFont().getStyle() | Font.BOLD, button8.getFont().getSize() + 4f));
        button8.setFocusable(false);
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button8MousePressed(e);
            }
        });
        add(button8);
        button8.setBounds(675, 345, 75, 40);

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane3;
    private JTextField textField2;
    private JLabel label3;
    private JScrollPane scrollPane4;
    private JTextField textField3;
    private JScrollPane scrollPane2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label4;
    private JLabel label5;
    private JLabel label7;
    private JLabel label9;
    private JLabel label11;
    private JButton button6;
    private JButton button7;
    private JScrollPane scrollPane5;
    private JLabel label8;
    private JScrollPane scrollPane6;
    private JLabel label6;
    private JScrollPane scrollPane7;
    private JLabel label10;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
