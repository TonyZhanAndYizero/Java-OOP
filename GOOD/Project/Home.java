import java.awt.event.*;
import javax.swing.border.*;

import Source.Calculator.CalculatorMatrix;
import Source.Calculator.CalculatorSci;
import Source.Calculator.CalculatorStd;
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
        home.setVisible(true);
    }

    private static CalculatorMatrix cm;
    private static CalculatorSci sci;
    private static CalculatorStd std;
    private static Angle angle;
    private static LinearRegression linearRegression;
    private static DecimalConversion decimalConversion;
    private static TwentyFour twentyFour;
    private static Variance variance;
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
        cm=new CalculatorMatrix();
        initComponents();
    }

    private void showStd(ActionEvent e) {
        // TODO add your code here
        this.setTitle("  Standard Calculator");
        getContentPane().removeAll();
        getContentPane().add(cm);
        revalidate();
        repaint();
        pack();
    }

    private void showSci(ActionEvent e) {
        // TODO add your code here
        this.setTitle("  Scientific Calculator");
        getContentPane().removeAll();
        getContentPane().add(sci);
        sci.getTextField1().requestFocus();
        revalidate();
        repaint();
        pack();
    }

    private void menuItem3MousePressed(MouseEvent e) {
        // TODO add your code here
        this.setTitle("  Angle Transformer");
        getContentPane().removeAll();
        getContentPane().add(angle);
        revalidate();
        repaint();
        pack();
    }

    private void menuItem4MousePressed(MouseEvent e) {
        // TODO add your code here
        this.setTitle("  Linear Regression");
        getContentPane().removeAll();
        getContentPane().add(linearRegression);
        revalidate();
        repaint();
        pack();
    }

    private void showDecimalConversion(MouseEvent e) {
        // TODO add your code here
        this.setTitle("  Decimal Conversion");
        getContentPane().removeAll();
        getContentPane().add(decimalConversion);
        revalidate();
        repaint();
        pack();
    }

    private void showTwentyFour(MouseEvent e) {
        // TODO add your code here
        this.setTitle("  24-Point Game");
        getContentPane().removeAll();
        getContentPane().add(twentyFour);
        revalidate();
        repaint();
        pack();
    }

    private void showVariance(MouseEvent e) {
        // TODO add your code here
        this.setTitle("  Variance");
        getContentPane().removeAll();
        getContentPane().add(variance);
        revalidate();
        repaint();
        pack();
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("Project/Resources/img/icon.png"); //图片和项目同一路径，故不用图片的路径
        this.setIconImage(icon.getImage());
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        label1 = new JLabel();
        radioButtonMenuItem1 = new JRadioButtonMenuItem();
        radioButtonMenuItem2 = new JRadioButtonMenuItem();
        label2 = new JLabel();
        radioButtonMenuItem3 = new JRadioButtonMenuItem();
        radioButtonMenuItem5 = new JRadioButtonMenuItem();
        label3 = new JLabel();
        radioButtonMenuItem4 = new JRadioButtonMenuItem();
        radioButtonMenuItem7 = new JRadioButtonMenuItem();
        label4 = new JLabel();
        radioButtonMenuItem6 = new JRadioButtonMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();

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
                        menuItem3MousePressed(e);
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
                        menuItem4MousePressed(e);
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
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u6587\u4ef6");
                menu2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                menu2.setMargin(new Insets(5, 5, 5, 5));

                //---- menuItem1 ----
                menuItem1.setText("\u6253\u5f00\u6587\u4ef6");
                menu2.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u4fdd\u5b58\u6587\u4ef6");
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);
        pack();

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButtonMenuItem1);
        buttonGroup1.add(radioButtonMenuItem2);
        buttonGroup1.add(radioButtonMenuItem3);
        buttonGroup1.add(radioButtonMenuItem5);
        buttonGroup1.add(radioButtonMenuItem4);
        buttonGroup1.add(radioButtonMenuItem7);
        buttonGroup1.add(radioButtonMenuItem6);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JLabel label1;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JLabel label2;
    private JRadioButtonMenuItem radioButtonMenuItem3;
    private JRadioButtonMenuItem radioButtonMenuItem5;
    private JLabel label3;
    private JRadioButtonMenuItem radioButtonMenuItem4;
    private JRadioButtonMenuItem radioButtonMenuItem7;
    private JLabel label4;
    private JRadioButtonMenuItem radioButtonMenuItem6;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
/*

 */