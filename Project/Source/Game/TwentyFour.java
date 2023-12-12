/*
 * Created by JFormDesigner on Tue Dec 12 10:56:47 CST 2023
 */

package Source.Game;

import Source.Tools.EngineerArithmetic;
import Source.UtilitiesSci;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import Source.Game.Utilities24;

import static Source.UtilitiesSci.checkNum;

/**
 * @author Yury
 */
public class TwentyFour extends JPanel {
    public TwentyFour() {
        initComponents();
    }


    private void button_divMousePressed(MouseEvent e) {
        // TODO add your code here
        if (checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("/");
            strToShow.add("\u00F7");
            lastCh = "/";
            SetTextField1();
        }
    }

    private void button_mulMousePressed(MouseEvent e) {
        // TODO add your code here
        if (checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("*");
            strToShow.add("\u00D7");
            lastCh = "*";
            SetTextField1();
        }
    }

    private void button_minusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("-");
            strToShow.add("-");
            lastCh = "-";
            SetTextField1();
        }
    }

    private void button_plusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("+");
            strToShow.add("+");
            lastCh = "+";
            SetTextField1();
        }
    }

    private void button_rightMousePressed(MouseEvent e) {
        // TODO add your code here
        if (cntLeftBracket > 0 && (checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")"))) {
            strToCal.add(")");
            strToShow.add(")");
            lastCh = ")";
            SetTextField1();
        }
    }

    private void button_leftMousePressed(MouseEvent e) {
        // TODO add your code here
        if (!checkNum(lastCh) && !UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add("(");
            strToShow.add("(");
            cntLeftBracket++;
            lastCh = "(";
            SetTextField1();
        }

    }

    private void button_cleanEntryMousePressed(MouseEvent e) {
        // TODO add your code here
        flagButton1 = false;
        flagButton2 = false;
        flagButton3 = false;
        flagButton4 = false;
        clearEntry();
        SetTextField1();
    }


    private void button_backspaceMousePressed(MouseEvent e) {
        // TODO add your code here
        backSpace();
        SetTextField1();
    }
    private void button_equalMousePressed(MouseEvent e) {
        // TODO add your code here
        if (flagButton1 && flagButton2 && flagButton3 && flagButton4) {
            getResult();
        } else {
            status.setText("Incomplete");
            status.setForeground(Color.red);
        }

        //SetTextField1();
    }
    boolean flagButton1, flagButton2, flagButton3, flagButton4;
    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
        if (!flagButton1) {
            String now = button1.getText();
            if (inputNum(now)) {
                SetTextField1();
                flagButton1 = true;
            }
        }

    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
        if (!flagButton2) {
            String now = button2.getText();
            if (inputNum(now)) {
                SetTextField1();
                flagButton2 = true;
            }
        }

    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
        if (!flagButton3) {
            String now = button3.getText();
            if (inputNum(now)) {
                SetTextField1();
                flagButton3 = true;
            }
        }
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
        if (!flagButton4) {
            String now = button4.getText();
            if (inputNum(now)) {
                SetTextField1();
                flagButton4 = true;
            }
        }
    }
    Utilities24 utilities24 = new Utilities24();
    private void buttonReplayMousePressed(MouseEvent e) {
        // TODO add your code here
        textField1.setText("");
        boolean flag = false;
        int num1 = 6, num2 = 6, num3 = 6, num4 = 6;
        while (!flag) {
            num1 = utilities24.getRandomNum(14);
            num2 = utilities24.getRandomNum(14);
            num3 = utilities24.getRandomNum(14);
            num4 = utilities24.getRandomNum(14);
            flag = utilities24.checkExistingAnswer(num1, num2, num3, num4);
        }
        button1.setText(String.valueOf(num1));
        button2.setText(String.valueOf(num2));
        button3.setText(String.valueOf(num3));
        button4.setText(String.valueOf(num4));
        status.setText("Playing");
        status.setForeground(Color.darkGray);
        flagButton1 = false;
        flagButton2 = false;
        flagButton3 = false;
        flagButton4 = false;
    }
    private void buttonAnsMousePressed(MouseEvent e) {
        // TODO add your code here
        StringBuilder ans = new StringBuilder();
        for (String k : utilities24.ansList) {
                ans.append(k).append("\r\n");
        }
        textArea1.setText(String.valueOf(ans));
        dialog1.setVisible(true);
    }

    private ArrayList<String> strToCal = new ArrayList<>();
    private ArrayList<String> strToShow = new ArrayList<>();
    private String lastCh = "";
    protected int cntLeftBracket = 0;
    private void SetTextField1() {
        // TODO add your code here
        StringBuilder tmp = new StringBuilder();
        if (strToShow.isEmpty()) {
            //tmp.append("0");
        } else {
            for (String s : strToShow) {
                tmp.append(s);
            }
        }
        textField1.setText(String.valueOf(tmp));
    }
    protected boolean inputNum(String ch) {
        if (!UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")") && !checkNum(lastCh)) {
            strToCal.add(ch);
            strToShow.add(ch);
            lastCh = ch;
            return true;
        }
        return false;
    }
    protected void backSpace() {
        if (!strToShow.isEmpty()) {
            String tmp = null;
            if (checkNum(strToCal.get(strToCal.size() - 1))){
                tmp = strToCal.get(strToCal.size() - 1);
            }
            //System.out.println(tmp);
            strToCal.remove(strToCal.size() - 1);
            strToShow.remove(strToShow.size() - 1);
            if (tmp != null) {
                if (tmp.equals(button1.getText())) {
                    flagButton1 = false;
                } else if (tmp.equals(button2.getText())) {
                    flagButton2 = false;
                } else if (tmp.equals(button3.getText())) {
                    flagButton3 = false;
                } else if (tmp.equals(button4.getText())) {
                    flagButton4 = false;
                }
            }

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
                if (ans.equals("24")) {
                    status.setText("Right");
                    status.setForeground(new Color(0, 128, 0));
                } else {
                    status.setText("Wrong");
                    status.setForeground(Color.RED);
                }
            } else {
                status.setText("Error");
                status.setForeground(Color.RED);
                tmp2.append("Error!");
            }

            textField1.setText(String.valueOf(tmp2));
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
        status = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        scrollPane3 = new JScrollPane();
        textField1 = new JTextField();
        button_div = new JButton();
        button_mul = new JButton();
        button_minus = new JButton();
        button_plus = new JButton();
        button_right = new JButton();
        button_left = new JButton();
        button_cleanEntry = new JButton();
        button_backspace = new JButton();
        title = new JLabel();
        buttonReplay = new JButton();
        buttonEqual = new JButton();
        buttonAns = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        dialog1 = new JDialog();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //---- status ----
        status.setBorder(new BevelBorder(BevelBorder.LOWERED));
        status.setText("Not Start");
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
        status.setAlignmentY(0.0F);
        add(status);
        status.setBounds(420, 75, 120, 50);

        //---- button1 ----
        button1.setFont(new Font("Consolas", Font.BOLD, 20));
        button1.setAlignmentY(0.0F);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(45, 170, 80, 40);

        //---- button2 ----
        button2.setFont(new Font("Consolas", Font.BOLD, 20));
        button2.setAlignmentY(0.0F);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2);
        button2.setBounds(140, 170, 80, 40);

        //---- button3 ----
        button3.setFont(new Font("Consolas", Font.BOLD, 20));
        button3.setAlignmentY(0.0F);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        add(button3);
        button3.setBounds(235, 170, 80, 40);

        //---- button4 ----
        button4.setFont(new Font("Consolas", Font.BOLD, 20));
        button4.setAlignmentY(0.0F);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        add(button4);
        button4.setBounds(330, 170, 80, 40);

        //======== scrollPane3 ========
        {

            //---- textField1 ----
            textField1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "Your Equation", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Consolas", Font.BOLD | Font.ITALIC, 14)));
            textField1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 28));
            textField1.setBackground(new Color(0xf0f0f0));
            textField1.setAutoscrolls(false);
            textField1.setHorizontalAlignment(SwingConstants.CENTER);
            textField1.setEditable(false);
            textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            scrollPane3.setViewportView(textField1);
        }
        add(scrollPane3);
        scrollPane3.setBounds(25, 60, 385, 70);

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
        button_div.setBounds(45, 225, 80, 40);

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
        button_mul.setBounds(140, 225, 80, 40);

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
        button_minus.setBounds(235, 225, 80, 40);

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
        button_plus.setBounds(330, 225, 80, 40);

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
        button_right.setBounds(140, 275, 80, 40);

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
        button_left.setBounds(45, 275, 80, 40);

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
        button_cleanEntry.setBounds(235, 275, 80, 40);

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
        button_backspace.setBounds(330, 275, 80, 40);

        //---- title ----
        title.setText("\u4e8c\u5341\u56db\u70b9");
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 10f));
        add(title);
        title.setBounds(15, 15, 100, 23);

        //---- buttonReplay ----
        buttonReplay.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonReplay.setText("\u5f00\u59cb/\u91cd\u7f6e");
        buttonReplay.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonReplayMousePressed(e);
            }
        });
        add(buttonReplay);
        buttonReplay.setBounds(425, 170, 110, 40);

        //---- buttonEqual ----
        buttonEqual.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonEqual.setFocusable(false);
        buttonEqual.setText("\u786e\u8ba4");
        buttonEqual.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_equalMousePressed(e);
            }
        });
        add(buttonEqual);
        buttonEqual.setBounds(425, 275, 110, 40);

        //---- buttonAns ----
        buttonAns.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonAns.setFocusable(false);
        buttonAns.setText("\u7b54\u6848");
        buttonAns.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonAnsMousePressed(e);
            }
        });
        add(buttonAns);
        buttonAns.setBounds(425, 225, 110, 40);

        //---- label1 ----
        label1.setText("Num1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Consolas", Font.ITALIC, 14));
        add(label1);
        label1.setBounds(45, 145, 80, 25);

        //---- label2 ----
        label2.setText("Num2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Consolas", Font.ITALIC, 14));
        add(label2);
        label2.setBounds(140, 145, 80, 25);

        //---- label3 ----
        label3.setText("Num3");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Consolas", Font.ITALIC, 14));
        add(label3);
        label3.setBounds(235, 145, 80, 25);

        //---- label4 ----
        label4.setText("Num4");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(new Font("Consolas", Font.ITALIC, 14));
        add(label4);
        label4.setBounds(330, 145, 80, 25);

        setPreferredSize(new Dimension(575, 395));

        //======== dialog1 ========
        {
            var dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(null);

            //======== scrollPane2 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("Consolas", Font.BOLD, 20));
                textArea1.setEditable(false);
                scrollPane2.setViewportView(textArea1);
            }
            dialog1ContentPane.add(scrollPane2);
            scrollPane2.setBounds(10, 10, 175, 170);

            dialog1ContentPane.setPreferredSize(new Dimension(205, 220));
            dialog1.pack();
            dialog1.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel status;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scrollPane3;
    private JTextField textField1;
    private JButton button_div;
    private JButton button_mul;
    private JButton button_minus;
    private JButton button_plus;
    private JButton button_right;
    private JButton button_left;
    private JButton button_cleanEntry;
    private JButton button_backspace;
    private JLabel title;
    private JButton buttonReplay;
    private JButton buttonEqual;
    private JButton buttonAns;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JDialog dialog1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
