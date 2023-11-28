/*
 * Created by JFormDesigner on Mon Nov 27 23:43:35 CST 2023
 */
// -*- coding: utf-8 -*-
package Source;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author 王海峰
 */
public class Converter extends JPanel {
    private JPopupMenu popupMenu;
    Font chineseFont = new Font("SimSun", Font.PLAIN, 14);
    public Converter() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("纳米");
        JMenuItem item2 = new JMenuItem("微米");
        JMenuItem item3 = new JMenuItem("毫米");
        JMenuItem item4 = new JMenuItem("厘米");
        JMenuItem item5 = new JMenuItem("米");
        JMenuItem item6 = new JMenuItem("公里");
        JMenuItem item7 = new JMenuItem("英寸");
        JMenuItem item8 = new JMenuItem("英尺");
        JMenuItem item9 = new JMenuItem("码");
        JMenuItem item10 = new JMenuItem("英里");
        JMenuItem item11 = new JMenuItem("海里");
        // 添加点击菜单项的事件监听器
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setText("Option 1");
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setText("Option 2");
            }
        });

        // 将菜单项添加到弹出菜单
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);
        popupMenu.add(item4);
        popupMenu.add(item5);
        popupMenu.add(item6);
        popupMenu.add(item7);
        popupMenu.add(item8);
        popupMenu.add(item9);
        popupMenu.add(item10);
        popupMenu.add(item11);
        popupMenu.show(button1, 0, button1.getHeight());
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        popupMenu = new JPopupMenu();

        JMenuItem item1 = new JMenuItem("纳米");
        JMenuItem item2 = new JMenuItem("微米");
        JMenuItem item3 = new JMenuItem("毫米");
        JMenuItem item4 = new JMenuItem("厘米");
        JMenuItem item5 = new JMenuItem("米");
        JMenuItem item6 = new JMenuItem("公里");
        JMenuItem item7 = new JMenuItem("英寸");
        JMenuItem item8 = new JMenuItem("英尺");
        JMenuItem item9 = new JMenuItem("码");
        JMenuItem item10 = new JMenuItem("英里");
        JMenuItem item11 = new JMenuItem("海里");

        // 添加点击菜单项的事件监听器
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                }
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                }
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                }
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                }
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText("Option 2");
            }
        });
        // 将菜单项添加到弹出菜单
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);
        popupMenu.add(item4);
        popupMenu.add(item5);
        popupMenu.add(item6);
        popupMenu.add(item7);
        popupMenu.add(item8);
        popupMenu.add(item9);
        popupMenu.add(item10);
        popupMenu.add(item11);

        popupMenu.show(button2, 0, button2.getHeight());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- button1 ----
        button1.setText("\u82f1\u5bf8");
        button1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 13));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        add(button1, "cell 2 4");

        //---- button2 ----
        button2.setText("\u5398\u7c73");
        button2.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 13));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        add(button2, "cell 2 14");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
