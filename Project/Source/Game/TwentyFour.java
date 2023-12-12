/*
 * Created by JFormDesigner on Tue Dec 12 10:56:47 CST 2023
 */

package Source.Game;

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

    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void button_divMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_mulMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_minusMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_plusMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_rightMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_leftMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1MousePressed(MouseEvent e) {
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

    private void button7MousePressed(MouseEvent e) {
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

    private void button_absMousePressed(MouseEvent e) {
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

    private void button_percentMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_cleanEntryMousePressed(MouseEvent e) {
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

    private void progressBar1MouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void button_facMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_modMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_eMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_paiMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_xpowyMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_tenpowMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_logMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_lnMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_sinMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_cosMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button_tanMousePressed(MouseEvent e) {
        // TODO add your code here
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

        //======== this ========
        setLayout(null);

        //---- label5 ----
        label5.setText("text");
        label5.setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(label5);
        label5.setBounds(430, 260, 40, 50);

        //---- button1 ----
        button1.setFont(new Font("Consolas", Font.BOLD, 28));
        add(button1);
        button1.setBounds(45, 60, 80, 60);

        //---- button2 ----
        button2.setFont(new Font("Consolas", Font.BOLD, 14));
        add(button2);
        button2.setBounds(140, 60, 80, 60);

        //---- button3 ----
        button3.setFont(new Font("Consolas", Font.BOLD, 14));
        add(button3);
        button3.setBounds(235, 60, 80, 60);

        //---- button4 ----
        button4.setFont(new Font("Consolas", Font.BOLD, 14));
        add(button4);
        button4.setBounds(330, 60, 80, 60);

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
        scrollPane3.setBounds(35, 245, 385, 70);

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
        button_div.setBounds(45, 130, 80, 40);

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
        button_mul.setBounds(140, 130, 80, 40);

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
        button_minus.setBounds(235, 130, 80, 40);

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
        button_plus.setBounds(330, 130, 80, 40);

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
        button_right.setBounds(140, 180, 80, 40);

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
        button_left.setBounds(45, 180, 80, 40);

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
        button_cleanEntry.setBounds(235, 180, 80, 40);

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
        button_backspace.setBounds(330, 180, 80, 40);

        setPreferredSize(new Dimension(490, 380));
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
