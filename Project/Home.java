import java.awt.event.*;
import javax.swing.border.*;

import Source.Calculator.CalculatorMatrix;
import Source.Calculator.CalculatorSci;
import Source.Calculator.CalculatorStd;
import Source.Game.GuessNumber;
import Source.Game.TwentyFour;
import Source.Physics.LinearRegression;
import Source.Physics.Variance;
import Source.Transform.Angle;
import Source.Transform.DecimalConversion;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Nov 21 18:26:39 CST 2023
 */


/**
 * @author Yury
 */
public class Home extends JFrame {
    public static void main(String[] args) {
        Home home = new Home();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 初始界面为标准计算器
        home.getContentPane().removeAll();
        home.getContentPane().add(std);
        home.setTitle("  Standard Calculator");
        home.revalidate();
        home.repaint();
        home.pack();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
    }

    private static CalculatorSci sci;
    private static CalculatorStd std;
    private static CalculatorMatrix matrix;
    private static Angle angle;
    private static LinearRegression linearRegression;
    private static DecimalConversion decimalConversion;
    private static TwentyFour twentyFour;
    private static Variance variance;
    private static GuessNumber guessNumber;

    public Home() {
        try {
//            //需要下载JTatto-1.6.13.jar到与src同级的lib中，然后在左上角项目结构中添加该库
//            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
//            com.jtattoo.plaf.noire.NoireLookAndFeel 柔和黑
//            com.jtattoo.plaf.smart.SmartLookAndFeel 木质感+xp风格
//            com.jtattoo.plaf.mint.MintLookAndFeel 椭圆按钮+黄色按钮背景
//            com.jtattoo.plaf.mcwin.McWinLookAndFeel 椭圆按钮+绿色按钮背景
//            com.jtattoo.plaf.luna.LunaLookAndFeel 纯XP风格
//            com.jtattoo.plaf.hifi.HiFiLookAndFeel 黑色风格
//            com.jtattoo.plaf.fast.FastLookAndFeel 普通swing风格+蓝色边框
//            com.jtattoo.plaf.bernstein.BernsteinLookAndFeel 黄色风格
//            com.jtattoo.plaf.aluminium.AluminiumLookAndFeel 椭圆按钮+翠绿色按钮背景+金属质感（默认）
//            com.jtattoo.plaf.aero.AeroLookAndFeel xp清新风格
//            com.jtattoo.plaf.acryl.AcrylLookAndFeel 布质感+swing纯风格
//            com.jtattoo.plaf.texture.TextureLookAndFeel
//            com.jtattoo.plaf.graphite.GraphiteLookAndFeel
        } catch (Exception ignored) {
        }
        sci = new CalculatorSci();
        std = new CalculatorStd();
        angle = new Angle();
        decimalConversion = new DecimalConversion();
        linearRegression = new LinearRegression();
        twentyFour = new TwentyFour();
        variance = new Variance();
        guessNumber = new GuessNumber();
        matrix = new CalculatorMatrix();
        initComponents();
    }

    private void showStd(ActionEvent e) {
        this.setTitle("  Standard Calculator");
        getContentPane().removeAll();
        getContentPane().add(std);
        std.getTextField1().requestFocus();
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showSci(ActionEvent e) {
        this.setTitle("  Scientific Calculator");
        getContentPane().removeAll();
        getContentPane().add(sci);
        sci.getTextField1().requestFocus();
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showAngleTransformer(MouseEvent e) {
        this.setTitle("  Angle Transformer");
        getContentPane().removeAll();
        getContentPane().add(angle);
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showLinearRegression(MouseEvent e) {
        this.setTitle("  Linear Regression");
        getContentPane().removeAll();
        getContentPane().add(linearRegression);
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showDecimalConversion(MouseEvent e) {
        this.setTitle("  Decimal Conversion");
        getContentPane().removeAll();
        getContentPane().add(decimalConversion);
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showTwentyFour(MouseEvent e) {
        this.setTitle("  24-Point Game");
        getContentPane().removeAll();
        getContentPane().add(twentyFour);
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showVariance(MouseEvent e) {
        this.setTitle("  Variance");
        getContentPane().removeAll();
        getContentPane().add(variance);
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showGuessNumber(MouseEvent e) {
        this.setTitle("  Guess Number");
        getContentPane().removeAll();
        getContentPane().add(guessNumber);
        guessNumber.getTextField1().requestFocus();
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void showMatrix(MouseEvent e) {
        this.setTitle("  Matrix Calculator");
        getContentPane().removeAll();
        getContentPane().add(matrix);
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private void menuItem1MousePressed(MouseEvent e) {
        dialog1.setVisible(true);
    }

    private void button1MousePressed(MouseEvent e) {
        if(e.getButton()==1){
            dialog1.setVisible(false);
        }
    }

    private void button2MousePressed(MouseEvent e) {
        if(e.getButton()==1){
            dialog2.setVisible(false);
        }
    }

    private void menuItem2MousePressed(MouseEvent e) {
        dialog2.setVisible(true);
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon(getClass().getResource("Resources/img/icon.png")); //图片和项目同一路径，故不用图片的路径
        this.setIconImage(icon.getImage());
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        label1 = new JLabel();
        radioButtonMenuItem1 = new JRadioButtonMenuItem();
        radioButtonMenuItem2 = new JRadioButtonMenuItem();
        radioButtonMenuItem9 = new JRadioButtonMenuItem();
        label2 = new JLabel();
        radioButtonMenuItem3 = new JRadioButtonMenuItem();
        radioButtonMenuItem5 = new JRadioButtonMenuItem();
        label3 = new JLabel();
        radioButtonMenuItem4 = new JRadioButtonMenuItem();
        radioButtonMenuItem7 = new JRadioButtonMenuItem();
        label4 = new JLabel();
        radioButtonMenuItem6 = new JRadioButtonMenuItem();
        radioButtonMenuItem8 = new JRadioButtonMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        dialog1 = new JDialog();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        dialog2 = new JDialog();
        scrollPane2 = new JScrollPane();
        textArea3 = new JTextArea();
        button2 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(200, 200));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7c7b\u578b");
                menu1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                menu1.setMargin(new Insets(5, 5, 5, 5));
                menu1.setContentAreaFilled(false);

                //---- label1 ----
                label1.setText(" \u8ba1\u7b97\u5668 ");
                label1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                label1.setForeground(Color.gray);
                label1.setMinimumSize(new Dimension(80, 20));
                label1.setMaximumSize(new Dimension(80, 20));
                label1.setBorder(new EmptyBorder(5, 0, 0, 0));
                label1.setPreferredSize(new Dimension(80, 20));
                menu1.add(label1);

                //---- radioButtonMenuItem1 ----
                radioButtonMenuItem1.setText("\u6807\u51c6");
                radioButtonMenuItem1.setSelected(true);
                radioButtonMenuItem1.setIcon(new ImageIcon(getClass().getResource("/Resources/img/std.png")));
                radioButtonMenuItem1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem1.setIconTextGap(5);
                radioButtonMenuItem1.addActionListener(e -> showStd(e));
                menu1.add(radioButtonMenuItem1);

                //---- radioButtonMenuItem2 ----
                radioButtonMenuItem2.setText("\u79d1\u5b66");
                radioButtonMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Resources/img/sci.png")));
                radioButtonMenuItem2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem2.setIconTextGap(5);
                radioButtonMenuItem2.addActionListener(e -> showSci(e));
                menu1.add(radioButtonMenuItem2);

                //---- radioButtonMenuItem9 ----
                radioButtonMenuItem9.setText("\u77e9\u9635");
                radioButtonMenuItem9.setSelected(true);
                radioButtonMenuItem9.setIcon(new ImageIcon(getClass().getResource("/Resources/img/matrix.png")));
                radioButtonMenuItem9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem9.setIconTextGap(5);
                radioButtonMenuItem9.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showMatrix(e);
                    }
                });
                menu1.add(radioButtonMenuItem9);

                //---- label2 ----
                label2.setText(" \u8f6c\u6362\u5668 ");
                label2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                label2.setForeground(Color.gray);
                label2.setBorder(new EmptyBorder(5, 0, 0, 0));
                label2.setMaximumSize(new Dimension(80, 20));
                label2.setMinimumSize(new Dimension(80, 20));
                label2.setPreferredSize(new Dimension(80, 20));
                menu1.add(label2);

                //---- radioButtonMenuItem3 ----
                radioButtonMenuItem3.setText("\u89d2\u5ea6");
                radioButtonMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Resources/img/angle.png")));
                radioButtonMenuItem3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem3.setIconTextGap(5);
                radioButtonMenuItem3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showAngleTransformer(e);
                    }
                });
                menu1.add(radioButtonMenuItem3);

                //---- radioButtonMenuItem5 ----
                radioButtonMenuItem5.setText("\u8fdb\u5236");
                radioButtonMenuItem5.setIcon(new ImageIcon(getClass().getResource("/Resources/img/decimal.png")));
                radioButtonMenuItem5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem5.setIconTextGap(5);
                radioButtonMenuItem5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showDecimalConversion(e);
                    }
                });
                menu1.add(radioButtonMenuItem5);

                //---- label3 ----
                label3.setText(" \u7269\u7406\u8ba1\u7b97 ");
                label3.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                label3.setForeground(Color.gray);
                label3.setBorder(new EmptyBorder(5, 0, 0, 0));
                label3.setMaximumSize(new Dimension(80, 20));
                label3.setMinimumSize(new Dimension(80, 20));
                label3.setPreferredSize(new Dimension(80, 20));
                menu1.add(label3);

                //---- radioButtonMenuItem4 ----
                radioButtonMenuItem4.setText("\u4e00\u5143\u7ebf\u6027\u56de\u5f52");
                radioButtonMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Resources/img/linear2.png")));
                radioButtonMenuItem4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem4.setIconTextGap(5);
                radioButtonMenuItem4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showLinearRegression(e);
                    }
                });
                menu1.add(radioButtonMenuItem4);

                //---- radioButtonMenuItem7 ----
                radioButtonMenuItem7.setText("\u65b9\u5dee");
                radioButtonMenuItem7.setIcon(new ImageIcon(getClass().getResource("/Resources/img/variance.png")));
                radioButtonMenuItem7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem7.setIconTextGap(5);
                radioButtonMenuItem7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showVariance(e);
                    }
                });
                menu1.add(radioButtonMenuItem7);

                //---- label4 ----
                label4.setText(" \u76ca\u667a ");
                label4.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                label4.setForeground(Color.gray);
                label4.setPreferredSize(new Dimension(80, 20));
                label4.setMinimumSize(new Dimension(80, 20));
                label4.setMaximumSize(new Dimension(80, 20));
                menu1.add(label4);

                //---- radioButtonMenuItem6 ----
                radioButtonMenuItem6.setText("24\u70b9");
                radioButtonMenuItem6.setIcon(new ImageIcon(getClass().getResource("/Resources/img/24.png")));
                radioButtonMenuItem6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem6.setIconTextGap(5);
                radioButtonMenuItem6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showTwentyFour(e);
                    }
                });
                menu1.add(radioButtonMenuItem6);

                //---- radioButtonMenuItem8 ----
                radioButtonMenuItem8.setText("\u731c\u6570\u5b57");
                radioButtonMenuItem8.setIcon(new ImageIcon(getClass().getResource("/Resources/img/guess2.png")));
                radioButtonMenuItem8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                radioButtonMenuItem8.setIconTextGap(5);
                radioButtonMenuItem8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        showGuessNumber(e);
                    }
                });
                menu1.add(radioButtonMenuItem8);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5e2e\u52a9");
                menu2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                menu2.setMargin(new Insets(5, 5, 5, 5));

                //---- menuItem1 ----
                menuItem1.setText("\u4e00\u5143\u7ebf\u6027\u56de\u5f52");
                menuItem1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem1MousePressed(e);
                    }
                });
                menu2.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u65b9\u5dee\u8bf4\u660e");
                menuItem2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem2MousePressed(e);
                    }
                });
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);
        pack();

        //======== dialog1 ========
        {
            dialog1.setTitle("\u4e00\u5143\u7ebf\u6027\u56de\u5f52\u8bf4\u660e");
            var dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setText("\u5f53\u60a8\u60f3\u4f7f\u7528.txt\u6587\u4ef6\u5bfc\u5165\u4e00\u5143\u7ebf\u6027\u56de\u5f52\u6570\u636e\u70b9\u7684\u65f6\u5019\uff0c\u8bf7\n\u4e25\u683c\u6309\u7167\u5982\u4e0b\u683c\u5f0f\u6392\u5e03\uff1a(\u4e0b\u9762\u662f\u4e00\u4e2ak=3\u7684\u4f8b\u5b50)\nk:3\nx:2 3 4\ny:3 4 5\n\u5176\u4e2d\uff0c\"k:\",\"x:\"\u548c\"y:\"\u5fc5\u987b\u4e25\u683c\u4e00\u81f4\uff0c\u5176\u540e\u6570\u636e\u70b9\u53ef\u7528\n\u4efb\u4f55\u7a7a\u767d\u7b26\u5206\u5272\uff0c\u5747\u4e0d\u5f71\u54cd\uff0c\u4f46\u8be53\u4e2a\u6807\u8bc6\u7b26\u4e0d\u53ef\u6709\u5dee\u522b\uff01\n\u6781\u7aef\u4f8b\u5b50\u4e3a\uff1a\nk:   4\nx:\n3 4\n5 \n5 y: 2 3 5\n7");
                textArea1.setEditable(false);
                scrollPane1.setViewportView(textArea1);
            }
            dialog1ContentPane.add(scrollPane1);
            scrollPane1.setBounds(0, 0, 349, 150);

            //---- button1 ----
            button1.setText("\u5173\u95ed");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button1MousePressed(e);
                }
            });
            dialog1ContentPane.add(button1);
            button1.setBounds(145, 155, 60, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog1ContentPane.setMinimumSize(preferredSize);
                dialog1ContentPane.setPreferredSize(preferredSize);
            }
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u65b9\u5dee\u8bf4\u660e");
            var dialog2ContentPane = dialog2.getContentPane();
            dialog2ContentPane.setLayout(null);

            //======== scrollPane2 ========
            {

                //---- textArea3 ----
                textArea3.setText("\u4e3a\u8fce\u5408\u300a\u6982\u7387\u7edf\u8ba1\u300b\u53ca\u300a\u57fa\u7840\u7269\u7406\u5b9e\u9a8c\u300b\u9700\u6c42\uff0c\u672c\u8f6f\n\u4ef6\u91c7\u7528\u5206\u6bcd\u4e3a\"\u6837\u672c\u6570-1\"\u7684\u8ba1\u7b97\u89c4\u5219\u3002");
                textArea3.setEditable(false);
                scrollPane2.setViewportView(textArea3);
            }
            dialog2ContentPane.add(scrollPane2);
            scrollPane2.setBounds(0, 0, 349, 150);

            //---- button2 ----
            button2.setText("\u5173\u95ed");
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button2MousePressed(e);
                }
            });
            dialog2ContentPane.add(button2);
            button2.setBounds(145, 155, 60, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog2ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog2ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog2ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog2ContentPane.setMinimumSize(preferredSize);
                dialog2ContentPane.setPreferredSize(preferredSize);
            }
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButtonMenuItem1);
        buttonGroup1.add(radioButtonMenuItem2);
        buttonGroup1.add(radioButtonMenuItem9);
        buttonGroup1.add(radioButtonMenuItem3);
        buttonGroup1.add(radioButtonMenuItem5);
        buttonGroup1.add(radioButtonMenuItem4);
        buttonGroup1.add(radioButtonMenuItem7);
        buttonGroup1.add(radioButtonMenuItem6);
        buttonGroup1.add(radioButtonMenuItem8);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JLabel label1;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JRadioButtonMenuItem radioButtonMenuItem9;
    private JLabel label2;
    private JRadioButtonMenuItem radioButtonMenuItem3;
    private JRadioButtonMenuItem radioButtonMenuItem5;
    private JLabel label3;
    private JRadioButtonMenuItem radioButtonMenuItem4;
    private JRadioButtonMenuItem radioButtonMenuItem7;
    private JLabel label4;
    private JRadioButtonMenuItem radioButtonMenuItem6;
    private JRadioButtonMenuItem radioButtonMenuItem8;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JDialog dialog1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JDialog dialog2;
    private JScrollPane scrollPane2;
    private JTextArea textArea3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}