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
 * use JFormDesigner to build the frame.
 *
 * @author tonyzhan0514 and Yury.
 */
public class Calculator_std extends JFrame {
    public Calculator_std() {
        initComponents();
    }


    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    /**
     * all the UI design and robot issues
     *
     * @author TonyZhan
     */
    private void button1MousePressed(MouseEvent e) {
        //System.out.println(e.getButton());
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_1);
        }
    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_2);
        }
    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_3);
        }
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_4);
        }
    }

    private void button5MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_5);
        }
    }

    private void button6MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_6);
        }
    }

    private void button7MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_7);
        }
    }

    private void button8MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_8);
        }
    }

    private void button9MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_9);
        }
    }

    private void button0MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_0);
        }
    }

    private void button_dotMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_PERIOD);
        }
    }

    private void button_backspaceMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
        }
    }

    private void button_divMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_DIVIDE);
        }
    }

    private void button_mulMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MULTIPLY);
        }
    }

    private void button_minusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MINUS);
        }
    }

    private void button_plusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ADD);
        }
    }

    private void button_equalMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }

    private void button_clearMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ESCAPE);
        }
    }

    private void button_cleanEntryMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_DELETE);
        }
    }

    /**
     * judge whether the textField1 should be cleared.
     */
    private boolean pending_cal_toClear = false;
    /**
     * judge the multiple consecutive calculate.
     */
    private boolean newNum = false;
    /**
     * judge whether consecutive equal
     */
    private boolean OnceEqual = false;
    /**
     * save the consecutive equal number
     */
    private String OnceEqualConst;

    /**
     * update the textField1 and label1, depending on the input logic
     *
     * @param e the KeyEvent.
     * @author TonyZhan
     */
    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
        String str_last = Utilities.PureNumberWithoutArithmetics(label1.getText());
        String str_arithmetic = Utilities.PureArithmetic(label1.getText().replace(str_last, ""));
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        if (Utilities.KeycodeNum_check_std(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (OnceEqual) {
                label1.setText("");
                textField1.setText("");
                OnceEqual = false;
            }
            if (!pending_cal_toClear)
                InputNumber(e);
            else {
                textField1.setText("");
                InputNumber(e);
                pending_cal_toClear = false;
            }
            newNum = true;
        } else if (Utilities.KeycodeCal_check_std(e.getKeyChar()) && (!newNum || str_last.isEmpty())) {
            label1.setText(str_now + " " + e.getKeyChar() + " ");
            pending_cal_toClear = true;
            newNum = false;
            OnceEqual = false;
        } else if (Utilities.KeycodeCal_check_std(e.getKeyChar()) && newNum) {
            //TODO yunsuan
            BigDecimal ans = FourArithmetic.calculatePlain(str_last, str_arithmetic, str_now);
            if (ans != null) {
                label1.setText(ans.toPlainString() + " " + e.getKeyChar() + " ");
                textField1.setText(ans.toPlainString());
            }
            newNum = false;
            pending_cal_toClear = true;
            OnceEqual = false;
        } else if (Utilities.KeycodeEqual_check(e.getKeyCode()) && !OnceEqual) {
            BigDecimal ans = FourArithmetic.calculatePlain(str_last, str_arithmetic, str_now);
            if (ans != null) {
                label1.setText(str_last + " " + str_arithmetic + " " + str_now + " = " + ans.toPlainString());
                textField1.setText(ans.toPlainString());
            }
            newNum = false;
            pending_cal_toClear = true;
            OnceEqual = true;
            OnceEqualConst = str_now;
        } else if (Utilities.KeycodeEqual_check(e.getKeyCode()) && OnceEqual) {
            BigDecimal ans = FourArithmetic.calculatePlain(str_now, str_arithmetic, OnceEqualConst);
            if (ans != null) {
                label1.setText(str_now + " " + str_arithmetic + " " + OnceEqualConst + " = " + ans.toPlainString());
                textField1.setText(ans.toPlainString());
            }
            newNum = false;
            pending_cal_toClear = true;
            OnceEqual = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            label1.setText("");
            textField1.setText("0");
        } else if(e.getKeyCode() == KeyEvent.VK_DELETE){
            textField1.setText("0");
        }
    }

    public void InputNumber(KeyEvent e) {
        String nowInput = textField1.getText();
        if (!nowInput.equals("0")) {
            //无前导0，输入数字
            if (Utilities.KeycodeNum_check_std(e.getKeyChar()) && Utilities.countDot(nowInput) < 1) {
                nowInput = nowInput + e.getKeyChar();
            } else if (Character.isDigit(e.getKeyChar())) {
                nowInput = nowInput + e.getKeyChar();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (!nowInput.isEmpty()) {
                    nowInput = nowInput.substring(0, nowInput.length() - 1);
                }
            }
        } else {
            if (Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '0') {
                nowInput = "" + e.getKeyChar();
            } else if (e.getKeyChar() == '.') {
                nowInput = nowInput + ".";
            }
        }
        if (nowInput.isEmpty())
            nowInput = "0";
        textField1.setText(nowInput);
    }

    private void button_polarMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String str = textField1.getText();
            if (!str.equals("0")) {
                if (str.charAt(0) == '-') {
                    str = str.substring(1);
                } else {
                    str = "-" + str;
                }
            }
            textField1.setText(str);
        }
    }

    private void button_percentMousePressed(MouseEvent e) {
        // TODO add your code here
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());

        BigDecimal ans = FourArithmetic.calculatePlain(str_now, "*", "0.01");
        if (ans != null) {
            label1.setText(str_now + " " + "*" + " " + "0.01" + " = " + ans.toPlainString());
            textField1.setText(ans.toPlainString());
        }
        newNum = false;
        pending_cal_toClear = true;
        OnceEqual = true;
    }
    /**
     * @Description 页面切换监听器
     * @param e
     * @author yury
     * @date 2023/11/20 17:18
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
        panel1 = new JPanel();
        scrollPane4 = new JScrollPane();
        label1 = new JLabel();
        scrollPane3 = new JScrollPane();
        textField1 = new JTextField();
        button_backspace = new JButton();
        button_David = new JButton();
        button_smoke = new JButton();
        button_clear = new JButton();
        button_cleanEntry = new JButton();
        button_percent = new JButton();
        button_div = new JButton();
        button_mul = new JButton();
        button_minus = new JButton();
        button_plus = new JButton();
        button_equal = new JButton();
        button_sqrt = new JButton();
        button_pow2 = new JButton();
        button_upsidedown = new JButton();
        button_polar = new JButton();
        button_dot = new JButton();
        button0 = new JButton();
        button9 = new JButton();
        button8 = new JButton();
        button7 = new JButton();
        button6 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        button2 = new JButton();
        button1 = new JButton();
        label2 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        panel3 = new JPanel();
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

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //======== scrollPane4 ========
                {

                    //---- label1 ----
                    label1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), "Last Step", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Consolas", Font.BOLD | Font.ITALIC, 14)));
                    label1.setFont(new Font("Consolas", Font.PLAIN, 18));
                    label1.setForeground(Color.darkGray);
                    label1.setRequestFocusEnabled(false);
                    label1.setHorizontalAlignment(SwingConstants.TRAILING);
                    scrollPane4.setViewportView(label1);
                }
                panel1.add(scrollPane4);
                scrollPane4.setBounds(35, 55, 560, 70);

                //======== scrollPane3 ========
                {

                    //---- textField1 ----
                    textField1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "Now Step", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Consolas", Font.BOLD | Font.ITALIC, 14)));
                    textField1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 28));
                    textField1.setBackground(new Color(0xf0f0f0));
                    textField1.setText("0");
                    textField1.setAutoscrolls(false);
                    textField1.setHorizontalAlignment(SwingConstants.TRAILING);
                    textField1.setEditable(false);
                    textField1.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            textField1KeyPressed(e);
                        }
                    });
                    scrollPane3.setViewportView(textField1);
                }
                panel1.add(scrollPane3);
                scrollPane3.setBounds(35, 145, 560, 80);

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
                panel1.add(button_backspace);
                button_backspace.setBounds(375, 240, 100, 50);

                //---- button_David ----
                button_David.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_David.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
                button_David.setFocusable(false);
                panel1.add(button_David);
                button_David.setBounds(485, 240, 100, 170);

                //---- button_smoke ----
                button_smoke.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_smoke.setIcon(new ImageIcon(getClass().getResource("/Resources/img/smoke.png")));
                button_smoke.setFocusable(false);
                panel1.add(button_smoke);
                button_smoke.setBounds(485, 420, 100, 170);

                //---- button_clear ----
                button_clear.setText("C");
                button_clear.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_clear.setFocusable(false);
                button_clear.setAlignmentY(0.0F);
                button_clear.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_clearMousePressed(e);
                    }
                });
                panel1.add(button_clear);
                button_clear.setBounds(265, 240, 100, 50);

                //---- button_cleanEntry ----
                button_cleanEntry.setText("CE");
                button_cleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_cleanEntry.setFocusable(false);
                button_cleanEntry.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_cleanEntryMousePressed(e);
                    }
                });
                panel1.add(button_cleanEntry);
                button_cleanEntry.setBounds(155, 240, 100, 50);

                //---- button_percent ----
                button_percent.setText("%");
                button_percent.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_percent.setFocusable(false);
                button_percent.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_percentMousePressed(e);
                    }
                });
                panel1.add(button_percent);
                button_percent.setBounds(45, 240, 100, 50);

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
                panel1.add(button_div);
                button_div.setBounds(375, 300, 100, 50);

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
                panel1.add(button_mul);
                button_mul.setBounds(375, 360, 100, 50);

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
                panel1.add(button_minus);
                button_minus.setBounds(375, 420, 100, 50);

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
                panel1.add(button_plus);
                button_plus.setBounds(375, 480, 100, 50);

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
                panel1.add(button_equal);
                button_equal.setBounds(375, 540, 100, 50);

                //---- button_sqrt ----
                button_sqrt.setText("\u221ax");
                button_sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_sqrt.setFocusable(false);
                panel1.add(button_sqrt);
                button_sqrt.setBounds(265, 300, 100, 50);

                //---- button_pow2 ----
                button_pow2.setText("x^2");
                button_pow2.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_pow2.setFocusable(false);
                panel1.add(button_pow2);
                button_pow2.setBounds(155, 300, 100, 50);

                //---- button_upsidedown ----
                button_upsidedown.setText("1/x");
                button_upsidedown.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_upsidedown.setFocusable(false);
                panel1.add(button_upsidedown);
                button_upsidedown.setBounds(45, 300, 100, 50);

                //---- button_polar ----
                button_polar.setText("+/-");
                button_polar.setFont(new Font("Consolas", Font.PLAIN, 16));
                button_polar.setFocusable(false);
                button_polar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_polarMousePressed(e);
                    }
                });
                panel1.add(button_polar);
                button_polar.setBounds(45, 540, 100, 50);

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
                panel1.add(button_dot);
                button_dot.setBounds(265, 540, 100, 50);

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
                panel1.add(button0);
                button0.setBounds(155, 540, 100, 50);

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
                panel1.add(button9);
                button9.setBounds(265, 360, 100, 50);

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
                panel1.add(button8);
                button8.setBounds(155, 360, 100, 50);

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
                panel1.add(button7);
                button7.setBounds(45, 360, 100, 50);

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
                panel1.add(button6);
                button6.setBounds(265, 420, 100, 50);

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
                panel1.add(button5);
                button5.setBounds(155, 420, 100, 50);

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
                panel1.add(button4);
                button4.setBounds(45, 420, 100, 50);

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
                panel1.add(button3);
                button3.setBounds(265, 480, 100, 50);

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
                panel1.add(button2);
                button2.setBounds(155, 480, 100, 50);

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
                panel1.add(button1);
                button1.setBounds(45, 480, 100, 50);

                //---- label2 ----
                label2.setText("\u6807\u51c6");
                label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                panel1.add(label2);
                label2.setBounds(new Rectangle(new Point(15, 15), label2.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(panel1, "card1");

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //---- label3 ----
                label3.setText("\u79d1\u5b66");
                label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                panel2.add(label3);
                label3.setBounds(15, 15, 34, 17);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(panel2, "card2");

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //---- label4 ----
                label4.setText("\u79ef\u5206");
                label4.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                panel3.add(label4);
                label4.setBounds(15, 15, 34, 17);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(panel3, "card3");
        }
        contentPane.add(mainPanel);
        mainPanel.setBounds(0, 0, 638, 668);

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
    private JPanel panel1;
    private JScrollPane scrollPane4;
    private JLabel label1;
    private JScrollPane scrollPane3;
    private JTextField textField1;
    private JButton button_backspace;
    private JButton button_David;
    private JButton button_smoke;
    private JButton button_clear;
    private JButton button_cleanEntry;
    private JButton button_percent;
    private JButton button_div;
    private JButton button_mul;
    private JButton button_minus;
    private JButton button_plus;
    private JButton button_equal;
    private JButton button_sqrt;
    private JButton button_pow2;
    private JButton button_upsidedown;
    private JButton button_polar;
    private JButton button_dot;
    private JButton button0;
    private JButton button9;
    private JButton button8;
    private JButton button7;
    private JButton button6;
    private JButton button5;
    private JButton button4;
    private JButton button3;
    private JButton button2;
    private JButton button1;
    private JLabel label2;
    private JPanel panel2;
    private JLabel label3;
    private JPanel panel3;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
