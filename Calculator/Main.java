import Source.Calculator_std;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
//            //��Ҫ����JTatto-1.6.13.jar����srcͬ����lib�У�Ȼ�������Ͻ���Ŀ�ṹ����Ӹÿ�
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
        Calculator_std calculatorStd = new Calculator_std();
        calculatorStd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorStd.setVisible(true);
    }
}
