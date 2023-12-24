package Source.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.spi.BreakIteratorProvider;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;


/*
 * Created by JFormDesigner on Sat Nov 18 15:30:39 CST 2023
 */


/**
 * Description: A standard calculator
 *
 * @author TonyZhan
 **/
public class CalculatorStd extends JPanel implements Calculator {
    public CalculatorStd() {
        try {
            String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ignored) {
        }
        initComponents();
    }

    /**
     * Description: A robot to deal with click
     *
     * @author TonyZhan
     **/
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
     * Description: all the UI design and robot issues
     *
     * @author TonyZhan
     */
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

    private void buttonDotMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_PERIOD);
        }
    }

    private void buttonBackspaceMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
        }
    }

    private void buttonDivMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_DIVIDE);
        }
    }

    private void buttonMulMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MULTIPLY);
        }
    }

    private void buttonMinusMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_MINUS);
        }
    }

    private void buttonPlusMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ADD);
        }
    }

    public void buttonEqualMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }

    private void buttonClearMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_ESCAPE);
        }
    }

    private void buttonCleanEntryMousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            robot.keyPress(KeyEvent.VK_DELETE);
        }
    }

    private void buttonPolarMousePressed(MouseEvent e) {
        CalProgressStd.polar(e, this);
    }

    private void buttonPercentMousePressed(MouseEvent e) {
        CalProgressStd.percent(e, this);
    }

    /**
     * Description: judge whether the textField1 should be cleared.
     *
     * @author: TonyZhan
     */
    protected boolean pendingCalToClear = false;
    /**
     * Description: judge the multiple consecutive calculate.
     *
     * @author: TonyZhan
     */
    protected boolean newNum = false;
    /**
     * Description: judge whether consecutive equal
     *
     * @author: TonyZhan
     */
    protected boolean OnceEqual = false;
    /**
     * Description: save the consecutive equal number
     *
     * @author: TonyZhan
     */
    protected String OnceEqualConst;
    /**
     * Description: to check the error situation
     *
     * @author TonyZhan
     **/
    protected boolean error = false;

    /**
     * Description: a series of button movement, the crucial code is in CalProgressStd.
     *
     * @param e KeyEvent
     * @author TonyZhan
     **/
    private void textField1KeyPressed(KeyEvent e) {
        CalProgressStd.textFieldAndLabel(e, this);
    }

    private void buttonUpsideDownMousePressed(MouseEvent e) {
        CalProgressStd.upsideDown(e, this);
    }

    private void buttonSqrtMousePressed(MouseEvent e) {
        CalProgressStd.sqrt(e, this);
    }

    private void buttonPow2MousePressed(MouseEvent e) {
        CalProgressStd.pow2(e, this);
    }

    private void buttonFloorMousePressed(MouseEvent e) {
        CalProgressStd.floorCeil(e, this, 0);
    }

    private void buttonCeilMousePressed(MouseEvent e) {
        CalProgressStd.floorCeil(e, this, 1);
    }

    private void buttonAEbMousePressed(MouseEvent e) {
        CalProgressStd.science(e, this);
    }

    private void buttonPlainMousePressed(MouseEvent e) {
        CalProgressStd.plain(e, this);
    }

    /**
     * Description: A music displayer
     *
     * @author TonyZhan
     **/
    protected static boolean play = false;
    protected static Clip clip;

    static {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(CalculatorStd.class.getResource("/Resources/music/oh_David.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Description: entertainment = =
     *
     * @param e MouseEvent
     * @author TonyZhan
     */
    private void buttonDavidMousePressed(MouseEvent e) {
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

    private void buttonSmokeMousePressed(MouseEvent k) {
        if (clip != null) {
            clip.stop();
            play = false;
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(CalculatorStd.class.getResource("/Resources/music/oh_David.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private void progressBar1MouseReleased(MouseEvent e) {
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
        buttonDot = new JButton();
        buttonPolar = new JButton();
        buttonUpsidedDown = new JButton();
        buttonPow2 = new JButton();
        buttonSqrt = new JButton();
        buttonEqual = new JButton();
        buttonPlus = new JButton();
        buttonMinus = new JButton();
        buttonMul = new JButton();
        buttonDiv = new JButton();
        buttonPercent = new JButton();
        buttonCleanEntry = new JButton();
        buttonClear = new JButton();
        buttonDavid = new JButton();
        buttonBackspace = new JButton();
        scrollPane3 = new JScrollPane();
        textField1 = new JTextField();
        progressBar1 = new JProgressBar();
        scrollPane1 = new JScrollPane();
        label1 = new JLabel();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        buttonPlain = new JMenuItem();
        buttonAEb = new JMenuItem();
        menu2 = new JMenu();
        buttonFloor = new JMenuItem();
        buttonCeil = new JMenuItem();
        buttonSmoke = new JButton();

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

        //---- buttonDot ----
        buttonDot.setText(".");
        buttonDot.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonDot.setFocusable(false);
        buttonDot.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonDot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDotMousePressed(e);
            }
        });
        add(buttonDot);
        buttonDot.setBounds(380, 520, 100, 50);

        //---- buttonPolar ----
        buttonPolar.setText("+/-");
        buttonPolar.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPolar.setFocusable(false);
        buttonPolar.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonPolar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPolarMousePressed(e);
            }
        });
        add(buttonPolar);
        buttonPolar.setBounds(160, 520, 100, 50);

        //---- buttonUpsidedDown ----
        buttonUpsidedDown.setText("1/x");
        buttonUpsidedDown.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonUpsidedDown.setFocusable(false);
        buttonUpsidedDown.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonUpsidedDown.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonUpsideDownMousePressed(e);
            }
        });
        add(buttonUpsidedDown);
        buttonUpsidedDown.setBounds(160, 280, 100, 50);

        //---- buttonPow2 ----
        buttonPow2.setText("x^2");
        buttonPow2.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPow2.setFocusable(false);
        buttonPow2.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonPow2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPow2MousePressed(e);
            }
        });
        add(buttonPow2);
        buttonPow2.setBounds(270, 280, 100, 50);

        //---- buttonSqrt ----
        buttonSqrt.setText("\u221ax");
        buttonSqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonSqrt.setFocusable(false);
        buttonSqrt.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonSqrt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSqrtMousePressed(e);
            }
        });
        add(buttonSqrt);
        buttonSqrt.setBounds(380, 280, 100, 50);

        //---- buttonEqual ----
        buttonEqual.setText("=");
        buttonEqual.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonEqual.setFocusable(false);
        buttonEqual.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonEqual.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonEqualMousePressed(e);
            }
        });
        add(buttonEqual);
        buttonEqual.setBounds(490, 520, 100, 50);

        //---- buttonPlus ----
        buttonPlus.setText("+");
        buttonPlus.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPlus.setFocusable(false);
        buttonPlus.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPlusMousePressed(e);
            }
        });
        add(buttonPlus);
        buttonPlus.setBounds(490, 460, 100, 50);

        //---- buttonMinus ----
        buttonMinus.setText("-");
        buttonMinus.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonMinus.setFocusable(false);
        buttonMinus.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonMinusMousePressed(e);
            }
        });
        add(buttonMinus);
        buttonMinus.setBounds(490, 400, 100, 50);

        //---- buttonMul ----
        buttonMul.setText("\u00d7");
        buttonMul.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonMul.setFocusable(false);
        buttonMul.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonMul.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonMulMousePressed(e);
            }
        });
        add(buttonMul);
        buttonMul.setBounds(490, 340, 100, 50);

        //---- buttonDiv ----
        buttonDiv.setText("\u00f7");
        buttonDiv.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonDiv.setFocusable(false);
        buttonDiv.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonDiv.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDivMousePressed(e);
            }
        });
        add(buttonDiv);
        buttonDiv.setBounds(490, 280, 100, 50);

        //---- buttonPercent ----
        buttonPercent.setText("%");
        buttonPercent.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonPercent.setFocusable(false);
        buttonPercent.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonPercent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonPercentMousePressed(e);
            }
        });
        add(buttonPercent);
        buttonPercent.setBounds(160, 220, 100, 50);

        //---- buttonCleanEntry ----
        buttonCleanEntry.setText("CE");
        buttonCleanEntry.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonCleanEntry.setFocusable(false);
        buttonCleanEntry.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonCleanEntry.setToolTipText("\u6e05\u7a7a\u5f53\u524d\u8f93\u5165");
        buttonCleanEntry.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonCleanEntryMousePressed(e);
            }
        });
        add(buttonCleanEntry);
        buttonCleanEntry.setBounds(270, 220, 100, 50);

        //---- buttonClear ----
        buttonClear.setText("C");
        buttonClear.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonClear.setFocusable(false);
        buttonClear.setAlignmentY(0.0F);
        buttonClear.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonClear.setToolTipText("\u6e05\u9664\u5f53\u524d\u8f93\u5165\u548c\u8f93\u51fa");
        buttonClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonClearMousePressed(e);
            }
        });
        add(buttonClear);
        buttonClear.setBounds(380, 220, 100, 50);

        //---- buttonDavid ----
        buttonDavid.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonDavid.setIcon(new ImageIcon(getClass().getResource("/Resources/img/David.png")));
        buttonDavid.setFocusable(false);
        buttonDavid.setText("\u64ad\u653e");
        buttonDavid.setBackground(UIManager.getColor("Button.background"));
        buttonDavid.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDavidMousePressed(e);
            }
        });
        add(buttonDavid);
        buttonDavid.setBounds(90, 580, 170, 145);

        //---- buttonBackspace ----
        buttonBackspace.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonBackspace.setIcon(new ImageIcon(getClass().getResource("/Resources/img/delete(1).png")));
        buttonBackspace.setFocusable(false);
        buttonBackspace.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonBackspace.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonBackspaceMousePressed(e);
            }
        });
        add(buttonBackspace);
        buttonBackspace.setBounds(490, 220, 100, 50);

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

                //---- buttonPlain ----
                buttonPlain.setText("  \u5341\u8fdb\u5236\u8ba1\u6570\u6cd5");
                buttonPlain.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                buttonPlain.setFocusable(false);
                buttonPlain.setMargin(new Insets(8, 8, 8, 8));
                buttonPlain.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttonPlain.setMinimumSize(new Dimension(5, 5));
                buttonPlain.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        buttonPlainMousePressed(e);
                    }
                });
                menu1.add(buttonPlain);

                //---- buttonAEb ----
                buttonAEb.setText("  \u79d1\u5b66\u8ba1\u6570\u6cd5");
                buttonAEb.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                buttonAEb.setFocusable(false);
                buttonAEb.setMargin(new Insets(8, 8, 8, 8));
                buttonAEb.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttonAEb.setToolTipText("\u5f53\u6570\u5b57\u5927\u4e8e1E+16\u6216\u8868\u8fbe\u8db3\u591f\u7b80\u6d01\u65f6\u624d\u4f1a\u8f6c\u6362\u3002\u8bf7\u6ce8\u610f\uff1a\u8f6c\u6362\u540e\u4f1a\u5bfc\u81f4\u8f83\u5c0f\u7684\u7cbe\u5ea6\u635f\u5931(\u79d1\u5b66\u8ba1\u6570\u6cd5\u6700\u591a\u4ec5\u4fdd\u755916\u4f4d\u6709\u6548\u6570\u5b57)");
                buttonAEb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        buttonAEbMousePressed(e);
                    }
                });
                menu1.add(buttonAEb);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("   \u53d6\u6574\u51fd\u6570   ");
                menu2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 18));
                menu2.setMargin(new Insets(4, 2, 4, 2));

                //---- buttonFloor ----
                buttonFloor.setText("  \u5411\u4e0b\u53d6\u6574");
                buttonFloor.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                buttonFloor.setFocusable(false);
                buttonFloor.setMargin(new Insets(8, 8, 8, 8));
                buttonFloor.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttonFloor.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        buttonFloorMousePressed(e);
                    }
                });
                menu2.add(buttonFloor);

                //---- buttonCeil ----
                buttonCeil.setText("  \u5411\u4e0a\u53d6\u6574");
                buttonCeil.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                buttonCeil.setFocusable(false);
                buttonCeil.setMargin(new Insets(8, 8, 8, 8));
                buttonCeil.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttonCeil.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        buttonCeilMousePressed(e);
                    }
                });
                menu2.add(buttonCeil);
            }
            menuBar1.add(menu2);
        }
        add(menuBar1);
        menuBar1.setBounds(60, 180, 630, menuBar1.getPreferredSize().height);

        //---- buttonSmoke ----
        buttonSmoke.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 16));
        buttonSmoke.setIcon(new ImageIcon(getClass().getResource("/Resources/img/smoke.png")));
        buttonSmoke.setFocusable(false);
        buttonSmoke.setText("    \u91cd\u7f6e");
        buttonSmoke.setBackground(UIManager.getColor("Button.background"));
        buttonSmoke.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSmokeMousePressed(e);
            }
        });
        add(buttonSmoke);
        buttonSmoke.setBounds(490, 580, 170, 145);

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
    protected JButton buttonDot;
    protected JButton buttonPolar;
    protected JButton buttonUpsidedDown;
    protected JButton buttonPow2;
    protected JButton buttonSqrt;
    protected JButton buttonEqual;
    protected JButton buttonPlus;
    protected JButton buttonMinus;
    protected JButton buttonMul;
    protected JButton buttonDiv;
    protected JButton buttonPercent;
    protected JButton buttonCleanEntry;
    protected JButton buttonClear;
    protected JButton buttonDavid;
    protected JButton buttonBackspace;
    protected JScrollPane scrollPane3;
    protected JTextField textField1;
    protected JProgressBar progressBar1;
    protected JScrollPane scrollPane1;
    protected JLabel label1;
    private JMenuBar menuBar1;
    private JMenu menu1;
    protected JMenuItem buttonPlain;
    protected JMenuItem buttonAEb;
    private JMenu menu2;
    protected JMenuItem buttonFloor;
    protected JMenuItem buttonCeil;
    protected JButton buttonSmoke;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
