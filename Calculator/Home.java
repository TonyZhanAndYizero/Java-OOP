import java.awt.event.*;
import Source.Calculator_sci;
import Source.Calculator_std;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Tue Nov 21 18:26:39 CST 2023
 */



/**
 * @author Yury
 */
public class Home extends JFrame {
    private static Calculator_std std;
    private static Calculator_sci sci;
    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
//            //��Ҫ����JTatto-1.6.13.jar����srcͬ����lib�У�Ȼ�������Ͻ���Ŀ�ṹ�����Ӹÿ�
//            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            String lookAndFeel = "com.jtattoo.plaf.fast.FastLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
//            com.jtattoo.plaf.noire.NoireLookAndFeel ��ͺ�
//            com.jtattoo.plaf.smart.SmartLookAndFeel ľ�ʸ�+xp���
//            com.jtattoo.plaf.mint.MintLookAndFeel ��Բ��ť+��ɫ��ť����
//            com.jtattoo.plaf.mcwin.McWinLookAndFeel ��Բ��ť+��ɫ��ť����
//            com.jtattoo.plaf.luna.LunaLookAndFeel ��XP���
//            com.jtattoo.plaf.hifi.HiFiLookAndFeel ��ɫ���
//            com.jtattoo.plaf.fast.FastLookAndFeel ��ͨswing���+��ɫ�߿�
//            com.jtattoo.plaf.bernstein.BernsteinLookAndFeel ��ɫ���
//            com.jtattoo.plaf.aluminium.AluminiumLookAndFeel ��Բ��ť+����ɫ��ť����+�����ʸУ�Ĭ�ϣ�
//            com.jtattoo.plaf.aero.AeroLookAndFeel xp���·��
//            com.jtattoo.plafacryl.AcrylLookAndFeel ���ʸ�+swing�����
        } catch (Exception ignored) {
        }

        Home home = new Home();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ��ʼ����Ϊ��׼������
        home.getContentPane().removeAll();
        home.getContentPane().add(std);
        home.revalidate();
        home.repaint();
        home.setVisible(true);
    }
    public Home() {
        std = new Calculator_std();
        sci = new Calculator_sci();
        initComponents();
    }

    private void showStd(ActionEvent e) {
        // TODO add your code here
        getContentPane().removeAll();
        getContentPane().add(std);
        std.getTextField1().requestFocus();
        revalidate();
        repaint();
    }

    private void showSci(ActionEvent e) {
        // TODO add your code here
        getContentPane().removeAll();
        getContentPane().add(sci);
        sci.getTextField1().requestFocus();
        revalidate();
        repaint();
    }

    private void showSci(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("Calculator/Resources/img/icon.png"); //ͼƬ����Ŀͬһ·�����ʲ���ͼƬ��·��
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
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7c7b\u578b");

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