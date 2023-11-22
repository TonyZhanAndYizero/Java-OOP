import java.awt.event.*;
import Source.CalculatorPack.Calculator_sci;
import Source.CalculatorPack.Calculator_std;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Nov 21 18:26:39 CST 2023
 */



/**
 * @author Yury
 */
public class Home extends JFrame {
    private static final Calculator_std std=new Calculator_std();
    private static final Calculator_sci sci=new Calculator_sci();
    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
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
//            com.jtattoo.plafacryl.AcrylLookAndFeel 布质感+swing纯风格
        } catch (Exception ignored) {
        }

        Home home = new Home();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 初始界面为标准计算器
        home.getContentPane().add(std);
        home.setTitle("  Standard Calculator");
        home.revalidate();
        home.repaint();
        home.setVisible(true);
    }
    public Home() {
        initComponents();
    }

    private void showStd(ActionEvent e) {
        // TODO add your code here
        this.setTitle("  Standard Calculator");
        getContentPane().removeAll();
        getContentPane().add(std);
        std.getTextField1().requestFocus();
        revalidate();
        repaint();
    }

    private void showSci(ActionEvent e) {
        // TODO add your code here
        this.setTitle("  Scientific Calculator");
        getContentPane().removeAll();
        getContentPane().add(sci);
        revalidate();
        repaint();
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("Project/Resources/img/icon.png"); //图片和项目同一路径，故不用图片的路径
        this.setIconImage(icon.getImage());
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        radioButtonMenuItem1 = new JRadioButtonMenuItem();
        radioButtonMenuItem2 = new JRadioButtonMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();

        //======== this ========
        setMinimumSize(new Dimension(800, 800));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7c7b\u578b");
                menu1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                menu1.setMargin(new Insets(5, 5, 5, 5));

                //---- radioButtonMenuItem1 ----
                radioButtonMenuItem1.setText("\u6807\u51c6");
                radioButtonMenuItem1.setSelected(true);
                radioButtonMenuItem1.addActionListener(e -> showStd(e));
                menu1.add(radioButtonMenuItem1);

                //---- radioButtonMenuItem2 ----
                radioButtonMenuItem2.setText("\u79d1\u5b66");
                radioButtonMenuItem2.addActionListener(e -> showSci(e));
                menu1.add(radioButtonMenuItem2);
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

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButtonMenuItem1);
        buttonGroup1.add(radioButtonMenuItem2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
/*

 */