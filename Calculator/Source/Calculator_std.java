package Source;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/*
 * Created by JFormDesigner on Sat Nov 18 15:30:39 CST 2023
 */


/**
 * @author tonyzhan0514
 */
public class Calculator_std extends JFrame {
    public Calculator_std() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void button1MousePressed(MouseEvent e) {
        //System.out.println(e.getButton());
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "1";
            textField1.setText(str);
        }
    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "2";
            textField1.setText(str);
        }
    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "3";
            textField1.setText(str);
        }
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "4";
            textField1.setText(str);
        }
    }

    private void button5MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "5";
            textField1.setText(str);
        }
    }

    private void button6MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "6";
            textField1.setText(str);
        }
    }

    private void button7MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "7";
            textField1.setText(str);
        }
    }

    private void button8MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "8";
            textField1.setText(str);
        }
    }

    private void button9MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "9";
            textField1.setText(str);
        }
    }

    private void button0MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + "0";
            textField1.setText(str);
        }
    }

    private void textField1KeyPressed(KeyEvent e) {
        String str;
        str = textField1.getText();
        // TODO add your code here
        if (!str.equals("0")) {
            if (Utilities.Keycode_check_std(e.getKeyChar())&&Utilities.countDot(str)<1) {
                str = str + e.getKeyChar();
            } else if (Character.isDigit(e.getKeyChar())) {
                str = str + e.getKeyChar();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (!str.isEmpty()) {
                    str = str.substring(0, str.length() - 1);
                }
            }
        } else {
            if (Utilities.Keycode_check_std(e.getKeyChar()) && e.getKeyChar() != '0' && e.getKeyChar() != '.') {
                str = "" + e.getKeyChar();
            } else if (e.getKeyChar() == '.') {
                str = str + ".";
            }
        }
        if (str.isEmpty())
            str = "0";
        textField1.setText(str);
    }

    private void button_dotMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            str = str + ".";
            textField1.setText(str);
        }
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("Calculator/Resources/img/icon.png"); //图片和项目同一路径，故不用图片的路径
        this.setIconImage(icon.getImage());
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button0 = new JButton();
        button_dot = new JButton();
        button_polar = new JButton();
        button_upsidedown = new JButton();
        button_pow2 = new JButton();
        button_sqrt = new JButton();
        button_equal = new JButton();
        button_plus = new JButton();
        button_minus = new JButton();
        button_mul = new JButton();
        button_div = new JButton();
        button_percent = new JButton();
        button_cleanEntry = new JButton();
        button_clear = new JButton();
        button_smoke = new JButton();
        button_David = new JButton();
        button_backspace = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("  Calculator");
        setForeground(SystemColor.controlDkShadow);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.setAlignmentY(0.4736842F);
            menuBar1.setBorderPainted(false);
            menuBar1.setAutoscrolls(true);
            menuBar1.setMargin(null);
            menuBar1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //======== menu2 ========
            {
                menu2.setText("\u7c7b\u578b");
                menu2.setFont(new Font("\u5b8b\u4f53", menu2.getFont().getStyle() | Font.BOLD, 14));
                menu2.setBorderPainted(false);
                menu2.setAutoscrolls(true);
                menu2.setComponentPopupMenu(null);
                menu2.setMargin(new Insets(5, 5, 5, 5));

                //---- menuItem3 ----
                menuItem3.setText("\u6807\u51c6");
                menuItem3.setFont(new Font("\u5b8b\u4f53", menuItem3.getFont().getStyle() | Font.BOLD, menuItem3.getFont().getSize()));
                menuItem3.setPreferredSize(new Dimension(73, 22));
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u79d1\u5b66");
                menuItem4.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");
                menu1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 14));
                menu1.setMargin(new Insets(5, 5, 5, 5));

                //---- menuItem1 ----
                menuItem1.setText("\u6253\u5f00\u6587\u4ef6");
                menuItem1.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u4fdd\u5b58\u6587\u4ef6");
                menuItem2.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- textField1 ----
        textField1.setBorder(null);
        textField1.setHorizontalAlignment(SwingConstants.TRAILING);
        textField1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 28));
        textField1.setEditable(false);
        textField1.setBackground(Color.white);
        textField1.setText("0");
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textField1KeyPressed(e);
            }
        });
        contentPane.add(textField1);
        textField1.setBounds(40, 55, 460, 65);

        //---- button1 ----
        button1.setText("1");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.setFocusable(false);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(40, 310, 85, 40);

        //---- button2 ----
        button2.setText("2");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.setFocusable(false);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(130, 310, 85, 40);

        //---- button3 ----
        button3.setText("3");
        button3.setFont(new Font("Consolas", Font.PLAIN, 16));
        button3.setFocusable(false);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(220, 310, 85, 40);

        //---- button4 ----
        button4.setText("4");
        button4.setFont(new Font("Consolas", Font.PLAIN, 16));
        button4.setFocusable(false);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(40, 265, 85, 40);

        //---- button5 ----
        button5.setText("5");
        button5.setFont(new Font("Consolas", Font.PLAIN, 16));
        button5.setFocusable(false);
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button5MousePressed(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(130, 265, 85, 40);

        //---- button6 ----
        button6.setText("6");
        button6.setFont(new Font("Consolas", Font.PLAIN, 16));
        button6.setFocusable(false);
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button6MousePressed(e);
            }
        });
        contentPane.add(button6);
        button6.setBounds(220, 265, 85, 40);

        //---- button7 ----
        button7.setText("7");
        button7.setFont(new Font("Consolas", Font.PLAIN, 16));
        button7.setFocusable(false);
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button7MousePressed(e);
            }
        });
        contentPane.add(button7);
        button7.setBounds(40, 220, 85, 40);

        //---- button8 ----
        button8.setText("8");
        button8.setFont(new Font("Consolas", Font.PLAIN, 16));
        button8.setFocusable(false);
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button8MousePressed(e);
            }
        });
        contentPane.add(button8);
        button8.setBounds(130, 220, 85, 40);

        //---- button9 ----
        button9.setText("9");
        button9.setFont(new Font("Consolas", Font.PLAIN, 16));
        button9.setFocusable(false);
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button9MousePressed(e);
            }
        });
        contentPane.add(button9);
        button9.setBounds(220, 220, 85, 40);

        //---- button0 ----
        button0.setText("0");
        button0.setFont(new Font("Consolas", Font.PLAIN, 16));
        button0.setFocusable(false);
        button0.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button0MousePressed(e);
            }
        });
        contentPane.add(button0);
        button0.setBounds(130, 355, 85, 40);

        //---- button_dot ----
        button_dot.setText(".");
        button_dot.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_dot.setFocusable(false);
        button_dot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_dotMousePressed(e);
            }
        });
        contentPane.add(button_dot);
        button_dot.setBounds(220, 355, 85, 40);

        //---- button_polar ----
        button_polar.setText("+/-");
        button_polar.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_polar.setFocusable(false);
        contentPane.add(button_polar);
        button_polar.setBounds(40, 355, 85, 40);

        //---- button_upsidedown ----
        button_upsidedown.setText("1/x");
        button_upsidedown.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_upsidedown.setFocusable(false);
        contentPane.add(button_upsidedown);
        button_upsidedown.setBounds(40, 175, 85, 40);

        //---- button_pow2 ----
        button_pow2.setText("x^2");
        button_pow2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_pow2.setFocusable(false);
        contentPane.add(button_pow2);
        button_pow2.setBounds(130, 175, 85, 40);

        //---- button_sqrt ----
        button_sqrt.setText("\u221ax");
        button_sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_sqrt.setFocusable(false);
        contentPane.add(button_sqrt);
        button_sqrt.setBounds(220, 175, 85, 40);

        //---- button_equal ----
        button_equal.setText("=");
        button_equal.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_equal.setFocusable(false);
        contentPane.add(button_equal);
        button_equal.setBounds(310, 355, 85, 40);

        //---- button_plus ----
        button_plus.setText("+");
        button_plus.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_plus.setFocusable(false);
        contentPane.add(button_plus);
        button_plus.setBounds(310, 310, 85, 40);

        //---- button_minus ----
        button_minus.setText("-");
        button_minus.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_minus.setFocusable(false);
        contentPane.add(button_minus);
        button_minus.setBounds(310, 265, 85, 40);

        //---- button_mul ----
        button_mul.setText("\u00d7");
        button_mul.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_mul.setFocusable(false);
        contentPane.add(button_mul);
        button_mul.setBounds(310, 220, 85, 40);

        //---- button_div ----
        button_div.setText("\u00f7");
        button_div.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_div.setFocusable(false);
        contentPane.add(button_div);
        button_div.setBounds(310, 175, 85, 40);

        //---- button_percent ----
        button_percent.setText("%");
        button_percent.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_percent.setFocusable(false);
        contentPane.add(button_percent);
        button_percent.setBounds(40, 130, 85, 40);

        //---- button_cleanEntry ----
        button_cleanEntry.setText("CE");
        button_cleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_cleanEntry.setFocusable(false);
        contentPane.add(button_cleanEntry);
        button_cleanEntry.setBounds(130, 130, 85, 40);

        //---- button_clear ----
        button_clear.setText("C");
        button_clear.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_clear.setFocusable(false);
        button_clear.setAlignmentY(0.0F);
        contentPane.add(button_clear);
        button_clear.setBounds(220, 130, 85, 40);

        //---- button_smoke ----
        button_smoke.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_smoke.setIcon(new ImageIcon(getClass().getResource("/Resources/img/smoke.png")));
        button_smoke.setFocusable(false);
        contentPane.add(button_smoke);
        button_smoke.setBounds(400, 265, 100, 130);

        //---- button_David ----
        button_David.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_David.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
        button_David.setFocusable(false);
        contentPane.add(button_David);
        button_David.setBounds(400, 130, 100, 130);

        //---- button_backspace ----
        button_backspace.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_backspace.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        button_backspace.setFocusable(false);
        contentPane.add(button_backspace);
        button_backspace.setBounds(310, 130, 85, 40);

        //---- label1 ----
        label1.setText("123");
        label1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), "Last Step", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
            new Font("Consolas", Font.BOLD | Font.ITALIC, 12)));
        label1.setHorizontalAlignment(SwingConstants.TRAILING);
        label1.setFont(new Font("Consolas", Font.PLAIN, 18));
        label1.setForeground(Color.darkGray);
        label1.setRequestFocusEnabled(false);
        contentPane.add(label1);
        label1.setBounds(40, 10, 460, 40);

        contentPane.setPreferredSize(new Dimension(570, 465));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton button_dot;
    private JButton button_polar;
    private JButton button_upsidedown;
    private JButton button_pow2;
    private JButton button_sqrt;
    private JButton button_equal;
    private JButton button_plus;
    private JButton button_minus;
    private JButton button_mul;
    private JButton button_div;
    private JButton button_percent;
    private JButton button_cleanEntry;
    private JButton button_clear;
    private JButton button_smoke;
    private JButton button_David;
    private JButton button_backspace;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
