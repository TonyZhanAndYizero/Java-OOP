/*
 * Created by JFormDesigner on Tue Nov 21 18:18:37 CST 2023
 */

package Source.CalculatorPack;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import Source.ToolsPack.*;
import Source.Utilities_sci;

/**
 * @author Yury
 */
public class Calculator_sci extends JPanel implements Calculator{
    public Calculator_sci() {
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
    public JTextField getTextField1() {
        return textField1;
    }
    private void button1MousePressed(MouseEvent e) {
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

    private void button_absMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_A);
        }
    }

    private void button_paiMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_P);
        }
    }

    private void button_pow2MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            if (Utilities_sci.checkNum(lastCh) || Utilities_sci.checkPIorE(lastCh) || lastCh.equals(")")) {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_6);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_2);
            }
        }
    }

    private void button_xpowyMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void button_equalMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }

    private void button_plusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ADD);
        }
    }

    private void button_minusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MINUS);
        }
    }

    private void button_mulMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MULTIPLY);
        }
    }

    private void button_divMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_DIVIDE);
        }
    }

    private void button_percentMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            if (Utilities_sci.checkNum(lastCh) || Utilities_sci.checkPIorE(lastCh) || lastCh.equals(")")) {
                robot.keyPress(KeyEvent.VK_MULTIPLY);
                robot.keyPress(KeyEvent.VK_0);
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyPress(KeyEvent.VK_0);
                robot.keyPress(KeyEvent.VK_1);
            }
        }
    }

    private void button_cleanEntryMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

    private void button_leftMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
    private void button_rightMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
    private void button_smokeMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_DavidMousePressed(MouseEvent e) {
        // TODO add your code here
    }
    private void progressBar1MouseReleased(MouseEvent e) {
        // TODO add your code here

    }
    private void button_backspaceMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }


    private void button_eMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_E);
        }
    }

    private void button_modMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_M);
        }
    }

    private void button_facMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }


    private void button_tenpowMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_0);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void button_logMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
        }
    }

    private void button_lnMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
        }
    }

    private void button_sqrtMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
        }
    }
    private void button_sinMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
        }
    }

    private void button_cosMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
        }
    }

    private void button_tanMousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
        }
    }
    private ArrayList<String> strToCal = new ArrayList<>();
    private ArrayList<String> strToShow = new ArrayList<>();
    private String lastCh = "";
    protected int cntLeftBracket = 0;
    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
        String ch = String.valueOf(e.getKeyChar());
        if (Utilities_sci.checkNum(ch)) {
            inputNum(ch);
        } else if (Utilities_sci.checkPIorE(ch)) {
            inputPIorE(ch);
        } else if (Utilities_sci.checkMod(ch)) {
            inputMod(ch);
        } else if (Utilities_sci.checkPow(ch)) {
            inputPow(ch);
        } else if (Utilities_sci.checkLeftBracketFunction(ch)) {
            inputLeftBracketFunction(ch);
        } else if (Utilities_sci.checkOperation(ch)) {
            inputOperation(ch);
        } else if (ch.equals("(")) {
            inputLeftBracket(ch);
        } else if (ch.equals(")")) {
            inputRightBracket(ch);
        } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            backSpace();
        } else if (Utilities_sci.checkEqual(e)) {
            getResult();
        } else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            clearEntry();
        } else if (ch.equals(".")) {
            inputDot();
        }
        StringBuilder tmp = new StringBuilder();
        if (strToShow.isEmpty()) {
            tmp.append("0");
        } else {
            for (String s : strToShow) {
                tmp.append(s);
            }
        }
        textField1.setText(String.valueOf(tmp));
    }
    protected void inputDot() {
        if (!Utilities_sci.checkPIorE(lastCh) && !lastCh.equals(")") && !lastCh.equals(".")) {
            if (!Utilities_sci.checkNum(lastCh)) {
                strToCal.add("0");
                strToShow.add("0");
            }
            strToCal.add(".");
            strToShow.add(".");
            lastCh = ".";
        }
    }
    protected void inputNum(String ch) {
        if (!Utilities_sci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add(ch);
            strToShow.add(ch);
            lastCh = ch;
        }
    }
    protected void inputPIorE(String ch) {
        if (!Utilities_sci.checkNum((lastCh)) && !Utilities_sci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            if (ch.equals("p")) {
                strToCal.add(String.valueOf(Math.PI));
                strToShow.add("¦Ð");
            } else {
                strToCal.add(String.valueOf(Math.E));
                strToShow.add("e");
            }
            lastCh = ch;
        }
        
    }
    protected void inputMod(String ch) {
        if (Utilities_sci.checkNum(lastCh) || Utilities_sci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("m");
            strToShow.add("mod");
            lastCh = ch;
        }
    }
    protected void inputPow(String ch) {
        if (Utilities_sci.checkNum(lastCh) || Utilities_sci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("^");
            strToShow.add("^");
            lastCh = ch;
        }
    }
    protected void inputLeftBracketFunction(String ch) {
        if (!Utilities_sci.checkNum((lastCh)) && !Utilities_sci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            if (ch.equals("s")) {
                strToCal.add("s(");
                strToShow.add("sin(");
            } else if (ch.equals("c")) {
                strToCal.add("c(");
                strToShow.add("cos(");
            } else if (ch.equals("t")) {
                strToCal.add("t(");
                strToShow.add("tan(");
            } else if (ch.equals("l")) {
                strToCal.add("l(");
                strToShow.add("ln(");
            } else if (ch.equals("o")) {
                strToCal.add("o(");
                strToShow.add("log(");
            } else if (ch.equals("g")) {
                strToCal.add("g(");
                strToShow.add("sqrt(");
            } else if (ch.equals("!")) {
                strToCal.add("!(");
                strToShow.add("fact(");
            } else if (ch.equals("a")) {
                strToCal.add("a(");
                strToShow.add("abs(");
            }
            cntLeftBracket++;
            lastCh = ch;
        }
    }
    protected void inputOperation(String ch) {
        if (Utilities_sci.checkNum(lastCh) || Utilities_sci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add(ch);
            strToShow.add(ch);
            lastCh = ch;
        } else if (ch.equals("-")) {
            if (Utilities_sci.checkLeftBracketFunction(lastCh) || lastCh.equals("(") || lastCh.isEmpty() || lastCh.equals("=")) {
                strToCal.add("-");
                strToShow.add("-");
                lastCh = "-";
            }
        }
    }
    protected void inputLeftBracket(String ch) {
        if (!Utilities_sci.checkNum(lastCh) && !Utilities_sci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add("(");
            strToShow.add("(");
            cntLeftBracket++;
            lastCh = ch;
        }
    }
    protected void inputRightBracket(String ch) {
        if (cntLeftBracket > 0 && (Utilities_sci.checkNum(lastCh) || Utilities_sci.checkPIorE(lastCh) || lastCh.equals(")"))) {
            strToCal.add(")");
            strToShow.add(")");
            lastCh = ch;
        }
    }
    protected void backSpace() {
        if (!strToShow.isEmpty()) {
            strToCal.remove(strToCal.size() - 1);
            strToShow.remove(strToShow.size() - 1);
            System.out.println(strToShow.size());
            if (!strToShow.isEmpty()) {
                lastCh = strToCal.get(strToCal.size() - 1);
            } else {
                lastCh = "";
            }
        }
    }
    protected void getResult() {
        StringBuilder tmp = new StringBuilder();
        StringBuilder tmp2 = new StringBuilder();
        if (!strToCal.isEmpty()) {
            for (String s : strToCal) {
                tmp.append(s);
            }
            for (String s : strToShow) {
                tmp2.append(s);
            }
            String ans = EngineerArithmetic.engineerCal(String.valueOf(tmp));
            tmp2.append(" = ");
            if (ans != null) {
                tmp2.append(ans);
            } else {
                tmp2.append("Error!");
            }

            label1.setText(String.valueOf(tmp2));
            strToShow.clear();
            strToCal.clear();

            lastCh = "=";
        }
    }
    protected void clearEntry() {
        strToShow.clear();
        strToCal.clear();
        lastCh = "";
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
        button_abs = new JButton();
        button_pow2 = new JButton();
        button_sqrt = new JButton();
        button_equal = new JButton();
        button_plus = new JButton();
        button_minus = new JButton();
        button_mul = new JButton();
        button_div = new JButton();
        button_percent = new JButton();
        button_cleanEntry = new JButton();
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
        setBorder(new BevelBorder(BevelBorder.LOWERED));
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
        button1.setBounds(155, 465, 80, 40);

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
        button2.setBounds(240, 465, 80, 40);

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
        button3.setBounds(325, 465, 80, 40);

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
        button4.setBounds(155, 420, 80, 40);

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
        button5.setBounds(240, 420, 80, 40);

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
        button6.setBounds(325, 420, 80, 40);

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
        button7.setBounds(155, 375, 80, 40);

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
        button8.setBounds(240, 375, 80, 40);

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
        button9.setBounds(325, 375, 80, 40);

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
        button0.setBounds(240, 510, 80, 40);

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
        button_dot.setBounds(325, 510, 80, 40);

        //---- button_abs ----
        button_abs.setText("abs");
        button_abs.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_abs.setFocusable(false);
        button_abs.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_absMousePressed(e);
            }
        });
        add(button_abs);
        button_abs.setBounds(155, 510, 80, 40);

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
        button_pow2.setBounds(70, 285, 80, 40);

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
        button_sqrt.setBounds(70, 330, 80, 40);

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
        button_equal.setBounds(410, 510, 80, 40);

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
        button_plus.setBounds(410, 465, 80, 40);

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
        button_minus.setBounds(410, 420, 80, 40);

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
        button_mul.setBounds(410, 375, 80, 40);

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
        button_div.setBounds(410, 330, 80, 40);

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
        button_percent.setBounds(70, 240, 80, 40);

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
        button_cleanEntry.setBounds(325, 240, 80, 40);

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
        button_smoke.setBounds(510, 405, 170, 145);

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
        button_David.setBounds(510, 240, 170, 145);

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
        button_backspace.setBounds(410, 240, 80, 40);

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
        scrollPane3.setBounds(60, 95, 630, 80);

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
        scrollPane1.setBounds(60, 15, 630, 75);

        //---- button_left ----
        button_left.setText("(");
        button_left.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_left.setFocusable(false);
        button_left.setAlignmentY(0.0F);
        button_left.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_leftMousePressed(e);
            }
        });
        add(button_left);
        button_left.setBounds(155, 330, 80, 40);

        //---- button_right ----
        button_right.setText(")");
        button_right.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_right.setFocusable(false);
        button_right.setAlignmentY(0.0F);
        button_right.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_rightMousePressed(e);
            }
        });
        add(button_right);
        button_right.setBounds(240, 330, 80, 40);

        //---- button_fac ----
        button_fac.setText("fact");
        button_fac.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_fac.setFocusable(false);
        button_fac.setAlignmentY(0.0F);
        button_fac.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_facMousePressed(e);
            }
        });
        add(button_fac);
        button_fac.setBounds(325, 330, 80, 40);

        //---- button_mod ----
        button_mod.setText("mod");
        button_mod.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_mod.setFocusable(false);
        button_mod.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_modMousePressed(e);
            }
        });
        add(button_mod);
        button_mod.setBounds(410, 285, 80, 40);

        //---- button_e ----
        button_e.setText("e");
        button_e.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_e.setFocusable(false);
        button_e.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_eMousePressed(e);
            }
        });
        add(button_e);
        button_e.setBounds(240, 240, 80, 40);

        //---- button_pai ----
        button_pai.setText("\u03c0");
        button_pai.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_pai.setFocusable(false);
        button_pai.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_paiMousePressed(e);
            }
        });
        add(button_pai);
        button_pai.setBounds(155, 240, 80, 40);

        //---- button_xpowy ----
        button_xpowy.setText("x^y");
        button_xpowy.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_xpowy.setFocusable(false);
        button_xpowy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_xpowyMousePressed(e);
            }
        });
        add(button_xpowy);
        button_xpowy.setBounds(70, 375, 80, 40);

        //---- button_tenpow ----
        button_tenpow.setText("10^x");
        button_tenpow.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_tenpow.setFocusable(false);
        button_tenpow.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_tenpowMousePressed(e);
            }
        });
        add(button_tenpow);
        button_tenpow.setBounds(70, 420, 80, 40);

        //---- button_log ----
        button_log.setText("log");
        button_log.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_log.setFocusable(false);
        button_log.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_logMousePressed(e);
            }
        });
        add(button_log);
        button_log.setBounds(70, 465, 80, 40);

        //---- button_ln ----
        button_ln.setText("ln");
        button_ln.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_ln.setFocusable(false);
        button_ln.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_lnMousePressed(e);
            }
        });
        add(button_ln);
        button_ln.setBounds(70, 510, 80, 40);

        //---- button_sin ----
        button_sin.setText(" sin ");
        button_sin.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_sin.setPreferredSize(null);
        button_sin.setMinimumSize(new Dimension(80, 40));
        button_sin.setMaximumSize(new Dimension(100, 50));
        button_sin.setMargin(null);
        button_sin.setFocusable(false);
        button_sin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sinMousePressed(e);
            }
        });
        add(button_sin);
        button_sin.setBounds(155, 285, 80, 40);

        //---- button_cos ----
        button_cos.setText(" cos ");
        button_cos.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_cos.setMinimumSize(new Dimension(80, 40));
        button_cos.setMaximumSize(new Dimension(100, 50));
        button_cos.setMargin(null);
        button_cos.setFocusable(false);
        button_cos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_cosMousePressed(e);
            }
        });
        add(button_cos);
        button_cos.setBounds(240, 285, 80, 40);

        //---- button_tan ----
        button_tan.setText(" tan ");
        button_tan.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_tan.setMinimumSize(new Dimension(80, 40));
        button_tan.setMaximumSize(new Dimension(80, 40));
        button_tan.setMargin(null);
        button_tan.setFocusable(false);
        button_tan.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_tanMousePressed(e);
            }
        });
        add(button_tan);
        button_tan.setBounds(325, 285, 80, 40);

        setPreferredSize(new Dimension(845, 720));
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
    private JButton button_abs;
    private JButton button_pow2;
    private JButton button_sqrt;
    private JButton button_equal;
    private JButton button_plus;
    private JButton button_minus;
    private JButton button_mul;
    private JButton button_div;
    private JButton button_percent;
    private JButton button_cleanEntry;
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
