/*
 * Created by JFormDesigner on Tue Nov 21 18:18:37 CST 2023
 */

package Source;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yury
 */
public class Calculator_sci extends JPanel implements Calculator{
    public Calculator_sci() {
        initComponents();
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button7MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button5MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button6MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button8MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button9MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button0MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_dotMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_polarMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_upsidedownMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_pow2MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_sqrtMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_equalMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_plusMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_minusMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_mulMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_divMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_percentMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_cleanEntryMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_clearMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_smokeMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_DavidMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_backspaceMousePressed(MouseEvent e) {
        // TODO add your code here
    }
    private String strToCal = "";
    private String strToShow = "";
    private String lastCh = "";
    protected boolean inputtingNum = false;
    protected boolean inputtingFunction = false;
    protected boolean inputtingPIorE = false;
    protected boolean inputtingPow = false;
    protected int noLeftSpace = 0;
    protected boolean isInputtingLeftBracketFunction = false;
    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
        String str_now = Utilities.PureNumberWithoutArithmetics(textField1.getText());
        String ch = String.valueOf(e.getKeyChar());
        if (Utilities_sci.checkNum(ch)) {
            inputNum(ch);
        } else if (ch.equals("p") || ch.equals("e")) {
            inputPIorE(ch);
        } else if (ch.equals("m")) {
            inputMod(ch);
        } else if (ch.equals("^")) {
            inputPow(ch);
        } else if (Utilities_sci.checkLeftBracketFunction(ch)) {
            inputLeftBracketFunction(ch);
        }
        lastCh = ch;
        textField1.setText(strToShow);
    }
    protected void inputNum(String ch) {
        if (!Utilities_sci.checkPIorE(lastCh)) {
            strToCal += ch;
            if (Utilities_sci.checkLeftBracketFunction(lastCh) || Utilities_sci.checkPow(lastCh)) {

            }
            if (inputtingNum || noLeftSpace > 0) {
                strToShow += ch;
            } else {
                strToShow += " " + ch;
            }
            inputtingNum = true;
            inputtingFunction = false;
        }
    }
    protected void inputPIorE(String ch) {
        if (!inputtingNum) {
            if (ch.equals("p")) {
                strToCal += Math.PI;
                if (noLeftSpace > 0) {
                    strToShow += " ";
                }
                strToShow += Math.PI;
            } else {
                strToCal += Math.E;
                if (noLeftSpace > 0) {
                    strToShow += " ";
                }
                strToShow += Math.E;
            }
            inputtingPIorE = true;
            inputtingFunction = false;
        }
        
    }
    protected void inputMod(String ch) {
        if (!inputtingFunction) {
            strToCal += "m";
            strToShow += " mod";
            inputtingFunction = true;
            inputtingNum = false;
            inputtingPIorE = false;
        }
    }
    protected void inputPow(String ch) {
        if (!inputtingFunction) {
            strToCal += "^";
            strToShow += "^";
            noLeftSpace++;
            inputtingFunction = true;
            inputtingNum = false;
            inputtingPIorE = false;
        }
    }
    protected void inputLeftBracketFunction(String ch) {
        if (!inputtingNum && !inputtingPIorE) {
            if (ch.equals("s")) {

            }
        }

    }
    private void progressBar1MouseReleased(MouseEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button7 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button0 = new JButton();
        button_dot = new JButton();
        button_polar = new JButton();
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
        button_left = new JButton();
        button_right = new JButton();
        button_fac = new JButton();
        button_mod = new JButton();
        button_e = new JButton();
        button_pai = new JButton();
        button_xpowy = new JButton();
        button_tenpow = new JButton();
        button_log = new JButton();
        button_ln = new JButton();
        button_sin = new JButton();
        button_cos = new JButton();
        button_tan = new JButton();

        //======== this ========
        setLayout(null);

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
        button7.setBounds(135, 400, 80, 40);

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
        button1.setBounds(135, 490, 80, 40);

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
        button2.setBounds(220, 490, 80, 40);

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
        button3.setBounds(305, 490, 80, 40);

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
        button4.setBounds(135, 445, 80, 40);

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
        button5.setBounds(220, 445, 80, 40);

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
        button6.setBounds(305, 445, 80, 40);

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
        button8.setBounds(220, 400, 80, 40);

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
        button9.setBounds(305, 400, 80, 40);

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
        button0.setBounds(220, 535, 80, 40);

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
        button_dot.setBounds(305, 535, 80, 40);

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
        button_polar.setBounds(135, 535, 80, 40);

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
        button_pow2.setBounds(50, 310, 80, 40);

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
        button_sqrt.setBounds(50, 355, 80, 40);

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
        button_equal.setBounds(390, 535, 80, 40);

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
        button_plus.setBounds(390, 490, 80, 40);

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
        button_minus.setBounds(390, 445, 80, 40);

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
        button_mul.setBounds(390, 400, 80, 40);

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
        button_div.setBounds(390, 355, 80, 40);

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
        button_percent.setBounds(50, 265, 80, 40);

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
        button_cleanEntry.setBounds(305, 220, 80, 40);

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
        button_clear.setBounds(305, 265, 80, 40);

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
        button_smoke.setBounds(490, 430, 170, 145);

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
        button_David.setBounds(490, 265, 170, 145);

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
        button_backspace.setBounds(390, 265, 80, 40);

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
        progressBar1.setBounds(85, 590, 210, 40);

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

        //---- button_left ----
        button_left.setText("(");
        button_left.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_left.setFocusable(false);
        button_left.setAlignmentY(0.0F);
        button_left.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clearMousePressed(e);
            }
        });
        add(button_left);
        button_left.setBounds(135, 355, 80, 40);

        //---- button_right ----
        button_right.setText(")");
        button_right.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_right.setFocusable(false);
        button_right.setAlignmentY(0.0F);
        button_right.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clearMousePressed(e);
            }
        });
        add(button_right);
        button_right.setBounds(220, 355, 80, 40);

        //---- button_fac ----
        button_fac.setText("n!");
        button_fac.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_fac.setFocusable(false);
        button_fac.setAlignmentY(0.0F);
        button_fac.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clearMousePressed(e);
            }
        });
        add(button_fac);
        button_fac.setBounds(305, 355, 80, 40);

        //---- button_mod ----
        button_mod.setText("mod");
        button_mod.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_mod.setFocusable(false);
        button_mod.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_upsidedownMousePressed(e);
            }
        });
        add(button_mod);
        button_mod.setBounds(390, 310, 80, 40);

        //---- button_e ----
        button_e.setText("e");
        button_e.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_e.setFocusable(false);
        button_e.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_upsidedownMousePressed(e);
            }
        });
        add(button_e);
        button_e.setBounds(220, 265, 80, 40);

        //---- button_pai ----
        button_pai.setText("\u03a0");
        button_pai.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_pai.setFocusable(false);
        button_pai.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_upsidedownMousePressed(e);
            }
        });
        add(button_pai);
        button_pai.setBounds(135, 265, 80, 40);

        //---- button_xpowy ----
        button_xpowy.setText("x^y");
        button_xpowy.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_xpowy.setFocusable(false);
        button_xpowy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sqrtMousePressed(e);
            }
        });
        add(button_xpowy);
        button_xpowy.setBounds(50, 400, 80, 40);

        //---- button_tenpow ----
        button_tenpow.setText("10^x");
        button_tenpow.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_tenpow.setFocusable(false);
        button_tenpow.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sqrtMousePressed(e);
            }
        });
        add(button_tenpow);
        button_tenpow.setBounds(50, 445, 80, 40);

        //---- button_log ----
        button_log.setText("log");
        button_log.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_log.setFocusable(false);
        button_log.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sqrtMousePressed(e);
            }
        });
        add(button_log);
        button_log.setBounds(50, 490, 80, 40);

        //---- button_ln ----
        button_ln.setText("ln");
        button_ln.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_ln.setFocusable(false);
        button_ln.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sqrtMousePressed(e);
            }
        });
        add(button_ln);
        button_ln.setBounds(50, 535, 80, 40);

        //---- button_sin ----
        button_sin.setText(" sin ");
        button_sin.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_sin.setPreferredSize(null);
        button_sin.setMinimumSize(new Dimension(80, 40));
        button_sin.setMaximumSize(new Dimension(100, 50));
        button_sin.setMargin(null);
        add(button_sin);
        button_sin.setBounds(135, 310, 80, 40);

        //---- button_cos ----
        button_cos.setText(" cos ");
        button_cos.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_cos.setMinimumSize(new Dimension(80, 40));
        button_cos.setMaximumSize(new Dimension(100, 50));
        button_cos.setMargin(null);
        add(button_cos);
        button_cos.setBounds(220, 310, 80, 40);

        //---- button_tan ----
        button_tan.setText(" tan ");
        button_tan.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_tan.setMinimumSize(new Dimension(80, 40));
        button_tan.setMaximumSize(new Dimension(80, 40));
        button_tan.setMargin(null);
        add(button_tan);
        button_tan.setBounds(305, 310, 80, 40);

        setPreferredSize(new Dimension(795, 640));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button7;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton button_dot;
    private JButton button_polar;
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
    private JButton button_left;
    private JButton button_right;
    private JButton button_fac;
    private JButton button_mod;
    private JButton button_e;
    private JButton button_pai;
    private JButton button_xpowy;
    private JButton button_tenpow;
    private JButton button_log;
    private JButton button_ln;
    private JButton button_sin;
    private JButton button_cos;
    private JButton button_tan;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
