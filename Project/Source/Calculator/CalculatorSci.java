/*
 * Created by JFormDesigner on Tue Nov 21 18:18:37 CST 2023
 */

package Source.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.*;

import Source.Tools.*;

/**
 * @author Yury
 */
public class CalculatorSci extends JPanel implements Calculator {
    public CalculatorSci() {
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
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_1);
        }
    }

    private void button2MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_2);
        }
    }

    private void button3MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_3);
        }
    }

    private void button4MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_4);
        }
    }

    private void button5MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_5);
        }
    }

    private void button6MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_6);
        }
    }

    private void button7MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_7);
        }
    }

    private void button8MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_8);
        }
    }

    private void button9MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_9);
        }
    }

    private void button0MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_0);
        }
    }


    private void progressBar1MouseReleased(MouseEvent e) {
        int mouseX = e.getX();
        int progressBarWidth = progressBar1.getWidth();
        int progress = (int) ((double) mouseX / progressBarWidth * progressBar1.getMaximum());
        progressBar1.setValue(progress);
        long time = (long) ((double) mouseX / progressBarWidth * CalculatorStd.clip.getMicrosecondLength());
        CalculatorStd.clip.setMicrosecondPosition(time);
    }


    private void buttonDotMousePressed(MouseEvent e) {

        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_PERIOD);
        }
    }

    private void buttonAbsMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_A);
        }
    }

    private void buttonPow2MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_6);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_2);
            }
        }
    }

    private void buttonSqrtMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
        }
    }

    public void buttonEqualMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }

    private void buttonPlusMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ADD);
        }
    }

    private void buttonMinusMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MINUS);
        }
    }

    private void buttonMulMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MULTIPLY);
        }
    }

    private void buttonDivMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_DIVIDE);
        }
    }

    private void buttonPercentMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
                robot.keyPress(KeyEvent.VK_MULTIPLY);
                robot.keyPress(KeyEvent.VK_0);
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyPress(KeyEvent.VK_0);
                robot.keyPress(KeyEvent.VK_1);
            }
        }
    }

    private void buttonCleanEntryMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

    private void buttonSmokeMousePressed(MouseEvent e) {
        if (CalculatorStd.clip != null) {
            CalculatorStd.clip.stop();
            CalculatorStd.play = false;
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(CalculatorStd.class.getResource("/Resources/music/oh_David.wav"));
            CalculatorStd.clip = AudioSystem.getClip();
            CalculatorStd.clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException k) {
            throw new RuntimeException(k);
        }
    }

    private void buttonDavidMousePressed(MouseEvent e) {
        try {
            if (!CalculatorStd.play) {
                CalculatorStd.clip.start();
                CalculatorStd.play = true;
            } else {
                CalculatorStd.clip.stop();
                CalculatorStd.play = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void buttonBackspaceMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }

    private void buttonLeftMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void buttonRightMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void buttonFacMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void buttonModMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_M);
        }
    }

    private void buttonEMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_E);
        }
    }

    private void buttonPaiMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_P);
        }
    }

    private void buttonXpowyMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void buttonTenpowMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_0);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private void buttonLogMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
        }
    }

    private void buttonLnMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
        }
    }

    private void buttonSinMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
        }
    }

    private void buttonCosMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
        }
    }

    private void buttonTanMousePressed(MouseEvent e) {
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
        String ch = String.valueOf(e.getKeyChar());
        if (UtilitiesSci.checkNum(ch)) {
            inputNum(ch);
        } else if (UtilitiesSci.checkPIorE(ch)) {
            inputPIorE(ch);
        } else if (UtilitiesSci.checkMod(ch)) {
            inputMod(ch);
        } else if (UtilitiesSci.checkPow(ch)) {
            inputPow(ch);
        } else if (UtilitiesSci.checkLeftBracketFunction(ch)) {
            inputLeftBracketFunction(ch);
        } else if (UtilitiesSci.checkOperation(ch)) {
            inputOperation(ch);
        } else if (ch.equals("(")) {
            inputLeftBracket(ch);
        } else if (ch.equals(")")) {
            inputRightBracket(ch);
        } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            backSpace();
        } else if (UtilitiesSci.checkEqual(e)) {
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
        if (!UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")") && !lastCh.equals(".")) {
            if (!UtilitiesSci.checkNum(lastCh)) {
                strToCal.add("0");
                strToShow.add("0");
            }
            strToCal.add(".");
            strToShow.add(".");
            lastCh = ".";
        }
    }

    protected void inputNum(String ch) {
        if (!UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add(ch);
            strToShow.add(ch);
            lastCh = ch;
        }
    }

    protected void inputPIorE(String ch) {
        if (!UtilitiesSci.checkNum((lastCh)) && !UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
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
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("m");
            strToShow.add("mod");
            lastCh = ch;
        }
    }

    protected void inputPow(String ch) {
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("^");
            strToShow.add("^");
            lastCh = ch;
        }
    }

    protected void inputLeftBracketFunction(String ch) {
        if (!UtilitiesSci.checkNum((lastCh)) && !UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
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
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add(ch);
            if (ch.equals("/")) {
                strToShow.add("\u00F7");
            } else if (ch.equals("*")) {
                strToShow.add("\u00D7");
            } else {
                strToShow.add(ch);
            }
            lastCh = ch;
        } else if (ch.equals("-")) {
            if (UtilitiesSci.checkLeftBracketFunction(lastCh) || lastCh.equals("(") || lastCh.isEmpty() || lastCh.equals("=")) {
                strToCal.add("-");
                strToShow.add("-");
                lastCh = "-";
            }
        }
    }

    protected void inputLeftBracket(String ch) {
        if (!UtilitiesSci.checkNum(lastCh) && !UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add("(");
            strToShow.add("(");
            cntLeftBracket++;
            lastCh = ch;
        }
    }

    protected void inputRightBracket(String ch) {
        if (cntLeftBracket > 0 && (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")"))) {
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
        buttonDot = new JButton();
        buttonAbs = new JButton();
        buttonPow2 = new JButton();
        buttonSqrt = new JButton();
        buttonEqual = new JButton();
        buttonPlus = new JButton();
        buttonMinus = new JButton();
        buttonMul = new JButton();
        buttonDiv = new JButton();
        buttonPercent = new JButton();
        buttonCleanEntry = new JButton();
        button_smoke = new JButton();
        buttonDavid = new JButton();
        buttonBackspace = new JButton();
        scrollPane3 = new JScrollPane();
        textField1 = new JTextField();
        progressBar1 = new JProgressBar();
        scrollPane1 = new JScrollPane();
        label1 = new JLabel();
        buttonLeft = new JButton();
        buttonRight = new JButton();
        buttonFac = new JButton();
        buttonMod = new JButton();
        buttonE = new JButton();
        buttonPai = new JButton();
        buttonXpowy = new JButton();
        buttonTenpow = new JButton();
        buttonLog = new JButton();
        buttonLn = new JButton();
        buttonSin = new JButton();
        buttonCos = new JButton();
        buttonTan = new JButton();

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

        //---- buttonDot ----
        buttonDot.setText(".");
        buttonDot.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonDot.setFocusable(false);
        buttonDot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDotMousePressed(e);
            }
        });
        add(buttonDot);
        buttonDot.setBounds(325, 510, 80, 40);

        //---- buttonAbs ----
        buttonAbs.setText("abs");
        buttonAbs.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonAbs.setFocusable(false);
        buttonAbs.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonAbsMousePressed(e);
            }
        });
        add(buttonAbs);
        buttonAbs.setBounds(155, 510, 80, 40);

        //---- buttonPow2 ----
        buttonPow2.setText("x^2");
        buttonPow2.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPow2.setFocusable(false);
        buttonPow2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPow2MousePressed(e);
            }
        });
        add(buttonPow2);
        buttonPow2.setBounds(70, 285, 80, 40);

        //---- buttonSqrt ----
        buttonSqrt.setText("\u221ax");
        buttonSqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonSqrt.setFocusable(false);
        buttonSqrt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSqrtMousePressed(e);
            }
        });
        add(buttonSqrt);
        buttonSqrt.setBounds(70, 330, 80, 40);

        //---- buttonEqual ----
        buttonEqual.setText("=");
        buttonEqual.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonEqual.setFocusable(false);
        buttonEqual.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonEqualMousePressed(e);
            }
        });
        add(buttonEqual);
        buttonEqual.setBounds(410, 510, 80, 40);

        //---- buttonPlus ----
        buttonPlus.setText("+");
        buttonPlus.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPlus.setFocusable(false);
        buttonPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPlusMousePressed(e);
            }
        });
        add(buttonPlus);
        buttonPlus.setBounds(410, 465, 80, 40);

        //---- buttonMinus ----
        buttonMinus.setText("-");
        buttonMinus.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonMinus.setFocusable(false);
        buttonMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonMinusMousePressed(e);
            }
        });
        add(buttonMinus);
        buttonMinus.setBounds(410, 420, 80, 40);

        //---- buttonMul ----
        buttonMul.setText("\u00d7");
        buttonMul.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonMul.setFocusable(false);
        buttonMul.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonMulMousePressed(e);
            }
        });
        add(buttonMul);
        buttonMul.setBounds(410, 375, 80, 40);

        //---- buttonDiv ----
        buttonDiv.setText("\u00f7");
        buttonDiv.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonDiv.setFocusable(false);
        buttonDiv.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDivMousePressed(e);
            }
        });
        add(buttonDiv);
        buttonDiv.setBounds(410, 330, 80, 40);

        //---- buttonPercent ----
        buttonPercent.setText("%");
        buttonPercent.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPercent.setFocusable(false);
        buttonPercent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPercentMousePressed(e);
            }
        });
        add(buttonPercent);
        buttonPercent.setBounds(70, 240, 80, 40);

        //---- buttonCleanEntry ----
        buttonCleanEntry.setText("CE");
        buttonCleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonCleanEntry.setFocusable(false);
        buttonCleanEntry.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonCleanEntryMousePressed(e);
            }
        });
        add(buttonCleanEntry);
        buttonCleanEntry.setBounds(325, 240, 80, 40);

        //---- button_smoke ----
        button_smoke.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button_smoke.setIcon(new ImageIcon(getClass().getResource("/Resources/img/smoke.png")));
        button_smoke.setFocusable(false);
        button_smoke.setText("      \u91cd\u7f6e");
        button_smoke.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSmokeMousePressed(e);
            }
        });
        add(button_smoke);
        button_smoke.setBounds(510, 420, 170, 130);

        //---- buttonDavid ----
        buttonDavid.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonDavid.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
        buttonDavid.setFocusable(false);
        buttonDavid.setText("\u64ad\u653e");
        buttonDavid.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDavidMousePressed(e);
            }
        });
        add(buttonDavid);
        buttonDavid.setBounds(510, 240, 170, 130);

        //---- buttonBackspace ----
        buttonBackspace.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonBackspace.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        buttonBackspace.setFocusable(false);
        buttonBackspace.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonBackspaceMousePressed(e);
            }
        });
        add(buttonBackspace);
        buttonBackspace.setBounds(410, 240, 80, 40);

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
        progressBar1.setBounds(510, 375, 170, 40);

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

        //---- buttonLeft ----
        buttonLeft.setText("(");
        buttonLeft.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonLeft.setFocusable(false);
        buttonLeft.setAlignmentY(0.0F);
        buttonLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonLeftMousePressed(e);
            }
        });
        add(buttonLeft);
        buttonLeft.setBounds(155, 330, 80, 40);

        //---- buttonRight ----
        buttonRight.setText(")");
        buttonRight.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonRight.setFocusable(false);
        buttonRight.setAlignmentY(0.0F);
        buttonRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonRightMousePressed(e);
            }
        });
        add(buttonRight);
        buttonRight.setBounds(240, 330, 80, 40);

        //---- buttonFac ----
        buttonFac.setText("fact");
        buttonFac.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonFac.setFocusable(false);
        buttonFac.setAlignmentY(0.0F);
        buttonFac.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonFacMousePressed(e);
            }
        });
        add(buttonFac);
        buttonFac.setBounds(325, 330, 80, 40);

        //---- buttonMod ----
        buttonMod.setText("mod");
        buttonMod.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonMod.setFocusable(false);
        buttonMod.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonModMousePressed(e);
            }
        });
        add(buttonMod);
        buttonMod.setBounds(410, 285, 80, 40);

        //---- buttonE ----
        buttonE.setText("e");
        buttonE.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonE.setFocusable(false);
        buttonE.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonEMousePressed(e);
            }
        });
        add(buttonE);
        buttonE.setBounds(240, 240, 80, 40);

        //---- buttonPai ----
        buttonPai.setText("\u03c0");
        buttonPai.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPai.setFocusable(false);
        buttonPai.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPaiMousePressed(e);
            }
        });
        add(buttonPai);
        buttonPai.setBounds(155, 240, 80, 40);

        //---- buttonXpowy ----
        buttonXpowy.setText("x^y");
        buttonXpowy.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonXpowy.setFocusable(false);
        buttonXpowy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonXpowyMousePressed(e);
            }
        });
        add(buttonXpowy);
        buttonXpowy.setBounds(70, 375, 80, 40);

        //---- buttonTenpow ----
        buttonTenpow.setText("10^x");
        buttonTenpow.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonTenpow.setFocusable(false);
        buttonTenpow.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonTenpowMousePressed(e);
            }
        });
        add(buttonTenpow);
        buttonTenpow.setBounds(70, 420, 80, 40);

        //---- buttonLog ----
        buttonLog.setText("log");
        buttonLog.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonLog.setFocusable(false);
        buttonLog.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonLogMousePressed(e);
            }
        });
        add(buttonLog);
        buttonLog.setBounds(70, 465, 80, 40);

        //---- buttonLn ----
        buttonLn.setText("ln");
        buttonLn.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonLn.setFocusable(false);
        buttonLn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonLnMousePressed(e);
            }
        });
        add(buttonLn);
        buttonLn.setBounds(70, 510, 80, 40);

        //---- buttonSin ----
        buttonSin.setText(" sin ");
        buttonSin.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonSin.setPreferredSize(null);
        buttonSin.setMinimumSize(new Dimension(80, 40));
        buttonSin.setMaximumSize(new Dimension(100, 50));
        buttonSin.setMargin(null);
        buttonSin.setFocusable(false);
        buttonSin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSinMousePressed(e);
            }
        });
        add(buttonSin);
        buttonSin.setBounds(155, 285, 80, 40);

        //---- buttonCos ----
        buttonCos.setText(" cos ");
        buttonCos.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonCos.setMinimumSize(new Dimension(80, 40));
        buttonCos.setMaximumSize(new Dimension(100, 50));
        buttonCos.setMargin(null);
        buttonCos.setFocusable(false);
        buttonCos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonCosMousePressed(e);
            }
        });
        add(buttonCos);
        buttonCos.setBounds(240, 285, 80, 40);

        //---- buttonTan ----
        buttonTan.setText(" tan ");
        buttonTan.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonTan.setMinimumSize(new Dimension(80, 40));
        buttonTan.setMaximumSize(new Dimension(80, 40));
        buttonTan.setMargin(null);
        buttonTan.setFocusable(false);
        buttonTan.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonTanMousePressed(e);
            }
        });
        add(buttonTan);
        buttonTan.setBounds(325, 285, 80, 40);

        setPreferredSize(new Dimension(755, 655));
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
    private JButton buttonDot;
    private JButton buttonAbs;
    private JButton buttonPow2;
    private JButton buttonSqrt;
    private JButton buttonEqual;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMul;
    private JButton buttonDiv;
    private JButton buttonPercent;
    private JButton buttonCleanEntry;
    private JButton button_smoke;
    private JButton buttonDavid;
    private JButton buttonBackspace;
    private JScrollPane scrollPane3;
    private JTextField textField1;
    private JProgressBar progressBar1;
    private JScrollPane scrollPane1;
    private JLabel label1;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JButton buttonFac;
    private JButton buttonMod;
    private JButton buttonE;
    private JButton buttonPai;
    private JButton buttonXpowy;
    private JButton buttonTenpow;
    private JButton buttonLog;
    private JButton buttonLn;
    private JButton buttonSin;
    private JButton buttonCos;
    private JButton buttonTan;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
