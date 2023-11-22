package Source;

import Source.Tools.FourArithmetic;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;
import java.math.MathContext;
import javax.sound.sampled.*;
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
public class Calculator_std extends JPanel implements Calculator{
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
     * to reverse the polar of a number
     *
     * @param e a mouse listener
     * @author TonyZhan
     */
    private void button_polarMousePressed(MouseEvent e) {
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        String str_equal = Utilities.PureEqual(label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans = new BigDecimal(str_now).negate();
            if (!str_equal.isEmpty() || label1.getText().isEmpty()) {
                label1.setText("negate" + "(" + str_now + ")" + " = " + ans.toPlainString());
                textField1.setText(ans.toPlainString());
                newNum = false;
                pending_cal_toClear = true;
                OnceEqual = true;
            } else {
                textField1.setText(ans.toPlainString());
            }
        }
    }

    /**
     * to do percentage algorithm
     *
     * @param e a mouse listener
     * @author TonyZhan
     */
    private void button_percentMousePressed(MouseEvent e) {
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        String str_equal = Utilities.PureEqual(label1.getText());
        System.out.println(str_equal);
        // TODO add your code here
        if (e.getButton() == 1) {
            BigDecimal ans = FourArithmetic.calculatePlain(str_now, "*", "0.01");
            if (!str_equal.isEmpty() || label1.getText().isEmpty()) {
                if (ans != null) {
                    label1.setText(str_now + " " + "*" + " " + "0.01" + " = " + ans.toPlainString());
                    textField1.setText(ans.toPlainString());
                }
                newNum = false;
                pending_cal_toClear = true;
                OnceEqual = true;
            } else {
                if (ans != null) {
                    textField1.setText(ans.toPlainString());
                }
            }
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
    private boolean error = false;

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
        if (!error) {
            if (Utilities.KeycodeNum_check_std(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (OnceEqual) {
                    label1.setText("");
                    textField1.setText("0");
                    InputNumber(e);
                    OnceEqual = false;
                    pending_cal_toClear = false;
                } else if (!pending_cal_toClear) InputNumber(e);
                else {
                    textField1.setText("");
                    InputNumber(e);
                    pending_cal_toClear = false;
                }
                newNum = true;
            } else if ((Utilities.KeycodeCal_check_std(e.getKeyChar()) && (!newNum || str_last.isEmpty()))) {
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
                } else {
                    label1.setText("");
                    textField1.setText("ERROR! Press any key to reset.");
                    error = true;
                }
                newNum = false;
                pending_cal_toClear = true;
                OnceEqual = false;
            } else if (Utilities.KeycodeEqual_check(e.getKeyCode()) && str_arithmetic.isEmpty()) {
                label1.setText(str_now + " = " + str_now);
                newNum = false;
                pending_cal_toClear = true;
                OnceEqual = true;
            } else if (Utilities.KeycodeEqual_check(e.getKeyCode()) && !OnceEqual) {
                BigDecimalCal(str_last, str_arithmetic, str_now);
                OnceEqualConst = str_now;
            } else if (Utilities.KeycodeEqual_check(e.getKeyCode()) && OnceEqual) {
                BigDecimalCal(str_now, str_arithmetic, OnceEqualConst);
            }
        } else if (Utilities.Keycode_check(e.getKeyChar()) || Utilities.KeySpecialCode_check(e.getKeyCode())) {
            textField1.setText("0");
            error = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            label1.setText("");
            textField1.setText("0");
            error = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            textField1.setText("0");
            error = false;
        }
    }

    /**
     * calculate progress
     *
     * @param str_last       a
     * @param str_arithmetic b
     * @param str_now        c, such that a(b)c=...[2(*)3=6]
     * @author TonyZhan
     */
    private void BigDecimalCal(String str_last, String str_arithmetic, String str_now) {
        BigDecimal ans = FourArithmetic.calculatePlain(str_last, str_arithmetic, str_now);
        if (ans != null) {
            label1.setText(str_last + " " + str_arithmetic + " " + str_now + " = " + ans.toPlainString());
            textField1.setText(ans.toPlainString());
        } else {
            label1.setText("");
            textField1.setText("ERROR! Press any key to reset.");
            error = true;
        }
        newNum = false;
        pending_cal_toClear = true;
        OnceEqual = true;
    }

    /**
     * to input number, maintaining its legitimacy
     *
     * @param e a key listener
     * @author TonyZhan
     */
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
        if (nowInput.isEmpty()) nowInput = "0";
        textField1.setText(nowInput);
    }

    private void button_upsidedownMousePressed(MouseEvent e) {
        // TODO add your code here
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        String str_equal = Utilities.PureEqual(label1.getText());
        if (e.getButton() == 1) {
            if (!error) {
                BigDecimal ans = FourArithmetic.calculatePlain("1", "/", str_now);
                if (!str_equal.isEmpty() || label1.getText().isEmpty()) {
                    if (ans != null) {
                        label1.setText("1" + " " + "/" + " " + str_now + " = " + ans.toPlainString());
                        textField1.setText(ans.toPlainString());
                    } else {
                        label1.setText("");
                        textField1.setText("ERROR! Press any key to reset.");
                        error = true;
                        return;
                    }
                    newNum = false;
                    pending_cal_toClear = true;
                    OnceEqual = true;
                } else {
                    if (ans != null) {
                        textField1.setText(ans.toPlainString());
                    }
                }
            } else {
                textField1.setText("0");
                error = false;
            }
        }
    }

    private void button_sqrtMousePressed(MouseEvent e) {
        // TODO add your code here
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        String str_equal = Utilities.PureEqual(label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans;
            if (!error) {
                try {
                    ans = new BigDecimal(str_now).sqrt(new MathContext(15));
                } catch (ArithmeticException ae) {
                    label1.setText("");
                    textField1.setText("ERROR! Press any key to reset.");
                    error = true;
                    return;
                }
                if (!str_equal.isEmpty() || label1.getText().isEmpty()) {
                    label1.setText("sqrt(" + str_now + ")" + " = " + ans.toPlainString());
                    textField1.setText(ans.toPlainString());
                    newNum = false;
                    pending_cal_toClear = true;
                    OnceEqual = true;
                } else {
                    textField1.setText(ans.toPlainString());
                }
            } else {
                textField1.setText("0");
                error = false;
            }
        }
    }

    private void button_pow2MousePressed(MouseEvent e) {
        // TODO add your code here
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        String str_equal = Utilities.PureEqual(label1.getText());
        if (e.getButton() == 1) {
            if (!error) {
                BigDecimal ans = new BigDecimal(str_now).pow(2,MathContext.DECIMAL128);
                System.out.println(ans);
                if (ans.toPlainString().length() > 10000) {
                    System.out.println("ok");
                    ans = null;
                }
                if (ans == null) {
                    label1.setText("");
                    textField1.setText("ERROR! Press any key to reset.");
                    error = true;
                    return;
                }
                if (!str_equal.isEmpty() || label1.getText().isEmpty()) {
                    label1.setText("(" + str_now + ")" + "^2" + " = " + ans.toPlainString());
                    textField1.setText(ans.toPlainString());
                    newNum = false;
                    pending_cal_toClear = true;
                    OnceEqual = true;
                } else {
                    textField1.setText(ans.toPlainString());
                }
            } else {
                textField1.setText("0");
                error = false;
            }
        }
    }

    private boolean play = false;
    private static final File DAVID = new File("Calculator/Resources/music/oh_David.wav");
    private Clip clip = null;

    {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(DAVID);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private void button_DavidMousePressed(MouseEvent e) {
        // TODO add your code here
        try {
            if (!play) {
                clip.start();
                play = true;
            } else {
                clip.stop();
                play = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void button_smokeMousePressed(MouseEvent k) {
        if (clip != null) {
            clip.stop();
            play = false;
        }
        // TODO add your code here
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(DAVID);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private void progressBar1MousePressed(MouseEvent e) {

    }

    private void progressBar1MouseReleased(MouseEvent e) {
        // TODO add your code here
        int mouseX = e.getX();
        int progressBarWidth = progressBar1.getWidth();
        int progress = (int) ((double) mouseX / progressBarWidth * progressBar1.getMaximum());
        progressBar1.setValue(progress);
        long time = (long) ((double) mouseX / progressBarWidth * clip.getMicrosecondLength());
        clip.setMicrosecondPosition(time);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
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
        scrollPane3 = new JScrollPane();
        textField1 = new JTextField();
        progressBar1 = new JProgressBar();
        scrollPane1 = new JScrollPane();
        label1 = new JLabel();

        //======== this ========
        setForeground(SystemColor.controlDkShadow);
        setLayout(null);

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
        add(button1);
        button1.setBounds(50, 460, 100, 50);

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
        add(button2);
        button2.setBounds(160, 460, 100, 50);

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
        add(button3);
        button3.setBounds(270, 460, 100, 50);

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
        add(button4);
        button4.setBounds(50, 400, 100, 50);

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
        add(button5);
        button5.setBounds(160, 400, 100, 50);

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
        add(button6);
        button6.setBounds(270, 400, 100, 50);

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
        add(button7);
        button7.setBounds(50, 340, 100, 50);

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
        add(button8);
        button8.setBounds(160, 340, 100, 50);

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
        add(button9);
        button9.setBounds(270, 340, 100, 50);

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
        add(button0);
        button0.setBounds(160, 520, 100, 50);

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
        add(button_dot);
        button_dot.setBounds(270, 520, 100, 50);

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
        add(button_polar);
        button_polar.setBounds(50, 520, 100, 50);

        //---- button_upsidedown ----
        button_upsidedown.setText("1/x");
        button_upsidedown.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_upsidedown.setFocusable(false);
        button_upsidedown.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_upsidedownMousePressed(e);
            }
        });
        add(button_upsidedown);
        button_upsidedown.setBounds(50, 280, 100, 50);

        //---- button_pow2 ----
        button_pow2.setText("x^2");
        button_pow2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_pow2.setFocusable(false);
        button_pow2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_pow2MousePressed(e);
            }
        });
        add(button_pow2);
        button_pow2.setBounds(160, 280, 100, 50);

        //---- button_sqrt ----
        button_sqrt.setText("\u221ax");
        button_sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_sqrt.setFocusable(false);
        button_sqrt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sqrtMousePressed(e);
            }
        });
        add(button_sqrt);
        button_sqrt.setBounds(270, 280, 100, 50);

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
        add(button_equal);
        button_equal.setBounds(380, 520, 100, 50);

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
        add(button_plus);
        button_plus.setBounds(380, 460, 100, 50);

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
        add(button_minus);
        button_minus.setBounds(380, 400, 100, 50);

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
        add(button_mul);
        button_mul.setBounds(380, 340, 100, 50);

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
        add(button_div);
        button_div.setBounds(380, 280, 100, 50);

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
        add(button_percent);
        button_percent.setBounds(50, 220, 100, 50);

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
        add(button_cleanEntry);
        button_cleanEntry.setBounds(160, 220, 100, 50);

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
        add(button_clear);
        button_clear.setBounds(270, 220, 100, 50);

        //---- button_smoke ----
        button_smoke.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button_smoke.setIcon(new ImageIcon(getClass().getResource("/Resources/img/smoke.png")));
        button_smoke.setFocusable(false);
        button_smoke.setText("      \u91cd\u7f6e");
        button_smoke.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_smokeMousePressed(e);
            }
        });
        add(button_smoke);
        button_smoke.setBounds(490, 415, 170, 145);

        //---- button_David ----
        button_David.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button_David.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
        button_David.setFocusable(false);
        button_David.setText("\u64ad\u653e");
        button_David.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_DavidMousePressed(e);
            }
        });
        add(button_David);
        button_David.setBounds(490, 235, 170, 145);

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
        add(button_backspace);
        button_backspace.setBounds(380, 220, 100, 50);

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
            textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            textField1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    textField1KeyPressed(e);
                }
            });
            scrollPane3.setViewportView(textField1);
        }
        add(scrollPane3);
        scrollPane3.setBounds(40, 125, 630, 80);

        //---- progressBar1 ----
        progressBar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                progressBar1MouseReleased(e);
            }
        });
        add(progressBar1);
        progressBar1.setBounds(85, 605, 210, 40);

        //======== scrollPane1 ========
        {

            //---- label1 ----
            label1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED), "Last Step", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Consolas", Font.BOLD | Font.ITALIC, 14)));
            label1.setFont(new Font("Consolas", Font.PLAIN, 18));
            label1.setForeground(Color.darkGray);
            label1.setHorizontalAlignment(SwingConstants.TRAILING);
            label1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            label1.setAlignmentX(0.5F);
            label1.setOpaque(true);
            label1.setBackground(new Color(0xf0f0f0));
            scrollPane1.setViewportView(label1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(40, 40, 630, 75);

        setPreferredSize(new Dimension(725, 785));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    private JScrollPane scrollPane3;
    private JTextField textField1;
    private JProgressBar progressBar1;
    private JScrollPane scrollPane1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
