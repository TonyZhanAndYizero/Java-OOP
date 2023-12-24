/*
 * Created by JFormDesigner on Sat Dec 16 15:23:46 CST 2023
 */

package Source.Game;

import Source.Calculator.UtilitiesSci;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yury
 */
public class  GuessNumber extends JPanel {
    public GuessNumber() {
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

    private void button0MousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_0);
        }
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

    private String[] s = new String[4];
    private int statusCode = -1;

    /**
     * Description: To reset the game.
     *
     * @param e MouseEvent
     * @author Yury and Tony
     */

    private final ArrayList<JLabel> labels = new ArrayList<>();

    private void buttonReplayMousePressed(MouseEvent e) {
        // TODO add your code here
        clearEntry();

        line = 0;


        Timer timer = new Timer();
        for (int i = 1; i <= 24; i++) {
            int finalI = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    labels.get(finalI - 1).setText("");
                    labels.get(finalI - 1).setBackground(new Color(0xf0f0f0));
                }
            }, 50L * i);
        }

        for (int i = 25; i <= 28; i++) {
            int finalI = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    labels.get(finalI - 1).setText("?");
                }
            }, 50L * i);
        }
        status.setText("Playing");
        status.setForeground(Color.darkGray);

        status1.setText("");
        status2.setText("");
        status3.setText("");
        status4.setText("");
        status5.setText("");
        status6.setText("");

        int num1 = 6, num2 = 6, num3 = 6, num4 = 6;
        Utilities24 utilities24 = new Utilities24();
        num1 = utilities24.getRandomNum(10) - 1;
        num2 = utilities24.getRandomNum(10) - 1;
        num3 = utilities24.getRandomNum(10) - 1;
        num4 = utilities24.getRandomNum(10) - 1;
        s[0] = String.valueOf(num1);
        s[1] = String.valueOf(num2);
        s[2] = String.valueOf(num3);
        s[3] = String.valueOf(num4);

        statusCode = 1;

        cntCorrect = 0;
        cntHave = 0;

    }

    private void buttonConfirmMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }

    private void buttonBackspaceMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
        }
    }

    private ArrayList<String> strToShow = new ArrayList<>();
    private int line = 0;

    /**
     * Description: To execute keyboard input.
     *
     * @param e KeyEvent
     * @author Yury
     */
    protected void textField1KeyPressed(KeyEvent e) {
        if (statusCode == 1) {
            String ch = String.valueOf(e.getKeyChar());
            if (UtilitiesSci.checkNum(ch)) {
                inputNum(ch);
            } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                backSpace();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                getResult();
            }
        } else {
            showDialog2();
        }
    }

    /**
     * Description: To set text od textField1
     *
     * @author Yury
     */
    protected void setTextField1() {
        StringBuilder tmp = new StringBuilder();
        for (String s : strToShow) {
            tmp.append(s);
        }
        textField1.setText(String.valueOf(tmp));
    }

    /**
     * Description: To input a number.
     *
     * @param ch String
     * @author Yury
     */
    protected void inputNum(String ch) {
        if (statusCode != 1) {
            showDialog2();
            return;
        }
        strToShow.add(ch);
        setTextField1();
    }

    /**
     * Description: Execute backspace.
     *
     * @author Yury
     */
    protected void backSpace() {
        if (statusCode != 1) {
            showDialog2();
            return;
        }
        if (!strToShow.isEmpty()) {
            strToShow.remove(strToShow.size() - 1);
            setTextField1();
            //System.out.println(strToShow.size());
        }
    }

    private int cntCorrect = 0, cntHave = 0;

    /**
     * Description: To check if the input is legal.
     *
     * @param label JLabel
     * @param j     int
     * @author Yury
     */
    protected void checkAns(JLabel label, int j) {
        if (label.getText().equals(s[j])) {
            cntCorrect++;
            label.setBackground(new Color(0, 128, 0));
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                if (i == j) continue;
                if (label.getText().equals(s[i])) {
                    cntHave++;
                    label.setBackground(new Color(220, 128, 0));
                    return;
                }
            }
        }
        label.setBackground(new Color(128, 0, 0));
    }

    /**
     * Description: To check if the input is correct and execute something after correct.
     *
     * @return boolean
     * @author Yury
     */
    protected boolean checkCorrect() {
        if (cntCorrect == 4) {
            status.setText("Correct");
            status.setForeground(new Color(0, 128, 0));
            statusCode = 2;
            showAns();
            clearEntry();
            return true;
        }
        return false;
    }

    /**
     * Description: To show the answer.
     *
     * @author Yury
     */
    protected void showAns() {
        label25.setText(s[0]);
        label26.setText(s[1]);
        label27.setText(s[2]);
        label28.setText(s[3]);

    }

    /**
     * Description: If the player failed, show failure event.
     *
     * @author Yury
     */
    protected void showFail() {
        status.setText("Fail");
        status.setForeground(Color.RED);
        statusCode = -1;
        showAns();
    }

    /**
     * Description: To execute confirming.
     *
     * @author Yury
     */
    protected void getResult() {
        if (statusCode == 1) {
            String input = textField1.getText();
            if (input.length() != 4) {
                dialog1.setVisible(true);
                return;
            }

            if (line == 0) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label1.setText(input.substring(0, 1));
                        checkAns(label1, 0);
                    }
                }, 100L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label2.setText(input.substring(1, 2));
                        checkAns(label2, 1);
                    }
                }, 200L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label3.setText(input.substring(2, 3));
                        checkAns(label3, 2);
                    }
                }, 300L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label4.setText(input.substring(3));
                        checkAns(label4, 3);
                        status1.setText(cntCorrect + "A" + cntHave + "B");
                        if (checkCorrect()) {
                            return;
                        }
                        line++;
                        cntCorrect = 0;
                        cntHave = 0;
                    }
                }, 400L);
            } else if (line == 1) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label5.setText(input.substring(0, 1));
                        checkAns(label5, 0);
                    }
                }, 100L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label6.setText(input.substring(1, 2));
                        checkAns(label6, 1);
                    }
                }, 200L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label7.setText(input.substring(2, 3));
                        checkAns(label7, 2);
                    }
                }, 300L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label8.setText(input.substring(3));
                        checkAns(label8, 3);
                        status2.setText(cntCorrect + "A" + cntHave + "B");
                        if (checkCorrect()) {
                            return;
                        }
                        line++;
                        cntCorrect = 0;
                        cntHave = 0;
                    }
                }, 400L);
            } else if (line == 2) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label9.setText(input.substring(0, 1));
                        checkAns(label9, 0);
                    }
                }, 100L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label10.setText(input.substring(1, 2));
                        checkAns(label10, 1);
                    }
                }, 200L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label11.setText(input.substring(2, 3));
                        checkAns(label11, 2);
                    }
                }, 300L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label12.setText(input.substring(3));
                        checkAns(label12, 3);
                        status3.setText(cntCorrect + "A" + cntHave + "B");
                        if (checkCorrect()) {
                            return;
                        }
                        line++;
                        cntCorrect = 0;
                        cntHave = 0;
                    }
                }, 400L);
            } else if (line == 3) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label13.setText(input.substring(0, 1));
                        checkAns(label13, 0);
                    }
                }, 100L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label14.setText(input.substring(1, 2));
                        checkAns(label14, 1);
                    }
                }, 200L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label15.setText(input.substring(2, 3));
                        checkAns(label15, 2);
                    }
                }, 300L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label16.setText(input.substring(3));
                        checkAns(label16, 3);
                        status4.setText(cntCorrect + "A" + cntHave + "B");
                        if (checkCorrect()) {
                            return;
                        }
                        line++;
                        cntCorrect = 0;
                        cntHave = 0;
                    }
                }, 400L);
            } else if (line == 4) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label17.setText(input.substring(0, 1));
                        checkAns(label17, 0);
                    }
                }, 100L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label18.setText(input.substring(1, 2));
                        checkAns(label18, 1);
                    }
                }, 200L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label19.setText(input.substring(2, 3));
                        checkAns(label19, 2);
                    }
                }, 300L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label20.setText(input.substring(3));
                        checkAns(label20, 3);
                        status5.setText(cntCorrect + "A" + cntHave + "B");
                        if (checkCorrect()) {
                            return;
                        }
                        line++;
                        cntCorrect = 0;
                        cntHave = 0;
                    }
                }, 400L);
            } else if (line == 5) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label21.setText(input.substring(0, 1));
                        checkAns(label21, 0);
                    }
                }, 100L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label22.setText(input.substring(1, 2));
                        checkAns(label22, 1);
                    }
                }, 200L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label23.setText(input.substring(2, 3));
                        checkAns(label23, 2);
                    }
                }, 300L);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        label24.setText(input.substring(3));
                        checkAns(label24, 3);
                        status6.setText(cntCorrect + "A" + cntHave + "B");
                        if (checkCorrect()) {
                            return;
                        } else {
                            showFail();
                        }
                    }
                }, 400L);
            }
            clearEntry();
        } else {
            showDialog2();
        }

    }

    protected void clearEntry() {
        strToShow.clear();
        setTextField1();
    }

    protected void showDialog2() {
        dialog2.setVisible(true);
    }

    private void closeDialog1(MouseEvent e) {
        dialog1.setVisible(false);
    }

    private void closeDialog2(MouseEvent e) {
        dialog2.setVisible(false);
    }

    private void buttonRulesMousePressed(MouseEvent e) {
        dialog3.setVisible(true);
    }

    private void closeRules(MouseEvent e) {
        dialog3.setVisible(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        title = new JLabel();
        button0 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        textField1 = new JTextField();
        buttonReplay = new JButton();
        buttonConfirm = new JButton();
        status1 = new JLabel();
        status2 = new JLabel();
        status3 = new JLabel();
        status4 = new JLabel();
        status5 = new JLabel();
        status6 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        label28 = new JLabel();
        buttonBackspace = new JButton();
        status = new JLabel();
        buttonRules = new JButton();
        dialog1 = new JDialog();
        label29 = new JLabel();
        button10 = new JButton();
        dialog2 = new JDialog();
        label30 = new JLabel();
        button11 = new JButton();
        dialog3 = new JDialog();
        button12 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //---- label1 ----
        label1.setText("5");
        label1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label1.setFont(new Font("Consolas", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(145, 65, 35, 35);

        //---- label2 ----
        label2.setText("5");
        label2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label2.setFont(new Font("Consolas", Font.BOLD, 18));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        label2.setBounds(185, 65, 35, 35);

        //---- label3 ----
        label3.setText("5");
        label3.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label3.setFont(new Font("Consolas", Font.BOLD, 18));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        add(label3);
        label3.setBounds(225, 65, 35, 35);

        //---- label4 ----
        label4.setText("5");
        label4.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label4.setFont(new Font("Consolas", Font.BOLD, 18));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        add(label4);
        label4.setBounds(265, 65, 35, 35);

        //---- label5 ----
        label5.setText("5");
        label5.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label5.setFont(new Font("Consolas", Font.BOLD, 18));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        add(label5);
        label5.setBounds(145, 105, 35, 35);

        //---- label6 ----
        label6.setText("5");
        label6.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label6.setFont(new Font("Consolas", Font.BOLD, 18));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        add(label6);
        label6.setBounds(185, 105, 35, 35);

        //---- label7 ----
        label7.setText("5");
        label7.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label7.setFont(new Font("Consolas", Font.BOLD, 18));
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        add(label7);
        label7.setBounds(225, 105, 35, 35);

        //---- label8 ----
        label8.setText("5");
        label8.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label8.setFont(new Font("Consolas", Font.BOLD, 18));
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        add(label8);
        label8.setBounds(265, 105, 35, 35);

        //---- label9 ----
        label9.setText("5");
        label9.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label9.setFont(new Font("Consolas", Font.BOLD, 18));
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        add(label9);
        label9.setBounds(145, 145, 35, 35);

        //---- label10 ----
        label10.setText("5");
        label10.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label10.setFont(new Font("Consolas", Font.BOLD, 18));
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        add(label10);
        label10.setBounds(185, 145, 35, 35);

        //---- label11 ----
        label11.setText("5");
        label11.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label11.setFont(new Font("Consolas", Font.BOLD, 18));
        label11.setHorizontalAlignment(SwingConstants.CENTER);
        add(label11);
        label11.setBounds(225, 145, 35, 35);

        //---- label12 ----
        label12.setText("5");
        label12.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label12.setFont(new Font("Consolas", Font.BOLD, 18));
        label12.setHorizontalAlignment(SwingConstants.CENTER);
        add(label12);
        label12.setBounds(265, 145, 35, 35);

        //---- label13 ----
        label13.setText("5");
        label13.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label13.setFont(new Font("Consolas", Font.BOLD, 18));
        label13.setHorizontalAlignment(SwingConstants.CENTER);
        add(label13);
        label13.setBounds(145, 185, 35, 35);

        //---- label14 ----
        label14.setText("5");
        label14.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label14.setFont(new Font("Consolas", Font.BOLD, 18));
        label14.setHorizontalAlignment(SwingConstants.CENTER);
        add(label14);
        label14.setBounds(185, 185, 35, 35);

        //---- label15 ----
        label15.setText("5");
        label15.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label15.setFont(new Font("Consolas", Font.BOLD, 18));
        label15.setHorizontalAlignment(SwingConstants.CENTER);
        add(label15);
        label15.setBounds(225, 185, 35, 35);

        //---- label16 ----
        label16.setText("5");
        label16.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label16.setFont(new Font("Consolas", Font.BOLD, 18));
        label16.setHorizontalAlignment(SwingConstants.CENTER);
        add(label16);
        label16.setBounds(265, 185, 35, 35);

        //---- label17 ----
        label17.setText("5");
        label17.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label17.setFont(new Font("Consolas", Font.BOLD, 18));
        label17.setHorizontalAlignment(SwingConstants.CENTER);
        add(label17);
        label17.setBounds(145, 225, 35, 35);

        //---- label18 ----
        label18.setText("5");
        label18.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label18.setFont(new Font("Consolas", Font.BOLD, 18));
        label18.setHorizontalAlignment(SwingConstants.CENTER);
        add(label18);
        label18.setBounds(185, 225, 35, 35);

        //---- label19 ----
        label19.setText("5");
        label19.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label19.setFont(new Font("Consolas", Font.BOLD, 18));
        label19.setHorizontalAlignment(SwingConstants.CENTER);
        add(label19);
        label19.setBounds(225, 225, 35, 35);

        //---- label20 ----
        label20.setText("5");
        label20.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label20.setFont(new Font("Consolas", Font.BOLD, 18));
        label20.setHorizontalAlignment(SwingConstants.CENTER);
        add(label20);
        label20.setBounds(265, 225, 35, 35);

        //---- label21 ----
        label21.setText("5");
        label21.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label21.setFont(new Font("Consolas", Font.BOLD, 18));
        label21.setHorizontalAlignment(SwingConstants.CENTER);
        add(label21);
        label21.setBounds(145, 265, 35, 35);

        //---- label22 ----
        label22.setText("5");
        label22.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label22.setFont(new Font("Consolas", Font.BOLD, 18));
        label22.setHorizontalAlignment(SwingConstants.CENTER);
        add(label22);
        label22.setBounds(185, 265, 35, 35);

        //---- label23 ----
        label23.setText("5");
        label23.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label23.setFont(new Font("Consolas", Font.BOLD, 18));
        label23.setHorizontalAlignment(SwingConstants.CENTER);
        add(label23);
        label23.setBounds(225, 265, 35, 35);

        //---- label24 ----
        label24.setText("5");
        label24.setBorder(new BevelBorder(BevelBorder.LOWERED));
        label24.setFont(new Font("Consolas", Font.BOLD, 18));
        label24.setHorizontalAlignment(SwingConstants.CENTER);
        add(label24);
        label24.setBounds(265, 265, 35, 35);

        //---- title ----
        title.setText("\u731c\u6570\u5b57");
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 10f));
        add(title);
        title.setBounds(15, 15, 100, 23);

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
        button0.setBounds(20, 375, 80, 40);

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
        button1.setBounds(115, 375, 80, 40);

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
        button2.setBounds(210, 375, 80, 40);

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
        button3.setBounds(305, 375, 80, 40);

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
        button4.setBounds(400, 375, 80, 40);

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
        button5.setBounds(20, 425, 80, 40);

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
        button6.setBounds(115, 425, 80, 40);

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
        button7.setBounds(210, 425, 80, 40);

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
        button8.setBounds(305, 425, 80, 40);

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
        button9.setBounds(400, 425, 80, 40);

        //---- textField1 ----
        textField1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "Your Answer", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
            new Font("Consolas", Font.BOLD | Font.ITALIC, 14)));
        textField1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        textField1.setBackground(new Color(0xf0f0f0));
        textField1.setAutoscrolls(false);
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        textField1.setEditable(false);
        textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textField1KeyPressed(e);
            }
        });
        add(textField1);
        textField1.setBounds(120, 315, 350, 50);

        //---- buttonReplay ----
        buttonReplay.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonReplay.setText("\u5f00\u59cb/\u91cd\u7f6e");
        buttonReplay.setFocusable(false);
        buttonReplay.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonReplayMousePressed(e);
            }
        });
        add(buttonReplay);
        buttonReplay.setBounds(495, 145, 110, 40);

        //---- buttonConfirm ----
        buttonConfirm.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonConfirm.setFocusable(false);
        buttonConfirm.setText("\u786e\u8ba4");
        buttonConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonConfirmMousePressed(e);
            }
        });
        add(buttonConfirm);
        buttonConfirm.setBounds(495, 375, 110, 40);

        //---- status1 ----
        status1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status1.setHorizontalAlignment(SwingConstants.CENTER);
        status1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status1.setAlignmentY(0.0F);
        add(status1);
        status1.setBounds(325, 65, 120, 35);

        //---- status2 ----
        status2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status2.setHorizontalAlignment(SwingConstants.CENTER);
        status2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status2.setAlignmentY(0.0F);
        add(status2);
        status2.setBounds(325, 105, 120, 35);

        //---- status3 ----
        status3.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status3.setHorizontalAlignment(SwingConstants.CENTER);
        status3.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status3.setAlignmentY(0.0F);
        add(status3);
        status3.setBounds(325, 145, 120, 35);

        //---- status4 ----
        status4.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status4.setHorizontalAlignment(SwingConstants.CENTER);
        status4.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status4.setAlignmentY(0.0F);
        add(status4);
        status4.setBounds(325, 185, 120, 35);

        //---- status5 ----
        status5.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status5.setHorizontalAlignment(SwingConstants.CENTER);
        status5.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status5.setAlignmentY(0.0F);
        add(status5);
        status5.setBounds(325, 225, 120, 35);

        //---- status6 ----
        status6.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status6.setHorizontalAlignment(SwingConstants.CENTER);
        status6.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status6.setAlignmentY(0.0F);
        add(status6);
        status6.setBounds(325, 265, 120, 35);

        //---- label25 ----
        label25.setBorder(null);
        label25.setFont(new Font("\u5e7c\u5706", Font.BOLD, 18));
        label25.setHorizontalAlignment(SwingConstants.CENTER);
        label25.setText("\uff1f");
        add(label25);
        label25.setBounds(145, 25, 35, 35);

        //---- label26 ----
        label26.setText("\uff1f");
        label26.setBorder(null);
        label26.setFont(new Font("\u5e7c\u5706", Font.BOLD, 18));
        label26.setHorizontalAlignment(SwingConstants.CENTER);
        add(label26);
        label26.setBounds(185, 25, 35, 35);

        //---- label27 ----
        label27.setText("\uff1f");
        label27.setBorder(null);
        label27.setFont(new Font("\u5e7c\u5706", Font.BOLD, 18));
        label27.setHorizontalAlignment(SwingConstants.CENTER);
        add(label27);
        label27.setBounds(225, 25, 35, 35);

        //---- label28 ----
        label28.setText("\uff1f");
        label28.setBorder(null);
        label28.setFont(new Font("\u5e7c\u5706", Font.BOLD, 18));
        label28.setHorizontalAlignment(SwingConstants.CENTER);
        add(label28);
        label28.setBounds(265, 25, 35, 35);

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
        buttonBackspace.setBounds(495, 425, 110, 40);

        //---- status ----
        status.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status.setText("Not Start");
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status.setAlignmentY(0.0F);
        add(status);
        status.setBounds(325, 25, 120, 35);

        //---- buttonRules ----
        buttonRules.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonRules.setText("\u6e38\u620f\u89c4\u5219");
        buttonRules.setFocusable(false);
        buttonRules.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonRulesMousePressed(e);
            }
        });
        add(buttonRules);
        buttonRules.setBounds(495, 190, 110, 40);

        setPreferredSize(new Dimension(630, 505));

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a");
            var dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(null);

            //---- label29 ----
            label29.setText("\u8bf7\u8f93\u51654\u4e2a\u6570\u5b57\uff01");
            label29.setFont(new Font("\u5e7c\u5706", Font.BOLD, 16));
            label29.setHorizontalAlignment(SwingConstants.CENTER);
            dialog1ContentPane.add(label29);
            label29.setBounds(20, 30, 155, 50);

            //---- button10 ----
            button10.setText("\u5173\u95ed");
            button10.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
            button10.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    closeDialog1(e);
                }
            });
            dialog1ContentPane.add(button10);
            button10.setBounds(65, 115, button10.getPreferredSize().width, 40);

            dialog1ContentPane.setPreferredSize(new Dimension(200, 190));
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u63d0\u793a");
            var dialog2ContentPane = dialog2.getContentPane();
            dialog2ContentPane.setLayout(null);

            //---- label30 ----
            label30.setText("\u8bf7\u70b9\u51fb\u201c\u5f00\u59cb/\u91cd\u7f6e\u201d\uff01");
            label30.setFont(new Font("\u5e7c\u5706", Font.BOLD, 16));
            label30.setHorizontalAlignment(SwingConstants.CENTER);
            dialog2ContentPane.add(label30);
            label30.setBounds(5, 30, 190, 50);

            //---- button11 ----
            button11.setText("\u5173\u95ed");
            button11.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
            button11.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    closeDialog2(e);
                }
            });
            dialog2ContentPane.add(button11);
            button11.setBounds(65, 115, button11.getPreferredSize().width, 40);

            dialog2ContentPane.setPreferredSize(new Dimension(200, 190));
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }

        //======== dialog3 ========
        {
            dialog3.setPreferredSize(new Dimension(365, 300));
            dialog3.setTitle("\u7b80\u4ecb\u4e0e\u89c4\u5219");
            var dialog3ContentPane = dialog3.getContentPane();
            dialog3ContentPane.setLayout(null);

            //---- button12 ----
            button12.setText("\u5173\u95ed");
            button12.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
            button12.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    closeRules(e);
                }
            });
            dialog3ContentPane.add(button12);
            button12.setBounds(150, 225, button12.getPreferredSize().width, 40);

            //======== scrollPane1 ========
            {
                scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane1.setFocusable(false);

                //---- textArea1 ----
                textArea1.setText("\u731c\u6570\u5b57\uff08\u53c8\u79f0 Bulls and Cows \uff09\n\u662f\u4e00\u79cd\u53e4\u8001\u7684\u7684\u5bc6\u7801\u7834\u8bd1\u7c7b\u3001\u76ca\u667a\u7c7b\u5c0f\u6e38\u620f\uff0c\n\u8d77\u6e90\u4e8e20\u4e16\u7eaa\u4e2d\u671f\u3002\u7ed9\u5b9a\u56db\u4e2a\u6570\u5b57\uff080-9\uff09\uff0c\n\u4f60\u9700\u8981\u57286\u6b21\u5185\u731c\u51fa\u8fd9\u56db\u4e2a\u6570\u5b57\u662f\u4ec0\u4e48\uff0c\u4ee5\u53ca\n\u5b83\u4eec\u7684\u4f4d\u7f6e\u3002\u6bcf\u731c\u4e00\u6b21\uff0c\u5728\u5bf9\u5e94\u65b9\u683c\u4f1a\u663e\u793a\n\u989c\u8272\uff0c\u7eff\u8272\u4ee3\u8868\u6570\u5b57\u53ca\u5176\u4f4d\u7f6e\u90fd\u6b63\u786e\uff0c\u9ec4\u8272\n\u4ee3\u8868\u8fd94\u4e2a\u6570\u5b57\u4e2d\u6709\u4f60\u731c\u6d4b\u7684\u8fd9\u4e2a\u6570\u3001\u4f46\u4f4d\u7f6e\n\u4e0d\u6b63\u786e\uff0c\u7ea2\u8272\u4ee3\u8868\u6570\u5b57\u548c\u4f4d\u7f6e\u90fd\u9519\u8bef\u3002\n\u4e14\u6bcf\u6b21\u731c\u6d4b\u540e\u4f1a\u7ed9\u51fa\u51e0A\u51e0B\uff0c\u5176\u4e2dA\u524d\u9762\u7684\n\u6570\u5b57\u8868\u793a\u4f4d\u7f6e\u6b63\u786e\u7684\u6570\u7684\u4e2a\u6570\uff0c\u800cB\u524d\u7684\u6570\n\u5b57\u8868\u793a\u6570\u5b57\u6b63\u786e\u800c\u4f4d\u7f6e\u4e0d\u5bf9\u7684\u6570\u7684\u4e2a\u6570\u3002");
                textArea1.setEditable(false);
                textArea1.setFont(new Font("\u5e7c\u5706", Font.BOLD, 16));
                scrollPane1.setViewportView(textArea1);
            }
            dialog3ContentPane.add(scrollPane1);
            scrollPane1.setBounds(0, 0, 335, 215);

            dialog3ContentPane.setPreferredSize(new Dimension(335, 300));
            dialog3.pack();
            dialog3.setLocationRelativeTo(dialog3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);
        labels.add(label9);
        labels.add(label10);
        labels.add(label11);
        labels.add(label12);
        labels.add(label13);
        labels.add(label14);
        labels.add(label15);
        labels.add(label16);
        labels.add(label17);
        labels.add(label18);
        labels.add(label19);
        labels.add(label20);
        labels.add(label21);
        labels.add(label22);
        labels.add(label23);
        labels.add(label24);
        labels.add(label25);
        labels.add(label26);
        labels.add(label27);
        labels.add(label28);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel title;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JTextField textField1;
    private JButton buttonReplay;
    private JButton buttonConfirm;
    private JLabel status1;
    private JLabel status2;
    private JLabel status3;
    private JLabel status4;
    private JLabel status5;
    private JLabel status6;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JLabel label28;
    private JButton buttonBackspace;
    private JLabel status;
    private JButton buttonRules;
    private JDialog dialog1;
    private JLabel label29;
    private JButton button10;
    private JDialog dialog2;
    private JLabel label30;
    private JButton button11;
    private JDialog dialog3;
    private JButton button12;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
