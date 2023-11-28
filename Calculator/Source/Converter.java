/*
 * Created by JFormDesigner on Mon Nov 27 23:43:35 CST 2023
 */
// -*- coding: utf-8 -*-
package Source;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;

import static Source.Tools.LengthConverter.getLengthConversion;

/**
 * @author 王海峰
 */
public class Converter extends JPanel {
    private JPopupMenu popupMenu;
    private String originUnit = null, changeUnit = null;
    public Converter() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("nm");
        JMenuItem item2 = new JMenuItem("um");
        JMenuItem item3 = new JMenuItem("mm");
        JMenuItem item4 = new JMenuItem("cm");
        JMenuItem item5 = new JMenuItem("m");
        JMenuItem item6 = new JMenuItem("km");
        JMenuItem item7 = new JMenuItem("in");
        JMenuItem item8 = new JMenuItem("ft");
        JMenuItem item9 = new JMenuItem("yd");
        JMenuItem item10 = new JMenuItem("mi");
        JMenuItem item11 = new JMenuItem("nm");
        // 添加点击菜单项的事件监听器
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    originUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button1.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
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
        JMenuItem item1 = new JMenuItem("nm");
        JMenuItem item2 = new JMenuItem("um");
        JMenuItem item3 = new JMenuItem("mm");
        JMenuItem item4 = new JMenuItem("cm");
        JMenuItem item5 = new JMenuItem("m");
        JMenuItem item6 = new JMenuItem("km");
        JMenuItem item7 = new JMenuItem("in");
        JMenuItem item8 = new JMenuItem("ft");
        JMenuItem item9 = new JMenuItem("yd");
        JMenuItem item10 = new JMenuItem("mi");
        JMenuItem item11 = new JMenuItem("nm");

        // 添加点击菜单项的事件监听器
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem sourceItem = (JMenuItem) e.getSource();
                    button2.setText(sourceItem.getText());
                    changeUnit = sourceItem.getText();
                    textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
                }
            }
        });
        textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
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

    private void textField1KeyReleased() {
        // TODO add your code here
        if(originUnit == null || changeUnit == null) {
            originUnit = button1.getText();
            changeUnit = button2.getText();
        }
        textArea1.setText(getLengthConversion(textField1.getText(), originUnit, changeUnit));
    }

    private void textField1(ActionEvent e) {
        // TODO add your code here
    }

    private void textField1InputMethodTextChanged(InputMethodEvent e) {
        // TODO add your code here
    }

    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
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
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
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

        //======== scrollPane1 ========
        {

            //---- textField1 ----
            textField1.addActionListener(e -> textField1(e));
            textField1.addInputMethodListener(new InputMethodListener() {
                @Override
                public void caretPositionChanged(InputMethodEvent e) {}
                @Override
                public void inputMethodTextChanged(InputMethodEvent e) {
                    textField1InputMethodTextChanged(e);
                }
            });
            textField1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    textField1KeyPressed(e);
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    textField1KeyReleased();
                }
            });
            scrollPane1.setViewportView(textField1);
        }
        add(scrollPane1, "cell 3 0 21 4");

        //---- button1 ----
        button1.setText("km");
        originUnit = button1.getText();
        button1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 13));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        add(button1, "cell 11 8 5 3");

        //======== scrollPane2 ========

        add(textArea1, "cell 2 19 21 5");
        textArea1.setEditable(false); // 设置为不可编辑
        //---- button2 ----
        button2.setText("m");
        originUnit = button2.getText();
        button2.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 13));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        add(button2, "cell 10 27 4 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
