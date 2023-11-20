package Source;

import Source.Tools.FourArithmetic;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
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
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "1";
                } else {
                    str = str + "1";
                }
            } else {
                str = "1";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "2";
                } else {
                    str = str + "2";
                }
            } else {
                str = "2";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "3";
                } else {
                    str = str + "3";
                }
            } else {
                str = "3";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "4";
                } else {
                    str = str + "4";
                }
            } else {
                str = "4";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button5MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "5";
                } else {
                    str = str + "5";
                }
            } else {
                str = "5";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button6MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "6";
                } else {
                    str = str + "6";
                }
            } else {
                str = "6";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button7MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "7";
                } else {
                    str = str + "7";
                }
            } else {
                str = "7";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button8MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "8";
                } else {
                    str = str + "8";
                }
            } else {
                str = "8";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button9MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "9";
                } else {
                    str = str + "9";
                }
            } else {
                str = "9";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private void button0MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (lastOperation == 0) {
                if (str.equals("0")) {
                    str = "0";
                } else {
                    str = str + "0";
                }
            } else {
                str = "0";
            }
            textField1.setText(str);
            lastOperation = 0;
        }
    }

    private int lastOperation;
    private void button_backspaceMousePressed(MouseEvent e) {

    }
    private void button_equalMousePressed(MouseEvent e) {
        String str;
        str = textField1.getText();

        String str_last;
        str_last=Utilities.stdNum(label1.getText());
        if (lastOperation == 1) {
            // equal
            return;
        } else if (lastOperation == 0) {
            // number
            str=Utilities.stdNum(str);
            String s=str_last+" "+str;
            BigDecimal bd=FourArithmetic.calculate(s);
            if (bd != null) {
                label1.setText(s+" = ");
            }else{
                label1.setText(str+" = ");
            }
            str= String.valueOf(bd);
            textField1.setText(str);
        }
        lastOperation = 1;
    }
    private void button_plusMousePressed(MouseEvent e) {
        String str_last;
        str_last=Utilities.stdNum(textField1.getText())+" +";
        label1.setText(str_last);
        pending_cal_toClear=true;
        lastOperation = 2;
    }
    private void button_minusMousePressed(MouseEvent e) {
        String str_last;
        str_last=Utilities.stdNum(textField1.getText())+" -";
        label1.setText(str_last);
        pending_cal_toClear=true;
        lastOperation = 3;
    }
    private void button_mulMousePressed(MouseEvent e) {
        String str_last;
        str_last=Utilities.stdNum(textField1.getText())+" *";
        label1.setText(str_last);
        pending_cal_toClear=true;
        lastOperation = 4;
    }
    private void button_divMousePressed(MouseEvent e) {
        String str_last;
        str_last=Utilities.stdNum(textField1.getText())+" /";
        label1.setText(str_last);
        pending_cal_toClear=true;
        lastOperation = 5;
    }
    private boolean pending_cal_toClear=false;
    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
        String str;
        str = textField1.getText();

        String str_last;
        str_last=Utilities.stdNum(label1.getText());

        if(Utilities.KeycodeEqual_check(e.getKeyCode())){
            str=Utilities.stdNum(str);
            String s=str_last+" "+str;
            BigDecimal bd=FourArithmetic.calculate(s);
            if (bd != null) {
                label1.setText(s+" = "+bd);
            }else{
                label1.setText(str+" = "+str);
            }
            str="0";
        }
        else if(Utilities.KeycodeCal_check_std(e.getKeyChar())){
            str_last=Utilities.stdNum(textField1.getText())+" "+e.getKeyChar();
            label1.setText(str_last);
            pending_cal_toClear=true;
        }
        else {
            if (pending_cal_toClear&&(Utilities.KeycodeNum_check_std(e.getKeyChar())||Utilities.KeycodeCal_check_std(e.getKeyChar()))){
                str="";
                pending_cal_toClear=false;
            }
            if(!str.equals("0")) {
                if (Utilities.KeycodeNum_check_std(e.getKeyChar())&&Utilities.countDot(str)<1) {
                    str = str + e.getKeyChar();
                } else if (Character.isDigit(e.getKeyChar())) {
                    str = str + e.getKeyChar();
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (!str.isEmpty()) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } else {
                if (Utilities.KeycodeNum_check_std(e.getKeyChar()) && e.getKeyChar() != '0' && e.getKeyChar() != '.') {
                    str = "" + e.getKeyChar();
                } else if (e.getKeyChar() == '.') {
                    str = str + ".";
                }
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
    /**
     * @Description method
     * @param e
     * @author yury
     * @date 2023/11/20 16:14
     */
    private void radioButtonMenuItem1(ActionEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
        cardLayout.show(mainPanel, "card1");
    }

    private void radioButtonMenuItem2(ActionEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
        cardLayout.show(mainPanel, "card2");
    }

    private void radioButtonMenuItem3(ActionEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
        cardLayout.show(mainPanel, "card3");
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("Calculator/Resources/img/icon.png"); //图片和项目同一路径，故不用图片的路径
        this.setIconImage(icon.getImage());
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu2 = new JMenu();

        radioButtonMenuItem1 = new JRadioButtonMenuItem();
        radioButtonMenuItem2 = new JRadioButtonMenuItem();
        radioButtonMenuItem3 = new JRadioButtonMenuItem();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        mainPanel = new JPanel();
        card1 = new JPanel();
        button_smoke = new JButton();
        button_David = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        button_backspace = new JButton();
        button_percent = new JButton();
        button_polar = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button0 = new JButton();
        button_dot = new JButton();
        button_equal = new JButton();
        button3 = new JButton();
        button_plus = new JButton();
        button_minus = new JButton();
        button6 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button7 = new JButton();
        button_upsidedown = new JButton();
        button8 = new JButton();
        button_pow2 = new JButton();
        button9 = new JButton();
        button_mul = new JButton();
        button_div = new JButton();
        button_sqrt = new JButton();
        button_clear = new JButton();
        button_cleanEntry = new JButton();
        label2 = new JLabel();
        card2 = new JPanel();
        label3 = new JLabel();
        card3 = new JPanel();
        label4 = new JLabel();


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


                //---- radioButtonMenuItem1 ----
                radioButtonMenuItem1.setText("\u6807\u51c6");
                radioButtonMenuItem1.setSelected(true);
                radioButtonMenuItem1.addActionListener(e -> radioButtonMenuItem1(e));
                menu2.add(radioButtonMenuItem1);

                //---- radioButtonMenuItem2 ----
                radioButtonMenuItem2.setText("\u79d1\u5b66");
                radioButtonMenuItem2.addActionListener(e -> radioButtonMenuItem2(e));
                menu2.add(radioButtonMenuItem2);

                //---- radioButtonMenuItem3 ----
                radioButtonMenuItem3.setText("\u79ef\u5206");
                radioButtonMenuItem3.addActionListener(e -> radioButtonMenuItem3(e));
                menu2.add(radioButtonMenuItem3);

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

        //======== mainPanel ========
        {
            mainPanel.setLayout(new CardLayout());

            //======== card1 ========
            {
                card1.setLayout(null);

                //---- button_smoke ----
                button_smoke.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_smoke.setIcon(new ImageIcon(getClass().getResource("/Resources/img/smoke.png")));
                button_smoke.setFocusable(false);
                card1.add(button_smoke);
                button_smoke.setBounds(405, 305, 100, 130);

                //---- button_David ----
                button_David.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_David.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
                button_David.setFocusable(false);
                card1.add(button_David);
                button_David.setBounds(405, 170, 100, 130);

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
                card1.add(textField1);
                textField1.setBounds(45, 95, 460, 65);

                //---- label1 ----
                label1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), "Last Step", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Consolas", Font.BOLD | Font.ITALIC, 12)));
                label1.setHorizontalAlignment(SwingConstants.TRAILING);
                label1.setFont(new Font("Consolas", Font.PLAIN, 18));
                label1.setForeground(Color.darkGray);
                label1.setRequestFocusEnabled(false);
                card1.add(label1);
                label1.setBounds(45, 50, 460, 40);

                //---- button_backspace ----
                button_backspace.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_backspace.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
                button_backspace.setFocusable(false);
                button_backspace.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_backspaceMousePressed(e);
                    }
                });
                card1.add(button_backspace);
                button_backspace.setBounds(315, 170, 85, 40);

                //---- button_percent ----
                button_percent.setText("%");
                button_percent.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_percent.setFocusable(false);
                card1.add(button_percent);
                button_percent.setBounds(45, 170, 85, 40);

                //---- button_polar ----
                button_polar.setText("+/-");
                button_polar.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_polar.setFocusable(false);
                card1.add(button_polar);
                button_polar.setBounds(45, 395, 85, 40);

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
                card1.add(button1);
                button1.setBounds(45, 350, 85, 40);

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
                card1.add(button2);
                button2.setBounds(135, 350, 85, 40);

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
                card1.add(button0);
                button0.setBounds(135, 395, 85, 40);

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
                card1.add(button_dot);
                button_dot.setBounds(225, 395, 85, 40);

                //---- button_equal ----
                button_equal.setText("=");
                button_equal.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_equal.setFocusable(false);
                button_equal.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_equalMousePressed(e);
                    }
                });
                card1.add(button_equal);
                button_equal.setBounds(315, 395, 85, 40);

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
                card1.add(button3);
                button3.setBounds(225, 350, 85, 40);

                //---- button_plus ----
                button_plus.setText("+");
                button_plus.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_plus.setFocusable(false);
                button_plus.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_plusMousePressed(e);
                    }
                });
                card1.add(button_plus);
                button_plus.setBounds(315, 350, 85, 40);

                //---- button_minus ----
                button_minus.setText("-");
                button_minus.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_minus.setFocusable(false);
                button_minus.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_minusMousePressed(e);
                    }
                });
                card1.add(button_minus);
                button_minus.setBounds(315, 305, 85, 40);

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
                card1.add(button6);
                button6.setBounds(225, 305, 85, 40);

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
                card1.add(button5);
                button5.setBounds(135, 305, 85, 40);

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
                card1.add(button4);
                button4.setBounds(45, 305, 85, 40);

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
                card1.add(button7);
                button7.setBounds(45, 260, 85, 40);

                //---- button_upsidedown ----
                button_upsidedown.setText("1/x");
                button_upsidedown.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_upsidedown.setFocusable(false);
                card1.add(button_upsidedown);
                button_upsidedown.setBounds(45, 215, 85, 40);

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
                card1.add(button8);
                button8.setBounds(135, 260, 85, 40);

                //---- button_pow2 ----
                button_pow2.setText("x^2");
                button_pow2.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_pow2.setFocusable(false);
                card1.add(button_pow2);
                button_pow2.setBounds(135, 215, 85, 40);

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
                card1.add(button9);
                button9.setBounds(225, 260, 85, 40);

                //---- button_mul ----
                button_mul.setText("\u00d7");
                button_mul.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_mul.setFocusable(false);
                button_mul.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_mulMousePressed(e);
                    }
                });
                card1.add(button_mul);
                button_mul.setBounds(315, 260, 85, 40);

                //---- button_div ----
                button_div.setText("\u00f7");
                button_div.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_div.setFocusable(false);
                button_div.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_divMousePressed(e);
                    }
                });
                card1.add(button_div);
                button_div.setBounds(315, 215, 85, 40);

                //---- button_sqrt ----
                button_sqrt.setText("\u221ax");
                button_sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_sqrt.setFocusable(false);
                card1.add(button_sqrt);
                button_sqrt.setBounds(225, 215, 85, 40);

                //---- button_clear ----
                button_clear.setText("C");
                button_clear.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_clear.setFocusable(false);
                button_clear.setAlignmentY(0.0F);
                card1.add(button_clear);
                button_clear.setBounds(225, 170, 85, 40);

                //---- button_cleanEntry ----
                button_cleanEntry.setText("CE");
                button_cleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_cleanEntry.setFocusable(false);
                card1.add(button_cleanEntry);
                button_cleanEntry.setBounds(135, 170, 85, 40);

                //---- label2 ----
                label2.setText("\u6807\u51c6\u8ba1\u7b97\u5668");
                label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
                card1.add(label2);
                label2.setBounds(10, 10, 95, 30);
            }
            mainPanel.add(card1, "card1");

            //======== card2 ========
            {
                card2.setLayout(null);

                //---- label3 ----
                label3.setText("\u79d1\u5b66\u8ba1\u7b97\u5668");
                label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
                card2.add(label3);
                label3.setBounds(10, 10, 95, 30);
            }
            mainPanel.add(card2, "card2");

            //======== card3 ========
            {
                card3.setLayout(null);

                //---- label4 ----
                label4.setText("\u79ef\u5206\u8ba1\u7b97\u5668");
                label4.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
                card3.add(label4);
                label4.setBounds(10, 10, 95, 30);
            }
            mainPanel.add(card3, "card3");
        }
        contentPane.add(mainPanel);
        mainPanel.setBounds(0, 0, 583, 508);

        contentPane.setPreferredSize(new Dimension(585, 565));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButtonMenuItem1);
        buttonGroup1.add(radioButtonMenuItem2);
        buttonGroup1.add(radioButtonMenuItem3);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu2;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JRadioButtonMenuItem radioButtonMenuItem3;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JPanel mainPanel;
    private JPanel card1;
    private JButton button_smoke;
    private JButton button_David;
    private JTextField textField1;
    private JLabel label1;
    private JButton button_backspace;
    private JButton button_percent;
    private JButton button_polar;
    private JButton button1;
    private JButton button2;
    private JButton button0;
    private JButton button_dot;
    private JButton button_equal;
    private JButton button3;
    private JButton button_plus;
    private JButton button_minus;
    private JButton button6;
    private JButton button5;
    private JButton button4;
    private JButton button7;
    private JButton button_upsidedown;
    private JButton button8;
    private JButton button_pow2;
    private JButton button9;
    private JButton button_mul;
    private JButton button_div;
    private JButton button_sqrt;
    private JButton button_clear;
    private JButton button_cleanEntry;
    private JLabel label2;
    private JPanel card2;
    private JLabel label3;
    private JPanel card3;
    private JLabel label4;

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
