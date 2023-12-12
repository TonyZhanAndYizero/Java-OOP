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

/**
 * @author Yury
 */
public class TwentyFour extends JPanel {
    public TwentyFour() {
        initComponents();
    }


    private void button_divMousePressed(MouseEvent e) {
        // TODO add your code here
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("/");
            strToShow.add("¡Â");
            lastCh = "/";
            SetTextField1();
        }
    }

    private void button_mulMousePressed(MouseEvent e) {
        // TODO add your code here
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("*");
            strToShow.add("¡Á");
            lastCh = "*";
            SetTextField1();
        }
    }

    private void button_minusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("-");
            strToShow.add("-");
            lastCh = "-";
            SetTextField1();
        }
    }

    private void button_plusMousePressed(MouseEvent e) {
        // TODO add your code here
        if (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")")) {
            strToCal.add("+");
            strToShow.add("+");
            lastCh = "+";
            SetTextField1();
        }
    }

    private void button_rightMousePressed(MouseEvent e) {
        // TODO add your code here
        if (cntLeftBracket > 0 && (UtilitiesSci.checkNum(lastCh) || UtilitiesSci.checkPIorE(lastCh) || lastCh.equals(")"))) {
            strToCal.add(")");
            strToShow.add(")");
            lastCh = ")";
            SetTextField1();
        }
    }

    private void button_leftMousePressed(MouseEvent e) {
        // TODO add your code here
        if (!UtilitiesSci.checkNum(lastCh) && !UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add("(");
            strToShow.add("(");
            cntLeftBracket++;
            lastCh = "(";
            SetTextField1();
        }

    }

    private void button_cleanEntryMousePressed(MouseEvent e) {
        // TODO add your code here
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
        getResult();
        SetTextField1();
    }
    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
        String now = button1.getText();
        inputNum(now);
        SetTextField1();
    }

    private void button2MousePressed(MouseEvent e) {
        // TODO add your code here
        String now = button2.getText();
        inputNum(now);
        SetTextField1();
    }

    private void button3MousePressed(MouseEvent e) {
        // TODO add your code here
        String now = button3.getText();
        inputNum(now);
        SetTextField1();
    }

    private void button4MousePressed(MouseEvent e) {
        // TODO add your code here
        String now = button4.getText();
        inputNum(now);
        SetTextField1();
    }

    private void buttonReplayMousePressed(MouseEvent e) {
        // TODO add your code here

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
    protected void inputNum(String ch) {
        if (!UtilitiesSci.checkPIorE(lastCh) && !lastCh.equals(")")) {
            strToCal.add(ch);
            strToShow.add(ch);
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

            //label1.setText(String.valueOf(tmp2));
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
        label5 = new JLabel();
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
        button5 = new JButton();
        button_equal = new JButton();
        button_ans = new JButton();

        //======== this ========
        setLayout(null);

        //---- label5 ----
        label5.setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(label5);
        label5.setBounds(430, 75, 105, 50);

        //---- button1 ----
        button1.setFont(new Font("Consolas", Font.BOLD, 20));
        button1.setText("5");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(45, 155, 80, 60);

        //---- button2 ----
        button2.setFont(new Font("Consolas", Font.BOLD, 20));
        button2.setText("6");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2);
        button2.setBounds(140, 155, 80, 60);

        //---- button3 ----
        button3.setFont(new Font("Consolas", Font.BOLD, 20));
        button3.setText("78");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        add(button3);
        button3.setBounds(235, 155, 80, 60);

        //---- button4 ----
        button4.setFont(new Font("Consolas", Font.BOLD, 20));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        add(button4);
        button4.setBounds(330, 155, 80, 60);

        //======== scrollPane3 ========
        {

            //---- textField1 ----
            textField1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "Your Equation", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Consolas", Font.BOLD | Font.ITALIC, 14)));
            textField1.setFont(new Font("\u5b8b\u4f53", Font.BOLD | Font.ITALIC, 28));
            textField1.setBackground(new Color(0xf0f0f0));
            textField1.setAutoscrolls(false);
            textField1.setHorizontalAlignment(SwingConstants.CENTER);
            textField1.setEditable(false);
            textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            scrollPane3.setViewportView(textField1);
        }
        add(scrollPane3);
        scrollPane3.setBounds(35, 60, 385, 70);

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
        title.setText("24\u70b9");
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 10f));
        add(title);
        title.setBounds(15, 15, 60, 23);

        //---- button5 ----
        button5.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button5.setText("\u5f00\u59cb/\u91cd\u7f6e");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
                buttonReplayMousePressed(e);
            }
        });
        add(button5);
        button5.setBounds(425, 155, 110, 60);

        //---- button_equal ----
        button_equal.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button_equal.setFocusable(false);
        button_equal.setText("\u786e\u8ba4");
        button_equal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_equalMousePressed(e);
            }
        });
        add(button_equal);
        button_equal.setBounds(425, 275, 110, 40);

        //---- button_ans ----
        button_ans.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button_ans.setFocusable(false);
        button_ans.setText("\u7b54\u6848");
        button_ans.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_equalMousePressed(e);
            }
        });
        add(button_ans);
        button_ans.setBounds(425, 225, 110, 40);

        setPreferredSize(new Dimension(575, 395));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label5;
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
    private JButton button5;
    private JButton button_equal;
    private JButton button_ans;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
