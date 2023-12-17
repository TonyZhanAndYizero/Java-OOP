package Source.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;


/*
 * Created by JFormDesigner on Sat Nov 18 15:30:39 CST 2023
 */


/**
 * use JFormDesigner to build the frame.
 *
 * @author TonyZhan and Yury.
 */
public class CalculatorStd extends JPanel {
    public CalculatorStd() {
        try {
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ignored) {
        }
        initComponents();
    }

    /**
     * a robot to take charge of button.
     */
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

    protected ArrayList<String> textField1_texts = new ArrayList<>();
    protected ArrayList<String> label1_texts = new ArrayList<>();

    private void button_polarMousePressed(MouseEvent e) {
        CalProgressStd.polar(e, this);
    }

    private void button_percentMousePressed(MouseEvent e) {
        CalProgressStd.percent(e, this);
    }

    /**
     * judge whether the textField1 should be cleared.
     */
    protected boolean pending_cal_toClear = false;
    /**
     * judge the multiple consecutive calculate.
     */
    protected boolean newNum = false;
    /**
     * judge whether consecutive equal
     */
    protected boolean OnceEqual = false;
    /**
     * save the consecutive equal number
     */
    protected String OnceEqualConst;
    protected boolean error = false;


    private void textField1KeyPressed(KeyEvent e) {
        // TODO add your code here
        CalProgressStd.textFieldAndLabel(e, this);
    }

    private void button_upsidedownMousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.upsidedown(e, this);
    }

    private void button_sqrtMousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.sqrt(e, this);
    }

    private void button_pow2MousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.pow2(e, this);
    }

    private void button_floorMousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.floor_ceil(e, this, 0);
    }

    private void button_ceilMousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.floor_ceil(e, this, 1);
    }

    private void button_aEbMousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.science(e, this);
    }

    private void button_PlainMousePressed(MouseEvent e) {
        // TODO add your code here
        CalProgressStd.plain(e, this);
    }

    private boolean play = false;
    private static final File DAVID = new File("Project/Resources/music/oh_David.wav");
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

    /**
     * entertainment = =
     *
     * @author TonyZhan
     */
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
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        button_Plain = new JMenuItem();
        button_aEb = new JMenuItem();
        menu2 = new JMenu();
        button_floor = new JMenuItem();
        button_ceil = new JMenuItem();

        //======== this ========
        setBackground(UIManager.getColor("Panel.background"));
        setForeground(UIManager.getColor("Panel.foreground"));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(null);

        //---- button1 ----
        button1.setText("1");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.setFocusable(false);
        button1.setBorder(new BevelBorder(BevelBorder.RAISED));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(160, 460, 100, 50);

        //---- button2 ----
        button2.setText("2");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.setFocusable(false);
        button2.setBorder(new BevelBorder(BevelBorder.RAISED));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2);
        button2.setBounds(270, 460, 100, 50);

        //---- button3 ----
        button3.setText("3");
        button3.setFont(new Font("Consolas", Font.PLAIN, 16));
        button3.setFocusable(false);
        button3.setBorder(new BevelBorder(BevelBorder.RAISED));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        add(button3);
        button3.setBounds(380, 460, 100, 50);

        //---- button4 ----
        button4.setText("4");
        button4.setFont(new Font("Consolas", Font.PLAIN, 16));
        button4.setFocusable(false);
        button4.setBorder(new BevelBorder(BevelBorder.RAISED));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        add(button4);
        button4.setBounds(160, 400, 100, 50);

        //---- button5 ----
        button5.setText("5");
        button5.setFont(new Font("Consolas", Font.PLAIN, 16));
        button5.setFocusable(false);
        button5.setBorder(new BevelBorder(BevelBorder.RAISED));
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button5MousePressed(e);
            }
        });
        add(button5);
        button5.setBounds(270, 400, 100, 50);

        //---- button6 ----
        button6.setText("6");
        button6.setFont(new Font("Consolas", Font.PLAIN, 16));
        button6.setFocusable(false);
        button6.setBorder(new BevelBorder(BevelBorder.RAISED));
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button6MousePressed(e);
            }
        });
        add(button6);
        button6.setBounds(380, 400, 100, 50);

        //---- button7 ----
        button7.setText("7");
        button7.setFont(new Font("Consolas", Font.PLAIN, 16));
        button7.setFocusable(false);
        button7.setBorder(new BevelBorder(BevelBorder.RAISED));
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button7MousePressed(e);
            }
        });
        add(button7);
        button7.setBounds(160, 340, 100, 50);

        //---- button8 ----
        button8.setText("8");
        button8.setFont(new Font("Consolas", Font.PLAIN, 16));
        button8.setFocusable(false);
        button8.setBorder(new BevelBorder(BevelBorder.RAISED));
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button8MousePressed(e);
            }
        });
        add(button8);
        button8.setBounds(270, 340, 100, 50);

        //---- button9 ----
        button9.setText("9");
        button9.setFont(new Font("Consolas", Font.PLAIN, 16));
        button9.setFocusable(false);
        button9.setBorder(new BevelBorder(BevelBorder.RAISED));
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button9MousePressed(e);
            }
        });
        add(button9);
        button9.setBounds(380, 340, 100, 50);

        //---- button0 ----
        button0.setText("0");
        button0.setFont(new Font("Consolas", Font.PLAIN, 16));
        button0.setFocusable(false);
        button0.setBorder(new BevelBorder(BevelBorder.RAISED));
        button0.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button0MousePressed(e);
            }
        });
        add(button0);
        button0.setBounds(270, 520, 100, 50);

        //---- button_dot ----
        button_dot.setText(".");
        button_dot.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_dot.setFocusable(false);
        button_dot.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_dot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_dotMousePressed(e);
            }
        });
        add(button_dot);
        button_dot.setBounds(380, 520, 100, 50);

        //---- button_polar ----
        button_polar.setText("+/-");
        button_polar.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_polar.setFocusable(false);
        button_polar.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_polar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_polarMousePressed(e);
            }
        });
        add(button_polar);
        button_polar.setBounds(160, 520, 100, 50);

        //---- button_upsidedown ----
        button_upsidedown.setText("1/x");
        button_upsidedown.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_upsidedown.setFocusable(false);
        button_upsidedown.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_upsidedown.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_upsidedownMousePressed(e);
            }
        });
        add(button_upsidedown);
        button_upsidedown.setBounds(160, 280, 100, 50);

        //---- button_pow2 ----
        button_pow2.setText("x^2");
        button_pow2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_pow2.setFocusable(false);
        button_pow2.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_pow2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_pow2MousePressed(e);
            }
        });
        add(button_pow2);
        button_pow2.setBounds(270, 280, 100, 50);

        //---- button_sqrt ----
        button_sqrt.setText("\u221ax");
        button_sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_sqrt.setFocusable(false);
        button_sqrt.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_sqrt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sqrtMousePressed(e);
            }
        });
        add(button_sqrt);
        button_sqrt.setBounds(380, 280, 100, 50);

        //---- button_equal ----
        button_equal.setText("=");
        button_equal.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_equal.setFocusable(false);
        button_equal.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_equal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_equalMousePressed(e);
            }
        });
        add(button_equal);
        button_equal.setBounds(490, 520, 100, 50);

        //---- button_plus ----
        button_plus.setText("+");
        button_plus.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_plus.setFocusable(false);
        button_plus.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_plusMousePressed(e);
            }
        });
        add(button_plus);
        button_plus.setBounds(490, 460, 100, 50);

        //---- button_minus ----
        button_minus.setText("-");
        button_minus.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_minus.setFocusable(false);
        button_minus.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_minusMousePressed(e);
            }
        });
        add(button_minus);
        button_minus.setBounds(490, 400, 100, 50);

        //---- button_mul ----
        button_mul.setText("\u00d7");
        button_mul.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_mul.setFocusable(false);
        button_mul.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_mul.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_mulMousePressed(e);
            }
        });
        add(button_mul);
        button_mul.setBounds(490, 340, 100, 50);

        //---- button_div ----
        button_div.setText("\u00f7");
        button_div.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_div.setFocusable(false);
        button_div.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_div.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_divMousePressed(e);
            }
        });
        add(button_div);
        button_div.setBounds(490, 280, 100, 50);

        //---- button_percent ----
        button_percent.setText("%");
        button_percent.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_percent.setFocusable(false);
        button_percent.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_percent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_percentMousePressed(e);
            }
        });
        add(button_percent);
        button_percent.setBounds(160, 220, 100, 50);

        //---- button_cleanEntry ----
        button_cleanEntry.setText("CE");
        button_cleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_cleanEntry.setFocusable(false);
        button_cleanEntry.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_cleanEntry.setToolTipText("\u6e05\u7a7a\u5f53\u524d\u8f93\u5165");
        button_cleanEntry.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_cleanEntryMousePressed(e);
            }
        });
        add(button_cleanEntry);
        button_cleanEntry.setBounds(270, 220, 100, 50);

        //---- button_clear ----
        button_clear.setText("C");
        button_clear.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_clear.setFocusable(false);
        button_clear.setAlignmentY(0.0F);
        button_clear.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_clear.setToolTipText("\u6e05\u9664\u5f53\u524d\u8f93\u5165\u548c\u8f93\u51fa");
        button_clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clearMousePressed(e);
            }
        });
        add(button_clear);
        button_clear.setBounds(380, 220, 100, 50);

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
        button_smoke.setBounds(490, 580, 170, 145);

        //---- button_David ----
        button_David.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        button_David.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
        button_David.setFocusable(false);
        button_David.setText("\u64ad\u653e");
        button_David.setBackground(UIManager.getColor("Button.background"));
        button_David.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_DavidMousePressed(e);
            }
        });
        add(button_David);
        button_David.setBounds(90, 580, 170, 145);

        //---- button_backspace ----
        button_backspace.setFont(new Font("Consolas", Font.PLAIN, 16));
        button_backspace.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        button_backspace.setFocusable(false);
        button_backspace.setBorder(new BevelBorder(BevelBorder.RAISED));
        button_backspace.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_backspaceMousePressed(e);
            }
        });
        add(button_backspace);
        button_backspace.setBounds(490, 220, 100, 50);

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
        progressBar1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        progressBar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                progressBar1MouseReleased(e);
            }
        });
        add(progressBar1);
        progressBar1.setBounds(280, 635, 190, 40);

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
            label1.setRequestFocusEnabled(false);
            label1.setFocusable(false);
            scrollPane1.setViewportView(label1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(60, 15, 630, 75);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("   \u8868\u8fbe\u5f0f\u8f6c\u6362   ");
                menu1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 18));
                menu1.setMargin(new Insets(4, 2, 4, 2));

                //---- button_Plain ----
                button_Plain.setText("  \u5341\u8fdb\u5236\u8ba1\u6570\u6cd5");
                button_Plain.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                button_Plain.setFocusable(false);
                button_Plain.setMargin(new Insets(8, 8, 8, 8));
                button_Plain.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                button_Plain.setMinimumSize(new Dimension(5, 5));
                button_Plain.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_PlainMousePressed(e);
                    }
                });
                menu1.add(button_Plain);

                //---- button_aEb ----
                button_aEb.setText("  \u79d1\u5b66\u8ba1\u6570\u6cd5");
                button_aEb.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                button_aEb.setFocusable(false);
                button_aEb.setMargin(new Insets(8, 8, 8, 8));
                button_aEb.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                button_aEb.setToolTipText("\u5f53\u6570\u5b57\u5927\u4e8e1E+16\u6216\u8868\u8fbe\u8db3\u591f\u7b80\u6d01\u65f6\u624d\u4f1a\u8f6c\u6362\u3002\u8bf7\u6ce8\u610f\uff1a\u8f6c\u6362\u540e\u4f1a\u5bfc\u81f4\u8f83\u5c0f\u7684\u7cbe\u5ea6\u635f\u5931(\u79d1\u5b66\u8ba1\u6570\u6cd5\u6700\u591a\u4ec5\u4fdd\u755916\u4f4d\u6709\u6548\u6570\u5b57)");
                button_aEb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_aEbMousePressed(e);
                    }
                });
                menu1.add(button_aEb);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("   \u53d6\u6574\u51fd\u6570   ");
                menu2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 18));
                menu2.setMargin(new Insets(4, 2, 4, 2));

                //---- button_floor ----
                button_floor.setText("  \u5411\u4e0b\u53d6\u6574");
                button_floor.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                button_floor.setFocusable(false);
                button_floor.setMargin(new Insets(8, 8, 8, 8));
                button_floor.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                button_floor.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_floorMousePressed(e);
                    }
                });
                menu2.add(button_floor);

                //---- button_ceil ----
                button_ceil.setText("  \u5411\u4e0a\u53d6\u6574");
                button_ceil.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                button_ceil.setFocusable(false);
                button_ceil.setMargin(new Insets(8, 8, 8, 8));
                button_ceil.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                button_ceil.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button_ceilMousePressed(e);
                    }
                });
                menu2.add(button_ceil);
            }
            menuBar1.add(menu2);
        }
        add(menuBar1);
        menuBar1.setBounds(60, 180, 630, menuBar1.getPreferredSize().height);

        setPreferredSize(new Dimension(755, 785));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    protected JButton button1;
    protected JButton button2;
    protected JButton button3;
    protected JButton button4;
    protected JButton button5;
    protected JButton button6;
    protected JButton button7;
    protected JButton button8;
    protected JButton button9;
    protected JButton button0;
    protected JButton button_dot;
    protected JButton button_polar;
    protected JButton button_upsidedown;
    protected JButton button_pow2;
    protected JButton button_sqrt;
    protected JButton button_equal;
    protected JButton button_plus;
    protected JButton button_minus;
    protected JButton button_mul;
    protected JButton button_div;
    protected JButton button_percent;
    protected JButton button_cleanEntry;
    protected JButton button_clear;
    protected JButton button_smoke;
    protected JButton button_David;
    protected JButton button_backspace;
    protected JScrollPane scrollPane3;
    protected JTextField textField1;
    protected JProgressBar progressBar1;
    protected JScrollPane scrollPane1;
    protected JLabel label1;
    private JMenuBar menuBar1;
    private JMenu menu1;
    protected JMenuItem button_Plain;
    protected JMenuItem button_aEb;
    private JMenu menu2;
    protected JMenuItem button_floor;
    protected JMenuItem button_ceil;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
